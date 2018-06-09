/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Produtos.RepositorioProdutoLoja;
import Sistema.Sistema;
import Users.Administrador;
import Users.Loja;
import BaseDados.Serializacao;
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
        
        produto.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        loja.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        listaUsers.setVisible(sistema.getUtilizadorLigado() instanceof Administrador);
        repositorio.setVisible(sistema.getUtilizadorLigado() instanceof Loja);
        clicks.setVisible(sistema.getUtilizadorLigado() instanceof Loja);
    }

    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }
    
    private void listarUsers() {
        janelaListaAdmins listagem = new janelaListaAdmins(sistema);
        listagem.setVisible(true);        
    }
    
    private void listarProdutos() {
        janelaListaProdutos listagem = new janelaListaProdutos(sistema);
        listagem.setVisible(true);        
    }
    
    private void alterarPassword() {        
        DadosAdmins psw = new DadosAdmins(sistema, sistema.getUtilizadorLigado(), null);
        psw.setVisible(true);
    }
    
    private void listarLojas() {
        janelaListaLojas listagem = new janelaListaLojas(sistema);
        listagem.setVisible(true);        
    }
    
    
    
    private void listarProdutosLoja() {
        janelaProdutoLojas listagem = new janelaProdutoLojas(sistema);
        listagem.setVisible(true);        
    }
    
    private void listarProcurar() {
        janelaProcurarProduto listagem = new janelaProcurarProduto(sistema);
        listagem.setVisible(true);        
    }
    
   private void terminar() {        
        if (JOptionPane.showConfirmDialog(null, 
                "Deseja realmente terminar o programa?", 
                "Terminar", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            guardarAlteracoes();
            sistema.terminar();
        }
    }
    public void verClicks(){
        DadosClicksLojas listagem = new DadosClicksLojas(sistema);
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
        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        alteraDados = new javax.swing.JMenu();
        guardar = new javax.swing.JMenuItem();
        listaUsers = new javax.swing.JMenuItem();
        clicks = new javax.swing.JMenuItem();
        alterarDados = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenuItem();
        loja = new javax.swing.JMenu();
        listaLojas = new javax.swing.JMenuItem();
        produto = new javax.swing.JMenu();
        listaProduto = new javax.swing.JMenuItem();
        repositorio = new javax.swing.JMenu();
        novo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        procurar = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem6.setText("jMenuItem6");

        jMenu1.setText("jMenu1");

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        alteraDados.setText("Geral");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        alteraDados.add(guardar);

        listaUsers.setText("Lista Admins");
        listaUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUsersActionPerformed(evt);
            }
        });
        alteraDados.add(listaUsers);

        clicks.setText("Clicks");
        clicks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clicksActionPerformed(evt);
            }
        });
        alteraDados.add(clicks);

        alterarDados.setText("Alterar Dados");
        alterarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarDadosActionPerformed(evt);
            }
        });
        alteraDados.add(alterarDados);

        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        alteraDados.add(Sair);

        jMenuBar1.add(alteraDados);

        loja.setText("Loja");

        listaLojas.setText("Lista Lojas");
        listaLojas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaLojasActionPerformed(evt);
            }
        });
        loja.add(listaLojas);

        jMenuBar1.add(loja);

        produto.setText("Produto");

        listaProduto.setText("Lista Produtos");
        listaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaProdutoActionPerformed(evt);
            }
        });
        produto.add(listaProduto);

        jMenuBar1.add(produto);

        repositorio.setText("Repositorio");

        novo.setText("Lista Repositorio");
        novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoActionPerformed(evt);
            }
        });
        repositorio.add(novo);

        jMenuBar1.add(repositorio);

        jMenu4.setText("Procurar");

        procurar.setText("Procurar");
        procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarActionPerformed(evt);
            }
        });
        jMenu4.add(procurar);

        jMenuBar1.add(jMenu4);

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

    private void alterarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarDadosActionPerformed
        // TODO add your handling code here:
        alterarPassword();
    }//GEN-LAST:event_alterarDadosActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
    
        sistema.terminar();
     
    }//GEN-LAST:event_SairActionPerformed

    private void listaUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUsersActionPerformed
        // TODO add your handling code here:
        listarUsers();
    }//GEN-LAST:event_listaUsersActionPerformed

    private void listaLojasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaLojasActionPerformed
        // TODO add your handling code here:
        listarLojas();
        
    }//GEN-LAST:event_listaLojasActionPerformed

    private void novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoActionPerformed
        // TODO add your handling code here:
        listarProdutosLoja();
    }//GEN-LAST:event_novoActionPerformed

    private void listaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaProdutoActionPerformed
        // TODO add your handling code here:
        listarProdutos();
    }//GEN-LAST:event_listaProdutoActionPerformed

    private void procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarActionPerformed
        // TODO add your handling code here:
        listarProcurar();
        
        
    }//GEN-LAST:event_procurarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        terminar();
    }//GEN-LAST:event_formWindowClosing

    private void clicksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clicksActionPerformed
        // TODO add your handling code here:
        
        verClicks();
    }//GEN-LAST:event_clicksActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Sair;
    private javax.swing.JMenu alteraDados;
    private javax.swing.JMenuItem alterarDados;
    private javax.swing.JMenuItem clicks;
    private javax.swing.JMenuItem guardar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem listaLojas;
    private javax.swing.JMenuItem listaProduto;
    private javax.swing.JMenuItem listaUsers;
    private javax.swing.JMenu loja;
    private javax.swing.JMenuItem novo;
    private javax.swing.JMenuItem procurar;
    private javax.swing.JMenu produto;
    private javax.swing.JMenu repositorio;
    // End of variables declaration//GEN-END:variables
}
