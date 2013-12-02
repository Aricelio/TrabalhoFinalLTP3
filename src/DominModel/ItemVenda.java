package DominModel;

import java.util.Objects;

public class ItemVenda {

    private int codigo;
    private int quantidade;
    private Venda venda;
    private Produto produto;

    //Construtor
    public ItemVenda() {
        this.codigo = 0;
    }

    //Getters
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
    
    public double getValorTotalItem() 
    {
        double total =  getQuantidade() * produto.getPreco();
        return total;
    }

    //Setters 
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setQuantidade(int quantidade) throws Exception {
        if (quantidade > 0) {
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
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.codigo;
        hash = 83 * hash + this.quantidade;
        hash = 83 * hash + Objects.hashCode(this.venda);
        hash = 83 * hash + Objects.hashCode(this.produto);
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.venda, other.venda)) {
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
        return "Item da Venda{" + "Codigo do Item= " + codigo 
                + ", Quantidade=" + quantidade + ", Codigo da Venda=" + venda.getCodigo() 
                + ", Produto=" + produto.getNome() + '}';
    }
    
}
