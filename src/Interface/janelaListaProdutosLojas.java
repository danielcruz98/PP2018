/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Users.ListaUsers;
import Negocio.Users.Loja;
import Negocio.Produtos.Produto;
import Negocio.Sistema;
import Negocio.Produtos.ProdutoLoja;
import Negocio.Produtos.RepositorioProduto;
import Negocio.Produtos.RepositorioProdutoLoja;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class janelaListaProdutosLojas extends javax.swing.JDialog {
    private Sistema sistema;
    /**
     * Creates new form janelaListaProdutoLojas
     */
    public janelaListaProdutosLojas(Sistema sistema) {
     
        initComponents();
    
        this.sistema = sistema;
        addTabelaLojas();
        addTabelaProdutos();
        addTabelaRep();
        
        
    }
    
    public void addTabelaLojas() {
        DefaultTableModel model = (DefaultTableModel) lojas.getModel();
        Object rowData[] = new Object[2];
        for (int i = 0; i < sistema.getListaUtilizadores().size(); i++) {
            if (sistema.getListaUtilizadores().todos().get(i) instanceof Loja) {

                Loja u = (Loja) sistema.getListaUtilizadores().todos().get(i);
                rowData[0] = u.getUsername();
                rowData[1] = u.getNome();
                model.addRow(rowData);
            }
        }

    }
    
    public void addTabelaProdutos() {
        DefaultTableModel model = (DefaultTableModel) produtos.getModel();
        Object rowData[] = new Object[5];
        for (int i = 0; i < sistema.getListaProduto().size(); i++) {
                      
                rowData[0] = sistema.getListaProduto().todos().get(i).getCodigoBarras();
                rowData[1] = sistema.getListaProduto().todos().get(i).getNomeProduto();
                model.addRow(rowData);
            
        }

    }
    
    public void addTabelaRep() {
        DefaultTableModel model = (DefaultTableModel) rep.getModel();
        Object rowData[] = new Object[5];
        for (int i = 0; i < sistema.getListaProdutoLoja().size(); i++) {
                      
                rowData[0] = sistema.getListaProdutoLoja().lista().get(i).getProduto().getNomeProduto();
                rowData[1] = sistema.getListaProdutoLoja().lista().get(i).getPreco();
                rowData[2] = sistema.getListaProdutoLoja().lista().get(i).getDisponibilidade();
                rowData[3] = sistema.getListaProdutoLoja().lista().get(i).getLoja().getNome();
                model.addRow(rowData);
            
        }

    }
    
    private void associar() throws ListaUsers.UtilizadorNaoExistenteException, RepositorioProduto.ProdutoNaoExistenteException, RepositorioProdutoLoja.ProdutoJaExisteNaLojaException {
        int rowIndexl = lojas.getSelectedRow();
        if (rowIndexl == -1) return;
        int rowIndexp = produtos.getSelectedRow();
        if (rowIndexp == -1) return;
        
        String username = (String) lojas.getValueAt(rowIndexl, 0);
        String codigo = (String) produtos.getValueAt(rowIndexp, 0);
        double p = Double.valueOf(preco.getText());
        Boolean b = Boolean.parseBoolean(disp.getText());
        Loja loja = (Loja)sistema.getListaUtilizadores().getUtilizador(username);
        Produto produto = sistema.getListaProduto().getProduto(codigo);
        ProdutoLoja u = new ProdutoLoja(p,b,produto,loja);
        try{
        
        sistema.getListaProdutoLoja().addProdutoLoja(u);
        } catch (RepositorioProdutoLoja.ProdutoJaExisteNaLojaException ex) {
          
            JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
        }
        
       
        
        
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        
    }
    
     private void fechar() {
        dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lojas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        produtos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        preco = new javax.swing.JTextField();
        disp = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        rep = new javax.swing.JTable();
        associar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lojas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Nome"
            }
        ));
        jScrollPane1.setViewportView(lojas);

        produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Barras", "Nome do Produto"
            }
        ));
        jScrollPane2.setViewportView(produtos);

        jLabel1.setText("Preco:");

        jLabel2.setText("Disponibilidade:");

        disp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispActionPerformed(evt);
            }
        });

        rep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preco", "Disponibilidade", "Loja"
            }
        ));
        jScrollPane3.setViewportView(rep);

        associar.setText("jButton1");
        associar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(preco, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(disp)))
                            .addComponent(associar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(disp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(associar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dispActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dispActionPerformed

    private void associarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associarActionPerformed
       
      
        
        try {
            // TODO add your handling code here:
            associar();
        } catch (ListaUsers.UtilizadorNaoExistenteException | RepositorioProduto.ProdutoNaoExistenteException | RepositorioProdutoLoja.ProdutoJaExisteNaLojaException ex) {
            Logger.getLogger(janelaListaProdutosLojas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }//GEN-LAST:event_associarActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton associar;
    private javax.swing.JTextField disp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable lojas;
    private javax.swing.JTextField preco;
    private javax.swing.JTable produtos;
    private javax.swing.JTable rep;
    // End of variables declaration//GEN-END:variables
}
