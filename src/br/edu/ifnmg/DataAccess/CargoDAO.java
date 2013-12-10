package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.DominModel.Cargo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CargoDAO extends DAO {
    //Construtor

    public CargoDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Cargo obj) {
        if (obj.getCodigo() == 0) {
            try {
                //Insere os dados na tabela Pessoas
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Cargos(cargo) values(?)");
                sqlInsert.setString(1, obj.getCargo());
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codCargo from Cargos where cargo = ? ");
                sqlConsulta.setString(1, obj.getCargo());


                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codCargo"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                //Atualiza os dados
                Connection con = getConexao();
                PreparedStatement sqlUpdate = con.prepareStatement("update Cargos set cargo=? where codCargo=?");
                sqlUpdate.setString(1, obj.getCargo());
                sqlUpdate.setInt(2, obj.getCodigo());

                sqlUpdate.executeUpdate();

                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Método Remover
    public boolean Remover(Cargo obj) {
        if (obj.getCodigo() >= 0) {
            try {
                PreparedStatement sqlDelete = getConexao().prepareStatement("delete from Cargos where codCargo=?");
                sqlDelete.setInt(1, obj.getCodigo());
                sqlDelete.executeUpdate();
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    //Método Abrir
    public Cargo AbrirCargo(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Cargos where codCargo=?");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("codCargo"));
                obj.setCargo(resultado.getString("cargo"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
    //Método Listar Cargos
    public List<Cargo> ListarCargos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from Cargos");

            ResultSet resultado = sql.executeQuery();

            List<Cargo> lista = new ArrayList<Cargo>();

            while (resultado.next()) {
                Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("codCargo"));
                obj.setCargo(resultado.getString("cargo"));
                

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Buscar Cargos
    public List<Cargo> BuscarCargos(Cargo filtro) {
        try {
            String sql = "select * from Cargos ";
            String where = " ";

            if (filtro.getCargo().length() > 0) {
                where = " cargo like '%" + filtro.getCargo() + "%' ";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " codCargo = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " where " + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);


            List<Cargo> lista = new ArrayList<Cargo>();

            while (resultado.next()) {
                Cargo obj = new Cargo();

                obj.setCodigo(resultado.getInt("codCargo"));
                obj.setCargo(resultado.getString("Cargo"));
                

                lista.add(obj);
            }

            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
