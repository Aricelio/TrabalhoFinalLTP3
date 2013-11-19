package DominModel;

public class Estoque {

    private int codigo;
    private int estoque;
    private Produto produto;

    /*---------------- Construtor -----------*/
    public Estoque() {
    }

    /*--------------- Getters ---------------*/
    public int getCodigo() {
        return codigo;
    }

    public int getEstoque() {
        return estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    /*------------- Setters ----------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setEstoque(int estoque) throws Exception {
        if (estoque >= 0) {
            this.estoque = estoque;
        } else {
            throw new Exception("Valor passado para o campo 'estoque' não pode ser negativo!");
        }
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
