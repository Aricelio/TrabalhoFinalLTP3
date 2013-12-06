package Presentation;

import DataAccess.RefeicaoDAO;
import DataAccess.TipoRefeicaoDAO;
import DominModel.Refeicao;
import DominModel.TipoRefeicao;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class frmRefeicaoEditar extends javax.swing.JInternalFrame {

    //Declaração de Variaveis
    TipoRefeicaoDAO tipoRefeicaoDAO = new TipoRefeicaoDAO();
    Refeicao refeicao;
    RefeicaoDAO refeicaoDAO;

    //Construtor
    public frmRefeicaoEditar(Refeicao ref, RefeicaoDAO dao) {
        initComponents();
        this.refeicao = ref;
        this.refeicaoDAO = dao;
        carregaTipos();

        if (refeicao != null) {
            carregaCampos();
        } else {
            refeicao = new Refeicao();
        }
    }

    //Carrega o comboBox tipos de refeicao
    private void carregaTipos() {
        List<TipoRefeicao> tipos = new ArrayList<TipoRefeicao>();
        tipos = tipoRefeicaoDAO.ListarTipos();

        cbxTipo.removeAllItems();
        for (TipoRefeicao t : tipos) {
            cbxTipo.addItem(t);
        }
    }

    //Carrega os campos
    private void carregaCampos() {
        txtDescricao.setText(refeicao.getDescricao());
        txtPrecoF.setValue(refeicao.getPreco());
        cbxTipo.setSelectedItem(refeicao.getTipo());
        cbxTipo.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPrecoF = new javax.swing.JFormattedTextField();
        lblTipo = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnApagar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JButton();
        btnNovoTipo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Edição de Refeição");

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

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnApagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnApagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Apagar.png"))); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
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

        btnNovoTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovoTipo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/relatorio.png"))); // NOI18N
        btnNovoTipo.setText("Novo Tipo");
        btnNovoTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipo)
                                .addGap(43, 43, 43)
                                .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescricao)
                                    .addComponent(lblPreco))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrecoF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnNovoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPreco)
                    .addComponent(txtPrecoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botão Salvar
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realemente salvar dos dados?") == 0) {
            try {
                refeicaoDAO = new RefeicaoDAO();
                TipoRefeicao tipo = new TipoRefeicao();

                tipo = (TipoRefeicao) cbxTipo.getSelectedItem();
                
                refeicao.setDescricao(txtDescricao.getText());
                refeicao.setPreco((double) txtPrecoF.getValue());
                refeicao.setTipo(tipo);

                refeicaoDAO.Salvar(refeicao);

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
    }//GEN-LAST:event_btnSalvarActionPerformed

    //Botão Apagar
    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed

        if (JOptionPane.showConfirmDialog(rootPane, "Deseja realmente apagar dos dados?") == 0) {
            try {
                refeicaoDAO.Remover(refeicao);
                JOptionPane.showMessageDialog(rootPane, "Exclusão concluida com sucesso!");

                this.setVisible(false);
                frmRefeicaoBuscar janela = new frmRefeicaoBuscar();
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
            frmRefeicaoBuscar janela = new frmRefeicaoBuscar();
            this.getParent().add(janela);
            janela.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    //Botão Novo Tipo
    private void btnNovoTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTipoActionPerformed
        this.setVisible(false);
        frmTipoRefeicaoEditar janela = new frmTipoRefeicaoEditar();
        this.getParent().add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_btnNovoTipoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovoTipo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbxTipo;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JFormattedTextField txtPrecoF;
    // End of variables declaration//GEN-END:variables
}
