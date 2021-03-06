
package DominModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Compra {
    private int codigo;
    private Date data;
    private double valorTotal;
    private String formaPagamento;
    private Sessao sessao;
    private Funcionario funcionario;
    
    /*------------ Construtor ------------------------------------------------*/
    public Compra() {
    }
    
    /*------------- Getters --------------------------------------------------*/
    public int getCodigo() {
        return codigo;
    }

    public Date getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    /*----------------------- Setters ----------------------------------------*/
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Codigo menor que um");
        }
    }

    public void setData(Date data) throws Exception{
        Calendar calendario = GregorianCalendar.getInstance();
        calendario.set(1900, 1, 1);

        if (calendario.getTime().before(data)) {
            this.data = data;
        } else {
            throw new Exception("Valor passado para o campo 'Data' é invalido!");
        }
    }

    public void setValorTotal(double valorTotal) throws Exception{
        if (valorTotal > 0) {
            this.valorTotal = valorTotal;
        } else {
            throw new Exception("Valor negativo");
        }
    }

    public void setFormaPagamento(String formaPagamento) throws Exception{
        Pattern FormaPagamento = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = FormaPagamento.matcher(formaPagamento);

        if (verifica.matches()) {
            this.formaPagamento = formaPagamento;
        } else {
            throw new Exception("Campo 'Forma de Pagamento' deve ter no mínimo 3 caracteres");
        }
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
