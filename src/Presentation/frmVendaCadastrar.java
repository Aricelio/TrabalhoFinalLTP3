
package Presentation;

import DominModel.Cliente;
import DataAccess.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

public class frmVendaCadastrar extends javax.swing.JInternalFrame {

    ClienteDAO clienteDAO = new ClienteDAO();
    public frmVendaCadastrar() {
        initComponents();
        carregaClientes();
    }

    private void carregaClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes = clienteDAO.ListarClientes();

        cbxCliente.removeAllItems();
        for (Cliente c : clientes) {
            cbxCliente.addItem(c);
        }
        //TipoProduto selecionado = (TipoProduto)cbxTipo.getSelectedItem();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpVendas = new javax.swing.JTabbedPane();
        pnGeral = new javax.swing.JPanel();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        lblFormaPagamento = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox();
        lblCliente = new javax.swing.JLabel();
        cbxFormaPagamento = new javax.swing.JComboBox();
        pnItens = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Vendas de Produtos");

        lblData.setText("Data: ");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblFormaPagamento.setText("Forma de Pagamento:");

        cbxCliente.setToolTipText("");

        lblCliente.setText("Cliente:");

        cbxFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Á vista", "Á prazo", "Cheque", "Cartão de Crédito" }));
        cbxFormaPagamento.setToolTipText("");

        javax.swing.GroupLayout pnGeralLayout = new javax.swing.GroupLayout(pnGeral);
        pnGeral.setLayout(pnGeralLayout);
        pnGeralLayout.setHorizontalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(18, 18, 18)
                        .addComponent(cbxCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addComponent(lblData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblFormaPagamento)
                        .addGap(18, 18, 18)
                        .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFormaPagamento)
                    .addComponent(cbxFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblData))
                .addGap(34, 34, 34)
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        tpVendas.addTab("Geral", pnGeral);

        javax.swing.GroupLayout pnItensLayout = new javax.swing.GroupLayout(pnItens);
        pnItens.setLayout(pnItensLayout);
        pnItensLayout.setHorizontalGroup(
            pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        pnItensLayout.setVerticalGroup(
            pnItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        tpVendas.addTab("Itens", pnItens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpVendas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tpVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxCliente;
    private javax.swing.JComboBox cbxFormaPagamento;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFormaPagamento;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JPanel pnItens;
    private javax.swing.JTabbedPane tpVendas;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
