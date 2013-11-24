
package DominModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Cargo {
    private int codigo;
    private String cargo;
    
    //Construtor
    public Cargo() {
        this.codigo = 0;
    }
    
    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getCargo() {
        return cargo;
    }
    
    //Setters
    public void setCodigo(int codigo) throws Exception{
        if(codigo > 0)
            this.codigo = codigo;
        else
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
    }

    public void setCargo(String cargo) throws Exception{
        Pattern Cargo = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Cargo.matcher(cargo);

        if (verifica.matches()) {
            this.cargo = cargo;
        } else {
            throw new Exception("Campo 'Cargo' deve ter no mínimo 3 caracteres");
        }
        
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigo;
        hash = 53 * hash + Objects.hashCode(this.cargo);
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
        final Cargo other = (Cargo) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Cargo{" + "codigo do Cargo = " + codigo + ", Cargo = " + cargo + '}';
    }
    
    
    
    
    
}
