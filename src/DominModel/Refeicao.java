package DominModel;

import java.util.Objects;

public class Refeicao {

    private int codigo;
    private double preco;
    private TipoRefeicao tipo;

    //Construtor
    public Refeicao() {
        this.codigo = 0;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public TipoRefeicao getTipo() {
        return tipo;
    }

    //Setters 
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
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.tipo);
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
        final Refeicao other = (Refeicao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Refeicao{" + "Codigo = " + codigo + ", Preco=" + preco 
                + ", Tipo = " + tipo.getTipo() + '}';
    }
    
}
