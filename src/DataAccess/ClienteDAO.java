package DataAccess;

import DominModel.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends PessoaDAO<Cliente> {

    //Construtor
    public ClienteDAO() {
        super();
    }

    //Método Salvar Cliente
    public boolean SalvarCliente(Cliente cli) {
        if (cli.getCodigo() == 0) {
            super.SalvarPessoa(cli);
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into Clientes(codCliente) values (?)");
                sqlInsert.setInt(1, cli.getCodigo());
                sqlInsert.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } 
        return false;
    }
    
    //Método Abrir Cliente
    public Cliente AbrirCliente(int id) {
        try {
            Cliente cliente = new Cliente();

            super.AbrirPessoa(cliente, id);
            
            return cliente;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    //Método Remover Cliente
    public boolean RemoverCliente(Cliente cli) {
        if ((cli.getCodigo() >= 0) && (cli.getAtivo() == 1)){
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
    
    //Metodo Listar Clientes
    public List<Cliente> ListarClientes() {
        try {           
            PreparedStatement sqlListar = getConexao().prepareStatement
                    ("select * from Pessoas P join Clientes C on P.codPessoa = C.codCliente where P.ativo = 1");
            ResultSet resultado = sqlListar.executeQuery();

            List<Cliente> listaClientes = new ArrayList<Cliente>();

            while (resultado.next()) {
                Cliente cli = new Cliente();

                //Carrega os dados da tabela pessoa
                super.CarregaObjetoPessoa(cli, resultado);

                listaClientes.add(cli);
            }            
            return listaClientes;
        } catch (Exception ex) {
             System.err.println(ex.getMessage());
             return null;
        }
    }
    
    //Método Buscar Clientes
    public List<Cliente> BuscarCliente(Cliente filtro) {
        try {
            String sql = "select * from Pessoas P join Clientes C on P.codPessoa = C.codCliente where P.ativo = 1";
            String where = "";

            if (filtro.getNome() != null) {
                if (filtro.getNome().length() > 0) {
                    where = " P.nome like '%" + filtro.getNome() + "%' ";
                }
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " C.codCliente = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Cliente> lista = new ArrayList<Cliente>();

            while (resultado.next()) {
                Cliente obj = new Cliente();

                CarregaObjetoPessoa(obj, resultado);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}

