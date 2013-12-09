package Presentation;

import DataAccess.FuncionarioDAO;
import DataAccess.UsuarioDAO;
import DominModel.Usuario;
import DominModel.Funcionario;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmFuncionarioBuscar extends javax.swing.JInternalFrame {

    //Declaração de Variaveis
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    Usuario usuario = new Usuario();
    Usuario userSistema = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    //Construtor
    public frmFuncionarioBuscar(Usuario usuario) {
        initComponents();
        userSistema = usuario;
        preencheTabela(funcionarioDAO.ListarFuncionarios());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JToggleButton();
        btnNovo = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Edição de Funcionarios");

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCodigo.setText("Codigo:");

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnFiltrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Contact-Card-icon.png"))); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Document-icon.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
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
        tblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1139, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(lblCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencheTabela(List<Funcionario> lista) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Nome");
            model.addColumn("Cargo");
            model.addColumn("Data de Nascimento");
            


            for (Funcionario funcionario : lista) {
                Vector valores = new Vector();
                valores.add(0, funcionario.getCodigo());
                valores.add(1, funcionario.getNome());
                valores.add(2, funcionario.getCargo().getCargo());
                valores.add(3, funcionario.getDataNascimento());
                model.addRow(valores);
            }
            tblListagem.setModel(model);
            tblListagem.repaint();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        Funcionario funcionario = new Funcionario();
        List<Funcionario> lista = null;

        try {
            if ((txtNome.getText().length() == 0) && (txtCodigo.getText().length() == 0)) {
                lista = funcionarioDAO.BuscarFuncionario(funcionario);
            } else {
                if ((txtNome.getText().length() > 0)) {
                    funcionario.setNome(txtNome.getText());
                }
                if (txtCodigo.getText().length() > 0) {
                    funcionario.setCodigo(Integer.parseInt((txtCodigo.getText())));
                }
                lista = funcionarioDAO.BuscarFuncionario(funcionario);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro! " + ex.getMessage());
        }
        preencheTabela(lista);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        if (("root".equals(userSistema.getLogin())) && ("root".equals(userSistema.getSenha()))) {

            frmFuncionarioEditar janela = new frmFuncionarioEditar(null, null, null, userSistema);

            this.getParent().add(janela);
            janela.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Para acessar esse formulario é preciso ser administrador");
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked

        try {
            if (("root".equals(userSistema.getLogin())) && ("root".equals(userSistema.getSenha()))) {

                Object valor = tblListagem.getValueAt(tblListagem.getSelectedRow(), 0);
                FuncionarioDAO dao = new FuncionarioDAO();
                Funcionario funcionario = dao.AbrirFuncionario((int) valor);
                usuario = usuarioDAO.AbrirUsuario((int) valor);

                frmFuncionarioEditar janela = new frmFuncionarioEditar(funcionario, dao, usuario, userSistema);
                this.getParent().add(janela);
                janela.setVisible(true);
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Para acessar esse formulario é preciso ser administrador");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblListagemMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnFiltrar;
    private javax.swing.JToggleButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
