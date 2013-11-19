package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funcionario extends Pessoa {

    private String cargo;

    /*------------- Construtor --------------------------------------------*/
    public Funcionario() {
    }
    /*------------- Getters e Setters -------------------------------------*/

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) throws Exception {
        Pattern Cargo = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Cargo.matcher(cargo);

        if (verifica.matches()) {
            this.cargo = cargo;
        } else {
            throw new Exception("Campo 'Cargo' deve ter no mínimo 3 caracteres");
        }


    }
}
