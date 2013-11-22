package DominModel;


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
    

    

    
}
