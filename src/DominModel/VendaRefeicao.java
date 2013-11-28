
package DominModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
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
    private List<ItemVendaRefeicao> itensVenda;
    
    //Construtor
    public VendaRefeicao() {
        itensVenda = new ArrayList<ItemVendaRefeicao>();
        this.codigo = 0;
    }
    
    //Getters
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
    
    public List<ItemVendaRefeicao> getItensVendaRefeicao(){
        return this.itensVenda;
    }
    
    //Setters
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
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.codigo;
        hash = 41 * hash + Objects.hashCode(this.data);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.formaPagamento);
        hash = 41 * hash + Objects.hashCode(this.cliente);
        hash = 41 * hash + Objects.hashCode(this.funcionario);
        hash = 41 * hash + Objects.hashCode(this.sessao);
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
        final VendaRefeicao other = (VendaRefeicao) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.sessao, other.sessao)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Venda de Refeicao{" + "Codigo = " + codigo + ", Data = " + data 
                + ", Valor = " + valorTotal + ", Forma de Pagamento=" + formaPagamento 
                + ", Cliente = " + cliente.getNome() 
                + ", Funcionario=" + funcionario.getNome() 
                + ", Codido da Sessao = " + sessao.getCodigo() + '}';
    }
    
    
}
