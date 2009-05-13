/*
 * Testes.java
 *
 * Created on 31 de Janeiro de 2008, 14:48
 */

package gui;

import dados.LinhaEntrada;
import dados.LinhaGabarito;
import dados.ModeloLinhaGabarito;
import dados.Teste;
import dados.Teste;
import gui.modelos.KeyListenerJanela;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author  UltraXP
 */
public class TabelasTeste extends javax.swing.JDialog {

    private int indiceTeste = 0;
    private Teste esteTeste = null;
    private String nomeArquivoEntrada = null;
    private boolean saidaNormal = false;
    
    /** Creates new form Testes */
    public TabelasTeste(java.awt.Frame parent, int indiceTeste) {
        super(parent, "Teste n�mero " + (indiceTeste + 1), true);
        this.indiceTeste = indiceTeste;
        initComponents();
        configurarTabela(tabEntradas);
        configurarTabela(tabGabaritos);
        configurarCombo();
        rdPadrao.setSelected(true);
        txtArquivo.setEnabled(false);
        txtArquivo.setText("");
        Janelas.alinharContainer(this);
        this.addKeyListener(new KeyListenerJanela());
        esteTeste = new Teste();
    }
    
    public TabelasTeste(java.awt.Frame parent, int indiceTeste, Teste teste) {
        super(parent, "Teste n�mero " + (indiceTeste + 1), true);
        this.indiceTeste = indiceTeste;
        this.esteTeste = teste;
        initComponents();
        configurarTabela(tabEntradas);
        configurarTabela(tabGabaritos);
        configurarCombo();
        if (esteTeste.getNomeArquivoEntrada() != null) {
            rdArquivo.setSelected(true);
            txtArquivo.setText(esteTeste.getNomeArquivoEntrada());
            nomeArquivoEntrada = esteTeste.getNomeArquivoEntrada();
        } else {
            rdPadrao.setSelected(true);
            txtArquivo.setEnabled(false);
            txtArquivo.setText("");
        }
        Janelas.alinharContainer(this);
    }
    
    private void configurarTabela(JTable tabela) {
        DefaultTableModel model = (DefaultTableModel)tabela.getModel();
        
        if (tabela == tabEntradas) {
            model.addColumn("String");
            if (esteTeste != null) {
                int tam = esteTeste.getNroLinhasEntradas();
                for (int i = 0; i <= tam - 1; i++) {
                    LinhaEntrada entrada = esteTeste.getEntrada(i);
                    model.addRow((new Object[] {entrada.getValor()}));
                }
                if (tam > 1) {
                    btnExcluirLinEnt.setEnabled(true);
                } else {
                    btnExcluirLinEnt.setEnabled(false);
                }
            } else {
                btnExcluirLinEnt.setEnabled(false);
                model.addRow(new Object[] {""});
            }
        } else  if (tabela == tabGabaritos) {
            if (esteTeste != null) {
                int nroLinhas = esteTeste.getNroLinhasGabaritos();
                model.setColumnIdentifiers(esteTeste.getModeloLinhaGabarito().getColunas());
                for (int i = 0; i <= nroLinhas - 1; i++) {
                    LinhaGabarito linhaGabarito = esteTeste.getLinhaGabarito(i);
                    model.addRow(linhaGabarito.getLinha());
                }
                if (nroLinhas > 1) {
                    btnExcluirLinGab.setEnabled(true);
                } else {
                    btnExcluirLinGab.setEnabled(false);
                }
                btnExcluirColGab.setEnabled(true);
            } else {
                btnExcluirLinGab.setEnabled(false);
                btnExcluirColGab.setEnabled(false);
                btnInserirLinGab.setEnabled(false);
                model.addRow(new Object[] {""});
            }
        }

        tabela.setRowHeight(22);
    }
    
    private void configurarCombo() {
        DefaultComboBoxModel modelColunas = new DefaultComboBoxModel(esteTeste.TIPOS);
        cmbColunas.setModel(modelColunas);
        cmbColunas.setSelectedIndex(0);
    }
    
