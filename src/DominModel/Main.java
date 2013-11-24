
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
        
        //p.setCPF("115.825.116.59");
        p.setRG("17.791.878");
        System.out.print(p.getRG());
        
        //Fornecedor
        Fornecedor fo = new Fornecedor();
        FornecedorDAO ford = new FornecedorDAO();
        
        //fo.setCnpj("11.111.111/111-11");
        //System.out.print(fo.getCnpj());
        
        /*fo.setNome("Embalarte");
        fo.setCnpj("11111111");
        fo.setCategoriaPessoa(CategoriaPessoa.Fornecedor);
        fo.setTipoPessoa("Juridica");*/
        
        //ford.SalvarFornecedor(fo);
        
        //Funcionario
        Funcionario f = new Funcionario();
        FuncionarioDAO fd = new FuncionarioDAO();        
        Cargo c = new Cargo();
        CargoDAO ca= new CargoDAO();
        
        //f = fd.AbrirFuncionario()
        
        Endereco e = new Endereco();
        Email em = new Email();
        
        //Cargo
        //c.setCargo("Atendente");       
        //ca.Salvar(c);       
        
        /*f.setNome("Philipe Caldeira");
        f.setCPF("22222222222");
        f.setDataNascimento(new Date());
        f.setCategoriaPessoa(CategoriaPessoa.Funcionario);
        f.setTipoPessoa("Fisica");
        f.setRG("17911888");
        f.setCargo(c);*/
        
        //fd.SalvarFuncionario(f);
        //f = fd.AbrirFuncionario(10);
        
        //System.out.print(f.getNome());
        
        //Cliente
        Cliente cli = new Cliente();
        ClienteDAO clid = new ClienteDAO();
        
        /*cli.setNome("Paulo Vitor");
        cli.setCPF("22222222222");
        cli.setDataNascimento(new Date());
        cli.setCategoriaPessoa(CategoriaPessoa.Cliente);
        cli.setTipoPessoa("Fisica");
        cli.setRG("17911777");
        
        clid.SalvarCliente(cli);*/
        
        //System.out.print(cli.getNome());
        
        
    }
}
