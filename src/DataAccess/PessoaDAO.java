package DataAccess;

import DominModel.CategoriaPessoa;
import DominModel.Pessoa;
import DominModel.Endereco;
import DominModel.Email;
import DominModel.Telefone;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO<T extends Pessoa> extends DAO {

    public PessoaDAO() {
        super();
    }

    //Método Salvar
    public boolean SalvarPessoa(T obj) {
        if (obj.getCodigo() == 0) {
            try {
                //Insere os dados na tabela Pessoas
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into Pessoas(Nome,DataNascimento,RG,CPF,tipoPessoa,categoriaPessoa,ativo) values(?,?,?,?,?,?,?)");
                sqlInsert.setString(1, obj.getNome());
                if(obj.getDataNascimento() != null)
                    sqlInsert.setDate(2, new java.sql.Date(obj.getDataNascimento().getTime()));
                else
                    sqlInsert.setDate(2, null);
                sqlInsert.setString(3, obj.getRG());
                sqlInsert.setString(4, obj.getCPF());
                sqlInsert.setString(5, obj.getTipoPessoa());
                sqlInsert.setString(6, obj.getCategoriaPessoa().name());
                sqlInsert.setInt(7, obj.getAtivo());
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codPessoa from Pessoas where nome = ?");
                sqlConsulta.setString(1, obj.getNome());
                
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
    public boolean RemoverPessoa(T obj) {
        if ((obj.getCodigo() >= 0) && (obj.getAtivo() == 1)) {
            try {
                PreparedStatement sqlDesativa = getConexao().prepareStatement
                        ("update Pessoas set ativo = 0 where codPessoa=?");
                sqlDesativa.setInt(1, obj.getCodigo());
                sqlDesativa.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    //Método AbrirPessoa 
    protected void AbrirPessoa(T obj, int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from Pessoas where codPessoa=? and ativo = 1");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                CarregaObjetoPessoa(obj, resultado);

                AbrirTelefones(obj);
                AbrirEmails(obj);
                AbrirEnderecos(obj);
            } 
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    //Abri os Emails
    public void AbrirEmails(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from emails where codPessoa=?");
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
    public void AbrirTelefones(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from telefones where codPessoa=?");
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
            tel.setCodigo(resultado.getInt("codTelefone"));
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
    public void AbrirEnderecos(T pessoa) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from enderecos where codPessoa=?");
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
            end.setUf(resultado.getString("estado"));


            return end;
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    //Método SalvarEmail

    private void SalvarEmail(T pessoa, Email obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into emails(codPessoa,email) values(?,?)");
                sql.setInt(1, pessoa.getCodigo());
                sql.setString(2, obj.getEmail());
                sql.executeUpdate();

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("update emails set codPessoa = ?, email = ? where codEmail = ?");
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
    private void SalvarEndereco(T pessoa, Endereco obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into enderecos(codPessoa,numero,complemento,rua,bairro,cidade,estado) values(?,?,?,?,?,?,?)");
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
                        ("update enderecos set codPessoa=?, numero=?, complemento=?, rua=?, bairro=?,cidade=?,estado=? where codEndereco = ?");

                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getNumero());
                sql.setString(3, obj.getComplemento());
                sql.setString(4, obj.getRua());
                sql.setString(5, obj.getBairro());
                sql.setString(6, obj.getCidade());
                sql.setString(7, obj.getUf());
                sql.setInt(8, obj.getCodigo());

                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
    
    //Método SalvarTelefone
    private void SalvarTelefone(T pessoa, Telefone obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sql = getConexao().prepareStatement
                        ("insert into telefones(CodPessoa,telefone,operadora,ddd) values(?,?,?,?)");
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
                        ("update emails set CodPessoa = ?, telefone = ?, operadora = ?, ddd = ? where codTelefone = ?");
                sql.setInt(1, pessoa.getCodigo());
                sql.setInt(2, obj.getTelefone());
                sql.setInt(3, obj.getOperadora());
                sql.setInt(4, obj.getDdd());
                sql.setInt(5, obj.getCodigo());
                sql.executeQuery();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    //Método CarregarObjetoPessoa
    protected void CarregaObjetoPessoa(T obj, ResultSet resultado) throws Exception {
        
        if("Fornecedor".equals(resultado.getString("categoriaPessoa"))){
            obj.setCodigo(resultado.getInt("codPessoa"));
            obj.setNome(resultado.getString("Nome"));
            obj.setTipoPessoa(resultado.getString("TipoPessoa"));
            obj.setAtivo(resultado.getInt("ativo"));
            //obj.setCategoriaPessoa(CategoriaPessoa.Fornecedor);
        }
        else{
            obj.setCodigo(resultado.getInt("codPessoa"));
            obj.setNome(resultado.getString("Nome"));
            obj.setTipoPessoa(resultado.getString("TipoPessoa"));
            obj.setAtivo(resultado.getInt("ativo"));
            obj.setDataNascimento(resultado.getDate("DataNascimento"));
            obj.setCPF(resultado.getString("CPF"));
            obj.setRG(resultado.getString("RG"));
        }
    }
}
