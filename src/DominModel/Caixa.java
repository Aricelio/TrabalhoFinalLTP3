/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DominModel;

/**
 *
 * @author Celio
 */
public class Caixa {
    private int codigo;
    private double saldo;

    /*--------- Construtor ---------------------------------------------------*/
    public Caixa() {
    }
    
    /*----------- Getters ----------------------------------------------------*/
    public int getCodigo() {
        return codigo;
    }

    public double getSaldo() {
        return saldo;
    }
    
    /*----------- Setters ----------------------------------------------------*/
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    
}
