/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Celio
 */
public class Email {
    private int codigo;
    private String email;
    private Pessoa pessoa;
    
    /*----- Construtor -----------*/
    public Email() {
    }
    
    /*-------- Getters -----------*/
    public int getCodigo() {
        return codigo;
    }

    public String getEmail() {
        return email;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    /*--------- Setters -----------*/
    public void setCodigo(int codigo) throws Exception{
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'Codigo' é Invalido!");
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
}
