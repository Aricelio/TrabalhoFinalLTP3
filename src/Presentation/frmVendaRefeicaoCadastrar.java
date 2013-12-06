
package Presentation;

import DataAccess.ClienteDAO;
import DataAccess.VendaRefeicaoDAO;
import DataAccess.FuncionarioDAO;
import DataAccess.RefeicaoDAO;
import DominModel.Cliente;
import DominModel.Compra;
import DominModel.Funcionario;
import DominModel.Refeicao;
import DominModel.VendaRefeicao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class frmVendaRefeicaoCadastrar extends javax.swing.JInternalFrame {

    //Declaração de Variaveis
    RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
    VendaRefeicao vendaRefeicao = new VendaRefeicao();
    ClienteDAO clienteDAO = new ClienteDAO();
    
    //Construtor
    public frmVendaRefeicaoCadastrar() {
        initComponents();
        carregaClientes();
        carregaRefeicoes();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvarVenda = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblFormaPagamento = new javax.swing.JLabel();
        cbxFormaPagamento = new javax.swing.JComboBox();
        cbxCliente = new javax.swing.JComboBox();
        lblCliente = new javax.swing.JLabel();
        lblProduto = new javax.swing.JLabel();
        cbxRefeicao = new javax.swing.JComboBox();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        lblTotalVenda = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de Venda de Refeições");

        btnSalvarVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Salvar.png"))); // NOI18N
        btnSalvarVenda.setText("Salvar Venda");
        btnSalvarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVendaActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Error-icon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblData.setText("Data: ");

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormaPagamento.setText("Forma de Pagamento:");

        cbxFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Á vista", "Á prazo", "Cheque", "Cartão de Crédito" }));
        cbxFormaPagamento.setToolTipText("");

        cbxCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCliente.setToolTipText("");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCliente.setText("Cliente:");

        lblProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProduto.setText("Refeição:");

        cbxRefeicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxRefeicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxRefeicaoActionPerformed(evt);
            }
        });

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade: ");

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalVenda.setText("Total da Venda: ");

        txtTotalVenda.setEditable(false);
        txtTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(btnSalvarVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProduto)
                                    .addComponent(lblCliente)
                                    .addComponent(lblData))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(lblFormaPagamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblQuantidade)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduto)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalVenda)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Seta o objeto venda Refeicao
    private void carregaVenda() {
        String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();
        Cliente clienteSelecionado = (Cliente) cbxCliente.getSelectedItem();
        FuncionarioDAO dao = new FuncionarioDAO();
        
        //Variaveis criadas para teste
        //Date data = new Date();
        Funcionario f = dao.AbrirFuncionario(10);

        try {
            vendaRefeicao.setData((Date)txtData.getValue());
            vendaRefeicao.setFormaPagamento(formaPagamento);
            vendaRefeicao.setCliente(clienteSelecionado);
            vendaRefeicao.setFuncionario(f);
        } catch (Exception ex) {
            Logger.getLogger(frmVendaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Carrega o comboBox dos clientes
    private void carregaClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = clienteDAO.ListarClientes();

        cbxCliente.removeAllItems();
        for (Cliente c : clientes) {
            cbxCliente.addItem(c);
        }
    }
    
    //Carrega o comboBox dos Produtos
    private void carregaRefeicoes() {
        List<Refeicao> refeicoes = new ArrayList<Refeicao>();
        refeicoes = refeicaoDAO.ListarRefeicoes();

        cbxRefeicao.removeAllItems();
        for (Refeicao ref : refeicoes) {
            cbxRefeicao.addItem(ref);
        }
    }
    
    //Botão Salvar
    private void btnSalvarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendaActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar os dados?") == 0) {
            try {
                VendaRefeicaoDAO dao = new VendaRefeicaoDAO();

                dao.Salvar(vendaRefeicao);

                JOptionPane.showMessageDialog(rootPane, "Dados Salvos com Sucesso!");
                
                //Fecha a tela atual e abre a tela de busca
                this.setVisible(false);
                frmRefeicaoBuscar janela = new frmRefeicaoBuscar();
                this.getParent().add(janela);
                janela.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao Salvar os dados! " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cadastro cancelado pelo usuario");
        }
    }//GEN-LAST:event_btnSalvarVendaActionPerformed

    //Botão Cancelar
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente Cancelar?") == 0) {

            this.setVisible(false);
            frmRefeicaoBuscar janela = new frmRefeicaoBuscar();
            this.getParent().add(janela);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxRefeicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxRefeicaoActionPerformed
        txtQuantidade.setText("");
    }//GEN-LAST:event_cbxRefeicaoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxFormaPagamento;
    private javax.swing.JComboBox cbxRefeicao;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
