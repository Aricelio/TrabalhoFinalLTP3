
package DominModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VendaRefeicao {
    private int codigo;
    private Date data;
    private double valorTotal;
    private String formaPagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Sessao sessao;
    
    /*---------- Construtor -----*/
    public VendaRefeicao() {
    }
    
    /*---------- Getters --------*/
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

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Sessao getSessao() {
        return sessao;
    }
    
    /*------------ Setters ---------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setData(Date data) throws Exception {
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
            throw new Exception("Valor passado para o campo 'Valor Total' não pode ser negativo!");
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    
    
}
