package DominModel;

public class ItemVenda {

    private int codigo;
    private int quantidade;
    private Venda venda;
    private Produto produto;

    /*--------- Construtor -----------*/
    public ItemVenda() {
    }

    /*--------- Getters --------------*/
    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public Produto getProduto() {
        return produto;
    }

    /*---------- setters -------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setQuantidade(int quantidade) throws Exception {
        if (codigo > 0) {
            this.quantidade = quantidade;
        } else {
            throw new Exception("Valor passado para o campo 'quantidade' não pode ser negativo!");
        }

    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
