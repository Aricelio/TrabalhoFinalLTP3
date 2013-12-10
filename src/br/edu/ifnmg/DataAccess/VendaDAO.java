package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.DominModel.ItemVenda;
import br.edu.ifnmg.DominModel.Produto;
import br.edu.ifnmg.DominModel.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO extends DAO {

    //Construtor
    public VendaDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Venda obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into vendas(data,valorTotal,formaPagamento,codSessao,codFuncionario,codCliente) values(?,?,?,?,?,?)");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setDouble(2, obj.getValorTotal());
                sql.setString(3, obj.getFormaPagamento());
                sql.setInt(4, obj.getSessao().getCodigo());
                sql.setInt(5, obj.getFuncionario().getCodigo());
                sql.setInt(6, obj.getCliente().getCodigo());
                sql.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codVenda from Vendas where valorTotal=? and Data=? and formaPagamento=? and codSessao=? and codFuncionario=? and codCliente=?");
                sqlConsulta.setDouble(1, obj.getValorTotal());
                sqlConsulta.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sqlConsulta.setString(3, obj.getFormaPagamento());
                sqlConsulta.setInt(4, obj.getSessao().getCodigo());
                sqlConsulta.setInt(5, obj.getFuncionario().getCodigo());
                sqlConsulta.setInt(6, obj.getCliente().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codVenda"));
                }

                //Salva o um item de venda
                for (ItemVenda it : obj.getItensVenda()) {
                    SalvarItemVenda(it.getProduto(), obj, it);
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement
                        ("update Vendas set valorTotal=?, Data=?,formaPagamento=?,codSessao=?,codFuncionario=?,codCliente=? where codVenda=?");
                sqlUpdate.setDouble(1, obj.getValorTotal());
                sqlUpdate.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sqlUpdate.setString(3, obj.getFormaPagamento());
                sqlUpdate.setInt(4, obj.getSessao().getCodigo());
                sqlUpdate.setInt(5, obj.getFuncionario().getCodigo());
                sqlUpdate.setInt(6, obj.getCliente().getCodigo());
                sqlUpdate.setInt(7, obj.getCodigo());

                sqlUpdate.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Salva um Item da Venda
    private void SalvarItemVenda(Produto produto, Venda venda, ItemVenda obj) {
        if (obj.getCodigo() == 0) {
            try {
                int codEstoque;
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into ItemVenda(codProduto,codVenda,quantidade) values(?,?,?)");
                sql.setInt(1, produto.getCodigo());
                sql.setInt(2, venda.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.executeUpdate();

                obj.setCodigo(venda.getCodigo());
                
                //Atualiza o estoque
                PreparedStatement sqlConsultaEstoque = getConexao().prepareStatement
                        ("select * from estoque where codProduto=?");
                sqlConsultaEstoque.setInt(1, produto.getCodigo());
                
                ResultSet resultado = sqlConsultaEstoque.executeQuery();
                
                if(resultado.next()){
                    
                    
                    PreparedStatement sqlUpdateEstoque = getConexao().prepareStatement
                            ("update estoque set estoque=? where codProduto=?");
                    sqlUpdateEstoque.setInt(1, produto.getEstoque());
                    sqlUpdateEstoque.setInt(2, produto.getCodigo());
                    sqlUpdateEstoque.executeUpdate();
                }

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("update ItemVenda set quantidade=?, codProduto=? where  codVenda=?");
                sql.setInt(1, obj.getQuantidade());
                sql.setInt(2, produto.getCodigo());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    //Método Remover
    public boolean RemoverVenda(Venda obj) {
        if (obj.getCodigo() > 0) {
            try {
                //Apaga o registro da tabela de ItensVenda
                PreparedStatement sqlDeleteItens = getConexao().prepareStatement("delete from ItemVenda where codVenda=?");
                sqlDeleteItens.setInt(1, obj.getCodigo());
                sqlDeleteItens.executeUpdate();

                //Apaga o resgistro da tabela de Vendas
                PreparedStatement sql = getConexao().prepareStatement("delete from vendas where codVenda=?");
                sql.setInt(1, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    //Método AbriVenda
    public Venda Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Vendas where codVenda=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Venda obj = new Venda();
                SessaoDAO sessao = new SessaoDAO();
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();
                
                CarregaObjetoVenda(obj, resultado, sessao, cliente, funcionario);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Listar vendas
    public List<Venda> ListarVendas() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Vendas");

            ResultSet resultado = sql.executeQuery();

            List<Venda> lista = new ArrayList<Venda>();

            while (resultado.next()) {
                Venda obj = new Venda();
                SessaoDAO sessao = new SessaoDAO();
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();

                CarregaObjetoVenda(obj, resultado, sessao, cliente, funcionario);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método que Carrega os dados da venda
    protected void CarregaObjetoVenda(Venda obj, ResultSet resultado, SessaoDAO sessao, ClienteDAO cliente, FuncionarioDAO funcionario) throws SQLException, Exception {
        obj.setCodigo(resultado.getInt("codVenda"));
        obj.setData(resultado.getDate("Data"));
        obj.setValorTotal(resultado.getDouble("ValorTotal"));
        obj.setFormaPagamento(resultado.getString("formapagamento"));
        obj.setSessao(sessao.Abrir(resultado.getInt("codSessao")));
        obj.setCliente(cliente.AbrirCliente(resultado.getInt("codCliente")));
        obj.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("codFuncionario")));
    }
}
