package DataAccess;

import DominModel.Fornecedor;
import DominModel.ItemProdutoFornecedor;
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
    public boolean Salvar(Produto obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into produtos(nome,preco,descricao,codTipoProduto,ativo) values(?,?,?,?,?)");
                sqlInsert.setString(1, obj.getNome());
                sqlInsert.setDouble(2, obj.getPreco());
                sqlInsert.setString(3, obj.getDescricao());
                sqlInsert.setInt(4, obj.getTipo().getCodigo());
                sqlInsert.setInt(5, obj.getAtivo());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codProduto from Produtos where nome= ? and descricao = ? and preco=? and codTipoProduto=?");
                sqlConsulta.setString(1, obj.getNome());
                sqlConsulta.setString(2, obj.getDescricao());
                sqlConsulta.setDouble(3, obj.getPreco());
                sqlConsulta.setInt(4, obj.getTipo().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codProduto"));
                }

                //Salva o estoque
                if (obj.getEstoque() > 0) {
                    PreparedStatement sqlInsertEstoque = getConexao().prepareStatement
                            ("insert into estoque(estoque,codProduto) values(?,?)");
                    sqlInsertEstoque.setInt(1, obj.getEstoque());
                    sqlInsertEstoque.setInt(2, obj.getCodigo());
                }


                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement
                        ("update Produtos set Nome=?, Descricao=? , preco=? , codTipoProduto=? where codProduto=?");
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
                //Seta o atributo ativo com valor '0'
                PreparedStatement sqlUpdate = getConexao().prepareStatement
                        ("update Produtos set ativo = 0 where codProduto=?");
                sqlUpdate.setInt(1, obj.getCodigo());
                sqlUpdate.executeUpdate();

                //Remove o registro do estoque referente ao Produto 
                PreparedStatement sqlDeleteEstoque = getConexao().prepareStatement
                        ("delete from estoque where codProduto=?");
                sqlDeleteEstoque.setInt(1, obj.getCodigo());

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
            PreparedStatement sqlConsultaProduto = getConexao().prepareStatement
                    ("select * from produtos where codProduto=? and ativo = 1");            
            sqlConsultaProduto.setInt(1, id);
            
            PreparedStatement sqlConsultaEstoque = getConexao().prepareStatement
                    ("select * from estoque where codProduto=?");            
            sqlConsultaEstoque.setInt(1, id);

            ResultSet resultadoProduto = sqlConsultaProduto.executeQuery();
            ResultSet resultadoEstoque = sqlConsultaEstoque.executeQuery();

            if (resultadoProduto.next()) {
                Produto obj = new Produto();

                CarregaObjetoProduto(obj, resultadoProduto);
                
                if(resultadoEstoque.next()){
                    obj.setEstoque(resultadoEstoque.getInt("estoque"));
                }
                
                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Listar itemProdutoFornecedor
    public List<ItemProdutoFornecedor> ListarItemProdutoFornecedor(Produto obj){
        try{
            List<ItemProdutoFornecedor> lista = new ArrayList<ItemProdutoFornecedor>();
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from ItemProdutoFornecedor where codProduto=?");
            sql.setInt(1, obj.getCodigo());
            
            ResultSet resultado  = sql.executeQuery();
            
            while(resultado.next()){
                ItemProdutoFornecedor item = new ItemProdutoFornecedor();
                FornecedorDAO dao = new FornecedorDAO();
                
                item.setFornecedor(dao.AbrirFornecedor(resultado.getInt("codFornecedor")));
                item.setProduto(obj);
                item.setCodigo(obj.getCodigo());
                
                lista.add(item);
            }
            return lista;
        }
        catch(Exception ex){
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

            //Filtra o Nome
            if (filtro.getNome() != null) {
                if (filtro.getNome().length() > 0) {
                    where = " nome like '%" + filtro.getNome() + "%' ";
                }
            }

            //Filtra o Codigo
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
