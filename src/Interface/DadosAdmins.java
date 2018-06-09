/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JOptionPane;

import Sistema.Sistema;
import Users.ListaAdmins;
import Users.Utilizador;
import Users.Administrador;

/**
 *
 * @author daniel
 */
public class DadosAdmins extends javax.swing.JDialog {

    private final Sistema sistema;    
    private final janelaListaAdmins lista;
    private final Utilizador utilizador; 
    /**
     * 
     * @param sistema
     * @param utilizador
     * @param lista
     */
    public DadosAdmins(Sistema sistema, Utilizador utilizador, janelaListaAdmins lista) {
        
        initComponents();
        
        this.sistema = sistema;   
        
        this.utilizador = utilizador;
        
        this.lista = lista;
        
        if (registoNovo()) {    
            setTitle("Criação de novo utilizador");
            username.requestFocus();                      
        }else{
            setTitle("Alteração de dados de utilizador");
            username.setText(utilizador.getUsername());
            nome.setText(utilizador.getNome());            
            password.requestFocus();
            
            username.setEnabled(false);
            nome.setEnabled(false);
        } 
    }
    /**
     * 
     * 
     */
    private boolean registoNovo() {
        return utilizador == null;
    }   
    /**
     * 
     * 
     */
    private void guardar() {
         if (registoNovo() && username.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o username pretendido!");            
            username.requestFocus();
            return;
        }
        
        if (nome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu nome!");            
            nome.requestFocus();
            return;
        }
        
        if (password.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a nova password!");
            password.requestFocus();
            return;
        }       
        
        if (conf.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a password de confirmação!");
            conf.requestFocus();
            return;
        }  
        
        String pass = new String(password.getPassword());
        
        if (!pass.equals(new String(conf.getPassword()))){
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            conf.requestFocus();
            return;
        }        
        
        if (registoNovo()) {      
            username.setEditable(true);                                 
            Utilizador novo = new Administrador();
            novo.setNome(nome.getText());
            novo.setUsername(username.getText());
            novo.setPassword(pass);
          
            try {
                sistema.getListaAdmins().adicionar((Administrador) novo);
            } catch (ListaAdmins.UtilizadorDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }                      
                  
        }else{
            username.setEditable(false);
            utilizador.setNome(nome.getText());
            utilizador.setPassword(pass);     
        }                       
        
            if (lista != null) {
            lista.atualizar();
        }          
        
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        
    }
    /**
     * 
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
        jLabel4 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        conf = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Nome");

        jLabel3.setText("Password");

        jLabel4.setText("Confirmação");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardar)
                        .addGap(26, 26, 26)
                        .addComponent(fechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(password)
                            .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(username, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(conf))))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(fechar))
                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_guardarActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        // TODO add your handling code here:
        fechar();
    }//GEN-LAST:event_fecharActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField conf;
    private javax.swing.JButton fechar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}