/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

import java.util.Date;

/**
 *
 * @author Celio
 */
public class Sessao {

    private int codigo;
    private Date dataInicio;
    private Date dataTermino;
    private double saldoAbertura;
    private double saldoFechamento;
    private Caixa caixa;
    private Usuario usuario;

    /*--------------- Construtor ---------------------------------------------*/
    public Sessao(Date dataInicio, double saldoAbertura) {
        this.dataInicio = new Date();
        this.saldoAbertura = caixa.getSaldo();
    }

    /*-------------- Getters -------------------------------------------------*/
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

    /*-------------------- Setters -------------------------------------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    /*public void setDataInicio(Date dataInicio) {
     this.dataInicio = dataInicio;
     }*/
    public void setDataTermino(Date dataTermino) {
        this.dataTermino = new Date();
    }

    /*public void setSaldoAbertura(double saldoAbertura) {
     this.saldoAbertura = saldoAbertura;
     }*/
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
}
