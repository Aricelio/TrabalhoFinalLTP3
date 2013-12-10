
package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.DominModel.Caixa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CaixaDAO extends DAO{

    //Construtor
    public CaixaDAO() {
        super();
    }
    
    //Método Salvar
    public boolean Salvar(Caixa obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into caixa(saldo) values(?)");

                sqlInsert.setDouble(1, obj.getSaldo());
                sqlInsert.executeUpdate();
                
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codCaixa from caixa where saldo=?");
                sqlConsulta.setDouble(1, obj.getSaldo());
                

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codCaixa"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Caixa set saldo=? where codCaixa=?");
                sql.setDouble(1, obj.getSaldo());
                sql.setInt(2, obj.getCodigo());
                sql.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }    
    
    //Método Remover
    
    
    //Método Abrir Caixa
    public Caixa AbrirCaixa(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from caixa where codCaixa=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {                
                Caixa caixa = new Caixa();

                caixa.setCodigo(resultado.getInt("codCaixa"));
                caixa.setSaldo(resultado.getDouble("saldo"));
                
                return caixa;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }    
}
