/*
 * Testes.java
 *
 * Created on 31 de Janeiro de 2008, 14:48
 */

package gui;

import dados.ListaIO;
import dados.PastaCorrecao;
import dados.Questao;
import dados.Teste;
import java.awt.Color;
import java.awt.Component;
import java.awt.FontMetrics;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author  UltraXP
 */
public class Testes extends javax.swing.JDialog {
    
    private Questao questao = null;
    private int indiceTeste = 0;
    
    /** Creates new form Testes */
    public Testes(java.awt.Frame parent, Questao questao, int indiceTeste) {
        super(parent, "Teste n�mero " + (indiceTeste + 1), true);
        this.questao = questao;
        this.indiceTeste = indiceTeste;
        initComponents();
        configurarTabela(tabEntradas);
        configurarTabela(tabGabaritos);
        Janelas.alinharContainer(this);
    }
    
    private void configurarTabela(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        ListaIO lista = questao.getListaIO();
        int tam = lista.getTamLista();
        // Adiciona algumas colunas
        if (tabela == tabEntradas) {
            model.addColumn("Entrada");
            if (tam > 0) {
                for (int i = 0; i <= tam - 1; i++) {
                    Teste entrada = lista.getEntrada(i);
                    model.addRow((new Object[] {entrada.getValor(), entrada.getTipo()}));
                }
            }
        } else {
            model.addColumn("Gabarito");
            if (tam > 0) {
                for (int i = 0; i <= tam - 1; i++) {
                    Teste gabarito = lista.getGabarito(i);
                    model.addRow((new Object[] {gabarito.getValor(), gabarito.getTipo()}));
                }
            }
            
        }
        model.addColumn("Tipo");

        tabela.setRowHeight(20);
        // Configura o combobox na primeira coluna vis�vel
        TableColumn col = tabela.getColumnModel().getColumn(1);
        col.setCellEditor(new ComboBoxEditor(Teste.TIPOS));
        col.setCellRenderer(new ComboBoxRenderer(Teste.TIPOS));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPaneGab = new javax.swing.JScrollPane();
        tabGabaritos = new javax.swing.JTable();
        btnInserir = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        jScrollPaneEnt = new javax.swing.JScrollPane();
        tabEntradas = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        tabGabaritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabGabaritos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabGabaritosMouseReleased(evt);
            }
        });

        jScrollPaneGab.setViewportView(tabGabaritos);

        btnInserir.setIcon(new javax.swing.ImageIcon("F:\\Arthur\\Projetos\\NetBeans\\Corretor\\imagens\\adicionar.png"));
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon("F:\\Arthur\\Projetos\\NetBeans\\Corretor\\imagens\\remover.png"));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        tabEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabEntradasMouseReleased(evt);
            }
        });

        jScrollPaneEnt.setViewportView(tabEntradas);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPaneGab, 0, 397, Short.MAX_VALUE)
                            .add(jScrollPaneEnt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, btnExcluir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, btnInserir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(btnCancelar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 296, Short.MAX_VALUE)
                        .add(btnConfirmar)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {btnExcluir, btnInserir}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(btnInserir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnExcluir))
                    .add(jScrollPaneEnt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPaneGab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnConfirmar)
                    .add(btnCancelar))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {btnExcluir, btnInserir}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabEntradasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabEntradasMouseReleased
        tabGabaritos.setSelectionModel(tabEntradas.getSelectionModel());
    }//GEN-LAST:event_tabEntradasMouseReleased

    private void tabGabaritosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabGabaritosMouseReleased
        tabEntradas.setSelectionModel(tabGabaritos.getSelectionModel());
    }//GEN-LAST:event_tabGabaritosMouseReleased

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        
        int nroLinhas = tabEntradas.getModel().getRowCount();
        questao.getListaIO().limparLista();
        for (int i = 0; i <= nroLinhas - 1; i++) {
            String valor = (String) tabEntradas.getValueAt(i, 0);
            String tipo = (String) tabEntradas.getValueAt(i, 1);
            Teste entrada = new Teste(valor, tipo);
            
            valor = (String) tabGabaritos.getValueAt(i, 0);
            tipo = (String) tabGabaritos.getValueAt(i, 1);
            Teste gabarito = new Teste(valor,tipo);
            
            questao.getListaIO().adicionarIO(entrada, gabarito);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        DefaultTableModel model = (DefaultTableModel)tabEntradas.getModel();
        model.addRow(new Object[] {"", "String"});
        model = (DefaultTableModel)tabGabaritos.getModel();
        model.addRow(new Object[] {"", "String"});
        tabEntradas.getSelectionModel().setSelectionInterval(0,0);
        tabGabaritos.getSelectionModel().setSelectionInterval(0,0);
        btnExcluir.setEnabled(true);
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int[] selecionadas = tabEntradas.getSelectedRows();
        DefaultTableModel model1 = (DefaultTableModel)tabEntradas.getModel();
        DefaultTableModel model2 = (DefaultTableModel)tabGabaritos.getModel();
        int tam = selecionadas.length;
        for (int i = tam - 1; i >= 0; i--) {
            int linha = selecionadas[i];
            model1.removeRow(linha);
            model2.removeRow(linha);
        }
        if (model1.getRowCount() > 0) {
            tabEntradas.getSelectionModel().setSelectionInterval(0,0);
            tabGabaritos.getSelectionModel().setSelectionInterval(0,0);
        } else {
            btnExcluir.setEnabled(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JScrollPane jScrollPaneEnt;
    private javax.swing.JScrollPane jScrollPaneGab;
    private javax.swing.JTable tabEntradas;
    private javax.swing.JTable tabGabaritos;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
    
    public static void main(String args[]) {
        new Testes(null, new Questao(), 0).setVisible(true);
    }
    
    class ComboBoxRenderer extends JComboBox implements TableCellRenderer {
        public ComboBoxRenderer(String[] items) {
            super(items);
        }    

        public Component getTableCellRendererComponent(JTable table, 
              Object value, boolean isSelected, boolean hasFocus, int row,
              int column) {
            
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                super.setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(table.getBackground());
            }    

            setSelectedItem(value);
            return this;
        }
    }    

    class ComboBoxEditor extends DefaultCellEditor {
        public ComboBoxEditor(String[] items) {
            super(new JComboBox(items));
        }
    }
}
