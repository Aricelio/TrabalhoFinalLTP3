
package DominModel;

public class ItemCompra {
    private int codigo;
    private int quantidade;
    private Compra compra;
    private Produto produto;
    
    /*--------------- Construtor ----------*/
    public ItemCompra() {
    }
    
    /*--------------- Getters -------------*/
    public int getCodigo() {
        return codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Compra getCompra() {
        return compra;
    }

    public Produto getProduto() {
        return produto;
    }
    
    /*-------------- Setters -------------*/
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setQuantidade(int quantidade) throws Exception{
        if (codigo > 0) {
            this.quantidade = quantidade;
        } else {
            throw new Exception("Valor passado para o campo 'quantidade' não pode ser negativo!");
        }
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
