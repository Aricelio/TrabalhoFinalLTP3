package Presentation;

import DominModel.Funcionario;
import DominModel.Sessao;
import DominModel.Caixa;
import DataAccess.SessaoDAO;
import DataAccess.UsuarioDAO;
import DominModel.Usuario;
import DataAccess.CaixaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmPrincipal extends javax.swing.JFrame {

    //Declaração de Variaveis
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Usuario usuario;
    CaixaDAO caixaDAO = new CaixaDAO();
    Funcionario funcionario = new Funcionario();
    Sessao sessao;
    SessaoDAO sessaoDAO;
    Caixa caixa = new Caixa();

    
    //Construtor
    public frmPrincipal(Funcionario funcionario) {
        initComponents();
        this.funcionario = funcionario;
        lblNomeUsuario.setText(this.funcionario.getNome());
        carregaSessao(funcionario);
    }

    //Seta inicio da Sessão
    private void carregaSessao(Funcionario funcionario) {
        Date data = new Date();
        try {
            sessao = new Sessao();
            sessaoDAO = new SessaoDAO();
            caixa = caixaDAO.AbrirCaixa(1);

            sessao.setDataInicio(data);
            sessao.setUsuario(usuarioDAO.AbrirUsuario(funcionario.getCodigo()));
            sessao.setCaixa(caixa);
            sessao.setSaldoAbertura(caixa.getSaldo());

            sessaoDAO.Salvar(sessao);
            txtInicioSessao.setValue(sessao.getDataInicio());
        } catch (Exception ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        lblUsuario = new javax.swing.JLabel();
        sprInferior = new javax.swing.JSeparator();
        lblSessao = new javax.swing.JLabel();
        txtInicioSessao = new javax.swing.JFormattedTextField();
        lblNomeUsuario = new javax.swing.JLabel();
        jmbBarraMenu = new javax.swing.JMenuBar();
        mnuSGV = new javax.swing.JMenu();
        mniLogoff = new javax.swing.JMenuItem();
        mniSair = new javax.swing.JMenuItem();
        mnuProdutos = new javax.swing.JMenu();
        mniNovoP = new javax.swing.JMenuItem();
        mniBuscarP = new javax.swing.JMenuItem();
        mniRelatorioProduto = new javax.swing.JMenu();
        mniRelatorioProdutoCadastrado = new javax.swing.JMenuItem();
        mniRelatorioProdutoEstoqueBaixo = new javax.swing.JMenuItem();
        mnuRefeicao = new javax.swing.JMenu();
        mniNovoR = new javax.swing.JMenuItem();
        mniBuscarRefeicao = new javax.swing.JMenuItem();
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
        mniBuscarFornecedor = new javax.swing.JMenuItem();
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
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario:");

        lblSessao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSessao.setText("Sessão iniacada: ");

        txtInicioSessao.setEditable(false);
        txtInicioSessao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));

        lblNomeUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        mnuSGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Sucesso.png"))); // NOI18N
        mnuSGV.setText("SGV");

        mniLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/cadeado.png"))); // NOI18N
        mniLogoff.setText("Logoff");
        mniLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoffActionPerformed(evt);
            }
        });
        mnuSGV.add(mniLogoff);

        mniSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Apagar.png"))); // NOI18N
        mniSair.setText("Fechar");
        mnuSGV.add(mniSair);

        jmbBarraMenu.add(mnuSGV);

        mnuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/caixa.png"))); // NOI18N
        mnuProdutos.setText("Produtos");

        mniNovoP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Document-icon.png"))); // NOI18N
        mniNovoP.setText("Novo");
        mniNovoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoPActionPerformed(evt);
            }
        });
        mnuProdutos.add(mniNovoP);

        mniBuscarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/pesquisa.png"))); // NOI18N
        mniBuscarP.setText("Buscar");
        mniBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarPActionPerformed(evt);
            }
        });
        mnuProdutos.add(mniBuscarP);

        mniRelatorioProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/relatorio.png"))); // NOI18N
        mniRelatorioProduto.setText("Relatorios");

        mniRelatorioProdutoCadastrado.setText("Produtos Cadastrados");
        mniRelatorioProdutoCadastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRelatorioProdutoCadastradoActionPerformed(evt);
            }
        });
        mniRelatorioProduto.add(mniRelatorioProdutoCadastrado);

        mniRelatorioProdutoEstoqueBaixo.setText("Produtos com Estoque Baixo");
        mniRelatorioProdutoEstoqueBaixo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRelatorioProdutoEstoqueBaixoActionPerformed(evt);
            }
        });
        mniRelatorioProduto.add(mniRelatorioProdutoEstoqueBaixo);

        mnuProdutos.add(mniRelatorioProduto);

        jmbBarraMenu.add(mnuProdutos);

        mnuRefeicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/bolo.png"))); // NOI18N
        mnuRefeicao.setText("Refeicao");

        mniNovoR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Document-icon.png"))); // NOI18N
        mniNovoR.setText("Novo");
        mniNovoR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoRActionPerformed(evt);
            }
        });
        mnuRefeicao.add(mniNovoR);

        mniBuscarRefeicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/pesquisa.png"))); // NOI18N
        mniBuscarRefeicao.setText("Buscar");
        mniBuscarRefeicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarRefeicaoActionPerformed(evt);
            }
        });
        mnuRefeicao.add(mniBuscarRefeicao);

        mniRelatoriosR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/relatorio.png"))); // NOI18N
        mniRelatoriosR.setText("Relatórios");
        mnuRefeicao.add(mniRelatoriosR);

        jmbBarraMenu.add(mnuRefeicao);

        mnuClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Pessoa.png"))); // NOI18N
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

        mniBuscarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/pesquisa.png"))); // NOI18N
        mniBuscarCli.setText("Buscar");
        mniBuscarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarCliActionPerformed(evt);
            }
        });
        mnuClientes.add(mniBuscarCli);

        mniRelatoriosC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/relatorio.png"))); // NOI18N
        mniRelatoriosC.setText("Relatórios");
        mnuClientes.add(mniRelatoriosC);

        jmbBarraMenu.add(mnuClientes);

        mnuFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Contact-Card-icon.png"))); // NOI18N
        mnuFuncionarios.setText("Funcionarios");

        mniNovoFu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Pessoa.png"))); // NOI18N
        mniNovoFu.setText("Novo");
        mniNovoFu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoFuActionPerformed(evt);
            }
        });
        mnuFuncionarios.add(mniNovoFu);

        mniListarFu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/pesquisa.png"))); // NOI18N
        mniListarFu.setText("Buscar");
        mniListarFu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniListarFuActionPerformed(evt);
            }
        });
        mnuFuncionarios.add(mniListarFu);

        mniRelatoriosFu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/relatorio.png"))); // NOI18N
        mniRelatoriosFu.setText("Relatorios");
        mnuFuncionarios.add(mniRelatoriosFu);

        jmbBarraMenu.add(mnuFuncionarios);

        mnuFornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Casa.png"))); // NOI18N
        mnuFornecedores.setText("Fornecedores");

        mniNovoFo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Casa.png"))); // NOI18N
        mniNovoFo.setText("Novo");
        mniNovoFo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNovoFoActionPerformed(evt);
            }
        });
        mnuFornecedores.add(mniNovoFo);

        mniBuscarFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/pesquisa.png"))); // NOI18N
        mniBuscarFornecedor.setText("Buscar");
        mniBuscarFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniBuscarFornecedorActionPerformed(evt);
            }
        });
        mnuFornecedores.add(mniBuscarFornecedor);

        mniRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/relatorio.png"))); // NOI18N
        mniRelatorios.setText("Relatórios");
        mnuFornecedores.add(mniRelatorios);

        jmbBarraMenu.add(mnuFornecedores);

        mnuTransacoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Shopping-Cart-icon.png"))); // NOI18N
        mnuTransacoes.setText("Transações");

        mniVendaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Shopping-Cart-icon.png"))); // NOI18N
        mniVendaProduto.setText("Cadastrar Venda de Produtos");
        mniVendaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVendaProdutoActionPerformed(evt);
            }
        });
        mnuTransacoes.add(mniVendaProduto);

        mniCompraProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Shopping-Cart-icon.png"))); // NOI18N
        mniCompraProduto.setText("Cadastrar Compra de Produtos");
        mniCompraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCompraProdutoActionPerformed(evt);
            }
        });
        mnuTransacoes.add(mniCompraProduto);

        mniVendaRefeicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Icones/Shopping-Cart-icon.png"))); // NOI18N
        mniVendaRefeicao.setText("Cadastrar Venda de Refeições");
        mniVendaRefeicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniVendaRefeicaoActionPerformed(evt);
            }
        });
        mnuTransacoes.add(mniVendaRefeicao);

        jmbBarraMenu.add(mnuTransacoes);

        setJMenuBar(jmbBarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sprInferior, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(624, Short.MAX_VALUE)
                .addComponent(lblSessao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtInicioSessao, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235)
                .addComponent(lblUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(602, Short.MAX_VALUE)
                .addComponent(sprInferior, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsuario)
                        .addComponent(lblSessao)
                        .addComponent(txtInicioSessao))
                    .addComponent(lblNomeUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarPActionPerformed

        frmProdutoBuscar janela = new frmProdutoBuscar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniBuscarPActionPerformed

    private void mniNovoRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoRActionPerformed
        frmRefeicaoEditar janela = new frmRefeicaoEditar(null, null);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniNovoRActionPerformed

    private void mniLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoffActionPerformed
        logoff();
    }//GEN-LAST:event_mniLogoffActionPerformed

    private void mniNovoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoPActionPerformed
        frmProdutoEditar janela = new frmProdutoEditar(null, null, true);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniNovoPActionPerformed

    private void mniVendaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVendaProdutoActionPerformed
        frmVendaCadastrar janela = new frmVendaCadastrar(funcionario,sessao);
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
        frmFornecedorEditar janela = new frmFornecedorEditar(null, null);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniNovoFoActionPerformed

    private void mniListarFuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniListarFuActionPerformed
        Usuario userSistema;
        userSistema = usuarioDAO.AbrirUsuario(funcionario.getCodigo());
        frmFuncionarioBuscar janela = new frmFuncionarioBuscar(userSistema);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniListarFuActionPerformed

    private void mniNovoFuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNovoFuActionPerformed
        usuario = usuarioDAO.AbrirUsuario(funcionario.getCodigo());
                
        if (("root".equals(usuario.getLogin())) && ("root".equals(usuario.getSenha()))){
            frmFuncionarioEditar janela = new frmFuncionarioEditar(null, null, null, usuario);
            add(janela);
            janela.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Para acessar esse formulario é preciso ser usuario administrador");
        }
            
    }//GEN-LAST:event_mniNovoFuActionPerformed

    private void mniBuscarFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarFornecedorActionPerformed
        frmFornecedorBuscar janela = new frmFornecedorBuscar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniBuscarFornecedorActionPerformed

    private void mniBuscarRefeicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniBuscarRefeicaoActionPerformed
        frmRefeicaoBuscar janela = new frmRefeicaoBuscar();
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniBuscarRefeicaoActionPerformed

    private void mniCompraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCompraProdutoActionPerformed
        frmCompraCadastrar janela = new frmCompraCadastrar(funcionario,sessao);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniCompraProdutoActionPerformed

    private void mniVendaRefeicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniVendaRefeicaoActionPerformed
        frmVendaRefeicaoCadastrar janela = new frmVendaRefeicaoCadastrar(funcionario,sessao);
        add(janela);
        janela.setVisible(true);
    }//GEN-LAST:event_mniVendaRefeicaoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logoff();
    }//GEN-LAST:event_formWindowClosing

    private void mniRelatorioProdutoCadastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRelatorioProdutoCadastradoActionPerformed
        /*Connection conn = null;
        try {
            // Obtém o diretório da aplicação
            String arquivo = System.getProperty("user.dir");

            // Carrega conexão via JDBC
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/trabalhofinal", "root", "");
            Statement sql = conn.createStatement();

            // Carrega fonte de dados
            ResultSet rs = sql.executeQuery("SELECT * FROM produtos where ativo = 1");
            JRDataSource ds = new JRResultSetDataSource(rs);

            // Preenche o relatório com os dados
            JasperPrint print = JasperFillManager.fillReport(arquivo + "/src/Presentation/RelatorioProdutosCadastrados.jasper", null, ds);

            // Exibe visualização dos dados
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } /*catch (ClassNotFoundException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } (catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }//GEN-LAST:event_mniRelatorioProdutoCadastradoActionPerformed

    private void mniRelatorioProdutoEstoqueBaixoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRelatorioProdutoEstoqueBaixoActionPerformed
        /*Connection conn = null;
        try {
            // Obtém o diretório da aplicação
            String arquivo = System.getProperty("user.dir");

            // Carrega conexão via JDBC
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/trabalhofinal", "root", "");
            Statement sql = conn.createStatement();

            // Carrega fonte de dados
            ResultSet rs = sql.executeQuery("SELECT * FROM pessoa");
            JRDataSource ds = new JRResultSetDataSource(rs);

            // Preenche o relatório com os dados
            JasperPrint print = JasperFillManager.fillReport(arquivo + "/src/Presentation/RelatorioProdutosEstoque.jasper", null, ds);

            // Exibe visualização dos dados
            JasperViewer.viewReport(print, false);

        } catch (JRException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } /*catch (ClassNotFoundException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } (catch (SQLException ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }//GEN-LAST:event_mniRelatorioProdutoEstoqueBaixoActionPerformed

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
                new frmPrincipal(null).setVisible(true);
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
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblSessao;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenuItem mniBuscarCli;
    private javax.swing.JMenuItem mniBuscarFornecedor;
    private javax.swing.JMenuItem mniBuscarP;
    private javax.swing.JMenuItem mniBuscarRefeicao;
    private javax.swing.JMenuItem mniCompraProduto;
    private javax.swing.JMenuItem mniListarFu;
    private javax.swing.JMenuItem mniLogoff;
    private javax.swing.JMenuItem mniNovoC;
    private javax.swing.JMenuItem mniNovoFo;
    private javax.swing.JMenuItem mniNovoFu;
    private javax.swing.JMenuItem mniNovoP;
    private javax.swing.JMenuItem mniNovoR;
    private javax.swing.JMenu mniRelatorioProduto;
    private javax.swing.JMenuItem mniRelatorioProdutoCadastrado;
    private javax.swing.JMenuItem mniRelatorioProdutoEstoqueBaixo;
    private javax.swing.JMenuItem mniRelatorios;
    private javax.swing.JMenuItem mniRelatoriosC;
    private javax.swing.JMenuItem mniRelatoriosFu;
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
    private javax.swing.JSeparator sprInferior;
    private javax.swing.JFormattedTextField txtInicioSessao;
    // End of variables declaration//GEN-END:variables

    //Faz logoff no sistema
    protected void logoff() {
        Date data = new Date();
        try {
            sessao.setDataTermino(data);
            sessao.setSaldoFechamento(caixa.getSaldo());
            sessaoDAO.Salvar(sessao);


            frmLogin janela = new frmLogin();

            janela.setVisible(true);
            setVisible(false);
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
