
package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Endereco {

    private int codigo;
    private int numero;
    private String complemento;
    private String rua;
    private String bairro;
    private String cidade;
    private String uf;
    private Pessoa pessoa;

    /*---------- Construtor--------------*/
    public Endereco() {
        this.uf = "MG";
    }

    /*------- Métodos Getters-----------*/
    public int getCodigo() {
        return codigo;
    }

    public int getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
    /*----------Métodos Setters------------------------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor ou igual a zero");
        }
    }

    public void setNumero(int numero) throws Exception {
        if (numero >= 1) {
            this.numero = numero;
        } else {
            throw new Exception("Numero menor ou igual a zero");
        }
    }

    public void setRua(String rua) throws Exception {
        Pattern Rua = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Rua.matcher(rua);

        if (verifica.matches()) {
            this.rua = rua;
        } else {
            throw new Exception("Valor passado para o campo 'Rua' é Invalido!");
        }
    }

    public void setBairro(String bairro) throws Exception {
        Pattern Bairro = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Bairro.matcher(bairro);

        if (verifica.matches()) {
            this.bairro = bairro;
        } else {
            throw new Exception("Valor passado para o campo 'Bairro' é Invalido!");
        }
    }

    public void setCidade(String cidade) throws Exception {
        Pattern Cidade = Pattern.compile("[a-zA-Z0-9 ]*");
        Matcher verifica = Cidade.matcher(cidade);

        if (verifica.matches()) {
            this.cidade = cidade;
        } else {
            throw new Exception("Valor passado para o campo 'Cidade' é Invalido!");
        }
    }

    public void setUf(String uf) throws Exception {
        Pattern UF = Pattern.compile("\\w*{2,}");
        Matcher verifica = UF.matcher(uf);

        if (verifica.matches()) {
            this.uf = uf;
        } else {
            throw new Exception("Valor passado para o campo 'UF' é Invalido!");
        }
    }

    public void setComplemento(String complemento) throws Exception {
        Pattern Complemento = Pattern.compile("[a-zA-Z]*");
        Matcher verifica = Complemento.matcher(complemento);

        if (verifica.matches()) {
            this.complemento = complemento;
        } else {
            throw new Exception("Valor passado para o campo 'Complemento' é Invalido!");
        }
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }    
    
}