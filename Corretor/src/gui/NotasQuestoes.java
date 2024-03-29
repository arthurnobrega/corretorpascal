/*
 * NotasQuestoes.java
 *
 * Created on 24 de Dezembro de 2007, 16:00
 */

package gui;

import dados.ListaQuestoes;
import gui.modelos.KeyListenerJanela;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author  UltraXP
 */
public class NotasQuestoes extends javax.swing.JDialog {
    
    int[] notasQuestoes = null;
    
    /** Creates new form NotasQuestoes */
    public NotasQuestoes(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        Janelas.alinharContainer(this);
        iniciarCampos();
        this.addKeyListener(new KeyListenerJanela());
    }
    
    private void iniciarCampos() {
        int soma = 0;
        int nroQuestoes = ListaQuestoes.getArrayListQuestoes().size();
        String[] vetorQuestao = new String[nroQuestoes];
        notasQuestoes = new int[nroQuestoes];
        
        for (int i = 0; i <= nroQuestoes - 1; i++) {
            vetorQuestao[i] = "Quest�o " + (i + 1);
            notasQuestoes[i] = (int) ListaQuestoes.getArrayListQuestoes().get(i).getNotaMax();
        }
        DefaultComboBoxModel modelQuestao = new DefaultComboBoxModel(vetorQuestao);        
        cmbQuestao.setModel(modelQuestao);
        cmbQuestao.setSelectedIndex(0);
        txtMaxQuestao.setText("" + ListaQuestoes.getArrayListQuestoes().get(0).getNotaMax());
        
        for (int i = 0; i <= notasQuestoes.length - 1; i++) {
            soma += notasQuestoes[i];
        }
        
        txtSoma.setText("" + soma);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        cmbQuestao = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSoma = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtMaxQuestao = new gui.modelos.TextoNumeros();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel1.setText("N\u00famero da Quest\u00e3o");

        cmbQuestao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbQuestaoItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nota M\u00e1xima da Quest\u00e3o");

        jLabel3.setText("Soma das Quest\u00f5es");

        txtSoma.setEditable(false);

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

        txtMaxQuestao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaxQuestaoKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel2)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtMaxQuestao, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(cmbQuestao, 0, 93, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(36, 36, 36)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtSoma, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(btnCancelar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 64, Short.MAX_VALUE)
                        .add(btnConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(cmbQuestao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(txtMaxQuestao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(47, 47, 47)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtSoma, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 27, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnConfirmar)
                    .add(btnCancelar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaxQuestaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaxQuestaoKeyReleased
        int soma = 0;
        int selecionado = cmbQuestao.getSelectedIndex();
        try {
            notasQuestoes[selecionado] = Integer.parseInt(txtMaxQuestao.getText());
            for (int i = 0; i <= notasQuestoes.length - 1; i++) {
                soma += notasQuestoes[i];
            }
            txtSoma.setText("" + soma);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtMaxQuestaoKeyReleased

    private void cmbQuestaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbQuestaoItemStateChanged
        int selecionado = cmbQuestao.getSelectedIndex();
        txtMaxQuestao.setText("" + notasQuestoes[selecionado]);
    }//GEN-LAST:event_cmbQuestaoItemStateChanged

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int soma = 0;
        int opcao = 0;
        for (int i = 0; i <= notasQuestoes.length - 1; i++) {
            soma += notasQuestoes[i];
        }
        
        if (soma != 100) {
            opcao = JOptionPane.showConfirmDialog(this, "A soma das quest�es n�o totaliza " +
                "100.\n Voc� quer continuar mesmo assim?", "Confirma��o!", JOptionPane.YES_NO_OPTION);
        }
        if (opcao == 0) {
            for (int i = 0; i <= notasQuestoes.length - 1; i++) {
                ListaQuestoes.getArrayListQuestoes().get(i).setNotaMax(notasQuestoes[i]);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private gui.modelos.TextoNumeros txtMaxQuestao;
    private javax.swing.JTextField txtSoma;
    // Fim da declara��o de vari�veis//GEN-END:variables

    
}
