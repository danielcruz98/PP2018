/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Sistema;
import Negocio.Produto;
import Negocio.RepositorioProduto;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class DadosProdutos extends javax.swing.JDialog {

    private final Sistema sistema;

    private final janelaListaProdutos lista;

    private final Produto produto;

    /**
     * Creates new form DadosProdutos
     *
     * @param sistema
     * @param produto
     * @param lista
     */
    public DadosProdutos(Sistema sistema, Produto produto, janelaListaProdutos lista) {

        initComponents();

        this.sistema = sistema;

        this.produto = produto;

        //Guarda a referencia a listagem
        this.lista = lista;

        if (registoNovo()) {

            setTitle("Criação de novo Produto");
            nome.requestFocus();
        } else {

            setTitle("Alteração de dados de Produto");

            nome.setText(produto.getNomeProduto());
            marca.setText(produto.getMarca());
            referencia.setText(produto.getReferencia());
            codigo.setText(produto.getCodigoBarras());

            codigo.setEnabled(false);

        }
    }

    /**
     * registo novo
     *
     */
    private boolean registoNovo() {

        return produto == null;
    }

    /**
     * recebe os dados todos e cria o produto
     *
     */
    private void guardar() {
        if (registoNovo() && nome.getText().isEmpty()) {
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
            JOptionPane.showMessageDialog(this, "Introduza p.f. a referencia!");
            codigo.requestFocus();
            return;
        }

        if (registoNovo()) {
            codigo.setEditable(true);
            Produto novo = new Produto();
            novo.setNomeProduto(nome.getText());
            novo.setMarca(marca.getText());
            novo.setReferencia(referencia.getText());
            novo.setCodigoBarras(codigo.getText());
            try {
                sistema.getListaProduto().registarProduto(novo);
            } catch (RepositorioProduto.ProdutoDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }
        } else {
            produto.setNomeProduto(nome.getText());
            produto.setMarca(marca.getText());
            produto.setReferencia(referencia.getText());
            codigo.setEditable(false);

        }

        if (lista != null) {
            lista.atualizar();
        }

        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();

    }

    /**
     * fecha a janela
     *
     */
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
        jLabel3 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        marca = new javax.swing.JTextField();
        referencia = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        codigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Marca:");

        jLabel3.setText("Referencia:");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(codigo)
                    .addComponent(nome)
                    .addComponent(referencia)
                    .addComponent(marca, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(sair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(referencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(sair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_guardarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        fechar();
    }//GEN-LAST:event_sairActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField marca;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField referencia;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
