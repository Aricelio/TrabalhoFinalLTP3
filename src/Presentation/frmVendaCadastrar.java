package Presentation;

import DominModel.Cliente;
import DataAccess.ClienteDAO;
import DataAccess.FuncionarioDAO;
import DataAccess.ProdutoDAO;
import DataAccess.VendaDAO;
import DominModel.Funcionario;
import DominModel.ItemVenda;
import DominModel.Produto;
import DominModel.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmVendaCadastrar extends javax.swing.JInternalFrame {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    Venda venda = new Venda();
    ItemVenda itemVenda;
    ClienteDAO clienteDAO = new ClienteDAO();

    //Construtor
    public frmVendaCadastrar() {
        initComponents();
        carregaClientes();
        carregaProdutos();
        preencheTabela(null);
    }

    //Seta o objeto venda
    private void carregaVenda() {
        String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();
        Cliente clienteSelecionado = (Cliente) cbxCliente.getSelectedItem();
        FuncionarioDAO dao = new FuncionarioDAO();
        
        //Variaveis criadas para teste
        //Date data = new Date();
        Funcionario f = dao.AbrirFuncionario(10);

        try {
            venda.setData((Date)txtData.getValue());
            venda.setFormaPagamento(formaPagamento);
            venda.setCliente(clienteSelecionado);
            venda.setFuncionario(f);
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
    private void carregaProdutos() {
        List<Produto> produtos = new ArrayList<Produto>();
        produtos = produtoDAO.ListarProdutos();

        cbxProduto.removeAllItems();
        for (Produto p : produtos) {
            cbxProduto.addItem(p);
        }
    }

    //Preenche a tabela de produtos
    private void preencheTabela(List<ItemVenda> listaItemVenda) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Nome");
            model.addColumn("Preço");
            model.addColumn("Quantidade");
            model.addColumn("Total");
            model.addColumn("Tipo");

            if (listaItemVenda != null) {
                for (ItemVenda i : listaItemVenda) {
                    Vector valores = new Vector();
                    valores.add(0, i.getProduto().getCodigo());
                    valores.add(1, i.getProduto().getNome());
                    valores.add(2, i.getProduto().getPreco());
                    valores.add(3, i.getQuantidade());
                    valores.add(4, i.getValorTotalItem());
                    valores.add(5, i.getProduto().getTipo().getTipo());

                    model.addRow(valores);
                }
            }
            tblListagem.setModel(model);
            tblListagem.repaint();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpVendas = new javax.swing.JTabbedPane();
        pnGeral = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblFormaPagamento = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        lblCliente = new javax.swing.JLabel();
        cbxFormaPagamento = new javax.swing.JComboBox();
        pnItens = new javax.swing.JPanel();
        cbxProduto = new javax.swing.JComboBox();
        pnlListagem = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        lblTotalVenda = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
        lblProduto = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnSalvarVenda = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Vendas de Produtos");

        tpVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblData.setText("Data: ");

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormaPagamento.setText("Forma de Pagamento:");

        cbxCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCliente.setToolTipText("");

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCliente.setText("Cliente:");

        cbxFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Á vista", "Á prazo", "Cheque", "Cartão de Crédito" }));
        cbxFormaPagamento.setToolTipText("");

        javax.swing.GroupLayout pnGeralLayout = new javax.swing.GroupLayout(pnGeral);
        pnGeral.setLayout(pnGeralLayout);
        pnGeralLayout.setHorizontalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblFormaPagamento)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(514, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData))
                .addGap(34, 34, 34)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(211, Short.MAX_VALUE))
        );

        tpVendas.addTab("Geral", pnGeral);

        cbxProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProdutoActionPerformed(evt);
            }
        });

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        pnlListagem.setViewportView(tblListagem);

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Salvar.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Error-icon.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        lblTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotalVenda.setText("Total da Venda: ");

        txtTotalVenda.setEditable(false);
        txtTotalVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblProduto.setText("Produto:");

        lblQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblQuantidade.setText("Quantidade: ");

        txtQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnItensLayout = new javax.swing.GroupLayout(pnItens);
        pnItens.setLayout(pnItensLayout);
        pnItensLayout.setHorizontalGroup(
            pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItensLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnItensLayout.createSequentialGroup()
                        .addComponent(lblQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtQuantidade))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnItensLayout.createSequentialGroup()
                        .addComponent(lblProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnItensLayout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(pnlListagem, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItensLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTotalVenda)
                .addGap(18, 18, 18)
                .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );
        pnItensLayout.setVerticalGroup(
            pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnItensLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnItensLayout.createSequentialGroup()
                        .addComponent(pnlListagem, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTotalVenda)
                            .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(pnItensLayout.createSequentialGroup()
                        .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProduto))
                        .addGap(25, 25, 25)
                        .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblQuantidade)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))))
        );

        tpVendas.addTab("Itens", pnItens);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpVendas)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpVendas)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botão Salvar
    private void btnSalvarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendaActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar os dados?") == 0) {
            try {
                VendaDAO vendaDAO = new VendaDAO();                
                
                vendaDAO.Salvar(venda);
               
                JOptionPane.showMessageDialog(rootPane, "Dados Salvos com Sucesso!");
                //Fecha a tela atual e abre a tela de busca
                this.setVisible(false);
                frmProdutoBuscar janela = new frmProdutoBuscar();
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
            frmProdutoBuscar janela = new frmProdutoBuscar();
            this.getParent().add(janela);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    //Botão Adicionar produto
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            carregaVenda();
            Produto prodSelecionado = (Produto) cbxProduto.getSelectedItem();
            int quantidade = Integer.parseInt(txtQuantidade.getText());

            itemVenda = new ItemVenda();
            itemVenda.setProduto(prodSelecionado);
            itemVenda.setQuantidade(quantidade);
            itemVenda.setVenda(venda);

            venda.addItemVenda(itemVenda);
            txtTotalVenda.setText("R$  " + venda.getValorTotal());
            preencheTabela(venda.getItensVenda());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Adicionar Produto! " + ex.getMessage()); 
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    //Botão Remover produto
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            carregaVenda();
            Produto prodSelecionado = (Produto) cbxProduto.getSelectedItem();

            for (ItemVenda i : venda.getItensVenda()) {
                if (i.getProduto() == prodSelecionado) {
                    venda.removeItemVenda(i);
                    break;
                }
            }

            txtTotalVenda.setText("R$  " + venda.getValorTotal());
            preencheTabela(venda.getItensVenda());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Remover Produto! " + ex.getMessage()); 
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        txtQuantidade.setText("");
    }//GEN-LAST:event_cbxProdutoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxFormaPagamento;
    private javax.swing.JComboBox cbxProduto;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JPanel pnItens;
    private javax.swing.JScrollPane pnlListagem;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTabbedPane tpVendas;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
