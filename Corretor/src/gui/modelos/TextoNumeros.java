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
 * Classe que extende JTextField e deixa o usuário informar apenas números.
 */
public class TextoNumeros extends JTextField {
    
    /**
     * Cria uma nova instância da classe TextoNumeros.
     */
    public TextoNumeros() {
        super();
        EventoTeclado evento = new EventoTeclado(this);
        this.addKeyListener(evento);
    }

    /**
     * Retorna o texto contido no campo.
     */
    public String getText() {
        return super.getText();
    }

    /**
     * Seta o texto que irá existir dentro do campo.
     */
    public void setText(String texto) {
        String numeros = new String();
        for (int i = 0; i <= texto.length() - 1; i++) {
            String letra = "" + texto.charAt(i);
            if ("0123456789".contains(letra)) {
                numeros += letra;
            }
        }
        super.setText(numeros);
    }

    /**
     * Classe que gerencia os eventos no campo.
     */
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
                    numeros += letra;
                }
            }
            jtext.setText(numeros);
        }

        public void keyPressed(KeyEvent e) { }

        public void keyTyped(KeyEvent e) { }

    }

}