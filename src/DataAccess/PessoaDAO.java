package DataAccess;

import DominModel.Pessoa;
import DominModel.Endereco;
import DominModel.Email;
import DominModel.Telefone;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO extends DAO {

    public PessoaDAO() {
        super();
    }

    //Método Salvar
    public boolean SalvarPessoa(Pessoa obj) {
        if (obj.getCodigo() == 0) {
            try {
                //Insere os dados na tabela Pessoas
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into Pessoas(Nome,DataNascimento,RG,CPF,tipoPessoa,categoriaPessoa) values(?,?,?,?,?,?)");
                sqlInsert.setString(1, obj.getNome());
                sqlInsert.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sqlInsert.setString(3, obj.getRG());
                sqlInsert.setString(4, obj.getCPF());
                sqlInsert.setString(5, obj.getTipoPessoa());
                sqlInsert.setString(6, obj.getCategoriaPessoa().name());
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codPessoa from Pessoas where nome = ? and CPF = ?");
                sqlConsulta.setString(1, obj.getNome());
                sqlConsulta.setString(2, obj.getCPF());
                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codPessoa"));
                }
                
                //Salva o email
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                //Salva o Endereco
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                //Salva o Telefone
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
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
                PreparedStatement sqlUpdate = con.prepareStatement
                        ("update Pessoas set Nome=?, DataNascimento=?, RG=?,CPF=?,tipoPessoa=? where codPessoa=?");
                sqlUpdate.setString(1, obj.getNome());
                sqlUpdate.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                sqlUpdate.setString(3, obj.getRG());
                sqlUpdate.setString(4, obj.getCPF());
                sqlUpdate.setString(5, obj.getTipoPessoa());
                sqlUpdate.setInt(6, obj.getCodigo());
                sqlUpdate.executeUpdate();
                
                //Salva o email
                for (Email e : obj.getEmails()) {
                    SalvarEmail(obj, e);
                }
                //Salva o Endereco
                for (Endereco e : obj.getEnderecos()) {
                    SalvarEndereco(obj, e);
                }
                //Salva o Telefone
                for (Telefone e : obj.getTelefones()) {
                    SalvarTelefone(obj, e);
                }

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Método Remover
    public boolean RemoverPessoa(Pessoa obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement                        
                        ("delete from Pessoas where codPessoa=?");
                sqlDelete.setInt(1, obj.getCodigo());
                sqlDelete.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    //Método Abrir Pessoa
    public Pessoa AbrirPessoa(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from Pessoas where codPessoa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));
                obj.setCPF(resultado.getString("CPF"));
                obj.setRG(resultado.getString("RG"));
                obj.setTipoPessoa(resultado.getString("TipoPessoa"));
                
                AbrirTelefones(obj);
                AbrirEmails(obj);
                AbrirEnderecos(obj);

                return obj;
            } else {
                return null;
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Listar
    public List<Pessoa> ListarPessoas() {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from Pessoas");

            ResultSet resultado = sql.executeQuery();

            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));
                obj.setCPF(resultado.getString("CPF"));
                obj.setRG(resultado.getString("RG"));
                obj.setTipoPessoa(resultado.getString("TipoPessoa"));

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Buscar
    public List<Pessoa> BuscarPessoa(Pessoa filtro) {
        try {
            String sql = "select * from Pessoas ";
            String where = " ";

            if (filtro.getNome().length() > 0) {
                where = " nome like '%" + filtro.getNome() + "%' ";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " id = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Pessoa> lista = new ArrayList<Pessoa>();

            while (resultado.next()) {
                Pessoa obj = new Pessoa();

                obj.setCodigo(resultado.getInt("codPessoa"));
                obj.setNome(resultado.getString("Nome"));
                obj.setDataNascimento(resultado.getDate("DataNascimento"));
                obj.setCPF(resultado.getString("CPF"));
                obj.setRG(resultado.getString("RG"));
                obj.setTipoPessoa(resultado.getString("TipoPessoa"));

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Abri os Emails
    public void AbrirEmails(Pessoa pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from emails where pessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addEmail(AbreEmail(resultado));

            }
        } catch (Exception ex) {
        }
    }

    private Email AbreEmail(ResultSet resultado) {
        Email email = new Email();
        try {
            email.setCodigo(resultado.getInt("codEmail"));
            email.setEmail(resultado.getString("Email"));
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return email;

    }
    //Método AbrirTelefones

    public void AbrirTelefones(Pessoa pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from telefones where pessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {
                pessoa.addTelefone(AbreTelefone(resultado));

            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private Telefone AbreTelefone(ResultSet resultado) {
        Telefone tel = new Telefone();
        try {
            tel.setCodigo(resultado.getInt("codTelefones"));
            tel.setDdd(resultado.getByte("DDD"));
            tel.setOperadora(resultado.getByte("operadora"));
            tel.setTelefone(resultado.getInt("telefone"));
            return tel;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    //Método AbrirEenderecos

    public void AbrirEnderecos(Pessoa pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from enderecos where pessoa=?");
            sql.setInt(1, pessoa.getCodigo());

            ResultSet resultado = sql.executeQuery();

            while (resultado.next()) {                
                pessoa.addEndereco(AbreEndereco(resultado));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());

        }
    }

    private Endereco AbreEndereco(ResultSet resultado) {
        Endereco end = new Endereco();
        try {
            end.setCodigo(resultado.getInt("codEndereco"));
            end.setNumero(resultado.getInt("numero"));
            end.setComplemento(resultado.getString("complemento"));
            end.setRua(resultado.getString("rua"));
            end.setBairro(resultado.getString("bairro"));
            end.setCidade(resultado.getString("cidade"));
            end.setUf(resultado.getString("uf"));
            

            return end;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    //Método SalvarEmail

    private void SalvarEmail(Pessoa pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement("insert into emails(pessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement("update emails set pessoa = ?, email = ? where id = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //Método SalvarEndereco 

    private void SalvarEndereco(Pessoa pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into enderecos(pessoa,numero,complemento,rua,bairro,cidade,uf) values(?,?,?,?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getComplemento());
                sql.setString(4, obj.getRua());
                sql.setString(5, obj.getBairro());
                sql.setString(6, obj.getCidade());
                sql.setString(7, obj.getUf());
                
                sql.executeUpdate();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("update enderecos set pessoa=?, numero=?, complemento=?, rua=?, bairro=?,cidade=?,uf=? where id = ?");
                sql.setInt(1, obj.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getComplemento());
                sql.setString(4, obj.getRua());
                sql.setString(5, obj.getBairro());
                sql.setString(6, obj.getCidade());
                sql.setString(7, obj.getUf());              
                
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    //Método SalvarTelefone

    private void SalvarTelefone(Pessoa pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into telefones(pessoa,telefone,operadora,ddd) values(?,?,?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getOperadora());
                sql.setInt(4, obj.getDdd());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("update emails set pessoa = ?, telefone = ?, operadora = ?, ddd = ? where id = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getOperadora());
                sql.setInt(4, obj.getDdd());
                sql.setInt(3, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
