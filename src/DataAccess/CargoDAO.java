
package DataAccess;

import DominModel.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CargoDAO extends DAO{
    //Construtor
    public CargoDAO() {
        super();
    }
    
    //Método Salvar
    public boolean Salvar(Cargo obj) {
        if (obj.getCodigo() == 0) {
            try {
                //Insere os dados na tabela Pessoas
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into Cargos(cargo) values(?)");
                sqlInsert.setString(1, obj.getCargo());                
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codCargo from Cargos where cargo = ? ");
                sqlConsulta.setString(1, obj.getCargo());
                
                
                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codCargo"));
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
                PreparedStatement sqlUpdate = con.prepareStatement
                        ("update Cargos set cargo=? where codCargo=?");
                sqlUpdate.setString(1, obj.getCargo());
                sqlUpdate.setInt(2, obj.getCodigo());
                
                sqlUpdate.executeUpdate();               
                
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    //Método Remover
    
    
    
    
    
}
