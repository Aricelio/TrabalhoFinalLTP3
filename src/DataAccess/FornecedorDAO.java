package DataAccess;

import DominModel.Fornecedor;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends PessoaDAO<Fornecedor> {

    //Construtor
    public FornecedorDAO() {
        super();
    }

    //Método Salvar Fornecedor
    public boolean SalvarFornecedor(Fornecedor forn) {
        if (forn.getCodigo() == 0) {
            super.SalvarPessoa(forn);
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into Fornecedores(codFornecedor,cnpj) values (?,?)");
                sqlInsert.setInt(1, forn.getCodigo());
                sqlInsert.setString(2, forn.getCnpj());
                sqlInsert.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.SalvarPessoa(forn);
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Fornecedores set cnpj=? where codFornecedor=?");
                sqlUpdate.setString(1, forn.getCnpj());
                sqlUpdate.setInt(2, forn.getCodigo());

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Método Remover Fornecedor
    public boolean RemoverFornecedor(Fornecedor forn) {
        if ((forn.getCodigo() >= 0) && (forn.getAtivo() == 1)){
            try {
                super.RemoverPessoa(forn);
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    //Método Abrir Fornecedor
    public Fornecedor AbrirFornecedor(int id) {
        try {
            Fornecedor fornecedor = new Fornecedor();

            super.AbrirPessoa(fornecedor, id);

            //Seleciona o Fornecedor e armazena em 'resultado'
            PreparedStatement sql = getConexao().prepareStatement("select * from Fornecedores where codFornecedor=?");
            sql.setInt(1, id);
            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                fornecedor.setCnpj(resultado.getString("cnpj"));
                return fornecedor;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Listar Fornecedor
    public List<Fornecedor> ListarFornecedores() {
        try {

            PreparedStatement sqlListar = getConexao().prepareStatement
                    ("select * from Pessoas P join Fornecedores F on P.codPessoa = F.codFornecedor where P.ativo = 1");
            ResultSet resultado = sqlListar.executeQuery();

            List<Fornecedor> listaF = new ArrayList<Fornecedor>();

            while (resultado.next()) {
                Fornecedor f = new Fornecedor();

                //Carrega os dados da tabela pessoa
                super.CarregaObjetoPessoa(f, resultado);

                //Carrega o restante dos dados (tabela funcionario)
                f.setCnpj(resultado.getString("cnpj"));

                listaF.add(f);
            }
            return listaF;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Buscar
    public List<Fornecedor> BuscarFornecedor(Fornecedor filtro) {
        try {
            String sql = "select * from Pessoas P join Fornecedores F on P.codPessoa = F.codFornecedor where P.ativo = 1";
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
                where = where + " F.codFornecedor = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            List<Fornecedor> lista = new ArrayList<Fornecedor>();

            while (resultado.next()) {
                Fornecedor obj = new Fornecedor();

                CarregaObjetoPessoa(obj, resultado);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    //Autenticar CNPJ
    public boolean AutenticarCNPJ(String CNPJ, Fornecedor obj){
        try{
            boolean retorno = false;
            PreparedStatement sqlListarCPF = getConexao().prepareStatement
                    ("select * from Pessoas P join Fornecedores F on P.codPessoa = F.codFornecedor where P.ativo = 1");
            ResultSet resultado = sqlListarCPF.executeQuery();
            
            while(resultado.next()){
                String resultadoCNPJ = resultado.getString("cnpj");
                if((CNPJ.equals(resultadoCNPJ)) && (obj.getCodigo() != resultado.getInt("codPessoa"))){
                    retorno = true;
                    break;
                }
            }
            return retorno;
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
