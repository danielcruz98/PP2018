/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Sistema;
import Negocio.Administrador;
import bd.Serializacao;
import javax.swing.JOptionPane;
/**
 *
 * @author daniel
 */
public class Principal extends javax.swing.JDialog {

    private Sistema sistema;
    private Serializacao bd;
    /**
     * Creates new form Principal
     */
    public Principal(Sistema sistema, Serializacao bd) {
        
        initComponents();
         
        this.sistema = sistema;
        this.bd=bd;
        
        novaLoja.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        listaLojas.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        listaUsers.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
    }

    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }
    
    private void listarUsers() {
        janelaListaUsers listagem = new janelaListaUsers(sistema);
        listagem.setVisible(true);        
    }
    
    private void listarProdutos() {
        janelaListaProdutos listagem = new janelaListaProdutos(sistema);
        listagem.setVisible(true);        
    }
    
    private void alterarPassword() {        
        DadosUsers psw = new DadosUsers(sistema, sistema.getUtilizadorLigado(), null);
        psw.setVisible(true);
    }
    
    private void listarLojas() {
        janelaListaLojas listagem = new janelaListaLojas(sistema);
        listagem.setVisible(true);        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        alteraDados = new javax.swing.JMenu();
        guardar = new javax.swing.JMenuItem();
        listaUsers = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        novaLoja = new javax.swing.JMenuItem();
        listaLojas = new javax.swing.JMenuItem();
        produtoLoja = new javax.swing.JMenuItem();
        Menu4 = new javax.swing.JMenu();
        novoProduto = new javax.swing.JMenuItem();
        listaProduto = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        alteraDados.setText("Geral");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        alteraDados.add(guardar);

        listaUsers.setText("Lista Users");
        listaUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUsersActionPerformed(evt);
            }
        });
        alteraDados.add(listaUsers);

        jMenuItem2.setText("Alterar Dados");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        alteraDados.add(jMenuItem2);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        alteraDados.add(Sair);

        jMenuBar1.add(alteraDados);

        jMenu4.setText("Loja");

        novaLoja.setText("Nova Loja");
        novaLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaLojaActionPerformed(evt);
            }
        });
        jMenu4.add(novaLoja);

        listaLojas.setText("Lista Lojas");
        listaLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaLojasActionPerformed(evt);
            }
        });
        jMenu4.add(listaLojas);

        produtoLoja.setText("Produto Loja");
        produtoLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoLojaActionPerformed(evt);
            }
        });
        jMenu4.add(produtoLoja);

        jMenuBar1.add(jMenu4);

        Menu4.setText("Produto");

        novoProduto.setText("Novo Produto");
        novoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoProdutoActionPerformed(evt);
            }
        });
        Menu4.add(novoProduto);

        listaProduto.setText("Lista Produtos");
        listaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaProdutoActionPerformed(evt);
            }
        });
        Menu4.add(listaProduto);

        jMenuBar1.add(Menu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        guardarAlteracoes();
        JOptionPane.showMessageDialog(this, "Alterações guardadas.");
    }//GEN-LAST:event_guardarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        alterarPassword();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        sistema.terminar();
    }//GEN-LAST:event_SairActionPerformed

    private void novaLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaLojaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novaLojaActionPerformed

    private void produtoLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoLojaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtoLojaActionPerformed

    private void novoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novoProdutoActionPerformed

    private void listaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProdutoActionPerformed
        // TODO add your handling code here:
        listarProdutos();
    }//GEN-LAST:event_listaProdutoActionPerformed

    private void listaUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUsersActionPerformed
        // TODO add your handling code here:
        listarUsers();
    }//GEN-LAST:event_listaUsersActionPerformed

    private void listaLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaLojasActionPerformed
        // TODO add your handling code here:
        listarLojas();
        
    }//GEN-LAST:event_listaLojasActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu4;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu alteraDados;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem listaLojas;
    private javax.swing.JMenuItem listaProduto;
    private javax.swing.JMenuItem listaUsers;
    private javax.swing.JMenuItem novaLoja;
    private javax.swing.JMenuItem novoProduto;
    private javax.swing.JMenuItem produtoLoja;
    // End of variables declaration//GEN-END:variables
}
