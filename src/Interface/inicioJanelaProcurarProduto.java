/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import BaseDados.Serializacao;
import Negocio.ProdutoLoja;
import Negocio.Sistema;
import Negocio.ListaLojas;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class inicioJanelaProcurarProduto extends javax.swing.JDialog {

    private final Sistema sistema;
    private final Serializacao bd;
    private ArrayList<ProdutoLoja> p;
    private AbstractTableModel modeloTabela;

    /**
     *
     * @param sistema
     * @param bd
     */
    public inicioJanelaProcurarProduto(Sistema sistema, Serializacao bd) {

        initComponents();

        this.sistema = sistema;
        this.bd = bd;
        this.p = p;
        texto.requestFocus();
        min.setVisible(false);
        max.setVisible(false);

    }

    /**
     *
     *
     */
    private AbstractTableModel criarModeloTabela() {
        String[] nomeColunas = {"Nome", "Marca", "referencia", "Preco", "Dsponibilidade"};

        List<ProdutoLoja> listas = new ArrayList<>(p);

        listas.sort(new Comparator<ProdutoLoja>() {

            @Override
            public int compare(ProdutoLoja o2, ProdutoLoja o1) {

                return String.valueOf(o1.getPreco()).compareTo(String.valueOf(o2.getPreco()));
            }
        });

        for (int i = 0; i < listas.size(); i++) {
            min.setText(String.format("O preço minimo é: %s ", String.valueOf(listas.get(listas.size() - 1).getPreco())));
            min.setVisible(true);
            max.setText(String.format("O preço máximo é: %s", String.valueOf(listas.get(0).getPreco())));
            max.setVisible(true);
        }

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                return p.size();
            }

            @Override
            public int getColumnCount() {
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                ProdutoLoja produto = p.get(rowIndex);
                System.out.println(produto.getLoja().getUsername());
                switch (columnIndex) {
                    case 0:
                        return produto.getProduto().getNomeProduto();
                    case 1:
                        return produto.getProduto().getMarca();
                    case 2:
                        return produto.getProduto().getReferencia();

                    case 3:
                        return produto.getPreco();
                    case 4:
                        return produto.getDisponibilidade();

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
    public void procurar() {

        if (combo.getSelectedItem().toString() == "Nome") {
            p = sistema.getListaProdutoLoja().procurarNome(texto.getText());

        } else if (combo.getSelectedItem().toString() == "Marca") {
            p = sistema.getListaProdutoLoja().procurarMarca(texto.getText());

        } else if (combo.getSelectedItem().toString() == "Referencia") {
            p = sistema.getListaProdutoLoja().procurarReferencia(texto.getText());

        }

        modeloTabela = criarModeloTabela();
        tabela.setModel(modeloTabela);

    }

    /**
     *
     *
     */
    private void lojaMostrada() {
        if (tabela.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Escolha uma loja p.f.");
            tabela.requestFocus();
            return;
        }

        int rowIndex = tabela.getSelectedRow();
        if (rowIndex == -1) {
            return;
        }

        ProdutoLoja pro = p.get(rowIndex);
        String username = pro.getLoja().getUsername();

        try {
            sistema.getListaLojas().conta(username);
            //Loja utilizador = (Loja)sistema.getListaUtilizadores().getUtilizador(username);
            //  utilizador.addClickUsados();

        } catch (ListaLojas.NaoVisita ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        DadosLojaMostrada loja = new DadosLojaMostrada(sistema, pro);
        loja.setVisible(true);
    }

    /**
     *
     *
     */
    public void login() {
        Login login = new Login(sistema, bd);
        login.setVisible(true);
        dispose();
    }

    /**
     *
     *
     */
    public void registar() {
        DadosRegistarLoja registar = new DadosRegistarLoja(sistema, bd);
        registar.setVisible(true);
        dispose();
    }

    /**
     *
     *
     */
    private void terminar() {

        guardarAlteracoes();
        sistema.terminar();

    }

    /**
     *
     *
     */
    private void guardarAlteracoes() {
        bd.guardar(sistema);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texto = new javax.swing.JTextField();
        procurar = new javax.swing.JButton();
        combo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        login = new javax.swing.JButton();
        registar = new javax.swing.JButton();
        min = new javax.swing.JLabel();
        max = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        procurar.setText("Procurar");
        procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarActionPerformed(evt);
            }
        });

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Marca", "Referencia" }));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Marca", "Referencia", "Preco", "Disponibilidade"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        jButton1.setText("Mostrar Loja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        registar.setText("Registar Loja");
        registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registarActionPerformed(evt);
            }
        });

        min.setText("jLabel1");

        max.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(login)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(procurar)
                            .addComponent(min)
                            .addComponent(max))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(registar)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procurar))
                .addGap(18, 18, 18)
                .addComponent(min)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(max))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarActionPerformed
        // TODO add your handling code here:

        procurar();
    }//GEN-LAST:event_procurarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        lojaMostrada();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
        login();
    }//GEN-LAST:event_loginActionPerformed

    private void registarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registarActionPerformed
        // TODO add your handling code here:
        registar();
    }//GEN-LAST:event_registarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        terminar();

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton login;
    private javax.swing.JLabel max;
    private javax.swing.JLabel min;
    private javax.swing.JButton procurar;
    private javax.swing.JButton registar;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField texto;
    // End of variables declaration//GEN-END:variables
}
