
package DominModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private int codigo;
    private String email;
    private Pessoa pessoa;
    
    //Construtor 
    public Email() {
        this.codigo = 0;
    }
    
    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    //Setters 
    public void setCodigo(int codigo) throws Exception{
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setEmail(String email)  throws Exception{
        Pattern emailP = Pattern.compile("[a-zA-Z0-9\\-_.]{3,250}@[\\d\\w]+.[\\w.]+");
        Matcher verifica = emailP.matcher(email);

        if (verifica.matches()) {
            this.email = email;
        } else {
            throw new Exception("Valor passado para o campo 'Email' é Invalido!");
        }
    }
    
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }    

    //hasCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.pessoa);
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
        final Email other = (Email) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
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
        return "Email{" + "Codigo do Email=" + codigo + ", Email=" + email + ", Pessoa=" + pessoa.getNome() + '}';
    }
    
    
}
