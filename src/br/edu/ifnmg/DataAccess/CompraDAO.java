package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.DominModel.Compra;
import br.edu.ifnmg.DominModel.ItemCompra;
import br.edu.ifnmg.DominModel.Produto;
import br.edu.ifnmg.DataAccess.FornecedorDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO extends DAO {

    //Declaração de variaveis
    FornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    //Construtor
    public CompraDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Compra obj) {
        if (obj.getCodigo() == 0) {
            try {

                //Insere os dados na tabela de compra
                PreparedStatement sql = getConexao().prepareStatement("insert into compras(data,valorTotal,formaPagamento,codSessao,codFuncionario,codFornecedor) values(?,?,?,?,?,?)");
                sql.setDate(1, new java.sql.Date(obj.getData().getTime()));
                sql.setDouble(2, obj.getValorTotal());
                sql.setString(3, obj.getFormaPagamento());
                sql.setInt(4, obj.getSessao().getCodigo());
                sql.setInt(5, obj.getFuncionario().getCodigo());
                sql.setInt(6, obj.getFornecedor().getCodigo());
                sql.executeUpdate();

                //Pega o codigo da compra que foi gerando no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codCompra from compras where valorTotal=? and Data=? and formaPagamento=? and codSessao=? and codFuncionario=? and codFornecedor=?");
                sqlConsulta.setDouble(1, obj.getValorTotal());
                sqlConsulta.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sqlConsulta.setString(3, obj.getFormaPagamento());
                sqlConsulta.setInt(4, obj.getSessao().getCodigo());
                sqlConsulta.setInt(5, obj.getFuncionario().getCodigo());
                sqlConsulta.setInt(6, obj.getFornecedor().getCodigo());


                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codCompra"));
                }

                //Salva o um item de venda
                for (ItemCompra it : obj.getItensCompra()) {
                    SalvarItemCompra(it.getProduto(), obj, it);
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Compras set valorTotal=?, Data=?,formaPagamento=?,codSessao=?,codFuncionario=?,codFornecedor=? where codCompra=?");
                sqlUpdate.setDouble(1, obj.getValorTotal());
                sqlUpdate.setDate(2, new java.sql.Date(obj.getData().getTime()));
                sqlUpdate.setString(3, obj.getFormaPagamento());
                sqlUpdate.setInt(4, obj.getSessao().getCodigo());
                sqlUpdate.setInt(5, obj.getFuncionario().getCodigo());
                sqlUpdate.setInt(6, obj.getFornecedor().getCodigo());
                sqlUpdate.setInt(7, obj.getCodigo());
                sqlUpdate.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Salva um Item da Compra
    private void SalvarItemCompra(Produto produto, Compra compra, ItemCompra obj) {
        if (obj.getCodigo() == 0) {
            try {
                int codEstoque;
                boolean confirmacao = false;

                //Insere os dados na tabela ItemCompra
                PreparedStatement sql = getConexao().prepareStatement("insert into ItemCompra(codProduto,codCompra,quantidade) values(?,?,?)");
                sql.setInt(1, produto.getCodigo());
                sql.setInt(2, compra.getCodigo());
                sql.setInt(3, obj.getQuantidade());
                sql.executeUpdate();
                obj.setCodigo(compra.getCodigo());

                //Verifica se o produto ja tem o fornecedor em que foi feito a compra
                PreparedStatement sqlConsulta = getConexao().prepareStatement("select * from itemProdutoFornecedor where codProduto=?");
                sqlConsulta.setInt(1, produto.getCodigo());

                ResultSet resultadoConsulta = sqlConsulta.executeQuery();
                while (resultadoConsulta.next()) {
                    if (resultadoConsulta.getInt("codFornecedor") == compra.getFornecedor().getCodigo()) {
                        confirmacao = true;
                    } 
                }
                if (!confirmacao) {
                    PreparedStatement sqlInsert = getConexao().prepareStatement
                            ("insert into itemprodutofornecedor(codFornecedor,codProduto) values(?,?)");
                    sqlInsert.setInt(1, compra.getFornecedor().getCodigo());
                    sqlInsert.setInt(2, produto.getCodigo());
                    sqlInsert.executeUpdate();
                }


                //Atualiza o estoque
                PreparedStatement sqlConsultaEstoque = getConexao().prepareStatement
                        ("select * from estoque where codProduto=?");
                sqlConsultaEstoque.setInt(1, produto.getCodigo());

                ResultSet resultado = sqlConsultaEstoque.executeQuery();

                if (resultado.next()) {
                    PreparedStatement sqlUpdateEstoque = getConexao().prepareStatement
                            ("update estoque set estoque = ? where codProduto=?");
                    sqlUpdateEstoque.setInt(1, produto.getEstoque());
                    sqlUpdateEstoque.setInt(2, produto.getCodigo());
                    sqlUpdateEstoque.executeUpdate();
                } else {
                    PreparedStatement sqlInsertEstoque = getConexao().prepareStatement
                            ("insert into estoque(estoque,codProduto) values(?,?)");
                    sqlInsertEstoque.setInt(1, produto.getEstoque());
                    sqlInsertEstoque.setInt(2, produto.getCodigo());
                    sqlInsertEstoque.executeUpdate();
                }

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("update ItemCompra set quantidade=?, codProduto=? where  codCompra=?");
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
    public boolean RemoverVenda(Compra obj) {
        if (obj.getCodigo() > 0) {
            try {
                //Apaga o registro da tabela de ItensVenda
                PreparedStatement sqlDeleteItens = getConexao().prepareStatement
                        ("delete from ItemCompra where codCompra=?");
                sqlDeleteItens.setInt(1, obj.getCodigo());
                sqlDeleteItens.executeUpdate();

                //Apaga o resgistro da tabela de Vendas
                PreparedStatement sql = getConexao().prepareStatement
                        ("delete from compras where codCompra=?");
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
    public Compra Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from Compras where codCompra=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Compra obj = new Compra();
                SessaoDAO sessao = new SessaoDAO();
                FuncionarioDAO funcionario = new FuncionarioDAO();

                CarregaObjetoCompra(obj, resultado, sessao, funcionario);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Listar compras
    public List<Compra> ListarCompras() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Compras");

            ResultSet resultado = sql.executeQuery();

            List<Compra> lista = new ArrayList<Compra>();

            while (resultado.next()) {
                Compra obj = new Compra();
                SessaoDAO sessao = new SessaoDAO();
                FuncionarioDAO funcionario = new FuncionarioDAO();
                ClienteDAO cliente = new ClienteDAO();

                CarregaObjetoCompra(obj, resultado, sessao, funcionario);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método que Carrega os dados da venda
    protected void CarregaObjetoCompra(Compra obj, ResultSet resultado, SessaoDAO sessao, FuncionarioDAO funcionario) throws SQLException, Exception {

        obj.setCodigo(resultado.getInt("codCompra"));
        obj.setData(resultado.getDate("Data"));
        obj.setValorTotal(resultado.getDouble("ValorTotal"));
        obj.setFormaPagamento(resultado.getString("formapagamento"));
        obj.setSessao(sessao.Abrir(resultado.getInt("codSessao")));
        obj.setFuncionario(funcionario.AbrirFuncionario(resultado.getInt("codFuncionario")));
        obj.setFornecedor(fornecedorDAO.AbrirFornecedor(resultado.getInt("codFornecedor")));
    }
}
