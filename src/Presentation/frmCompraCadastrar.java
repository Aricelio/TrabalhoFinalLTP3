package Presentation;

import DataAccess.CaixaDAO;
import DataAccess.CompraDAO;
import DataAccess.FornecedorDAO;
import DataAccess.ProdutoDAO;
import DominModel.Caixa;
import DominModel.Compra;
import DominModel.Fornecedor;
import DominModel.Funcionario;
import DominModel.ItemCompra;
import DominModel.Produto;
import DominModel.Sessao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmCompraCadastrar extends javax.swing.JInternalFrame {

    //Declaração de Variaveis
    ProdutoDAO produtoDAO = new ProdutoDAO();
    Compra compra = new Compra();
    ItemCompra itemCompra;
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    CaixaDAO caixaDAO = new CaixaDAO();
    Funcionario funcionario;
    Sessao sessao;
    Caixa caixa;

    //Construtor
    public frmCompraCadastrar(Funcionario funcionario, Sessao sessao) {
        initComponents();
        this.funcionario = funcionario;
        this.sessao = sessao;
        this.caixa = caixaDAO.AbrirCaixa(1);
        carregaFornecedores();
        carregaProdutos();
        preencheTabela(null);
    }

    //Carrega o comboBox dos fornecedores
    private void carregaFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        fornecedores = fornecedorDAO.ListarFornecedores();

        cbxFornecedor.removeAllItems();
        for (Fornecedor forn : fornecedores) {
            cbxFornecedor.addItem(forn);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpVendas = new javax.swing.JTabbedPane();
        pnGeral = new javax.swing.JPanel();
        lblFormaPagamento = new javax.swing.JLabel();
        cbxFornecedor = new javax.swing.JComboBox();
        lblFornecedor = new javax.swing.JLabel();
        cbxFormaPagamento = new javax.swing.JComboBox();
        pnItens = new javax.swing.JPanel();
        cbxProduto = new javax.swing.JComboBox();
        pnlListagem = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        lblTotalVenda = new javax.swing.JLabel();
        txtTotalCompra = new javax.swing.JTextField();
        lblProduto = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnSalvarVenda = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Compra de Produtos");

        tpVendas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFormaPagamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFormaPagamento.setText("Forma de Pagamento:");

        cbxFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxFornecedor.setToolTipText("");

        lblFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFornecedor.setText("Fornecedor:");

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
                        .addComponent(lblFornecedor)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addComponent(lblFormaPagamento)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(589, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornecedor)
                    .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(199, Short.MAX_VALUE))
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
        lblTotalVenda.setText("Total da Compra: ");

        txtTotalCompra.setEditable(false);
        txtTotalCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(pnlListagem, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnItensLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTotalVenda)
                .addGap(18, 18, 18)
                .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(txtTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
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
        btnSalvarVenda.setText("Salvar Compra");
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
            .addGroup(layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(btnSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tpVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 976, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tpVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 113, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Seta o objeto compra
    private void carregaCompra() {
        String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();       
        Fornecedor fornecedorSelected = (Fornecedor) cbxFornecedor.getSelectedItem();
        
        try {
            compra.setData(new Date());
            compra.setFormaPagamento(formaPagamento);
            compra.setFuncionario(funcionario);
            compra.setSessao(sessao);
            compra.setFornecedor(fornecedorSelected);
        } catch (Exception ex) {
            Logger.getLogger(frmVendaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cbxProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProdutoActionPerformed
        txtQuantidade.setText("");
    }//GEN-LAST:event_cbxProdutoActionPerformed

    //Preenche a tabela de produtos
    private void preencheTabela(List<ItemCompra> listaItemCompra) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Nome");
            model.addColumn("Tipo");
            model.addColumn("Preço");
            model.addColumn("Quantidade");
            model.addColumn("Total");


            if (listaItemCompra != null) {
                for (ItemCompra i : listaItemCompra) {
                    Vector valores = new Vector();
                    valores.add(0, i.getProduto().getCodigo());
                    valores.add(1, i.getProduto().getNome());
                    valores.add(2, i.getProduto().getTipo().getTipo());
                    valores.add(3, i.getProduto().getPreco());
                    valores.add(4, i.getQuantidade());
                    valores.add(5, i.getValorTotalItem());


                    model.addRow(valores);
                }
            }
            tblListagem.setModel(model);
            tblListagem.repaint();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Botão Adicionar
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            carregaCompra();
            Produto prodSelecionado = (Produto) cbxProduto.getSelectedItem();
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            prodSelecionado = produtoDAO.Abrir(prodSelecionado.getCodigo());

            itemCompra = new ItemCompra();
            itemCompra.setQuantidade(quantidade);
            itemCompra.setProduto(prodSelecionado);

            if ((itemCompra.getValorTotalItem() > caixa.getSaldo())
                    && ("Á vista".equals(compra.getFormaPagamento()))
                    && ((compra.getValorTotal() + itemCompra.getValorTotalItem()) > caixa.getSaldo())) 
            {
                JOptionPane.showMessageDialog(rootPane, "Valor total do produto é maior do que o valor em caixa.");
            } else {
                prodSelecionado.setEstoque(prodSelecionado.getEstoque() + quantidade);
                itemCompra.setCompra(compra);
                compra.addItemCompra(itemCompra);
                txtTotalCompra.setText("R$  " + compra.getValorTotal());
                preencheTabela(compra.getItensCompra());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Adicionar Produto! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    //Botão Remover
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            carregaCompra();
            Produto prodSelecionado = (Produto) cbxProduto.getSelectedItem();
            prodSelecionado = produtoDAO.Abrir(prodSelecionado.getCodigo());

            for (ItemCompra i : compra.getItensCompra()) {
                if (i.getProduto().equals(prodSelecionado)) {
                    compra.removeItemCompra(i);
                    break;
                }
            }

            txtTotalCompra.setText("R$  " + compra.getValorTotal());
            preencheTabela(compra.getItensCompra());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Remover Produto! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    //Botão Salvar Compra
    private void btnSalvarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVendaActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar os dados?") == 0) {
            try {
                carregaCompra();
                CompraDAO compraDAO = new CompraDAO();

                compraDAO.Salvar(compra);

                String formaPagamento = (String) cbxFormaPagamento.getSelectedItem();
                if ("Á vista".equals(formaPagamento)) {
                    caixa.setSaldo(caixa.getSaldo() - compra.getValorTotal());
                    caixaDAO.Salvar(caixa);
                }

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvarVenda;
    private javax.swing.JComboBox cbxFormaPagamento;
    private javax.swing.JComboBox cbxFornecedor;
    private javax.swing.JComboBox cbxProduto;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JPanel pnItens;
    private javax.swing.JScrollPane pnlListagem;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTabbedPane tpVendas;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTotalCompra;
    // End of variables declaration//GEN-END:variables
}
