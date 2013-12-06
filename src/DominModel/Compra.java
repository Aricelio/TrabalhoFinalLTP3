
package DominModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Compra {
    private int codigo;
    private Date data;
    private double valorTotal;
    private String formaPagamento;
    private Sessao sessao;
    private Funcionario funcionario;
    private List<ItemCompra> itensCompra;
    
    //Construtor
    public Compra() {
        itensCompra = new ArrayList<ItemCompra>();
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

    public Sessao getSessao() {
        return sessao;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    public List<ItemCompra> getItensCompra(){
        return itensCompra;
    }
    
    //Setters 
    public void setCodigo(int codigo) throws Exception{
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
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
        if (valorTotal >= 0) {
            this.valorTotal = valorTotal;
        } else {
            throw new Exception("Valor passado para o campo 'Valor Total' não pode ser negativo!");
        }
    }

    public void setFormaPagamento(String formaPagamento) throws Exception{
        Pattern FormaPagamento = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
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
    
    //Adiciona um item a compra
    public void addItemCompra(ItemCompra itemCompra) throws Exception{
        if(!itensCompra.contains(itemCompra)){
            itensCompra.add(itemCompra);
            
            double valor = itemCompra.getValorTotalItem() + getValorTotal();
            setValorTotal(valor);
        }
        else{
         throw new Exception("Esse item já esta contido na lista de Compras");
        }
    }
    
    //Remove um item da venda
    public void removeItemCompra(ItemCompra itemCompra) throws Exception{
        if(itensCompra.contains(itemCompra)){
            itensCompra.remove(itemCompra);
            
            double valor = getValorTotal() - itemCompra.getValorTotalItem();
            setValorTotal(valor);
        }
        else{
         throw new Exception("Esse item não existe na lista de Compras");
        }
    }

    //hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.data);
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.formaPagamento);
        hash = 11 * hash + Objects.hashCode(this.itensCompra);
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        if (!Objects.equals(this.itensCompra, other.itensCompra)) {
            return false;
        }
        return true;
    }
    
    
    //toString
    @Override
    public String toString() {
        return "Compra{" + "codigo da Compra =" + codigo + ", Data=" + data
                + ", Valor = " + valorTotal + ", Forma de Pagamento=" 
                + formaPagamento + ", Codigo da Sessao=" + sessao.getCodigo() 
                + ", Funcionario=" + funcionario.getNome() + '}';
    }
    
    
}
