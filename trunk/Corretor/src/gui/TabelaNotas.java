/*
 * TabelaNotas.java
 *
 * Created on 23 de Novembro de 2007, 01:47
 */

package gui;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import src.Aluno;
import src.PastaCorrecao;

/**
 *
 * @author  UltraXP
 */
public class TabelaNotas extends javax.swing.JPanel {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates new form TabelaNotas */
    public TabelaNotas(PastaCorrecao pastaCorrecao) {
        initComponents();
        this.pastaCorrecao = pastaCorrecao;
        preencherTabela();
    }
    
    private void preencherTabela() {
        Aluno[] alunos = pastaCorrecao.getAlunos();
        tabela.setModel(new TableModel() {
            public void addTableModelListener(TableModelListener l) {
            }
            
            public Class<?> getColumnClass(int columnIndex) {
                return "".getClass();
            }
            
            public int getColumnCount() {
                return 2;
            }
            
            public String getColumnName(int columnIndex) {
                if (columnIndex == 0) {
                    return "Aluno";
                } else if (columnIndex == 1) {
                    return "Nota";
                }
                return "";
            }
            public int getRowCount() {
                return pastaCorrecao.getAlunos().length;
            }
            
            public Object getValueAt(int rowIndex, int columnIndex) {
                if (columnIndex == 0) {
                    return pastaCorrecao.getAlunos()[rowIndex].getDiretorio().getName();
                } else if (columnIndex == 1) {
                    return pastaCorrecao.getAlunos()[rowIndex].getNotaFinal();
                }
                return "";
            }
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
            
            public void removeTableModelListener(TableModelListener l) {
            }
            
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            }
            
        });
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "T�tulo 1", "T�tulo 2", "T�tulo 3", "T�tulo 4"
            }
        ));
        jScrollPane1.setViewportView(tabela);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
