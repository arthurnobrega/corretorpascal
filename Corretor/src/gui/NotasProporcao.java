/*
 * NotasQuestoes.java
 *
 * Created on 24 de Dezembro de 2007, 16:00
 */

package gui;

import gui.modelos.KeyListenerJanela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import dados.Teste;
import dados.PastaCorrecao;
import logica.GerenciaTestes;

/**
 *
 * @author  UltraXP
 */
public class NotasProporcao extends javax.swing.JDialog {
    
    PastaCorrecao pastaCorrecao = PastaCorrecao.getInstancia();
    int[] notasQuestoes = null;
    int[][] notasTestes = null;
    
    /** Creates new form NotasProporcao */
    public NotasProporcao(java.awt.Frame parent) {
        super(parent, true);
        setTitle("Propor��o das Notas");
        initComponents();
        Janelas.alinharContainer(this);
        iniciarCampos();
        this.addKeyListener(new KeyListenerJanela());
    }
    
    private void iniciarCampos() {
        int somaQuestoes = 0, somaTestes = 0;
        int nroQuestoes = pastaCorrecao.getQuestoes().size();
        String[] vetorQuestao = new String[nroQuestoes];
        String[] vetorTeste = null;
        int maxTestes = 0;
        
        notasQuestoes = new int[nroQuestoes];
        
        for (int i = 0; i <= nroQuestoes - 1; i++) {
            int tam = pastaCorrecao.getQuestao(i).getTestes().size();
            if (tam > maxTestes) {
                maxTestes = tam;
            }
        }
        
        notasTestes = new int[nroQuestoes][maxTestes];
        
        for (int i = 0; i <= nroQuestoes - 1; i++) {
            vetorQuestao[i] = "Quest�o " + (i + 1);
            notasQuestoes[i] = pastaCorrecao.getQuestao(i).getNotaMax();
            int nroTestes = pastaCorrecao.getQuestao(i).getTestes().size();
            vetorTeste = new String[nroTestes];
            for (int j = 0; j <= nroTestes - 1; j++) {
                vetorTeste[j] = "Teste " + (j + 1);
                notasTestes[i][j] = pastaCorrecao.getQuestao(i).getTeste(j).getNotaMax();
            }
        }
        DefaultComboBoxModel modelQuestao = new DefaultComboBoxModel(vetorQuestao);        
        cmbQuestao.setModel(modelQuestao);
        cmbQuestao.setSelectedIndex(0);
        txtMaxQuestao.setText("" + pastaCorrecao.getQuestao(0).getNotaMax());        
        for (int i = 0; i <= notasQuestoes.length - 1; i++) {
            somaQuestoes += notasQuestoes[i];
        }        
        txtSomaQuestoes.setText("" + somaQuestoes);
        
        GerenciaTestes ger = new GerenciaTestes(pastaCorrecao.getQuestoes());
        DefaultComboBoxModel modelTeste = new DefaultComboBoxModel(ger.getVetorTestes(0));
        cmbTeste.setModel(modelTeste);
        cmbTeste.setSelectedIndex(0);
        txtMaxTeste.setText("" + pastaCorrecao.getQuestao(0).getTeste(0).getNotaMax());
        for (int i = 0; i <= notasTestes[0].length - 1; i++) {
            somaTestes += notasTestes[0][i];
        }
        txtSomaTestes.setText("" + somaTestes);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaxQuestao = new gui.modelos.TextoNumeros();
        cmbQuestao = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtSomaQuestoes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbTeste = new javax.swing.JComboBox();
        txtMaxTeste = new gui.modelos.TextoNumeros();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSomaTestes = new javax.swing.JTextField();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Quest\u00f5es", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        jLabel2.setText("Nota M\u00e1xima da Quest\u00e3o");

        jLabel1.setText("N\u00famero da Quest\u00e3o");

        txtMaxQuestao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaxQuestaoKeyReleased(evt);
            }
        });

        cmbQuestao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbQuestaoItemStateChanged(evt);
            }
        });

        jLabel3.setText("Soma das Quest\u00f5es");

        txtSomaQuestoes.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtMaxQuestao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(cmbQuestao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(5, 5, 5))))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(36, 36, 36)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtSomaQuestoes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(cmbQuestao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtMaxQuestao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 53, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtSomaQuestoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(45, 45, 45))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Testes da Quest\u00e3o Selecionada"));
        jLabel4.setText("N\u00famero do Teste");

        cmbTeste.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTesteItemStateChanged(evt);
            }
        });

        txtMaxTeste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaxTesteKeyReleased(evt);
            }
        });

        jLabel5.setText("Nota M\u00e1xima do Teste");

        jLabel6.setText("Soma dos Testes");

        txtSomaTestes.setEditable(false);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtMaxTeste, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtSomaTestes, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cmbTeste, 0, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cmbTeste, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtMaxTeste, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .add(52, 52, 52)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtSomaTestes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .add(46, 46, 46))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(btnCancelar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 352, Short.MAX_VALUE)
                        .add(btnConfirmar))
                    .add(layout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancelar)
                    .add(btnConfirmar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaxTesteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxTesteKeyReleased
        int soma = 0;
        int questaoSelecionada = cmbQuestao.getSelectedIndex();
        int testeSelecionado = cmbTeste.getSelectedIndex();
        int nroTestes = pastaCorrecao.getQuestao(questaoSelecionada).getTestes().size();
        try {
            notasTestes[questaoSelecionada][testeSelecionado] = Integer.parseInt(txtMaxTeste.getText());
            for (int i = 0; i <= nroTestes - 1; i++) {
                soma += notasTestes[questaoSelecionada][i];
            }
            txtSomaTestes.setText("" + soma);
        } catch (NumberFormatException ex) {
            // ignorando exce��o
        }
    }//GEN-LAST:event_txtMaxTesteKeyReleased

    private void cmbTesteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTesteItemStateChanged
        int questaoSelecionada = cmbQuestao.getSelectedIndex();
        int testeSelecionado = cmbTeste.getSelectedIndex();
        txtMaxTeste.setText("" + notasTestes[questaoSelecionada][testeSelecionado]);
    }//GEN-LAST:event_cmbTesteItemStateChanged

    private void txtMaxQuestaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxQuestaoKeyReleased
        int soma = 0;
        int selecionado = cmbQuestao.getSelectedIndex();
        try {
            notasQuestoes[selecionado] = Integer.parseInt(txtMaxQuestao.getText());
            for (int i = 0; i <= notasQuestoes.length - 1; i++) {
                soma += notasQuestoes[i];
            }
            txtSomaQuestoes.setText("" + soma);
        } catch (NumberFormatException ex) {
            // ignorando exce��o
        }
    }//GEN-LAST:event_txtMaxQuestaoKeyReleased

    private void cmbQuestaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbQuestaoItemStateChanged
        int selecionado = cmbQuestao.getSelectedIndex();
        int somaTestes = 0;
        txtMaxQuestao.setText("" + notasQuestoes[selecionado]);
        GerenciaTestes ger = new GerenciaTestes(pastaCorrecao.getQuestoes());
        DefaultComboBoxModel modelTeste = new DefaultComboBoxModel(ger.getVetorTestes(selecionado));
        cmbTeste.setModel(modelTeste);
        cmbTeste.setSelectedIndex(0);
        txtMaxTeste.setText("" + notasTestes[selecionado][0]);
        for (int i = 0; i <= notasTestes[selecionado].length - 1; i++) {
            somaTestes += notasTestes[selecionado][i];
        }
        txtSomaTestes.setText("" + somaTestes);
    }//GEN-LAST:event_cmbQuestaoItemStateChanged

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int somaQuestoes = 0;
        int opcao = 0;
        for (int i = 0; i <= notasQuestoes.length - 1; i++) {
            somaQuestoes += notasQuestoes[i];
        }
        
        if (somaQuestoes != 100) {
            opcao = JOptionPane.showConfirmDialog(this, "A soma das quest�es n�o totaliza " +
                "100.\n Voc� quer continuar mesmo assim?", "Confirma��o!", JOptionPane.YES_NO_OPTION);
        }
        if (opcao == 0) {
            
            for (int i = 0; i <= notasQuestoes.length - 1; i++) {
                int nroTestes = pastaCorrecao.getQuestao(i).getTestes().size();
                int soma = 0;
                for (int j = 0; j <= nroTestes - 1; j++) {
                    soma += notasTestes[i][j];
                }
                if (soma != 100) {
                    JOptionPane.showMessageDialog(this, "A soma dos testes da quest�o " + (i + 1) + " n�o totaliza " +
                "100.\n � necess�rio alterar.", "Erro!", JOptionPane.YES_NO_OPTION);
                    return;
                }
            }
            
            for (int i = 0; i <= notasQuestoes.length - 1; i++) {
                pastaCorrecao.getQuestao(i).setNotaMax(notasQuestoes[i]);
                int nroTestes = pastaCorrecao.getQuestao(i).getTestes().size();
                for (int j = 0; j <= nroTestes - 1; j++) {
                    pastaCorrecao.getQuestao(i).getTeste(j).setNotaMax(notasTestes[i][j]);
                }
            }
            JOptionPane.showMessageDialog(null, "Notas salvas com sucesso!", 
                    "Notas Salvas!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
       
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox cmbQuestao;
    private javax.swing.JComboBox cmbTeste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private gui.modelos.TextoNumeros txtMaxQuestao;
    private gui.modelos.TextoNumeros txtMaxTeste;
    private javax.swing.JTextField txtSomaQuestoes;
    private javax.swing.JTextField txtSomaTestes;
    // Fim da declara��o de vari�veis//GEN-END:variables

    
}
