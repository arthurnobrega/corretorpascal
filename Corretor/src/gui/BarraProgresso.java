/*
 * BarraProgresso.java
 *
 * Created on 2 de Dezembro de 2007, 21:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui;

import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

/**
 *
 * @author UltraXP
 */
public class BarraProgresso extends Thread {
    
    JFrame pai = null;
    Thread concorrente = null;
    JDialog dialogo = null;
    JProgressBar barraProgresso = null;
    
    /** Creates a new instance of BarraProgresso */
    public BarraProgresso() {
    }
    
    public void run() {
        dialogo = new JDialog(new JFrame(), "Carregando", true);
        barraProgresso = new JProgressBar();
        barraProgresso.setBounds(0, 0, 100, 20);
        barraProgresso.setMinimum(0);
        barraProgresso.setMaximum(100);
        barraProgresso.setIndeterminate(true);
        barraProgresso.setStringPainted(true);
        barraProgresso.setValue(0);
        Container container = new Container();
        container.add(barraProgresso);
        dialogo.setContentPane(container);
        dialogo.setBounds(0, 0, 100, 20);
        dialogo.pack();
        Janelas.alinharContainer(dialogo);
        dialogo.setVisible(true);
        try {
            wait();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        dialogo.dispose();
    }
    
}
