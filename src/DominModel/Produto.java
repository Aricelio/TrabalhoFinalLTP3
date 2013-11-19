package DominModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private String descricao;
    private TipoProduto tipo;
    

    /*----------- Construtor -------------*/
    public Produto() {
    }

    /*----------- Getters ----------------*/
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoProduto getTipo() {
        return tipo;
    }


    /*------------ Setters ---------------*/
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setNome(String nome) throws Exception{
        Pattern Nome = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Nome.matcher(nome);

        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Campo 'Nome' deve ter no mínimo 3 caracteres");
        }
    }

    public void setPreco(double preco) throws Exception{
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new Exception("Preco negativo");
        }
    }

    public void setDescricao(String descricao)  throws Exception{
        Pattern Descricao = Pattern.compile("[\\w\\s]{3,}");
        Matcher verifica = Descricao.matcher(descricao);

        if (verifica.matches()) {
            this.descricao = descricao;
        } else {
            throw new Exception("Campo 'Descrição' deve ter no mínimo 3 caracteres");
        }
        
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }
}
