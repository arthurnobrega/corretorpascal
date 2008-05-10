/*
 * BarraProgresso.java
 *
 * Created on 4 de Dezembro de 2007, 17:01
 */

package gui;

import java.awt.Rectangle;
import javax.swing.JProgressBar;
import logica.GerenciaCorrecao;

/**
 *
 * @author  UltraXP
 */
public class BarraProgresso extends javax.swing.JDialog implements Runnable {
        
    /** Creates new form BarraProgresso */
    public BarraProgresso(Principal principal) {
        super(principal, true);
        initComponents();
        Rectangle rect = new Rectangle();
        rect = barraProgresso.getBounds();
        barraProgresso.setBounds(rect);
        barraProgresso.setMinimum(1);
        barraProgresso.setMaximum(100);
        barraProgresso.setIndeterminate(true);
        barraProgresso.setStringPainted(true);
        barraProgresso.setValue(1);
        //Create the demo's UI.

        barraProgresso = new JProgressBar(0, 100);
        barraProgresso.setValue(0);
        barraProgresso.setStringPainted(true);
        Janelas.alinharContainer(this);
        this.pack();
        this.setVisible(true);
    }
    
    public void run() {
        while (GerenciaCorrecao.getInstancia().getNumeroExecucao() != 100) {
            barraProgresso.setValue(GerenciaCorrecao.getInstancia().getNumeroExecucao());
        }
        this.dispose();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        barraProgresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        barraProgresso.setMaximumSize(new java.awt.Dimension(32767, 20));
        barraProgresso.setMinimumSize(new java.awt.Dimension(10, 20));
        barraProgresso.setPreferredSize(new java.awt.Dimension(100, 20));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(barraProgresso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(barraProgresso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
