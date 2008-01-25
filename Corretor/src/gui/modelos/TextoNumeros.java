/*
 * TextoInteiro.java
 *
 * Created on 24 de Dezembro de 2007, 17:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gui.modelos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author UltraXP
 */
public class TextoNumeros extends JTextField {
        
    public TextoNumeros() {
        super();
        EventoTeclado evento = new EventoTeclado(this);
        this.addKeyListener(evento);
    }

    public TextoNumeros(String texto) {
        super(texto);
        EventoTeclado evento = new EventoTeclado(this);
        this.addKeyListener(evento);
    }

    public String getText() {
        return super.getText();
    }

    public void setText(String texto) {
        String numeros = new String();
        for (int i = 0; i <= texto.length() - 1; i++) {
            String letra = "" + texto.charAt(i);
            if ("0123456789".contains(letra)) {
                if (!((numeros.length() == 0) && (letra.equals("0")))) {
                    numeros += letra;
                }
            }
        }
        super.setText(numeros);
    }

    class EventoTeclado implements KeyListener {

        JTextField jtext = null;

        public EventoTeclado(JTextField jtext) {
            this.jtext = jtext;
        }

        public void keyReleased(KeyEvent e) {
            String texto = getText();
            String numeros = new String();
            for (int i = 0; i <= texto.length() - 1; i++) {
                String letra = "" + texto.charAt(i);
                if ("0123456789".contains(letra)) {
                    if (!((numeros.length() == 0) && (letra.equals("0")))) {
                        numeros += letra;
                    }
                }
            }
            jtext.setText(numeros);
        }

        public void keyPressed(KeyEvent e) {

        }

        public void keyTyped(KeyEvent e) {
            
        }

    }

}