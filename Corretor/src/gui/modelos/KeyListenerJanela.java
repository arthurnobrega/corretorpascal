/*
 * ListenerJanela.java
 *
 * Created on 8 de Fevereiro de 2008, 18:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.modelos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author UltraXP
 */
public class KeyListenerJanela extends KeyAdapter {
    
    public void keyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (evt.getSource() instanceof JFrame) {
                JFrame janela = (JFrame) evt.getSource();
                janela.dispose();
            } else if (evt.getSource() instanceof JDialog) {
                JDialog janela = (JDialog) evt.getSource();
                janela.dispose();
            }
        }
    }
    
}
