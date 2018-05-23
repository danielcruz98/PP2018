/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.ListaUsers;
import Negocio.Sistema;
import Negocio.Loja;
import Negocio.Utilizador;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class DadosLojas extends javax.swing.JDialog {

    private Sistema sistema;
    private janelaListaLojas lista;
    private Loja utilizador;
    

    /**
     * Creates new form DadosUsers
     */
    public DadosLojas(Sistema sistema, Loja utilizador, janelaListaLojas lista) {

        initComponents();

        this.sistema = sistema;

        this.utilizador = utilizador;

        this.lista = lista;

        if (registoNovo()) {
            setTitle("Criação de nova Loja");
            username.requestFocus();
        } else {
            setTitle("Alteração de dados da Loja");
            username.setText(utilizador.getUsername());
            nome.setText(utilizador.getNome());
            password.requestFocus();
            subscricao.setText(String.valueOf(utilizador.getSubscricao()));
            clicks.setText(String.valueOf(utilizador.getClicks()));
        }
    }

    private boolean registoNovo() {
        return utilizador == null;
    }

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

        if (password.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a nova password!");
            password.requestFocus();
            return;
        }

        if (conf.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a password de confirmação!");
            conf.requestFocus();
            return;
        }

        String pass = new String(password.getText());

        if (!pass.equals(new String(conf.getText()))) {
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            conf.requestFocus();
            return;
        }
        
        if (subscricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu nome!");
            subscricao.requestFocus();
            return;
        }
        
        if (clicks.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu nome!");
            clicks.requestFocus();
            return;
        }

        if (registoNovo()) {
            username.setEditable(true);
            Loja novo = new Loja();
            novo.setNome(nome.getText());
            novo.setUsername(username.getText());
            novo.setPassword(pass);
            novo.setSubscricao(Boolean.parseBoolean(subscricao.getText()));
            novo.setClicks(Integer.parseInt(clicks.getText()));

            try {
                sistema.getListaUtilizadores().adicionar(novo);
            } catch (ListaUsers.UtilizadorDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }

        } else {
            username.setEditable(false);
            utilizador.setNome(nome.getText());
            utilizador.setPassword(pass);
            utilizador.setSubscricao(Boolean.parseBoolean(subscricao.getText()));
            utilizador.setClicks(Integer.parseInt(clicks.getText()));
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        nome = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        conf = new javax.swing.JTextField();
        subscricao = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        clicks = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Nome");

        jLabel3.setText("Password");

        jLabel4.setText("Confirmação");

        jLabel5.setText("Subscrição");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

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

        jLabel6.setText("Clicks");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardar)
                        .addGap(29, 29, 29)
                        .addComponent(fechar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(nome)
                            .addComponent(password)
                            .addComponent(conf)
                            .addComponent(subscricao)
                            .addComponent(clicks))))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(conf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(subscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(clicks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(fechar))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

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
    private javax.swing.JTextField clicks;
    private javax.swing.JTextField conf;
    private javax.swing.JButton fechar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nome;
    private javax.swing.JTextField password;
    private javax.swing.JTextField subscricao;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
