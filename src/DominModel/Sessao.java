
package DominModel;

import java.util.Date;
import java.util.Objects;

public class Sessao {

    private int codigo;
    private Date dataInicio;
    private Date dataTermino;
    private double saldoAbertura;
    private double saldoFechamento;
    private Caixa caixa;
    private Usuario usuario;

    //Construtor
    public Sessao(Date dataInicio, double saldoAbertura) {
        this.dataInicio = new Date();
        this.saldoAbertura = caixa.getSaldo();
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public double getSaldoAbertura() {
        return saldoAbertura;
    }

    public double getSaldoFechamento() {
        return saldoFechamento;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = new Date();
    }

    
    public void setSaldoFechamento(double saldoFechamento) throws Exception {
        if (saldoFechamento >= 0) {
            this.saldoFechamento = saldoFechamento;
        } else {
            throw new Exception("Valor negativo!");
        }

    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.dataInicio);
        hash = 59 * hash + Objects.hashCode(this.dataTermino);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.saldoAbertura) ^ (Double.doubleToLongBits(this.saldoAbertura) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.saldoFechamento) ^ (Double.doubleToLongBits(this.saldoFechamento) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.caixa);
        hash = 59 * hash + Objects.hashCode(this.usuario);
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
        final Sessao other = (Sessao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        if (!Objects.equals(this.dataTermino, other.dataTermino)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldoAbertura) != Double.doubleToLongBits(other.saldoAbertura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldoFechamento) != Double.doubleToLongBits(other.saldoFechamento)) {
            return false;
        }
        if (!Objects.equals(this.caixa, other.caixa)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Sessao{" + "Codigo = " + codigo + ", Inicio = " + dataInicio 
                + ", Termino = " + dataTermino + ", Saldo de Abertura=" + saldoAbertura 
                + ", Saldo de Fechamento = " + saldoFechamento + ", Codido do Caixa=" + caixa.getCodigo() 
                + ", Usuario=" + usuario.getLogin() + '}';
    }
    
}
