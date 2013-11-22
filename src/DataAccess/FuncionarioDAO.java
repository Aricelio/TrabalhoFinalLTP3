package DataAccess;

import DominModel.Cargo;
import DominModel.Funcionario;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FuncionarioDAO extends PessoaDAO {

    private Cargo cargo;

    //Construtor
    public FuncionarioDAO() {
        super();
    }

    //Método Salvar
    public boolean SalvarFuncionario(Funcionario fun) {
        if (fun.getCodigo() == 0) {
            super.SalvarPessoa(fun);
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Funcionarios(cargo,codFuncionario) values (?,?)");
                sqlInsert.setInt(1, fun.getCargo().getCodigo());
                sqlInsert.setInt(2, fun.getCodigo());
                sqlInsert.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.SalvarPessoa(fun);
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Funcionarios set cargo=? where codFuncionario=?");
                sqlUpdate.setInt(1, fun.getCargo().getCodigo());
                sqlUpdate.setInt(2, fun.getCodigo());

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }
    
    //Método RemoverFuncionario
    public boolean RemoverFuncionario(Funcionario fun) {
        if (fun.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement
                        ("delete from Funcionarios where codFuncionario=?");
                sqlDelete.setInt(1, fun.getCodigo());
                sqlDelete.executeUpdate();
                
                super.RemoverPessoa(fun);

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    public Funcionario AbrirFuncionario(int id){
        try{
            Funcionario obj = (Funcionario)super.AbrirPessoa(id);
            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionarios where codFuncionario=?");
            sql.setInt(1, id);
            
            ResultSet resultado = sql.executeQuery();
            
            if (resultado.next()) {
                
                //Falta abrir o cargo
               
                
                AbrirTelefones(obj);
                AbrirEmails(obj);
                AbrirEnderecos(obj);

                return obj;
            } else {
                return null;
            }

            
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
