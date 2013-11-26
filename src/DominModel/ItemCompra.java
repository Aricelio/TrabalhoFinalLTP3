
package DominModel;

import java.util.Objects;

public class ItemCompra {
    private int codigo;
    private int quantidade;
    private Compra compra;
    private Produto produto;
    
    
    //Construtor
    public ItemCompra() {
        this.codigo = 0;
    }
    
    //Getters
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
    
    public double getValorTotalItem() 
    {
        double total =  getQuantidade() * produto.getPreco();
        return total;
    }
    
    //Setters
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

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.codigo;
        hash = 67 * hash + this.quantidade;
        hash = 67 * hash + Objects.hashCode(this.compra);
        hash = 67 * hash + Objects.hashCode(this.produto);
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
        final ItemCompra other = (ItemCompra) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Item Compra{" + "Codigo=" + codigo + ", Quantidade=" + quantidade 
                + ", codigo da Compra=" + compra.getCodigo() 
                + ", Produto=" + produto.getNome() + '}';
    }
    
    
}
