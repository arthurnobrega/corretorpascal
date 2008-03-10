/*
 * LinhaEntrada.java
 *
 * Created on 16 de Fevereiro de 2008, 00:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dados;

import java.io.Serializable;

/**
 *
 * @author UltraXP
 */
public class LinhaEntrada implements Serializable {
    
    private String valor = null;
    
    /** Creates a new instance of LinhaEntrada */
    public LinhaEntrada(String valor) {
        this.valor = valor;
    }
    
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    
}
