/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Produtos.Produto;
import Negocio.Produtos.ProdutoLoja;
import Negocio.Produtos.RepositorioProduto;
import Negocio.Produtos.RepositorioProdutoLoja;
import Negocio.Sistema;
import Negocio.Users.Administrador;
import Negocio.Users.ListaUsers;
import Negocio.Users.Loja;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class janelaProdutoLojas extends javax.swing.JDialog {

    private Sistema sistema;

    /**
     * Creates new form repositorioProdutoLojas
     */
    public janelaProdutoLojas(Sistema sistema) {

        initComponents();

        this.sistema = sistema;

        addTabelaRep();

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

    public void associar() throws ListaUsers.UtilizadorNaoExistenteException, RepositorioProduto.ProdutoNaoExistenteException, RepositorioProdutoLoja.ProdutoJaExisteNaLojaException {
        if (nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o username pretendido!");
            nome.requestFocus();
            return;
        }

        if (nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o nome!");
            nome.requestFocus();
            return;
        }

        if (marca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a marca!");
            marca.requestFocus();
            return;
        }

        if (referencia.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a referencia!");
            referencia.requestFocus();
            return;
        }
        if (codigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o codigo de barras!");
            codigo.requestFocus();
            return;
        }
        if (preco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o preco pretendido!");
            preco.requestFocus();
            return;
        }

        Produto novo = new Produto();
        novo.setNomeProduto(nome.getText());
        novo.setMarca(marca.getText());
        novo.setReferencia(referencia.getText());
        novo.setCodigoBarras(codigo.getText());
        codigo.addActionListener(combo);
        try {
            sistema.getListaProduto().registarProduto(novo);
        } catch (RepositorioProduto.ProdutoDuplicadoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;

        }

        Loja l = (Loja) sistema.getUtilizadorLigado();

        ProdutoLoja produto = new ProdutoLoja();
        boolean subs = true;
        if (combo.getSelectedItem().toString() == "Indisponivel") {
            subs = false;

        } else if (combo.getSelectedItem().toString() == "Disponivel") {
            subs = true;
        }
        produto.setDisponibilidade(subs);

        try {
            double p = Double.valueOf(preco.getText());
            produto.setPreco(p);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. um valor no preço");
            return;
        }

        try {
            Produto produtoA = sistema.getListaProduto().getProduto(codigo.getText());
            produto.setProduto(produtoA);
        } catch (RepositorioProduto.ProdutoNaoExistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        produto.setLoja(l);

        try {
            sistema.getListaProdutoLoja().addProdutoLoja(produto);
        } catch (RepositorioProdutoLoja.ProdutoJaExisteNaLojaException ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage());
            return;
        }

        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        janelaProdutoLojas listagem = new janelaProdutoLojas(sistema);
        listagem.setVisible(true);
    }

    public void editar() {
     
        if (preco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o preco pretendido!");
            preco.requestFocus();
            return;
        }

        if (rep.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha p.f. o produto que pretende alterar!");
            rep.requestFocus();
            return;
        }

        int i = rep.getSelectedRow();

        ProdutoLoja l = sistema.getListaProdutoLoja().getProdutoLoja(i);

        try {
            double p = Double.valueOf(preco.getText());
            l.setPreco(p);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. um valor no preço");
            return;
        }

        boolean subs = true;
        if (combo.getSelectedItem().toString() == "Indisponivel") {
            subs = false;

        } else if (combo.getSelectedItem().toString() == "Disponivel") {
            subs = true;
        }

        l.setDisponibilidade(subs);

        JOptionPane.showMessageDialog(this, "Produto alterado com sucesso.");
        fechar();
        janelaProdutoLojas listagem = new janelaProdutoLojas(sistema);
        listagem.setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        preco = new javax.swing.JTextField();
        associar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        rep = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        referencia = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Preco");

        jLabel2.setText("Disponibilidade");

        associar.setText("Associar");
        associar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associarActionPerformed(evt);
            }
        });

        rep.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Preco", "Disponibilidade", "Loja"
            }
        ));
        rep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                repMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(rep);

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Indisponivel", "Disponivel" }));

        jLabel3.setText("Codigo-Barras");

        jLabel4.setText("Referencia");

        jLabel5.setText("Marca");

        jLabel6.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(preco, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(nome)
                                    .addComponent(marca)
                                    .addComponent(referencia)
                                    .addComponent(codigo)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(associar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(associar)
                            .addComponent(editar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void associarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associarActionPerformed
        try {
            // TODO add your handling code here:
            associar();
        } catch (ListaUsers.UtilizadorNaoExistenteException | RepositorioProduto.ProdutoNaoExistenteException | RepositorioProdutoLoja.ProdutoJaExisteNaLojaException ex) {
            Logger.getLogger(janelaProdutoLojas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_associarActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_editarActionPerformed

    private void repMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_repMouseClicked
        // TODO add your handling code here:
        
        associar.setEnabled(false);
        int i = rep.getSelectedRow();

        ProdutoLoja l = sistema.getListaProdutoLoja().getProdutoLoja(i);

        Produto produto = l.getProduto();

        nome.setEditable(false);
        marca.setEditable(false);
        referencia.setEditable(false);
        codigo.setEditable(false);
        
        nome.setText(produto.getNomeProduto());
        marca.setText(produto.getMarca());
        referencia.setText(produto.getReferencia());
        codigo.setText(produto.getCodigoBarras());
    }//GEN-LAST:event_repMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton associar;
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField preco;
    private javax.swing.JTextField referencia;
    private javax.swing.JTable rep;
    // End of variables declaration//GEN-END:variables
}
