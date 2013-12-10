package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.DominModel.Refeicao;
import br.edu.ifnmg.DominModel.TipoRefeicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RefeicaoDAO extends DAO {

    //Construtor
    public RefeicaoDAO() {
        super();
    }

    //Método Salvar
    public boolean Salvar(Refeicao obj) {
        if (obj.getCodigo() == 0) {
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Refeicao(preco,descricao,codTipoRefeicao,ativo) values(?,?,?,?)");
                sqlInsert.setDouble(1, obj.getPreco());
                sqlInsert.setString(2, obj.getDescricao());
                sqlInsert.setInt(3, obj.getTipo().getCodigo());
                sqlInsert.setInt(4, obj.getAtivo());
                sqlInsert.executeUpdate();

                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codRefeicao from Refeicao where descricao = ? and preco=? and codTipoRefeicao=?");
                sqlConsulta.setString(1, obj.getDescricao());
                sqlConsulta.setDouble(2, obj.getPreco());
                sqlConsulta.setInt(3, obj.getTipo().getCodigo());

                ResultSet resultado = sqlConsulta.executeQuery();

                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codRefeicao"));
                }

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                Connection con = getConexao();
                PreparedStatement sql = con.prepareStatement("update Refeicao set Descricao=? , preco=? , codTipoRefeicao=? where codRefeicao=?");
                sql.setString(1, obj.getDescricao());
                sql.setDouble(2, obj.getPreco());
                sql.setInt(3, obj.getTipo().getCodigo());
                sql.setInt(4, obj.getCodigo());
                sql.executeUpdate();
                return true;

            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
    }

    //Método Remover Refeicao
    public boolean Remover(Refeicao obj) {
        if ((obj.getCodigo() > 0) && (obj.getAtivo() == 1)) {
            try {
                //Seta o atributo ativo com valor '0'
                PreparedStatement sqlUpdate = getConexao().prepareStatement("update Refeicao set ativo = 0 where codRefeicao=?");
                sqlUpdate.setInt(1, obj.getCodigo());
                sqlUpdate.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return true;
    }

    //Método Abrir
    public Refeicao Abrir(int id) {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from refeicao where codRefeicao=? and ativo = 1");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                Refeicao obj = new Refeicao();
                TipoRefeicaoDAO tipo = new TipoRefeicaoDAO();

                CarregaObjetoRefeicao(obj, resultado, tipo);

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    //Método BuscarTipo

    public List<Refeicao> BuscarRefeicao(Refeicao filtro, TipoRefeicao tipo) {
        try {
            String sql = "select * from Refeicao R join TipoRefeicao T on R.codTipoRefeicao = T.codTipoRefeicao where R.ativo = 1 and T.ativo = 1";
            String where = "";

            //if (tipo != null) {
                if (tipo.getTipo() != null) {
                    where = " T.tipo like '%" + tipo.getTipo() + "%' ";
                }
            //}

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " R.codRefeicao = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and" + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            List<Refeicao> lista = new ArrayList<Refeicao>();

            while (resultado.next()) {
                Refeicao obj = new Refeicao();
                TipoRefeicaoDAO tipoRefeicao = new TipoRefeicaoDAO();

                CarregaObjetoRefeicao(obj, resultado, tipoRefeicao);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método Listar Refeições
    public List<Refeicao> ListarRefeicoes() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from Refeicao");

            ResultSet resultado = sql.executeQuery();

            List<Refeicao> lista = new ArrayList<Refeicao>();

            while (resultado.next()) {
                Refeicao obj = new Refeicao();
                TipoRefeicaoDAO tipo = new TipoRefeicaoDAO();

                CarregaObjetoRefeicao(obj, resultado, tipo);

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Carrega Dados de Refeicao
    protected void CarregaObjetoRefeicao(Refeicao obj, ResultSet resultado, TipoRefeicaoDAO tipo) throws Exception, SQLException {
        obj.setCodigo(resultado.getInt("codRefeicao"));
        obj.setDescricao(resultado.getString("descricao"));
        obj.setPreco(resultado.getDouble("preco"));
        obj.setTipo(tipo.Abrir(resultado.getInt("codTipoRefeicao")));
    }
}
