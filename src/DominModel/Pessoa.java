
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
    private String nome;
    private Date dataNascimento;
    private String RG;
    private String CPF;
    private String tipoPessoa;

    /*---------- Construtor --------------------------------------------------*/
    public Pessoa() {
        this.codigo = 0;
    }

    /*----------------Getters-------------------------------------------------*/
    public int getCodigo() {
        return codigo;
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

    /*---------------------- Setter ------------------------------------------*/
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
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
            throw new Exception("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public void setRG(String rg) throws Exception {
        Pattern PRG = Pattern.compile("");
        Matcher verificacao = PRG.matcher(rg);

        if (verificacao.matches()) {
            this.RG = rg;
        } else {
            throw new Exception("Entrada para o campo RG INVALIDA!");
        }
    }

    public void setCPF(String CPF) throws Exception{
        Pattern Pcpf = Pattern.compile("");
        Matcher verificacao = Pcpf.matcher(CPF);

        if (verificacao.matches()) {
            this.CPF = CPF;
        } else {
            throw new Exception("Entrada para o campo CPF INVALIDA!");
        }

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
}
