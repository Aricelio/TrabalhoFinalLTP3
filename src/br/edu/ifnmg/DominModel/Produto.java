package br.edu.ifnmg.DominModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private String descricao;
    private int ativo;
    private TipoProduto tipo;
    private int estoque;
    private List<ItemProdutoFornecedor> fornecedores;

    //Construtor
    public Produto() {
        this.codigo = 0;
        this.ativo = 1;
        this.fornecedores = new ArrayList<ItemProdutoFornecedor>();
    }

    //Getters
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

    public int getAtivo() {
        return ativo;
    }

    public int getEstoque() {
        return estoque;
    }

    public List<ItemProdutoFornecedor> getFornecedores() {
        return fornecedores;
    }

    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'codigo' não pode ser negativo!");
        }
    }

    public void setNome(String nome) throws Exception {
        Pattern Nome = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
        Matcher verifica = Nome.matcher(nome);

        if (verifica.matches()) {
            this.nome = nome;
        } else {
            throw new Exception("Campo 'Nome' deve ter no mínimo 3 caracteres");
        }
    }

    public void setPreco(double preco) throws Exception {
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new Exception("Valor passado para o campo 'preco' não pode ser negativo!");
        }
    }

    public void setDescricao(String descricao) throws Exception {
        Pattern Descricao = Pattern.compile("[\\w\\sÀ-àçã-õâ-ûéêõóòáúû]{3,}");
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

    public void setAtivo(int ativo) throws Exception {
        if ((ativo == 0) || (ativo == 1)) {
            this.ativo = ativo;
        } else {
            throw new Exception("Campo 'ativo' deve receber valor '1' ou '0'");
        }
    }

    public void setEstoque(int estoque) throws Exception {
        if (estoque > 0) {
            this.estoque = estoque;
        } else {
            throw new Exception("Valor passado para o campo 'estoque' não pode ser negativo!");
        }
    }

    //Adiciona um Item a venda
    public void addFornecedor(ItemProdutoFornecedor fornecedor) throws Exception {
        if (!fornecedores.contains(fornecedor)) {
            fornecedores.add(fornecedor);
        } else {
            throw new Exception("Esse fornecedor ja esta contido na lista");
        }
    }

    //Remove um item da venda
    public void removeFornecedor(ItemProdutoFornecedor fornecedor) throws Exception {
        if (fornecedores.contains(fornecedor)) {
            fornecedores.remove(fornecedor);
        } else {
            throw new Exception("Esse fornecedor não esta contido na lista");
        }
    }

    
    

    
    

    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.descricao);
        hash = 71 * hash + Objects.hashCode(this.tipo);
        hash = 71 * hash + Objects.hashCode(this.fornecedores);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.fornecedores, other.fornecedores)) {
            return false;
        }
        return true;
    }
    

    //toString
    @Override
    public String toString() {
        return nome;
    }
}
