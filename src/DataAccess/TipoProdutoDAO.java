package DataAccess;

import DominModel.TipoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoProdutoDAO extends DAO {

    //Construtor
    public TipoProdutoDAO() {
        super();
    }

    //Método Salvar Tipo
    public boolean SalvarTipo(TipoProduto obj) {
        if (obj.getCodigo() == 0) {
            try {
                //Insere os dados na tabela tipoProduto
                PreparedStatement sqlInsert = getConexao().prepareStatement
                        ("insert into tipoProduto(tipo,ativo) values(?,?)");
                sqlInsert.setString(1, obj.getTipo());
                sqlInsert.setInt(2, obj.getAtivo());
                sqlInsert.executeUpdate();

                //Pega a chave primária que foi gerada no banco de dados
                PreparedStatement sqlConsulta = getConexao().prepareStatement
                        ("select codTipoProduto from TipoProduto where tipo = ? ");
                sqlConsulta.setString(1, obj.getTipo());

                ResultSet resultado = sqlConsulta.executeQuery();
                if (resultado.next()) {
                    obj.setCodigo(resultado.getInt("codTipoProduto"));
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
                        ("update TipoProduto set Tipo=? where codTipoProduto=?");
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
    public boolean RemoverTipo(TipoProduto obj) {
        if ((obj.getCodigo() >= 0) && (obj.getAtivo() == 1)) {
            try {
                PreparedStatement sqlDesativa = getConexao().prepareStatement
                        ("update TipoProduto set ativo = 0 where codTipoProduto=?");
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
    public TipoProduto Abrir(int id) {
        try {

            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from tipoProduto where codTipoProduto=? and ativo = 1");
            sql.setInt(1, id);

            ResultSet resultado = sql.executeQuery();

            if (resultado.next()) {
                TipoProduto obj = new TipoProduto();

                obj.setCodigo(resultado.getInt("codTipoProduto"));
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
    public List<TipoProduto> ListarTipos() {
        try {
            PreparedStatement sql = getConexao().prepareStatement
                    ("select * from TipoProduto where ativo = 1");

            ResultSet resultado = sql.executeQuery();

            List<TipoProduto> lista = new ArrayList<TipoProduto>();

            while (resultado.next()) {
                TipoProduto obj = new TipoProduto();

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

    //Método BuscarTipo
    public List<TipoProduto> BuscarTipo(TipoProduto filtro) {
        try {
            String sql = "select * from TipoProduto where ativo = 1";
            String where = "";

            if (filtro.getTipo().length() > 0) {
                where = " tipo like '%" + filtro.getTipo() + "%' ";
            }

            if (filtro.getCodigo() > 0) {
                if (where.length() > 0) {
                    where = where + " and ";
                }
                where = where + " codTipoProduto = " + filtro.getCodigo();
            }

            if (where.length() > 0) {
                sql = sql + " and" + where;
            }

            Statement comando = getConexao().createStatement();
            ResultSet resultado = comando.executeQuery(sql);

            List<TipoProduto> lista = new ArrayList<TipoProduto>();

            while (resultado.next()) {
                TipoProduto obj = new TipoProduto();

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
