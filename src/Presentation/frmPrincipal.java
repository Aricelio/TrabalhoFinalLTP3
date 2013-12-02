
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
        mniNovoP = new javax.swing.JMenuItem();
        mniBuscarP = new javax.swing.JMenuItem();
        mniRelatoriosP = new javax.swing.JMenuItem();
        mnuRefeicao = new javax.swing.JMenu();
        mniNovoR = new javax.swing.JMenuItem();
        mniListarR = new javax.swing.JMenuItem();
        mniRelatoriosR = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenu();
        mniNovoC = new javax.swing.JMenuItem();
        mniBuscarCli = new javax.swing.JMenuItem();
        mniRelatoriosC = new javax.swing.JMenuItem();
        mnuFuncionarios = new javax.swing.JMenu();
        mniNovoFu = new javax.swing.JMenuItem();
        mniListarFu = new javax.swing.JMenuItem();
        mniRelatoriosFu = new javax.swing.JMenuItem();
        mnuFornecedores = new javax.swing.JMenu();
        mniNovoFo = new javax.swing.JMenuItem();
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

        mniNovoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Document-icon.png"))); // NOI18N
        mniNovoP.setText("Novo");
        mniNovoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoPActionPerformed(evt);
            }
        });
        mnuProdutos.add(mniNovoP);

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

        mniNovoR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Document-icon.png"))); // NOI18N
        mniNovoR.setText("Novo");
        mniNovoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoRActionPerformed(evt);
            }
        });
        mnuRefeicao.add(mniNovoR);

        mniListarR.setText("Listar Tipos");
        mnuRefeicao.add(mniListarR);

        mniRelatoriosR.setText("Relatórios");
        mnuRefeicao.add(mniRelatoriosR);

        jmbBarraMenu.add(mnuRefeicao);

        mnuClientes.setText("Clientes");
        mnuClientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mniNovoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Pessoa.png"))); // NOI18N
        mniNovoC.setText("Novo");
        mniNovoC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoCActionPerformed(evt);
            }
        });
        mnuClientes.add(mniNovoC);

        mniBuscarCli.setText("Buscar");
        mniBuscarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarCliActionPerformed(evt);
            }
        });
        mnuClientes.add(mniBuscarCli);

        mniRelatoriosC.setText("Relatórios");
        mnuClientes.add(mniRelatoriosC);

        jmbBarraMenu.add(mnuClientes);

        mnuFuncionarios.setText("Funcionarios");

        mniNovoFu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Pessoa.png"))); // NOI18N
        mniNovoFu.setText("Novo");
        mnuFuncionarios.add(mniNovoFu);

        mniListarFu.setText("Buscar");
        mniListarFu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListarFuActionPerformed(evt);
            }
        });
        mnuFuncionarios.add(mniListarFu);

        mniRelatoriosFu.setText("Relatorios");
        mnuFuncionarios.add(mniRelatoriosFu);

        jmbBarraMenu.add(mnuFuncionarios);

        mnuFornecedores.setText("Fornecedores");

        mniNovoFo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Casa.png"))); // NOI18N
        mniNovoFo.setText("Novo");
        mniNovoFo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoFoActionPerformed(evt);
            }
        });
        mnuFornecedores.add(mniNovoFo);

        mniListarFo.setText("Buscar");
        mnuFornecedores.add(mniListarFo);

        mniRelatorios.setText("Relatórios");
        mnuFornecedores.add(mniRelatorios);

        jmbBarraMenu.add(mnuFornecedores);

        mnuTransacoes.setText("Transações");

        mniVendaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Shopping-Cart-icon.png"))); // NOI18N
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

    private void mniNovoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniNovoRActionPerformed

    private void mniLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniLogoffActionPerformed

    private void mniNovoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoPActionPerformed
        frmProdutoEditar janela = new frmProdutoEditar(null, null, true);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniNovoPActionPerformed

    private void mniVendaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVendaProdutoActionPerformed
        frmVendaCadastrar janela = new frmVendaCadastrar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniVendaProdutoActionPerformed

    private void mniBuscarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarCliActionPerformed
        frmClienteBuscar janela = new frmClienteBuscar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniBuscarCliActionPerformed

    private void mniNovoCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoCActionPerformed
        frmClienteEditar janela = new frmClienteEditar(null, null);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniNovoCActionPerformed

    private void mniNovoFoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoFoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mniNovoFoActionPerformed

    private void mniListarFuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListarFuActionPerformed
        frmFuncionarioBuscar janela = new frmFuncionarioBuscar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniListarFuActionPerformed

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
    private javax.swing.JMenuItem mniBuscarCli;
    private javax.swing.JMenuItem mniBuscarP;
    private javax.swing.JMenuItem mniCompraProduto;
    private javax.swing.JMenuItem mniListarFo;
    private javax.swing.JMenuItem mniListarFu;
    private javax.swing.JMenuItem mniListarR;
    private javax.swing.JMenuItem mniLogoff;
    private javax.swing.JMenuItem mniNovoC;
    private javax.swing.JMenuItem mniNovoFo;
    private javax.swing.JMenuItem mniNovoFu;
    private javax.swing.JMenuItem mniNovoP;
    private javax.swing.JMenuItem mniNovoR;
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
