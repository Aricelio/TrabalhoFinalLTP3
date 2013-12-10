
package br.edu.ifnmg.DominModel;


public class ErroValidacaoException extends Exception {
    String campo;
    public ErroValidacaoException(String msg, String cmp){
        super(msg);
        setCampo(cmp);
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }
    
}
