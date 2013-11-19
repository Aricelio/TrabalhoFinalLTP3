package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TipoRefeicao {

    private int codigo;
    private String tipo;

    /*-------- Construtor ----------*/
    public TipoRefeicao() {
    }

    /*-------- Getters -------------*/
    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    /*----------- Setters ----------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setTipo(String tipo) throws Exception {
        Pattern Tipo = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Tipo.matcher(tipo);

        if (verifica.matches()) {
            this.tipo = tipo;
        } else {
            throw new Exception("Valor passado para o campo 'tipo' é invalido!");
        }
    }
}
