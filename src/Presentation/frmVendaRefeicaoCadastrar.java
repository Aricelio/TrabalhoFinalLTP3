package Presentation;

import DataAccess.CaixaDAO;
import DataAccess.ClienteDAO;
import DataAccess.VendaRefeicaoDAO;
import DataAccess.RefeicaoDAO;
import DominModel.Caixa;
import DominModel.Cliente;
import DominModel.Funcionario;
import DominModel.ItemVendaRefeicao;
import DominModel.Refeicao;
import DominModel.Sessao;
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
    CaixaDAO caixaDAO = new CaixaDAO();
    ItemVendaRefeicao itemVenda;
    Sessao sessao;
    Funcionario funcionario;
    Caixa caixa;

    //Construtor
    public frmVendaRefeicaoCadastrar(Funcionario funcionario, Sessao sessao) {
        initComponents();
        this.funcionario = funcionario;
        this.sessao = sessao;
        this.caixa = caixaDAO.AbrirCaixa(1);
        carregaClientes();
        carregaRefeicoes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvarVenda = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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
        btnGerarTotal = new javax.swing.JButton();

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

        lblFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormaPagamento.setText("Pagamento:");

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

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade: ");

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalVenda.setText("Total da Venda: ");

        txtTotalVenda.setEditable(false);
        txtTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGerarTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGerarTotal.setText("Gerar Total");
        btnGerarTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarTotalActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFormaPagamento)
                                .addGap(18, 18, 18)
                                .addComponent(cbxFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addGap(48, 48, 48)
                                .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addGap(12, 12, 12)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxRefeicao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnGerarTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduto)
                    .addComponent(cbxRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalVenda)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGerarTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Seta o objeto venda Refeicao
    private void carregaVenda() {
        try {
            String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();
            Cliente clienteSelecionado = (Cliente) cbxCliente.getSelectedItem();

            vendaRefeicao.setData(new Date());
            vendaRefeicao.setFormaPagamento(formaPagamento);
            vendaRefeicao.setCliente(clienteSelecionado);
            vendaRefeicao.setFuncionario(funcionario);
            vendaRefeicao.setSessao(sessao);
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

    //Carrega o comboBox dos Refeições
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

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar os dados?") == 0) {
            try {
                carregaVenda();
                VendaRefeicaoDAO dao = new VendaRefeicaoDAO();
                int quantidade = Integer.parseInt(txtQuantidade.getText());
                Refeicao refeicaoSelecionada = (Refeicao) cbxRefeicao.getSelectedItem();
                refeicaoSelecionada = refeicaoDAO.Abrir(refeicaoSelecionada.getCodigo());

                itemVenda = new ItemVendaRefeicao();
                itemVenda.setQuantidade(quantidade);
                itemVenda.setVendaRefeicao(vendaRefeicao);
                itemVenda.setRefeicao(refeicaoSelecionada);
                vendaRefeicao.addItemVenda(itemVenda);


                dao.Salvar(vendaRefeicao);
                String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();
                if ("Á vista".equals(formaPagamento)) {
                    caixa.setSaldo(caixa.getSaldo() + vendaRefeicao.getValorTotal());
                    caixaDAO.Salvar(caixa);
                }

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

    private void btnGerarTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarTotalActionPerformed
        
        txtTotalVenda.setText("R$  " + vendaRefeicao.getValorTotal());
    }//GEN-LAST:event_btnGerarTotalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGerarTotal;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxFormaPagamento;
    private javax.swing.JComboBox cbxRefeicao;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
