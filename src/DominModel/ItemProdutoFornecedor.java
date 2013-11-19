
package DominModel;

public class ItemProdutoFornecedor {
    private int codigo;
    private Produto produto;
    private Fornecedor fornecedor;

    /*------------ Construtor ---------------*/
    public ItemProdutoFornecedor(int codigo) {
        this.codigo = 0;
    }
    
    /*------------ Getters -----------------*/
    public int getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    
    /*------------- Setters ----------------*/
    public void setCodigo(int codigo) throws Exception{
        if(codigo > 0)
            this.codigo = codigo;
        else
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }  
    
}
