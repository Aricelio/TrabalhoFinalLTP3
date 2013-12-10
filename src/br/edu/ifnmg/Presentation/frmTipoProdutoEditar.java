package br.edu.ifnmg.Presentation;

import br.edu.ifnmg.DataAccess.TipoProdutoDAO;
import br.edu.ifnmg.DominModel.TipoProduto;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmTipoProdutoEditar extends javax.swing.JInternalFrame {

    //Declaração de Variaveis
    List<TipoProduto> tipos = new ArrayList<TipoProduto>();
    TipoProdutoDAO dao = new TipoProdutoDAO();

    //Construtor
    public frmTipoProdutoEditar() {
        initComponents();
        tipos = dao.ListarTipos();
        carregaTipos();
        atualizaTabelaTipos(tipos);
        lblNomeEditar.setVisible(false);
        txtNomeEditar.setVisible(false);
    }

    //Carrega o comboBox Tipo
    private void carregaTipos() {
        List<TipoProduto> tipoProduto = new ArrayList<TipoProduto>();
        tipoProduto = dao.ListarTipos();

        cbxTipo.removeAllItems();
        for (TipoProduto t : tipoProduto) {
            cbxTipo.addItem(t);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpTipoProduto = new javax.swing.JTabbedPane();
        pnNovo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListagemTipoProduto = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        pnEditar = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox();
        lblTipoEditar = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        txtNomeEditar = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        lblNomeEditar = new javax.swing.JLabel();
        btnListagemProduto = new javax.swing.JButton();
        btnNovoProduto = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Tipos de Produtos");

        tpTipoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblListagemTipoProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListagemTipoProduto.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblListagemTipoProduto);

        btnAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Salvar.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnNovoLayout = new javax.swing.GroupLayout(pnNovo);
        pnNovo.setLayout(pnNovoLayout);
        pnNovoLayout.setHorizontalGroup(
            pnNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNovoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        pnNovoLayout.setVerticalGroup(
            pnNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnNovoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnNovoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpTipoProduto.addTab("Novo", pnNovo);

        cbxTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActionPerformed(evt);
            }
        });

        lblTipoEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTipoEditar.setText("Tipo:");

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Document-icon.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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

        txtNomeEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblNomeEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomeEditar.setText("Nome:");

        javax.swing.GroupLayout pnEditarLayout = new javax.swing.GroupLayout(pnEditar);
        pnEditar.setLayout(pnEditarLayout);
        pnEditarLayout.setHorizontalGroup(
            pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoEditar)
                    .addComponent(lblNomeEditar))
                .addGap(18, 18, 18)
                .addGroup(pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNomeEditar)
                    .addComponent(cbxTipo, 0, 180, Short.MAX_VALUE))
                .addGap(140, 140, 140)
                .addGroup(pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnEditarLayout.setVerticalGroup(
            pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnEditarLayout.createSequentialGroup()
                .addGroup(pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnEditarLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipoEditar))
                        .addGap(72, 72, 72)
                        .addGroup(pnEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomeEditar)))
                    .addGroup(pnEditarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        tpTipoProduto.addTab("Editar", pnEditar);

        btnListagemProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListagemProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/pesquisa.png"))); // NOI18N
        btnListagemProduto.setText("Listagem");
        btnListagemProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListagemProdutoActionPerformed(evt);
            }
        });

        btnNovoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Document-icon.png"))); // NOI18N
        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListagemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListagemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botão Adicionar
    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja adicionar o novo Tipo?") == 0) {
                TipoProduto tipo = new TipoProduto();
                tipo.setTipo(txtNome.getText());

                dao.SalvarTipo(tipo);

                atualizaTabelaTipos(dao.ListarTipos());
                carregaTipos();

                JOptionPane.showMessageDialog(rootPane, "Tipo adicionado");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação Cancelada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    //Botão Editar
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            lblNomeEditar.setVisible(true);
            txtNomeEditar.setVisible(true);
            TipoProduto tipo = new TipoProduto();
            tipo = (TipoProduto) cbxTipo.getSelectedItem();

            txtNomeEditar.setText(tipo.getTipo());
        } catch (Exception ex) {
            //System.out.println(ex);
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    //Botão Salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Salvar a alteração?") == 0) {
                TipoProduto tipo = new TipoProduto();
                tipo = (TipoProduto) cbxTipo.getSelectedItem();
                tipo.setTipo(txtNomeEditar.getText());

                List<TipoProduto> tipos = new ArrayList<TipoProduto>();
                tipos = dao.ListarTipos();

                dao.SalvarTipo(tipo);

                atualizaTabelaTipos(dao.ListarTipos());

                JOptionPane.showMessageDialog(rootPane, "Tipo de Produto alterado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação Cancelada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    //Botão Apagar
    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja relmente remover?") == 0) {
                TipoProduto tipoProduto = new TipoProduto();

                tipoProduto = (TipoProduto) cbxTipo.getSelectedItem();

                List<TipoProduto> tipos = new ArrayList<TipoProduto>();
                tipos = dao.ListarTipos();

                dao.RemoverTipo(tipoProduto);

                carregaTipos();
                atualizaTabelaTipos(dao.ListarTipos());
                JOptionPane.showMessageDialog(rootPane, "Exclusão concluida com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação Cancelada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        lblNomeEditar.setVisible(false);
        txtNomeEditar.setVisible(false);
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        frmProdutoEditar janela = new frmProdutoEditar(null,null,true);
        this.getParent().add(janela);
        this.setVisible(false);
        janela.setVisible(true);
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnListagemProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListagemProdutoActionPerformed
        frmProdutoBuscar janela = new frmProdutoBuscar();
        this.getParent().add(janela);
        this.setVisible(false);
        janela.setVisible(true);
    }//GEN-LAST:event_btnListagemProdutoActionPerformed

    //Atualiza a tabela de Tipos
    private void atualizaTabelaTipos(List<TipoProduto> tipos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tipos");

        for (TipoProduto t : tipos) {
            Vector valores = new Vector();
            valores.add(0, t.getTipo());
            model.addRow(valores);
        }
        tblListagemTipoProduto.setModel(model);
        tblListagemTipoProduto.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnListagemProduto;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeEditar;
    private javax.swing.JLabel lblTipoEditar;
    private javax.swing.JPanel pnEditar;
    private javax.swing.JPanel pnNovo;
    private javax.swing.JTable tblListagemTipoProduto;
    private javax.swing.JTabbedPane tpTipoProduto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeEditar;
    // End of variables declaration//GEN-END:variables
}
