
package DominModel;

import java.util.Objects;
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

    //Construtor
    public Endereco() {
        this.uf = "MG";
        this.codigo = 0;
    }

    //Getters
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
    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setNumero(int numero) throws Exception {
        if (numero >= 1) {
            this.numero = numero;
        } else {
            throw new Exception("Valor passado para o campo 'Numero' não pode ser negativo!");
        }
    }

    public void setRua(String rua) throws Exception {
        Pattern Rua = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Rua.matcher(rua);

        if (verifica.matches()) {
            this.rua = rua;
        } else {
            throw new Exception("Valor passado para o campo 'Rua' é Invalido!");
        }
    }

    public void setBairro(String bairro) throws Exception {
        Pattern Bairro = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Bairro.matcher(bairro);

        if (verifica.matches()) {
            this.bairro = bairro;
        } else {
            throw new Exception("Valor passado para o campo 'Bairro' é Invalido!");
        }
    }

    public void setCidade(String cidade) throws Exception {
        Pattern Cidade = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
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

    //hasCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo;
        hash = 83 * hash + this.numero;
        hash = 83 * hash + Objects.hashCode(this.complemento);
        hash = 83 * hash + Objects.hashCode(this.rua);
        hash = 83 * hash + Objects.hashCode(this.bairro);
        hash = 83 * hash + Objects.hashCode(this.cidade);
        hash = 83 * hash + Objects.hashCode(this.uf);
        hash = 83 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    //equals
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "Endereco{" + "Codigo do Endereco = " + codigo + ", Numero = " + numero 
                + ", Complemento = " + complemento + ", Rua = " + rua + ", Bairro = " 
                + bairro + ", Cidade=" + cidade + ", UF = " + uf + ", Pessoa=" + pessoa.getNome() + '}';
    }
    
    
    
}