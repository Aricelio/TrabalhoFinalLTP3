package DominModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pessoa {

    private int codigo;
    private CategoriaPessoa categoriaPessoa;
    private String nome;
    private Date dataNascimento;
    private String RG;
    private String CPF;
    private String tipoPessoa;
    private int ativo;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;

    //Construtor
    public Pessoa() {
        this.ativo = 1;
        this.codigo = 0;
        emails = new ArrayList<Email>();
        enderecos = new ArrayList<Endereco>();
        telefones = new ArrayList<Telefone>();
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public int getAtivo() {
        return ativo;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getRG() {
        return RG;
    }

    public String getCPF() {
        return CPF;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public CategoriaPessoa getCategoriaPessoa() {
        return categoriaPessoa;
    }

    public void setCategoriaPessoa(CategoriaPessoa categoriaPessoa) {
        this.categoriaPessoa = categoriaPessoa;
    }

    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setAtivo(int ativo) throws Exception {
        if ((ativo == 1) || (ativo == 0)) {
            this.ativo = ativo;
        } else {
            throw new Exception("Campo ativo só aceita valores '0' ou '1'");
        }
    }

    public void setNome(String nome) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);

        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Campo 'Nome' deve ter no mínimo 3 caracteres");
        }
    }

    public void setDataNascimento(Date dataNascimento) throws Exception {
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(dataNascimento)) {
            this.dataNascimento = dataNascimento;
        } else {
            throw new ErroValidacaoException("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public void setRG(String rg) throws Exception {
        //Pattern PRG = Pattern.compile("[\\w\\s]");
        //Matcher verificacao = PRG.matcher(rg);

        //if (verificacao.matches()) {
        this.RG = rg;
        //} else {
        //  throw new Exception("Entrada para o campo RG INVALIDA!");
        //}
    }

    public void setCPF(String CPF) throws Exception {
        //Pattern Pcpf = Pattern.compile("[\\s]");
        //Matcher verificacao = Pcpf.matcher(CPF);

        //if (verificacao.matches()) {
        this.CPF = CPF;
        //} else {
        //  throw new Exception("Entrada para o campo CPF INVALIDA!");
        //}

    }

    public void setTipoPessoa(String tipoPessoa) throws Exception {
        Pattern Tipo = Pattern.compile("[\\w\\s]{3,}");
        Matcher verificacao = Tipo.matcher(tipoPessoa);

        if (verificacao.matches()) {
            this.tipoPessoa = tipoPessoa;
        } else {
            throw new Exception("Campo 'TipoPessoa' deve ter no mínimo 3 caracteres");
        }
    }

    //Método Adicionar Email
    public void addEmail(Email email) throws Exception {
        if (!emails.contains(email)) {
            emails.add(email);
        } else {
            throw new Exception("Esse email ja foi cadastrado!");
        }
    }
    //Remover Email

    public void removeEmail(Email email) throws Exception {
        if (emails.contains(email)) {
            emails.remove(email);
        } else {
            throw new Exception("O email pedido não existe!");
        }
    }
    //Retorna a lista de emails

    public List<Email> getEmails() {
        return emails;
    }

    //Adiciona um Endereco
    public void addEndereco(Endereco endereco) throws Exception {
        if (!enderecos.contains(endereco)) {
            enderecos.add(endereco);
        } else {
            throw new Exception("O valor passado para o campo endereco ja existe!");
        }
    }
    //Remove um Endereco

    public void removeEndereco(Endereco endereco) throws Exception {
        if (enderecos.contains(endereco)) {
            enderecos.remove(endereco);
        } else {
            throw new Exception("Não foi possivel remover o endereço, pois ele não existe!");
        }

    }
    //Retorna a lista de Enderecos

    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    //Adicionar um Telefone

    public void addTelefone(Telefone telefone) throws Exception {
        if (!telefones.contains(telefone)) {
            telefones.add(telefone);
        } else {
            throw new Exception("O valor passado para o campo telefone ja existe!");
        }
    }
    //Remove uma Telefone

    public void removeTelefone(Telefone telefone) throws Exception {
        if (telefones.contains(telefone)) {
            telefones.remove(telefone);
        } else {
            throw new Exception("Não foi possivel remover o telefone, pois ele não existe!");
        }
    }
    //Retorna a lista de telefones

    public List<Telefone> getTelefones() {
        return telefones;
    }
}
