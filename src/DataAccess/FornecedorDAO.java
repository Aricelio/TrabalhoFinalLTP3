
package DataAccess;

import DominModel.Fornecedor;


import java.sql.PreparedStatement;

public class FornecedorDAO extends PessoaDAO{
    
    //Construtor
    public FornecedorDAO(){
        super();
    }
    
    //Método Salvar Fornecedor
    public boolean SalvarFornecedor(Fornecedor forn) {
        if (forn.getCodigo() == 0) {
            super.SalvarPessoa(forn);
            try {
                PreparedStatement sqlInsert = getConexao().prepareStatement("insert into Fornecedores(codFornecedor,cnpj) values (?,?)");
                sqlInsert.setInt(1, forn.getCodigo());
                sqlInsert.setString(2, forn.getCnpj());
                sqlInsert.executeUpdate();

                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        } else {
            try {
                super.SalvarPessoa(forn);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
    
    //Método Remover Cliente
    public boolean RemoverFuncionario(Fornecedor forn) {
        if (forn.getCodigo() >= 0) {
            try {
           
                super.RemoverPessoa(forn);
                return true;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return false;
            }
        }
        return false;
    }
}
