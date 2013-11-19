
package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fornecedor extends Pessoa {

    private String cnpj;

    public Fornecedor() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws Exception{
        Pattern CNPJ = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = CNPJ.matcher(cnpj);

        if (verifica.matches()) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("Campo 'CNPJ' deve é invalido");
        }
    }
}
