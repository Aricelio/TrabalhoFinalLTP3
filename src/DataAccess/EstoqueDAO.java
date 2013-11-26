
package DataAccess;

import DominModel.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstoqueDAO extends DAO{

    //Construtor
    public EstoqueDAO() {
        super();
    }
    
    //Método Salvar
    public boolean SalvarEstoque(Estoque obj) {
        if (obj.getCodigo() == 0) {
            try {
                
                //Insere os dados na tabela Estoque
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into Estoque(estoque,codProduto) values(?,?)");
                sqlInsert.setInt(1, obj.getEstoque());
                sqlInsert.setInt(2, obj.getProduto().getCodigo());
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codEstoque from Estoque where estoque=? and codProduto=?");
                sqlConsulta.setInt(1, obj.getEstoque());
                sqlConsulta.setInt(2, obj.getProduto().getCodigo());
                
                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codEstoque"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                //Atualiza os dados
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Estoque set estoque=?, codProduto=? where codEstoque=?");
                sqlUpdate.setInt(1, obj.getEstoque());
                sqlUpdate.setInt(2, obj.getProduto().getCodigo());
                sqlUpdate.setInt(3, obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    
    //Abrir Estoque
    public Estoque AbrirEstoque(int codProduto) {
        try {
            Estoque estoque = new Estoque();
            ProdutoDAO produto = new ProdutoDAO();

            PreparedStatement sqlConsulta = getConexao().prepareStatement
                    ("select * from Estoque where codProduto=?");
            sqlConsulta.setInt(1, codProduto);

            ResultSet resultado = sqlConsulta.executeQuery();

            if (resultado.next()) {
                estoque.setCodigo(resultado.getInt("codEstoque"));
                estoque.setEstoque(resultado.getInt("estoque"));
                estoque.setProduto(produto.Abrir(resultado.getInt("codProduto")));

                return estoque;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    //Método Remover
    public boolean RemoverEstoque(Estoque obj) {
        if (obj.getCodigo() >= 0){
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement
                        ("delete from Estoque where codEstoque=? and codProduto=?");
                sqlDelete.setInt(1, obj.getCodigo());
                sqlDelete.setInt(2, obj.getProduto().getCodigo());
                sqlDelete.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
}
