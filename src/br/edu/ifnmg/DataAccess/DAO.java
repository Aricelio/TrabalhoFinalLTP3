package br.edu.ifnmg.DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private Connection conexao;

    public DAO() {
        try {
            //-----------------Carrega Driver---------------------------------//
            Class.forName("com.mysql.jdbc.Driver");
            //-----------------Cria Conexao-----------------------------------//
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/trabalhofinal", "root", "");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public Connection getConexao() {
        return conexao;
    }
}
