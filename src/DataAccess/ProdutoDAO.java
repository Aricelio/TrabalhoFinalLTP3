package DataAccess;

import DominModel.Estoque;
import DominModel.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAO {

    //Construtor
    public ProdutoDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Produto obj, Estoque estoque) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into produtos(nome,preco,descricao,codTipoProduto,ativo) values(?,?,?,?,?)");
                sqlInsert.setString(1, obj.getNome());
                sqlInsert.setDouble(2, obj.getPreco());
                sqlInsert.setString(3, obj.getDescricao());
                sqlInsert.setInt(4, obj.getTipo().getCodigo());
                sqlInsert.setInt(5, obj.getAtivo());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codProduto from Produtos where nome= ? and descricao = ? and preco=? and codTipoProduto=?");
                sqlConsulta.setString(1, obj.getNome());
                sqlConsulta.setString(2, obj.getDescricao());
                sqlConsulta.setDouble(3, obj.getPreco());
                sqlConsulta.setInt(4, obj.getTipo().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codProduto"));
                }

                //Salva o estoque
                EstoqueDAO estoqueDAO = new EstoqueDAO();
                estoqueDAO.SalvarEstoque(estoque);

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Produtos set Nome=?, Descricao=? , preco=? , codTipoProduto=? where codProduto=?");
                sql.setString(1, obj.getNome());
                sql.setString(2, obj.getDescricao());
                sql.setDouble(3, obj.getPreco());
                sql.setInt(4, obj.getTipo().getCodigo());
                sql.setInt(5, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Método RemoverProduto
    public boolean Remover(Produto obj) {
        if ((obj.getCodigo() > 0) && (obj.getAtivo() == 1)) {
            try {
                EstoqueDAO estoqueDAO = new EstoqueDAO();

                //Seta o atributo ativo com valor '0'
                PreparedStatement sqlUpdate = getConexao().prepareStatement("update Produtos set ativo = 0 where codProduto=?");
                sqlUpdate.setInt(1, obj.getCodigo());
                sqlUpdate.executeUpdate();

                //Remove o registro do estoque referente ao Produto 
                estoqueDAO.RemoverEstoque(estoqueDAO.AbrirEstoque(obj.getCodigo()));

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    //Abrir produto
    public Produto Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from produtos where codProduto=? and ativo = 1");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Produto obj = new Produto();

                CarregaObjetoProduto(obj, resultado);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Listar Todos
    public List<Produto> ListarProdutos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Produtos where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();

                CarregaObjetoProduto(obj, resultado);

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Buscar
    public List<Produto> Buscar(Produto filtro) {
        try {
            String sql = "select * from Produtos where ativo = 1";
            String where = "";

            if (filtro.getNome() != null) {
                if (filtro.getNome().length() > 0) {
                    where = " nome like '%" + filtro.getNome() + "%' ";
                }
            }
            
            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " codProduto = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            List<Produto> lista = new ArrayList<Produto>();

            while (resultado.next()) {
                Produto obj = new Produto();
                CarregaObjetoProduto(obj, resultado);
                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    protected void CarregaObjetoProduto(Produto obj, ResultSet resultado) throws Exception, SQLException {
        TipoProdutoDAO tipo = new TipoProdutoDAO();

        obj.setCodigo(resultado.getInt("codProduto"));
        obj.setNome(resultado.getString("Nome"));
        obj.setDescricao(resultado.getString("Descricao"));
        obj.setPreco(resultado.getDouble("Preco"));
        obj.setTipo(tipo.Abrir(resultado.getInt("codTipoProduto")));
    }
}
