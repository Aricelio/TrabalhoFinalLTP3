package DataAccess;

import DominModel.Pessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PessoaDAO extends DAO {

    public PessoaDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into pessoa(Nome,DataNascimento,RG,CPF,tipoPessoa) values(?,?,?,?,?)");
                sqlInsert.setString(1, obj.getNome());
                sqlInsert.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sqlInsert.setString(3, obj.getRG());
                sqlInsert.setString(4, obj.getCPF());
                sqlInsert.setString(5, obj.getTipoPessoa());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codPessoa from pessoa where nome = ? and CPF = ?");
                sqlConsulta.setString(1, obj.getNome());
                sqlConsulta.setString(2, obj.getCPF());
                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codPessoa"));
                }



                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }

    }
}
