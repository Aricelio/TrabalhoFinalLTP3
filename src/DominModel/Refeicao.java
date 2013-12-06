package DominModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Refeicao {

    private int codigo;
    private double preco;
    private int ativo;
    private String descricao;
    private TipoRefeicao tipo;

    //Construtor
    public Refeicao() {
        this.codigo = 0;
        this.ativo = 1;
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
    
    public int getAtivo() {
        return ativo;
    }
    
    public String getDescricao() {
        return descricao;
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
    
    public void setAtivo(int ativo) throws Exception {
        if ((ativo == 0) || (ativo == 1)) {
            this.ativo = ativo;
        } else {
            throw new Exception("Campo 'ativo' deve receber valor '1' ou '0'");
        }
    }
    
    public void setDescricao(String descricao) throws Exception {
        Pattern Descricao = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû:;]{3,}");
        Matcher verifica = Descricao.matcher(descricao);

        if (verifica.matches()) {
            this.descricao = descricao;
        } else {
            throw new Exception("Campo 'Descrição' deve ter no mínimo 3 caracteres");
        }
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.codigo;
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 73 * hash + this.ativo;
        hash = 73 * hash + Objects.hashCode(this.descricao);
        hash = 73 * hash + Objects.hashCode(this.tipo);
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
        if (this.ativo != other.ativo) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
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
        return tipo.getTipo();
    }
    
}
