package DominModel;

import java.util.Objects;


public class Funcionario extends Pessoa {

    private Cargo cargo;

    //Construtor
    public Funcionario() {
        setCategoriaPessoa(CategoriaPessoa.Funcionario);
    }

    //Getters e Setters
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.cargo);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }
    
    //toString
    /*@Override
    public String toString() {
        return "Funcionario{" + "Cargo = " + cargo.getCargo() + '}';
    }*/
    
    

    
}
