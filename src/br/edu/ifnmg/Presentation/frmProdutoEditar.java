package br.edu.ifnmg.Presentation;

import br.edu.ifnmg.DataAccess.FornecedorDAO;
import br.edu.ifnmg.DataAccess.TipoProdutoDAO;
import br.edu.ifnmg.DominModel.Produto;
import br.edu.ifnmg.DataAccess.ProdutoDAO;
import br.edu.ifnmg.DominModel.Fornecedor;
import br.edu.ifnmg.DominModel.ItemProdutoFornecedor;
import br.edu.ifnmg.DominModel.TipoProduto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmProdutoEditar extends javax.swing.JInternalFrame {

    private TipoProdutoDAO tipoDAO = new TipoProdutoDAO();
    private Produto produto;
    private ProdutoDAO produtoDAO;
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();
    private ItemProdutoFornecedor itemProdutoFornecedor;
    private List<ItemProdutoFornecedor> fornecedores;

    //Construtor
    public frmProdutoEditar(Produto p, ProdutoDAO dao, boolean novoProduto) {
        initComponents();
        this.produto = p;
        this.produtoDAO = dao;
        

        carregaTipos();
        carregaFornecedores();

        if (produto != null) {
            carregaCampos();
            fornecedores = produtoDAO.ListarItemProdutoFornecedor(produto);
            preencheTabela(fornecedores);
        } else {
            preencheTabela(null);
            produto = new Produto();
        }
        if (novoProduto) {
            txtEstoque.setVisible(false);
            lblEstoque.setVisible(false);
        } else {
            txtEstoque.setVisible(true);
            lblEstoque.setVisible(true);
        }
    }

    //Carrega o comoBox dos tipos
    @SuppressWarnings("unchecked")
    private void carregaTipos() {
        List<TipoProduto> tipos = new ArrayList<TipoProduto>();
        tipos = tipoDAO.ListarTipos();

        cbxTipo.removeAllItems();
        for (TipoProduto t : tipos) {
            cbxTipo.addItem(t);
        }
    }

    //Carrega o comboBox dos Fornecedores
    private void carregaFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        fornecedores = fornecedorDAO.ListarFornecedores();

        cbxFornecedor.removeAllItems();
        for (Fornecedor f : fornecedores) {
            cbxFornecedor.addItem(f);
        }
    }

    //Carrega campos
    private void carregaCampos() {
        txtNome.setText(produto.getNome());
        txtDescricao.setText(produto.getDescricao());
        txtPrecoF.setValue(produto.getPreco());
        txtEstoque.setText(String.valueOf(produto.getEstoque()));
        cbxTipo.setSelectedItem(produto.getTipo());
        cbxTipo.repaint();
        cbxFornecedor.repaint();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnApagar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JButton();
        tpnProdutos = new javax.swing.JTabbedPane();
        jpDadosGerais = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPrecoF = new javax.swing.JFormattedTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox();
        lblEstoque = new javax.swing.JLabel();
        txtEstoque = new javax.swing.JTextField();
        btnNovoTipo = new javax.swing.JButton();
        jpFornecedores = new javax.swing.JPanel();
        lblFornecedor = new javax.swing.JLabel();
        cbxFornecedor = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        pnlListagem = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Edição de Produtos");
        setMinimumSize(new java.awt.Dimension(20, 20));
        setName(""); // NOI18N

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnApagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Apagar.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Error-icon.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tpnProdutos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescricao.setText("Descrição:");

        txtDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPreco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPreco.setText("Preço:");

        txtPrecoF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtPrecoF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTipo.setText("Tipo:");

        cbxTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblEstoque.setText("Estoque:");

        txtEstoque.setEditable(false);
        txtEstoque.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnNovoTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/relatorio.png"))); // NOI18N
        btnNovoTipo.setText("Novo Tipo");
        btnNovoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDadosGeraisLayout = new javax.swing.GroupLayout(jpDadosGerais);
        jpDadosGerais.setLayout(jpDadosGeraisLayout);
        jpDadosGeraisLayout.setHorizontalGroup(
            jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                        .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPreco)
                            .addComponent(lblNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecoF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEstoque)))
                .addGap(76, 76, 76)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescricao)
                    .addComponent(lblTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnNovoTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.Alignment.LEADING, 0, 217, Short.MAX_VALUE)
                    .addComponent(txtDescricao))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jpDadosGeraisLayout.setVerticalGroup(
            jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDadosGeraisLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPrecoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTipo)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpDadosGeraisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstoque)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        tpnProdutos.addTab("Dados gerais", jpDadosGerais);

        lblFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFornecedor.setText("Fornecedor: ");

        cbxFornecedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Salvar.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Apagar.png"))); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblListagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout jpFornecedoresLayout = new javax.swing.GroupLayout(jpFornecedores);
        jpFornecedores.setLayout(jpFornecedoresLayout);
        jpFornecedoresLayout.setHorizontalGroup(
            jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFornecedoresLayout.createSequentialGroup()
                .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpFornecedoresLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpFornecedoresLayout.createSequentialGroup()
                        .addContainerGap(35, Short.MAX_VALUE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82)
                .addComponent(pnlListagem, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpFornecedoresLayout.setVerticalGroup(
            jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFornecedoresLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFornecedoresLayout.createSequentialGroup()
                        .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFornecedor)
                            .addComponent(cbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(103, 103, 103)
                        .addGroup(jpFornecedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 100, Short.MAX_VALUE))
                    .addComponent(pnlListagem, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        tpnProdutos.addTab("Fornecedores", jpFornecedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229))
            .addComponent(tpnProdutos)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpnProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Botão Salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar dos dados?") == 0) {
            try {
                produtoDAO = new ProdutoDAO();
                TipoProduto tipo = new TipoProduto();

                tipo = (TipoProduto) cbxTipo.getSelectedItem();
                produto.setNome(txtNome.getText());
                produto.setDescricao(txtDescricao.getText());
                produto.setPreco((double) txtPrecoF.getValue());
                produto.setTipo(tipo);

                produtoDAO.Salvar(produto);

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
    }//GEN-LAST:event_btnSalvarActionPerformed
    //Botão Apagar
    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente apagar dos dados?") == 0) {
            try {
                produtoDAO.Remover(produto);
                JOptionPane.showMessageDialog(rootPane, "Exclusão concluida com sucesso!");

                this.setVisible(false);
                frmProdutoBuscar janela = new frmProdutoBuscar();
                this.getParent().add(janela);
                janela.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao Apagar os dados! " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Exclusão cancelada pelo usuario");
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    //Botão Cancelar
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente Cancelar?") == 0) {
            this.setVisible(false);
            frmProdutoBuscar janela = new frmProdutoBuscar();
            this.getParent().add(janela);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNovoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTipoActionPerformed
        this.setVisible(false);
        frmTipoProdutoEditar janela = new frmTipoProdutoEditar();
        this.getParent().add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_btnNovoTipoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            Fornecedor fornecedorSelecionado = (Fornecedor) cbxFornecedor.getSelectedItem();

            itemProdutoFornecedor = new ItemProdutoFornecedor();
            itemProdutoFornecedor.setFornecedor(fornecedorSelecionado);
            itemProdutoFornecedor.setProduto(produto);

            produto.addFornecedor(itemProdutoFornecedor);

            preencheTabela(produto.getFornecedores());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Adicionar Fornecedor! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        try {
            Fornecedor fornecedorSelecionado = (Fornecedor) cbxFornecedor.getSelectedItem();

            for (ItemProdutoFornecedor i : produto.getFornecedores()) {
                if (i.getFornecedor() == fornecedorSelecionado) {
                    produto.removeFornecedor(i);
                    break;
                }
            }
            preencheTabela(produto.getFornecedores());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao tentar Remover o Fornecedor! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    //Preenche a tabela de produtos
    private void preencheTabela(List<ItemProdutoFornecedor> listaFornecedores) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Nome");


            for (ItemProdutoFornecedor i : listaFornecedores) {
                Vector valores = new Vector();
                valores.add(0, i.getFornecedor().getCodigo());
                valores.add(1, i.getFornecedor().getNome());

                model.addRow(valores);

            }
            tblListagem.setModel(model);
            tblListagem.repaint();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JToggleButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovoTipo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxFornecedor;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jpDadosGerais;
    private javax.swing.JPanel jpFornecedores;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JScrollPane pnlListagem;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTabbedPane tpnProdutos;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtPrecoF;
    // End of variables declaration//GEN-END:variables
}
