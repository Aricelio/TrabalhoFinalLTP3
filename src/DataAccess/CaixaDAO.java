
package DataAccess;

import DominModel.Caixa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


class CaixaDAO extends DAO{

    //Construtor
    public CaixaDAO() {
        super();
    }
    
    //Método Salvar
    
    
    
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
