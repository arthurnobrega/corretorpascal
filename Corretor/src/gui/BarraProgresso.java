/*
 * BarraProgresso.java
 *
 * Created on 18 de Setembro de 2007, 00:52
 */

package gui;

import javax.swing.JProgressBar;

/**
 *
 * @author  UltraXP
 */
public class BarraProgresso extends javax.swing.JDialog implements Runnable {
    
    /** Creates new form BarraProgresso */
    public BarraProgresso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        barraProgresso.setString("Carregando...");
        barraProgresso.setIndeterminate(false);
        Janelas.alinharContainer(this);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        barraProgresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Carregando...");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, barraProgresso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(barraProgresso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void run() {
        this.setVisible(true);
        try {
            this.wait();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public JProgressBar getBarraProgresso() {
        return barraProgresso;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgresso;
    // End of variables declaration//GEN-END:variables
    
}