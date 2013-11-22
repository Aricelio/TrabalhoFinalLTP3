
package DominModel;
import DataAccess.*;
import java.util.Date;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Pessoa p = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        
        
        
        //Funcionario
        Funcionario f = new Funcionario();
        FuncionarioDAO fd = new FuncionarioDAO();        
        Cargo c = new Cargo();
        
        f.setCodigo(2);
        fd.RemoverFuncionario(f);
        
        
        Endereco e = new Endereco();
        Email em = new Email();
        
        //Cargo
        c.setCargo("Atendente");
        c.setCodigo(1);
        
        //Cliente
        /*Cliente cli = new Cliente();
        ClienteDAO clid = new ClienteDAO();
        
        cli.setNome("Paulo Vitor");
        cli.setCPF("22222222222");
        cli.setDataNascimento(new Date());
        cli.setCategoriaPessoa(CategoriaPessoa.Cliente);
        cli.setTipoPessoa("Fisica");
        cli.setRG("17911777");
        
        clid.SalvarCliente(cli);*/
        
        
    }
}
