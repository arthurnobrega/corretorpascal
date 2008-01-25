/*
 * Saidas.java
 *
 * Created on 19 de Outubro de 2007, 16:12
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
public class Saidas implements Serializable {
    
    private String relatorio = null;
    private String saida = null;
    
    /** Creates a new instance of Saidas */
    public Saidas(String saida, String relatorio) {
        this.saida = saida;
        this.relatorio = relatorio;
    }
    
    public String getRelatorio() {
        return relatorio;
    }
    
    public String getSaida() {
        return saida;
    }
    
}
