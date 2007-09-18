/*
 * ThreadBarra.java
 *
 * Created on 18 de Setembro de 2007, 17:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import gui.BarraProgresso;
import gui.Principal;

/**
 *
 * @author UltraXP
 */
public class ThreadBarra extends Thread {
    
    Principal pai = null;
    BarraProgresso barraProgresso = null;
    
    public ThreadBarra(Principal pai) {
        this.pai = pai;
        barraProgresso = new BarraProgresso(pai, true);
        barraProgresso.setVisible(true);
    }
    
    public void run() {
        
    }
    
    public void setarValorBarra(int valor) {
        barraProgresso.getBarraProgresso().setValue(valor);
        if (barraProgresso.getBarraProgresso().getValue() == 100) {
            barraProgresso.dispose();
        }
    }
    
}
