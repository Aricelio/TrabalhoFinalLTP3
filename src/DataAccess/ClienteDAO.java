package DataAccess;

import DominModel.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends PessoaDAO {

    //Construtor
    public ClienteDAO() {
        super();
    }

    //Método Salvar Cliente
    public boolean SalvarCliente(Cliente cli) {
        if (cli.getCodigo() == 0) {
            super.SalvarPessoa(cli);
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Clientes(codCliente) values (?)");
                sqlInsert.setInt(1, cli.getCodigo());
                sqlInsert.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.SalvarPessoa(cli);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    //Método Remover Cliente
    public boolean RemoverFuncionario(Cliente cli) {
        if (cli.getCodigo() >= 0) {
            try {
           
                super.RemoverPessoa(cli);
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
}
