package DominModel;

public class Telefone {

    private int codigo;
    private int telefone;
    private byte ddd;
    private byte operadora;
    private Pessoa pessoa;

    /*------------ Construtor-----------*/
    public Telefone() {
    }

    /*------------ Getters -------------*/
    public int getCodigo() {
        return codigo;
    }

    public int getTelefone() {
        return telefone;
    }

    public byte getDdd() {
        return ddd;
    }

    public byte getOperadora() {
        return operadora;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    /*----------- Setters ---------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'Codigo' é Invalido!Valor menor que 1");
        }
    }

    public void setTelefone(int telefone) throws Exception {
        if (telefone > 11111111) {
            this.telefone = telefone;
        } else {
            throw new Exception("Valor passado para o campo 'Telefone' é Invalido!");
        }
    }

    public void setDdd(byte ddd) throws Exception {
        if ((ddd > 9) && (ddd < 100)) {
            this.ddd = ddd;
        } else {
            throw new Exception("Valor passado para o campo 'DDD' é Invalido!");
        }
    }

    public void setOperadora(byte operadora) throws Exception {
        if ((operadora > 9) && (operadora < 100)) {
            this.operadora = operadora;
        } else {
            throw new Exception("Valor passado para o campo 'Operadora' é Invalido!");
        }
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
