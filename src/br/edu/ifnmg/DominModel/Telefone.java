package br.edu.ifnmg.DominModel;

import java.util.Objects;

public class Telefone {

    private int codigo;
    private int telefone;
    private byte ddd;
    private byte operadora;
    private Pessoa pessoa;

    //Construtor
    public Telefone() {
        this.codigo = 0;
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public int getTelefone() {
        return telefone;
    }

    public byte getDdd() {
        return ddd;
    }

    public byte getOperadora() {
        return operadora;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    //Setters
    public void setCodigo(int codigo) throws Exception {
        if (codigo >= 1) {
            this.codigo = codigo;
        } else {
            throw new Exception("Valor passado para o campo 'Codigo' é Invalido!Valor menor que 1");
        }
    }

    public void setTelefone(int telefone) throws Exception {
        if (telefone > 11111111) {
            this.telefone = telefone;
        } else {
            throw new Exception("Valor passado para o campo 'Telefone' é Invalido!");
        }
    }

    public void setDdd(byte ddd) throws Exception {
        if ((ddd > 9) && (ddd < 100)) {
            this.ddd = ddd;
        } else {
            throw new Exception("Valor passado para o campo 'DDD' é Invalido!");
        }
    }

    public void setOperadora(byte operadora) throws Exception {
        if ((operadora > 9) && (operadora < 100)) {
            this.operadora = operadora;
        } else {
            throw new Exception("Valor passado para o campo 'Operadora' é Invalido!");
        }
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    //hashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.codigo;
        hash = 23 * hash + this.telefone;
        hash = 23 * hash + this.ddd;
        hash = 23 * hash + this.operadora;
        hash = 23 * hash + Objects.hashCode(this.pessoa);
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
        final Telefone other = (Telefone) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.telefone != other.telefone) {
            return false;
        }
        if (this.ddd != other.ddd) {
            return false;
        }
        if (this.operadora != other.operadora) {
            return false;
        }
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "Telefone{" + "Codigo = " + codigo  
                + ", DDD = " + ddd + ", Operadora=" + operadora 
                + ", Telefone=" + telefone
                + ", Pessoa = " + pessoa.getNome() + '}';
    }
    
    
}
