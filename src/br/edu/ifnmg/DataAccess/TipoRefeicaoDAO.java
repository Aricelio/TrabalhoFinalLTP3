
package br.edu.ifnmg.DataAccess;

import br.edu.ifnmg.DominModel.TipoRefeicao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoRefeicaoDAO extends DAO{

    //Construtor
    public TipoRefeicaoDAO() {
        super();
    }
    
    //Método Salvar Tipo
    public boolean SalvarTipo(TipoRefeicao obj) {
        if (obj.getCodigo() == 0) {
            try {
                //Insere os dados na tabela Pessoas
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into tipoRefeicao(tipo,ativo) values(?,?)");
                sqlInsert.setString(1, obj.getTipo());
                sqlInsert.setInt(2, obj.getAtivo());
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement("select codTipoRefeicao from TipoRefeicao where tipo = ? ");
                sqlConsulta.setString(1, obj.getTipo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codTipoRefeicao"));
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
                PreparedStatement sqlUpdate = con.prepareStatement
                        ("update TipoRefeicao set Tipo=? where codTipoRefeicao=?");
                sqlUpdate.setString(1, obj.getTipo());
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
    public boolean RemoverTipo(TipoRefeicao obj) {
        if ((obj.getCodigo() >= 0) && (obj.getAtivo() == 1)) {
            try {
                PreparedStatement sqlDesativa = getConexao().prepareStatement
                        ("update TipoRefeicao set ativo = 0 where codTipoRefeicao=?");
                sqlDesativa.setInt(1, obj.getCodigo());
                sqlDesativa.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }

    //Abrir
    public TipoRefeicao Abrir(int id) {
        try {

            PreparedStatement sql = getConexao().prepareStatement("select * from TipoRefeicao where codTipoRefeicao=? and ativo = 1");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                TipoRefeicao obj = new TipoRefeicao();

                obj.setCodigo(resultado.getInt("codTipoRefeicao"));
                obj.setTipo(resultado.getString("Tipo"));
                obj.setAtivo(resultado.getInt("ativo"));

                return obj;
            } else {
                return null;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método ListarTipos
    public List<TipoRefeicao> ListarTipos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement("select * from TipoRefeicao where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<TipoRefeicao> lista = new ArrayList<TipoRefeicao>();

            while (resultado.next()) {
                TipoRefeicao obj = new TipoRefeicao();

                obj.setTipo(resultado.getString("tipo"));
                obj.setCodigo(resultado.getInt("codTipoRefeicao"));

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    //Método BuscarTipo
    public List<TipoRefeicao> BuscarTipo(TipoRefeicao filtro) {
        try {
            String sql = "select * from TipoRefeicao where ativo = 1";
            String where = "";

            if (filtro.getTipo().length() > 0) {
                where = " tipo like '%" + filtro.getTipo() + "%' ";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " codTipoRefeicao = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and" + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            List<TipoRefeicao> lista = new ArrayList<TipoRefeicao>();

            while (resultado.next()) {
                TipoRefeicao obj = new TipoRefeicao();

                obj.setTipo(resultado.getString("tipo"));
                obj.setCodigo(resultado.getInt("codTipoProduto"));

                lista.add(obj);
            }
            return lista;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
    
    

