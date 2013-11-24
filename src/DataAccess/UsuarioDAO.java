package DataAccess;

import DominModel.Funcionario;
import DominModel.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO extends DAO {

    public UsuarioDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Usuario obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into usuarios(login,senha,codFuncionario) values(?,?,?)");
                sql.setString(1, obj.getLogin());
                sql.setString(2, obj.getSenha());
                sql.setInt(3, obj.getFuncionario().getCodigo());
                sql.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codUsuario from Usuarios where login = ? and senha = ? and codFuncionario = ?");
                sqlConsulta.setString(1, obj.getLogin());
                sqlConsulta.setString(2, obj.getSenha());
                sqlConsulta.setInt(3, obj.getFuncionario().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codUsuario"));
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
                PreparedStatement sqlUpdate = con.prepareStatement("update Usuarios set login=?, senha=? where codUsuario=? and codFuncionario=?");
                sqlUpdate.setString(1, obj.getLogin());
                sqlUpdate.setString(2, obj.getSenha());
                sqlUpdate.setInt(3, obj.getCodigo());
                sqlUpdate.setInt(4, obj.getFuncionario().getCodigo());

                sqlUpdate.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    //Método Remover Usuario
    public boolean RemoverUsuario(int codFuncionario) {
        try {
            PreparedStatement sqlRemover = getConexao().prepareStatement
                    ("delete from Usuarios where codFuncionario = ?");
            sqlRemover.setInt(1, codFuncionario);
            sqlRemover.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        }

    }

    
}
