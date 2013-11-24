package DataAccess;

import DominModel.Cargo;
import DominModel.Funcionario;
import DataAccess.CargoDAO;
import DominModel.CategoriaPessoa;
import DataAccess.UsuarioDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Funcionarios(codCargo,codFuncionario) values (?,?)");
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
                PreparedStatement sqlUpdate = con.prepareStatement("update Funcionarios set codCargo=? where codFuncionario=?");
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
                UsuarioDAO user = new UsuarioDAO();
                
                user.RemoverUsuario(fun.getCodigo());
                super.RemoverPessoa(fun);
                
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    public Funcionario AbrirFuncionario(int id) {
        try {
            Funcionario funcionario = new Funcionario();
            //ERRO: funcionario não esta recebendo o objeto pessoa
            funcionario = (Funcionario) super.AbrirPessoa(id);

            CargoDAO cargoDAO = new CargoDAO();


            //Seleciona o funcionario e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Funcionarios where codFuncionario=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();

            //Seleciona o codigo do cargo do funcionario e armazena em 'resultadoCargo'
            PreparedStatement sqlConsultaCargo = getConexao().prepareStatement("select codCargo from Funcionarios where codFuncionario=?");
            sqlConsultaCargo.setInt(1, id);
            ResultSet resultadoCargo = sqlConsultaCargo.executeQuery();



            if (resultado.next()) {
                funcionario.setCargo(cargoDAO.AbrirCargo(resultadoCargo.getInt("codCargo")));
                return funcionario;
            } else {
                return null;
            }


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método ListarFuncionarios
    public List<Funcionario> ListarFuncionarios() {
        try {
            CargoDAO cargoDAO = new CargoDAO();

            PreparedStatement sqlListar = getConexao().prepareStatement
                    ("select * from Pessoas P join Funcionarios F on P.codPessoa = F.codFuncionario where P.ativo = 1");
            ResultSet resultado = sqlListar.executeQuery();

            List<Funcionario> listaF = new ArrayList<Funcionario>();

            while (resultado.next()) {
                Funcionario f = new Funcionario();

                //Carrega os dados da tabela pessoa
                super.CarregaObjetoPessoa(f, resultado);

                //Carrega o restante dos dados (tabela funcionario)
                f.setCargo(cargoDAO.AbrirCargo(resultado.getInt("codCargo")));
                

                listaF.add(f);
            }
            
            return listaF;

        } catch (Exception ex) {
             System.err.println(ex.getMessage());
             return null;
        }
    }
}
