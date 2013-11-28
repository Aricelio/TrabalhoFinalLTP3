
package Presentation;

public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jmbBarraMenu = new javax.swing.JMenuBar();
        mnuSGV = new javax.swing.JMenu();
        mniLogoff = new javax.swing.JMenuItem();
        mniSair = new javax.swing.JMenuItem();
        mnuProdutos = new javax.swing.JMenu();
        mniEditarP = new javax.swing.JMenuItem();
        mniBuscarP = new javax.swing.JMenuItem();
        mniRelatoriosP = new javax.swing.JMenuItem();
        mnuRefeicao = new javax.swing.JMenu();
        mniEditarR = new javax.swing.JMenuItem();
        mniListarR = new javax.swing.JMenuItem();
        mniRelatoriosR = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenu();
        mniEditarC = new javax.swing.JMenuItem();
        mniListarC = new javax.swing.JMenuItem();
        mniRelatoriosC = new javax.swing.JMenuItem();
        mnuFuncionarios = new javax.swing.JMenu();
        mniEditarFu = new javax.swing.JMenuItem();
        mniListarFu = new javax.swing.JMenuItem();
        mniRelatoriosFu = new javax.swing.JMenuItem();
        mnuFornecedores = new javax.swing.JMenu();
        mniEditarFo = new javax.swing.JMenuItem();
        mniListarFo = new javax.swing.JMenuItem();
        mniRelatorios = new javax.swing.JMenuItem();
        mnuTransacoes = new javax.swing.JMenu();
        mniVendaProduto = new javax.swing.JMenuItem();
        mniCompraProduto = new javax.swing.JMenuItem();
        mniVendaRefeicao = new javax.swing.JMenuItem();

        jMenuItem5.setText("jMenuItem5");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SGC ICIL");
        setName("JFPrincipal"); // NOI18N

        mnuSGV.setText("SGV");

        mniLogoff.setText("Logoff");
        mniLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoffActionPerformed(evt);
            }
        });
        mnuSGV.add(mniLogoff);

        mniSair.setText("Sair");
        mnuSGV.add(mniSair);

        jmbBarraMenu.add(mnuSGV);

        mnuProdutos.setText("Produtos");

        mniEditarP.setText("Editar");
        mniEditarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditarPActionPerformed(evt);
            }
        });
        mnuProdutos.add(mniEditarP);

        mniBuscarP.setText("Buscar");
        mniBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarPActionPerformed(evt);
            }
        });
        mnuProdutos.add(mniBuscarP);

        mniRelatoriosP.setText("Relatórios");
        mnuProdutos.add(mniRelatoriosP);

        jmbBarraMenu.add(mnuProdutos);

        mnuRefeicao.setText("Refeicao");

        mniEditarR.setText("Editar");
        mniEditarR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniEditarRActionPerformed(evt);
            }
        });
        mnuRefeicao.add(mniEditarR);

        mniListarR.setText("Listar Tipos");
        mnuRefeicao.add(mniListarR);

        mniRelatoriosR.setText("Relatórios");
        mnuRefeicao.add(mniRelatoriosR);

        jmbBarraMenu.add(mnuRefeicao);

        mnuClientes.setText("Clientes");
        mnuClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniEditarC.setText("Editar");
        mnuClientes.add(mniEditarC);

        mniListarC.setText("Listar");
        mnuClientes.add(mniListarC);

        mniRelatoriosC.setText("Relatórios");
        mnuClientes.add(mniRelatoriosC);

        jmbBarraMenu.add(mnuClientes);

        mnuFuncionarios.setText("Funcionarios");

        mniEditarFu.setText("Editar");
        mnuFuncionarios.add(mniEditarFu);

        mniListarFu.setText("Listar");
        mnuFuncionarios.add(mniListarFu);

        mniRelatoriosFu.setText("Relatorios");
        mnuFuncionarios.add(mniRelatoriosFu);

        jmbBarraMenu.add(mnuFuncionarios);

        mnuFornecedores.setText("Fornecedores");

        mniEditarFo.setText("Editar");
        mnuFornecedores.add(mniEditarFo);

        mniListarFo.setText("Listar");
        mnuFornecedores.add(mniListarFo);

        mniRelatorios.setText("Relatórios");
        mnuFornecedores.add(mniRelatorios);

        jmbBarraMenu.add(mnuFornecedores);

        mnuTransacoes.setText("Transações");

        mniVendaProduto.setText("Cadastrar Venda de Produtos");
        mniVendaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVendaProdutoActionPerformed(evt);
            }
        });
        mnuTransacoes.add(mniVendaProduto);

        mniCompraProduto.setText("Cadastrar Compra de Produtos");
        mnuTransacoes.add(mniCompraProduto);

        mniVendaRefeicao.setText("Cadastrar Venda de Refeições");
        mnuTransacoes.add(mniVendaRefeicao);

        jmbBarraMenu.add(mnuTransacoes);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1251, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 645, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarPActionPerformed
        
        frmProdutoBuscar janela = new frmProdutoBuscar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniBuscarPActionPerformed

    private void mniEditarRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditarRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniEditarRActionPerformed

    private void mniLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniLogoffActionPerformed

    private void mniEditarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniEditarPActionPerformed
        frmProdutoEditar janela = new frmProdutoEditar(null, null);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniEditarPActionPerformed

    private void mniVendaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVendaProdutoActionPerformed
        frmVendaCadastrar janela = new frmVendaCadastrar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniVendaProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JMenuBar jmbBarraMenu;
    private javax.swing.JMenuItem mniBuscarP;
    private javax.swing.JMenuItem mniCompraProduto;
    private javax.swing.JMenuItem mniEditarC;
    private javax.swing.JMenuItem mniEditarFo;
    private javax.swing.JMenuItem mniEditarFu;
    private javax.swing.JMenuItem mniEditarP;
    private javax.swing.JMenuItem mniEditarR;
    private javax.swing.JMenuItem mniListarC;
    private javax.swing.JMenuItem mniListarFo;
    private javax.swing.JMenuItem mniListarFu;
    private javax.swing.JMenuItem mniListarR;
    private javax.swing.JMenuItem mniLogoff;
    private javax.swing.JMenuItem mniRelatorios;
    private javax.swing.JMenuItem mniRelatoriosC;
    private javax.swing.JMenuItem mniRelatoriosFu;
    private javax.swing.JMenuItem mniRelatoriosP;
    private javax.swing.JMenuItem mniRelatoriosR;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JMenuItem mniVendaProduto;
    private javax.swing.JMenuItem mniVendaRefeicao;
    private javax.swing.JMenu mnuClientes;
    private javax.swing.JMenu mnuFornecedores;
    private javax.swing.JMenu mnuFuncionarios;
    private javax.swing.JMenu mnuProdutos;
    private javax.swing.JMenu mnuRefeicao;
    private javax.swing.JMenu mnuSGV;
    private javax.swing.JMenu mnuTransacoes;
    // End of variables declaration//GEN-END:variables
}
