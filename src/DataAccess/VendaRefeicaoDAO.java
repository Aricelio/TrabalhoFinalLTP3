
package DataAccess;

import DominModel.ItemVendaRefeicao;
import DominModel.Refeicao;
import DominModel.Venda;
import DominModel.VendaRefeicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaRefeicaoDAO extends DAO{
    
    //Construtor
    public VendaRefeicaoDAO(){
        super();
    }
    
    //Método Salvar
    public boolean Salvar(VendaRefeicao obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into vendaRefeicao(data,valorTotal,formaPagamento,codSessao,codFuncionario,codCliente) values(?,?,?,?,?,?)");
                //sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setDouble(2, obj.getValorTotal());
                sql.setString(3, obj.getFormaPagamento());
                sql.setInt(4, obj.getSessao().getCodigo());
                sql.setInt(5, obj.getFuncionario().getCodigo());
                sql.setInt(6, obj.getCliente().getCodigo());
                sql.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codVendaRefeicao  from vendaRefeicao where valorTotal=? and Data=? and formaPagamento=? and codSessao=? and codFuncionario=? and codCliente=?");
                sqlConsulta.setDouble(1, obj.getValorTotal());
                sqlConsulta.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sqlConsulta.setString(3, obj.getFormaPagamento());
                sqlConsulta.setInt(4, obj.getSessao().getCodigo());
                sqlConsulta.setInt(5, obj.getFuncionario().getCodigo());
                sqlConsulta.setInt(6, obj.getCliente().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codVendaRefeicao"));
                }

                //Salva o um item de venda
                for (ItemVendaRefeicao it : obj.getItensVendaRefeicao()) {
                    SalvarItemVenda(it.getRefeicao(), obj, it);
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
                        ("update VendaRefeicao set valorTotal=?, Data=?,formaPagamento=?,codSessao=?,codFuncionario=?,codCliente=? where codVendaRefeicao=?");
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
    
    //Método Salvar Item da venda
    private void SalvarItemVenda(Refeicao refeicao, VendaRefeicao vendaRefeicao, ItemVendaRefeicao obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement(
                        "insert into ItemVendaRefeicao(codRefeicao,codVendaRefeicao,quantidade) values(?,?,?)");
                sql.setInt(1, refeicao.getCodigo());
                sql.setInt(2, vendaRefeicao.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.executeUpdate();

                obj.setCodigo(vendaRefeicao.getCodigo());

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("update ItemVendaRefeicao set quantidade=?, codRefeicao=? where  codVendaRefeicao=?");
                sql.setInt(1, obj.getQuantidade());
                sql.setInt(2, refeicao.getCodigo());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    //Método Remover
    public boolean RemoverVenda(VendaRefeicao obj) {
        if (obj.getCodigo() > 0) {
            try {
                //Apaga o registro da tabela de ItensVenda
                PreparedStatement sqlDeleteItens = getConexao().prepareStatement
                        ("delete from ItemVendaRefeicao where codVendaRefeicao=?");
                sqlDeleteItens.setInt(1, obj.getCodigo());
                sqlDeleteItens.executeUpdate();

                //Apaga o resgistro da tabela de Vendas
                PreparedStatement sql = getConexao().prepareStatement
                        ("delete from vendaRefeicao where codVendaRefeicao=?");
                sql.setInt(1, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    //Método Abrir VendaRefeicao
    public Venda Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from VendaRefeicao where codVendaRefeicao=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Venda obj = new Venda();
                SessaoDAO sessao = new SessaoDAO();
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();
                
                CarregaObjetoVendaRefeicao(obj, resultado, sessao, cliente, funcionario);

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
            PreparedStatement sql = getConexao().prepareStatement("select * from VendaRefeicao");

            ResultSet resultado = sql.executeQuery();

            List<Venda> lista = new ArrayList<Venda>();

            while (resultado.next()) {
                Venda obj = new Venda();
                SessaoDAO sessao = new SessaoDAO();
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();

                CarregaObjetoVendaRefeicao(obj, resultado, sessao, cliente, funcionario);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    //Método que Carrega os dados da venda
    protected void CarregaObjetoVendaRefeicao(Venda obj, ResultSet resultado, SessaoDAO sessao, ClienteDAO cliente, FuncionarioDAO funcionario) throws SQLException, Exception {
        obj.setCodigo(resultado.getInt("codVendaRefeicao"));
        obj.setData(resultado.getDate("Data"));
        obj.setValorTotal(resultado.getDouble("ValorTotal"));
        obj.setFormaPagamento(resultado.getString("formaPagamento"));
        obj.setSessao(sessao.Abrir(resultado.getInt("codSessao")));
        obj.setCliente(cliente.AbrirCliente(resultado.getInt("codCliente")));
        obj.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("codFuncionario")));
    }
}
