/*
 * ColunaTeste.java
 *
 * Created on 16 de Fevereiro de 2008, 00:42
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
public class ModeloLinhaGabarito implements Serializable {
    
    private String[] colunas = null;
    
    /** Creates a new instance of ColunaTeste */
    public ModeloLinhaGabarito(String[] colunas) {
        this.colunas = colunas;
    }

    public String getColuna(int indice) {
        return colunas[indice];
    }
    
    public String[] getColunas() {
        return colunas;
    }
    
    public int getNroColunas() {
        return colunas.length;
    }
    
}
