package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {

    private int codigo;
    private String login;
    private String senha;
    private Funcionario funcionario;

    /*----------- Construtor ----------*/
    public Usuario() {
    }

    /*----------- Getters -------------*/
    public int getCodigo() {
        return codigo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    /*----------- Setters ----------------------------------------------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    public void setLogin(String login) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(login);

        if (verifica.matches()) {
            this.login = login;
        } else {
            throw new Exception("Campo 'login' deve ter no mínimo 3 caracteres");
        }
    }

    public void setSenha(String senha) throws Exception {
        Pattern Nome = Pattern.compile("[\\w]{6,}");
        Matcher verifica = Nome.matcher(login);

        if (verifica.matches()) {
            this.senha = senha;
        } else {
            throw new Exception("Campo 'senha' deve ter no mínimo 6 caracteres");
        }
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
}
