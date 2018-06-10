/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Negocio.Loja;
import Negocio.Sistema;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author daniel
 */
public class janelaLojasSuspensas extends javax.swing.JDialog {

    private Sistema sistema;

    private final AbstractTableModel modeloTabela;

    /**
     * Creates new form janelaLojasSuspensas
     */
    public janelaLojasSuspensas(Sistema sistema) {

        initComponents();

        this.sistema = sistema;

        this.modeloTabela = criarModeloTabelaLojasSuspensar();
        tabela.setModel(modeloTabela);
    }

    /**
     * cria o modelo da tabela e adiciona os dados
     *
     */
    private AbstractTableModel criarModeloTabelaLojasSuspensar() {
        String[] nomeColunas = {"Username", "Nome", "Subscricao"};

        ArrayList<Loja> listas = new ArrayList<>(sistema.getListaLojas().lojasSuspensas());

        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }

            @Override
            public int getRowCount() {
                return listas.size();
            }

            @Override
            public int getColumnCount() {
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                Loja l = (Loja) listas.get(rowIndex);

                switch (columnIndex) {
                    case 0:
                        return l.getUsername();
                    case 1:
                        return l.getNome();

                    case 2:
                        return l.getSubscricao();
                    default:
                        return "";
                }
            }
        };
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
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}