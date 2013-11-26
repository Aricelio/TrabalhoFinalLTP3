
package DominModel;
import DataAccess.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Pessoa p = new Pessoa();
        PessoaDAO pdao = new PessoaDAO();
        
        //p.setCPF("115.825.116.59");
        //p.setRG("17.791.878");
        //System.out.print(p.getRG());
        
        //Fornecedor
        Fornecedor fo = new Fornecedor();
        FornecedorDAO ford = new FornecedorDAO();
        
        
        //System.out.print(fo.getCnpj());
        
        //fo.setNome("Supermercado");
        //fo.setCnpj("11.111.111/1111-11");
        //fo.setCategoriaPessoa(CategoriaPessoa.Fornecedor);
        //fo.setTipoPessoa("Juridica");
        List<Fornecedor> listaFo = new ArrayList<Fornecedor>();
        
        //listaFo = ford.BuscarFornecedor(fo);
        
        //ford.SalvarFornecedor(fo);        
        //fo = ford.AbrirFornecedor(11);
        //listaFo = ford.ListarFornecedores();
        
        //System.out.print(listaFo.toString());
        
        //Funcionario
        Funcionario f = new Funcionario();
        List<Funcionario> listaF = new ArrayList<Funcionario>();
        FuncionarioDAO fd = new FuncionarioDAO();        
        Cargo c = new Cargo();
        CargoDAO ca= new CargoDAO();
        
        //f.setRG("7777MG-17.777");
        //f.setNome("Phi");
        //f.setCodigo(10);
        
        //f = fd.AbrirFuncionario(10);
        //listaF = fd.ListarFuncionarios();
        
        //listaF = fd.BuscarFuncionario(f);
        //System.out.print(listaF.toString());
        
        //f = fd.AbrirFuncionario(10);
        
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
        List<Cliente> listaC = new ArrayList<Cliente>();
        
        cli.setNome("Paul");
        listaC = clid.BuscarCliente(cli);
        //listaC = clid.ListarClientes();
        //cli = clid.AbrirCliente(7);
        //clid.RemoverCliente(cli);
        //System.out.print(cli.toString());
        System.out.print(listaC.toString());
        
        
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
