package DominModel;

public class Refeicao {

    private int codigo;
    private double preco;
    private TipoRefeicao tipo;

    /*------------ Construtor -----------*/
    public Refeicao() {
    }

    /*------------ Getters --------------*/
    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public TipoRefeicao getTipo() {
        return tipo;
    }

    /*------------ Setters --------------*/
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setPreco(double preco) throws Exception{
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new Exception("Valor passado para o campo 'Preço' não pode ser negativo!");
        }
    }

    public void setTipo(TipoRefeicao tipo) {
        this.tipo = tipo;
    }
}
