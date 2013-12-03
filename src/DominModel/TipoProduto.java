package DominModel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TipoProduto {

    private int codigo;
    private int ativo;
    private String tipo;

    //Construtor
    public TipoProduto() {
        this.codigo = 0;
        this.ativo = 1;
    }

    //Getters 
    public int getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtivo() {
        return ativo;
    }

    //Setters 
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setTipo(String tipo) throws Exception {
        Pattern Tipo = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Tipo.matcher(tipo);

        if (verifica.matches()) {
            this.tipo = tipo;
        } else {
            throw new Exception("Valor passado para o campo 'tipo' é invalido.");
        }
    }

    public void setAtivo(int ativo) throws Exception {
        if ((ativo == 1) || (ativo == 0)) {
            this.ativo = ativo;
        } else {
            throw new Exception("Campo ativo só aceita valores '0' ou '1'");
        }
    }
    
    

    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + this.ativo;
        hash = 59 * hash + Objects.hashCode(this.tipo);
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
        final TipoProduto other = (TipoProduto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.ativo != other.ativo) {
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
        return tipo;
    }
    
}
