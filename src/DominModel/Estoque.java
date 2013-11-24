package DominModel;

import java.util.Objects;

public class Estoque {

    private int codigo;
    private int estoque;
    private Produto produto;

    //Construtor
    public Estoque() {
        this.codigo = 0;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public int getEstoque() {
        return estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    //Setters
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

    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.codigo;
        hash = 29 * hash + this.estoque;
        hash = 29 * hash + Objects.hashCode(this.produto);
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
        final Estoque other = (Estoque) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.estoque != other.estoque) {
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
        return "Estoque{" + "Codigo do estoque = " + codigo + ", Quantidade = " + estoque + ", Produto = " + produto.getNome() + '}';
    }
    
}
