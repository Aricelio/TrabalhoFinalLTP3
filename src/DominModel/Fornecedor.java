
package DominModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fornecedor extends Pessoa {

    private String cnpj;

    //Construtor
    public Fornecedor() {
       setCategoriaPessoa(CategoriaPessoa.Fornecedor);
    }

    //Getter e Setter
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws Exception{
        Pattern CNPJ = Pattern.compile("\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}");
        Matcher verifica = CNPJ.matcher(cnpj);

        if (verifica.matches()) {
            this.cnpj = cnpj;
        } else {
            throw new Exception("Entrada para o campo CNPJ INVALIDA!");
        }
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cnpj);
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
        final Fornecedor other = (Fornecedor) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }
    
    
}
