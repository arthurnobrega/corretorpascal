/*
 * Relatorio.java
 *
 * Created on 1 de Dezembro de 2007, 19:52
 */

package gui;

import gui.modelos.KeyListenerJanela;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import dados.Aluno;
import dados.ArquivoFonte;
import dados.ListaQuestoes;
import dados.PastaCorrecao;
import dados.Saidas;
import javax.swing.JOptionPane;

/**
 *
 * @author  UltraXP
 */
public class Relatorio extends javax.swing.JDialog {
    
    private Aluno aluno;
    
    /** Creates new form Relatorio */
    public Relatorio(int alunoSelecionado, String titulo, JFrame pai) {
        super(pai, titulo, true);
        this.aluno = PastaCorrecao.getInstancia().getAlunos()[alunoSelecionado];
        initComponents();
        Janelas.alinharContainer(this);
        iniciarCombos();
        this.addKeyListener(new KeyListenerJanela());
    }
    
    private void iniciarCombos() {
        int nroQuestoes = ListaQuestoes.getArrayListQuestoes().size();
        int nroTestes1 = ListaQuestoes.getArrayListQuestoes().get(0).getTestes().size();
        String[] vetorQuestao = new String[nroQuestoes];
        String[] vetorTestes1 = new String[nroTestes1];
        
        for (int i = 0; i <= nroQuestoes - 1; i++) {
            vetorQuestao[i] = "Quest�o " + (i + 1);
        }
        DefaultComboBoxModel modelQuestao = new DefaultComboBoxModel(vetorQuestao);
        
        for (int i = 0; i <= nroTestes1 - 1; i++) {
            vetorTestes1[i] = "Teste " + (i + 1);
        }
        
        DefaultComboBoxModel modelTeste1 = new DefaultComboBoxModel(vetorTestes1);
        
        cmbQuestao.setModel(modelQuestao);
        cmbTeste.setModel(modelTeste1);
        
        cmbQuestao.setSelectedIndex(0);
        Saidas saidas = aluno.getFontes()[0].getSaidas().get(0);
        cmbTeste.setSelectedIndex(0);
        txtSaida.setText(saidas.getSaida());
        txtRelatorio.setText(saidas.getRelatorio());
        txtTempo.setText(aluno.getFontes()[0].getTempoExecucao(0) + "ms");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnVoltar = new javax.swing.JButton();
        cmbTeste = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cmbQuestao = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSaida = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRelatorio = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTempo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        cmbTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTesteActionPerformed(evt);
            }
        });

        jLabel2.setText("N\u00famero do Teste");

        cmbQuestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbQuestaoActionPerformed(evt);
            }
        });

        jLabel3.setText("N\u00famero da Quest\u00e3o");

        txtSaida.setColumns(20);
        txtSaida.setEditable(false);
        txtSaida.setRows(5);
        jScrollPane1.setViewportView(txtSaida);

        jLabel1.setText("Sa\u00edda do Programa");

        txtRelatorio.setColumns(20);
        txtRelatorio.setEditable(false);
        txtRelatorio.setRows(5);
        jScrollPane2.setViewportView(txtRelatorio);

        jLabel4.setText("Relat\u00f3rio");

        jLabel5.setText("Tempo de Execu\u00e7\u00e3o:");

        txtTempo.setEditable(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnVoltar)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel3)
                                    .add(layout.createSequentialGroup()
                                        .add(10, 10, 10)
                                        .add(jLabel2)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(cmbQuestao, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(cmbTeste, 0, 85, Short.MAX_VALUE)))
                            .add(jLabel1)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel4)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 252, Short.MAX_VALUE))
                            .add(layout.createSequentialGroup()
                                .add(2, 2, 2)
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))))
                    .add(layout.createSequentialGroup()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cmbQuestao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(cmbTeste, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(txtTempo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnVoltar)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTesteActionPerformed
        Saidas saidas = aluno.getFontes()[cmbQuestao.getSelectedIndex()].getSaidas().get(cmbTeste.getSelectedIndex());
        txtSaida.setText(saidas.getSaida());
        txtRelatorio.setText(saidas.getRelatorio());
        txtTempo.setText(aluno.getFontes()[cmbQuestao.getSelectedIndex()].getTempoExecucao(cmbTeste.getSelectedIndex()) + "ms");
    }//GEN-LAST:event_cmbTesteActionPerformed

    private void cmbQuestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbQuestaoActionPerformed
        if (aluno.getFontes().length < cmbQuestao.getSelectedIndex() && 
                aluno.getFontes()[cmbQuestao.getSelectedIndex()].getErroCompilacao()) {
            cmbQuestao.setSelectedIndex(0);
            JOptionPane.showMessageDialog(null, "Esta quest�o n�o foi corrigida pois houve \n" +
                    "um erro de compila��o nesta quest�o deste aluno!", 
                    "Erro de Compila��o!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (cmbQuestao.getSelectedIndex() < aluno.getFontes().length) {
            int nroTestes = ListaQuestoes.getArrayListQuestoes().get(cmbQuestao.getSelectedIndex()).getTestes().size();
            String[] vetorTestes = new String[nroTestes];

            for (int i = 0; i <= nroTestes - 1; i++) {
                vetorTestes[i] = "Teste " + (i + 1);
            }

            DefaultComboBoxModel modelTeste = new DefaultComboBoxModel(vetorTestes);
            cmbTeste.setModel(modelTeste);
            if (!aluno.getFontes()[cmbQuestao.getSelectedIndex()].getSaidas().isEmpty()) {
                Saidas saidas = aluno.getFontes()[cmbQuestao.getSelectedIndex()].getSaidas().get(0);
                cmbTeste.setSelectedIndex(0);
                txtTempo.setText(aluno.getFontes()[cmbQuestao.getSelectedIndex()].getTempoExecucao(0) + "ms");
                txtSaida.setText(saidas.getSaida());
                txtRelatorio.setText(saidas.getRelatorio());
                return;
            }
        }
        cmbQuestao.setSelectedIndex(0);
        JOptionPane.showMessageDialog(null, "O Aluno n�o fez esta quest�o!", 
                "Quest�o inexistente!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cmbQuestaoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
 
   
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cmbQuestao;
    private javax.swing.JComboBox cmbTeste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtRelatorio;
    private javax.swing.JTextArea txtSaida;
    private javax.swing.JTextField txtTempo;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
