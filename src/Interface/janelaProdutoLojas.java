/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Produto;
import Negocio.ProdutoLoja;
import Negocio.RepositorioProduto;
import Negocio.RepositorioProdutoLoja;
import Negocio.Sistema;
import Negocio.ListaLojas;
import Negocio.Loja;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class janelaProdutoLojas extends javax.swing.JDialog {

    private final Sistema sistema;

    private AbstractTableModel modeloTabela;

    /**
     *
     *
     * @param sistema
     */
    public janelaProdutoLojas(Sistema sistema) {

        initComponents();

        this.sistema = sistema;

        codigo.requestFocus();
        
        this.modeloTabela = criarModeloTabela();
        rep.setModel(modeloTabela);

    }

    /**
     *
     *
     */
    private AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Nome", "Marca", "referencia", "codigo", "Preco", "Dsponibilidade"};

        Loja l = (Loja) sistema.getUtilizadorLigado();
        String s = l.getUsername();

        ArrayList<ProdutoLoja> produto = sistema.getListaProdutoLoja().listarProdutosLoja(s);

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {

                return produto.size();
            }

            @Override
            public int getColumnCount() {
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                switch (columnIndex) {
                    case 0:
                        return produto.get(rowIndex).getProduto().getNomeProduto();
                    case 1:
                        return produto.get(rowIndex).getProduto().getMarca();
                    case 2:
                        return produto.get(rowIndex).getProduto().getReferencia();
                    case 3:
                        return produto.get(rowIndex).getProduto().getCodigoBarras();

                    case 4:
                        return produto.get(rowIndex).getPreco();
                    case 5:
                        return produto.get(rowIndex).getDisponibilidade();
                    default:
                        return "";
                }
            }
        };
    }

    /**
     *
     *
     * @throws Users.ListaLojas.UtilizadorNaoExistenteException
     * @throws Produtos.RepositorioProduto.ProdutoNaoExistenteException
     * @throws Produtos.RepositorioProdutoLoja.ProdutoJaExisteNaLojaException
     */
    public void associar() throws ListaLojas.UtilizadorNaoExistenteException, RepositorioProduto.ProdutoNaoExistenteException, RepositorioProdutoLoja.ProdutoJaExisteNaLojaException {
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

        modeloTabela = criarModeloTabela();
        rep.setModel(modeloTabela);
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");

    }

    /**
     *
     *
     */
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

        atualizar();
        JOptionPane.showMessageDialog(this, "Produto alterado com sucesso.");

    }

    /**
     *
     *
     */
    private void fechar() {
        dispose();
    }

    /**
     *
     *
     */
    public void atualizar() {
        modeloTabela.fireTableDataChanged();
    }

    /**
     *
     *
     * @throws Produtos.RepositorioProduto.ProdutoNaoExistenteException
     */
    public void procurar() throws RepositorioProduto.ProdutoNaoExistenteException {
        if (codigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o codigo de barras que pretende procurar!");
            codigo.requestFocus();
            return;
        }

        String s = codigo.getText();

        if (sistema.getListaProduto().verificarProduto(s) == true) {
            try {
                Produto p = sistema.getListaProduto().getProduto(s);
                JOptionPane.showMessageDialog(this, "O produto existe.");
                codigo.setText(p.getCodigoBarras());
                nome.setText(p.getNomeProduto());
                marca.setText(p.getMarca());
                referencia.setText(p.getReferencia());
            } catch (RepositorioProduto.ProdutoNaoExistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "O produto nao existe.");
        }
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
        procurar = new javax.swing.JButton();

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

        procurar.setText("Procurar");
        procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(preco))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(associar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editar)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(marca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                .addComponent(nome, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(referencia))))
                    .addComponent(procurar))
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
                        .addComponent(procurar)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void associarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associarActionPerformed
        try {
            // TODO add your handling code here:
            associar();
        } catch (ListaLojas.UtilizadorNaoExistenteException | RepositorioProduto.ProdutoNaoExistenteException | RepositorioProdutoLoja.ProdutoJaExisteNaLojaException ex) {
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
        preco.setText(String.valueOf(l.getPreco()));
    }//GEN-LAST:event_repMouseClicked

    private void procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarActionPerformed
        try {
            // TODO add your handling code here:
            procurar();
        } catch (RepositorioProduto.ProdutoNaoExistenteException ex) {
            Logger.getLogger(janelaProdutoLojas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_procurarActionPerformed

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
    private javax.swing.JButton procurar;
    private javax.swing.JTextField referencia;
    private javax.swing.JTable rep;
    // End of variables declaration//GEN-END:variables
}
