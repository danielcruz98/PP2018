/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Users.Loja;
import Sistema.Sistema;
import Users.ListaLojas;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class janelaListaLojas extends javax.swing.JDialog {

    private final Sistema sistema;
    private final AbstractTableModel modeloTabela;

    /**
     * Creates new form janelaListaLojas
     *
     * @param sistema
     */
    public janelaListaLojas(Sistema sistema) {

        initComponents();

        this.sistema = sistema;

        this.modeloTabela = criarModeloTabela();
        tabelaLojas.setModel(modeloTabela);

    }

    /**
     *
     *
     */
    private AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Username", "Nome", "Subscricao", "Clicks", "ClicksRestantes", "ClicksUsados"};

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                return sistema.getListaLojas().size();
            }

            @Override
            public int getColumnCount() {
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                Loja l = (Loja) sistema.getListaLojas().todos().get(rowIndex);

                switch (columnIndex) {
                    case 0:
                        return l.getUsername();
                    case 1:
                        return l.getNome();

                    case 2:
                        return l.getSubscricao();
                    case 3:
                        return l.getClicks();
                    case 4:
                        return l.getClicksRestantes();
                    case 5:
                        return l.getClicksUsados();
                    default:
                        return "";
                }
            }
        };
    }

    /**
     *
     *
     */
    private void lojaMostrada() {
        if (tabelaLojas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha uma loja p.f.");
            tabelaLojas.requestFocus();
            return;
        }

        int rowIndex = tabelaLojas.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }

        String username = (String) tabelaLojas.getValueAt(rowIndex, 0);

        try {
            sistema.getListaLojas().conta(username);
            //Loja utilizador = (Loja)sistema.getListaUtilizadores().getUtilizador(username);
            //  utilizador.addClickUsados();

        } catch (ListaLojas.NaoVisita ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        JOptionPane.showMessageDialog(this, "Loja visitada com sucesso.");
        fechar();
        janelaListaLojas listagem = new janelaListaLojas(sistema);
        listagem.setVisible(true);
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
     */
    private void adicionar() {

        DadosLojas janela = new DadosLojas(sistema, null, this);
        janela.setVisible(true);
    }

    /**
     *
     *
     */
    private void editar() {
        if (tabelaLojas.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha uma loja p.f.");
            tabelaLojas.requestFocus();
            return;
        }

        int rowIndex = tabelaLojas.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }

        String username = (String) tabelaLojas.getValueAt(rowIndex, 0);

        try {

            Loja utilizador = (Loja) sistema.getListaLojas().getUtilizador(username);
            DadosLojas janela = new DadosLojas(sistema, utilizador, this);
            janela.setVisible(true);
        } catch (ListaLojas.UtilizadorNaoExistenteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }

    /**
     *
     *
     */
    public void clicks() {
        int i = Integer.parseInt(click.getText());

        janelaListagemDeClicks clicks = new janelaListagemDeClicks(sistema, i);
        clicks.setVisible(true);
    }

    /**
     *
     *
     */
    public void visitadas() {
        janelaLojasMaisVisitadas listagem = new janelaLojasMaisVisitadas(sistema);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaLojas = new javax.swing.JTable();
        editar = new javax.swing.JButton();
        adicionar = new javax.swing.JButton();
        click = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        mostra = new javax.swing.JButton();
        visitas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaLojas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Nome", "Subscricao", "CLicks", "ClicksRestantes", "ClicksUsados"
            }
        ));
        jScrollPane1.setViewportView(tabelaLojas);

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        adicionar.setText("Adicionar");
        adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarActionPerformed(evt);
            }
        });

        jButton1.setText("Clicks");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        mostra.setText("MostraLoja");
        mostra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraActionPerformed(evt);
            }
        });

        visitas.setText("Mais Visitadas");
        visitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(adicionar)
                        .addGap(18, 18, 18)
                        .addComponent(click, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(65, 65, 65)
                        .addComponent(mostra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(visitas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editar)
                        .addGap(0, 22, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editar)
                    .addComponent(adicionar)
                    .addComponent(click, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(mostra)
                    .addComponent(visitas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        editar();
    }//GEN-LAST:event_editarActionPerformed

    private void adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_adicionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clicks();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mostraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostraActionPerformed
        // TODO add your handling code here:
        lojaMostrada();
    }//GEN-LAST:event_mostraActionPerformed

    private void visitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visitasActionPerformed
        // TODO add your handling code here:
        visitadas();
    }//GEN-LAST:event_visitasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionar;
    private javax.swing.JTextField click;
    private javax.swing.JButton editar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mostra;
    private javax.swing.JTable tabelaLojas;
    private javax.swing.JButton visitas;
    // End of variables declaration//GEN-END:variables
}
