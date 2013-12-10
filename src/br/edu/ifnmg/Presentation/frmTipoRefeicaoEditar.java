package br.edu.ifnmg.Presentation;

import br.edu.ifnmg.DataAccess.TipoRefeicaoDAO;
import br.edu.ifnmg.DominModel.TipoRefeicao;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmTipoRefeicaoEditar extends javax.swing.JInternalFrame {

    //Declaração de variaveis
    List<TipoRefeicao> tipos = new ArrayList<TipoRefeicao>();
    TipoRefeicaoDAO dao = new TipoRefeicaoDAO();

    //Construtor
    public frmTipoRefeicaoEditar() {
        initComponents();
        tipos = dao.ListarTipos();
        carregaTipos();
        atualizaTabelaTipos(tipos);
        lblNomeEditar.setVisible(false);
        txtNomeEditar.setVisible(false);
    }

    //Carrega o comboBox Tipo
    private void carregaTipos() {
        List<TipoRefeicao> tiposRefeicao = new ArrayList<TipoRefeicao>();
        tiposRefeicao = dao.ListarTipos();

        cbxTipo.removeAllItems();
        for (TipoRefeicao t : tiposRefeicao) {
            cbxTipo.addItem(t);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpTipoProduto = new javax.swing.JTabbedPane();
        pnNovo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListagemTipoRefeicao = new javax.swing.JTable();
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
        btnNovaRefeicao = new javax.swing.JButton();
        btnListagemRefeicao = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Tipos de Refeição");

        tpTipoProduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblListagemTipoRefeicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblListagemTipoRefeicao.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblListagemTipoRefeicao);

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
                .addContainerGap(70, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
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
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
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
                .addContainerGap(76, Short.MAX_VALUE))
        );

        tpTipoProduto.addTab("Editar", pnEditar);

        btnNovaRefeicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovaRefeicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/Document-icon.png"))); // NOI18N
        btnNovaRefeicao.setText("Nova Refeição");
        btnNovaRefeicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaRefeicaoActionPerformed(evt);
            }
        });

        btnListagemRefeicao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListagemRefeicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/edu/ifnmg/Imagens/Icones/pesquisa.png"))); // NOI18N
        btnListagemRefeicao.setText("Listagem");
        btnListagemRefeicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListagemRefeicaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpTipoProduto)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnNovaRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListagemRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListagemRefeicao, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja adicionar o novo Tipo?") == 0) {
                TipoRefeicao tipo = new TipoRefeicao();
                tipo.setTipo(txtNome.getText());

                dao.SalvarTipo(tipo);

                atualizaTabelaTipos(dao.ListarTipos());

                JOptionPane.showMessageDialog(rootPane, "Tipo adicionado");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Operação Cancelada");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            lblNomeEditar.setVisible(true);
            txtNomeEditar.setVisible(true);
            TipoRefeicao tipo = new TipoRefeicao();
            tipo = (TipoRefeicao) cbxTipo.getSelectedItem();

            txtNomeEditar.setText(tipo.getTipo());
        } catch (Exception ex) {
            //System.out.println(ex);
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja relmente remover?") == 0) {
                TipoRefeicao tipoProduto = new TipoRefeicao();

                tipoProduto = (TipoRefeicao) cbxTipo.getSelectedItem();

                List<TipoRefeicao> tipos = new ArrayList<TipoRefeicao>();
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

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Salvar a alteração?") == 0) {
                TipoRefeicao tipo = new TipoRefeicao();
                tipo = (TipoRefeicao) cbxTipo.getSelectedItem();
                tipo.setTipo(txtNomeEditar.getText());

                List<TipoRefeicao> tipos = new ArrayList<TipoRefeicao>();
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

    private void cbxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActionPerformed
        lblNomeEditar.setVisible(false);
        txtNomeEditar.setVisible(false);
    }//GEN-LAST:event_cbxTipoActionPerformed

    private void btnNovaRefeicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaRefeicaoActionPerformed
        frmRefeicaoEditar janela = new frmRefeicaoEditar(null,null);
        this.getParent().add(janela);
        this.setVisible(false);
        janela.setVisible(true);
    }//GEN-LAST:event_btnNovaRefeicaoActionPerformed

    private void btnListagemRefeicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListagemRefeicaoActionPerformed
        frmRefeicaoBuscar janela = new frmRefeicaoBuscar();
        this.getParent().add(janela);
        this.setVisible(false);
        janela.setVisible(true);
    }//GEN-LAST:event_btnListagemRefeicaoActionPerformed

    //Atualiza a tabela de Tipos
    private void atualizaTabelaTipos(List<TipoRefeicao> tipos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Tipos");

        for (TipoRefeicao t : tipos) {
            Vector valores = new Vector();
            valores.add(0, t.getTipo());
            model.addRow(valores);
        }
        tblListagemTipoRefeicao.setModel(model);
        tblListagemTipoRefeicao.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnListagemRefeicao;
    private javax.swing.JButton btnNovaRefeicao;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeEditar;
    private javax.swing.JLabel lblTipoEditar;
    private javax.swing.JPanel pnEditar;
    private javax.swing.JPanel pnNovo;
    private javax.swing.JTable tblListagemTipoRefeicao;
    private javax.swing.JTabbedPane tpTipoProduto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeEditar;
    // End of variables declaration//GEN-END:variables
}