    public Teste getTeste() {
        return esteTeste;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPaneEnt = new javax.swing.JScrollPane();
        tabEntradas = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnExcluirLinEnt = new javax.swing.JButton();
        btnInserirLinEnt = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        rdPadrao = new javax.swing.JRadioButton();
        rdArquivo = new javax.swing.JRadioButton();
        txtArquivo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPaneGab = new javax.swing.JScrollPane();
        tabGabaritos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmbColunas = new javax.swing.JComboBox();
        btnExcluirColGab = new javax.swing.JButton();
        btnInserirColGab = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnExcluirLinGab = new javax.swing.JButton();
        btnInserirLinGab = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Entrada");

        tabEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPaneEnt.setViewportView(tabEntradas);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Linha"));

        btnExcluirLinEnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remover.png"))); // NOI18N
        btnExcluirLinEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirLinEntActionPerformed(evt);
            }
        });

        btnInserirLinEnt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnInserirLinEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirLinEntActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(btnInserirLinEnt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnExcluirLinEnt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(new java.awt.Component[] {btnExcluirLinEnt, btnInserirLinEnt}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(btnExcluirLinEnt)
                .add(btnInserirLinEnt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2Layout.linkSize(new java.awt.Component[] {btnExcluirLinEnt, btnInserirLinEnt}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Entrada"));

        buttonGroup1.add(rdPadrao);
        rdPadrao.setText("Padr�o");
        rdPadrao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdPadraoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdArquivo);
        rdArquivo.setText("Arquivo");
        rdArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdArquivoActionPerformed(evt);
            }
        });

        txtArquivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtArquivoKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(rdPadrao)
                    .add(rdArquivo)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, txtArquivo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(rdPadrao)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(rdArquivo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtArquivo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(3, 3, 3)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .add(jPanel4Layout.createSequentialGroup()
                        .add(4, 4, 4)
                        .add(jScrollPaneEnt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPaneEnt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gabarito");

        tabGabaritos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPaneGab.setViewportView(tabGabaritos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Coluna"));

        btnExcluirColGab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remover.png"))); // NOI18N
        btnExcluirColGab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirColGabActionPerformed(evt);
            }
        });

        btnInserirColGab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnInserirColGab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirColGabActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, cmbColunas, 0, 100, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(btnInserirColGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnExcluirColGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnExcluirColGab, btnInserirColGab}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(cmbColunas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(13, 13, 13)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnExcluirColGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnInserirColGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnExcluirColGab, btnInserirColGab}, org.jdesktop.layout.GroupLayout.VERTICAL);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Linha"));

        btnExcluirLinGab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remover.png"))); // NOI18N
        btnExcluirLinGab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirLinGabActionPerformed(evt);
            }
        });

        btnInserirLinGab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/adicionar.png"))); // NOI18N
        btnInserirLinGab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirLinGabActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(btnInserirLinGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnExcluirLinGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {btnExcluirLinGab, btnInserirLinGab}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(btnInserirLinGab, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 41, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(btnExcluirLinGab))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {btnExcluirLinGab, btnInserirLinGab}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jPanel7Layout = new org.jdesktop.layout.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7Layout.linkSize(new java.awt.Component[] {jPanel1, jPanel3}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel7Layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel5Layout.createSequentialGroup()
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .add(jScrollPaneGab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel5Layout.createSequentialGroup()
                        .add(2, 2, 2)
                        .add(jPanel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jScrollPaneGab, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(btnCancelar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 389, Short.MAX_VALUE)
                        .add(btnConfirmar))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancelar)
                    .add(btnConfirmar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirLinGabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirLinGabActionPerformed
        DefaultTableModel model = (DefaultTableModel)tabGabaritos.getModel();
        model.addRow(new Object[] {""});
        tabGabaritos.getSelectionModel().setSelectionInterval(0,0);
        btnExcluirLinGab.setEnabled(true);
    }//GEN-LAST:event_btnInserirLinGabActionPerformed

    private void btnExcluirLinGabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirLinGabActionPerformed
        int[] selecionadas = tabGabaritos.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel)tabGabaritos.getModel();
        int tam = selecionadas.length;
        for (int i = tam - 1; i >= 0; i--) {
            if (model.getRowCount() == 1) {
                btnExcluirLinGab.setEnabled(false);
                break;
            }
            int linha = selecionadas[i];
            model.removeRow(linha);
        }
        if (model.getRowCount() == 1) {
            btnExcluirLinEnt.setEnabled(false);
        }
        tabGabaritos.getSelectionModel().setSelectionInterval(0,0);
    }//GEN-LAST:event_btnExcluirLinGabActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            esteTeste = new Teste();
            esteTeste.setNomeArquivoEntrada(nomeArquivoEntrada);
            ArrayList<LinhaEntrada> entradas = new ArrayList<LinhaEntrada>();
            int nroLinhasEnt = tabEntradas.getModel().getRowCount();
            for (int i = 0; i <= nroLinhasEnt - 1; i++) {
                String valor = (String) tabEntradas.getValueAt(i, 0);
                LinhaEntrada entrada = new LinhaEntrada(valor);
                entradas.add(entrada);
            }

            int nroColunas = tabGabaritos.getColumnCount();
            if (nroColunas == 0) {
                throw new ClassNotFoundException();
            }
            String[] colunas = new String[nroColunas];
            for (int i = 0; i <= nroColunas - 1; i++) {
                colunas[i] = tabGabaritos.getModel().getColumnName(i);
            }

            ArrayList<LinhaGabarito> gabaritos = new ArrayList<LinhaGabarito>();
            int nroLinhasGab = tabGabaritos.getModel().getRowCount();
            for (int i = 0; i <= nroLinhasGab - 1; i++) {
                String linha[] = new String[nroColunas];
                for (int j = 0; j <= nroColunas - 1; j++) {
                    String valor = (String) tabGabaritos.getValueAt(i, j);
                    if (valor == null || valor.equals("")) {
                        throw new IOException();
                    }
                    linha[j] = valor;
                }
                LinhaGabarito gabarito = new LinhaGabarito(linha);
                gabaritos.add(gabarito);
            }

            esteTeste.setLinhasEntrada(entradas);
            esteTeste.setLinhasGabarito(gabaritos);
            esteTeste.setModeloLinhaGabarito(new ModeloLinhaGabarito(colunas));
            
            saidaNormal = true;
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Linhas do gabarito n�o podem " +
                    "ficar em branco!", "Erro - Linha em branco!", 
                    JOptionPane.ERROR_MESSAGE);
            esteTeste = null;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Deve existir no m�nimo uma " +
                    "coluna no gabarito!", "Erro - Colunas em branco!", 
                    JOptionPane.ERROR_MESSAGE);
            esteTeste = null;
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnExcluirColGabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirColGabActionPerformed
        int[] selecionadas = tabGabaritos.getSelectedColumns();
        TableColumnModel modeloColuna = tabGabaritos.getColumnModel();
        int tam = selecionadas.length;
        for (int i = tam - 1; i >= 0; i--) {
            TableColumn col = modeloColuna.getColumn(selecionadas[i]);
            modeloColuna.removeColumn(col);
        }
        if (tabGabaritos.getColumnModel().getColumnCount() >= 1) {
            tabGabaritos.getColumnModel().getSelectionModel().setSelectionInterval(0,0);
        } else {
            btnExcluirColGab.setEnabled(false);
        }
    }//GEN-LAST:event_btnExcluirColGabActionPerformed

    private void btnInserirColGabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirColGabActionPerformed
        DefaultTableModel model = (DefaultTableModel)tabGabaritos.getModel();
        model.addColumn(cmbColunas.getSelectedItem());
        tabGabaritos.getSelectionModel().setSelectionInterval(0,0);
        btnInserirLinGab.setEnabled(true);
        btnExcluirColGab.setEnabled(true);
    }//GEN-LAST:event_btnInserirColGabActionPerformed

    private void btnInserirLinEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirLinEntActionPerformed
        DefaultTableModel model = (DefaultTableModel)tabEntradas.getModel();
        model.addRow(new Object[] {""});
        tabEntradas.getSelectionModel().setSelectionInterval(0,0);
        btnExcluirLinEnt.setEnabled(true);
    }//GEN-LAST:event_btnInserirLinEntActionPerformed

    private void btnExcluirLinEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirLinEntActionPerformed
        int[] selecionadas = tabEntradas.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel)tabEntradas.getModel();
        int tam = selecionadas.length;
        for (int i = tam - 1; i >= 0; i--) {
            if (model.getRowCount() == 1) {
                btnExcluirLinEnt.setEnabled(false);
                break;
            }
            int linha = selecionadas[i];
            model.removeRow(linha);
        }
        if (model.getRowCount() == 1) {
            btnExcluirLinEnt.setEnabled(false);
        }
        tabEntradas.getSelectionModel().setSelectionInterval(0,0);
    }//GEN-LAST:event_btnExcluirLinEntActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rdPadraoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdPadraoActionPerformed
        txtArquivo.setText("");
        txtArquivo.setEnabled(false);
        nomeArquivoEntrada = null;
    }//GEN-LAST:event_rdPadraoActionPerformed

    private void rdArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdArquivoActionPerformed
        txtArquivo.setEnabled(true);
        nomeArquivoEntrada = txtArquivo.getText();
    }//GEN-LAST:event_rdArquivoActionPerformed

    private void txtArquivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtArquivoKeyReleased
        nomeArquivoEntrada = txtArquivo.getText();
    }//GEN-LAST:event_txtArquivoKeyReleased

    public boolean getSaidaNormal() {
        return saidaNormal;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluirColGab;
    private javax.swing.JButton btnExcluirLinEnt;
    private javax.swing.JButton btnExcluirLinGab;
    private javax.swing.JButton btnInserirColGab;
    private javax.swing.JButton btnInserirLinEnt;
    private javax.swing.JButton btnInserirLinGab;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbColunas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPaneEnt;
    private javax.swing.JScrollPane jScrollPaneGab;
    private javax.swing.JRadioButton rdArquivo;
    private javax.swing.JRadioButton rdPadrao;
    private javax.swing.JTable tabEntradas;
    private javax.swing.JTable tabGabaritos;
    private javax.swing.JTextField txtArquivo;
    // End of variables declaration//GEN-END:variables

}