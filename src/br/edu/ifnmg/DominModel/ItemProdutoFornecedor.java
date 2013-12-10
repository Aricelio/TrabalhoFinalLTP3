
package br.edu.ifnmg.DominModel;

import java.util.Objects;

public class ItemProdutoFornecedor {
    
    private int codigo;
    private Produto produto;
    private Fornecedor fornecedor;

    //Construtor
    public ItemProdutoFornecedor() {
        this.codigo = 0;
    }
    
    //Getters
    public int getCodigo() {
        return codigo;
    }

    public Produto getProduto() {
        return produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    
    //Setters
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
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + Objects.hashCode(this.fornecedor);
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
        final ItemProdutoFornecedor other = (ItemProdutoFornecedor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "ItemProdutoFornecedor{" + "Codigo=" + codigo 
                + ", Produto = " + produto.getNome() 
                + ", Fornecedor = " + fornecedor.getNome() + '}';
    }
    
    
}
