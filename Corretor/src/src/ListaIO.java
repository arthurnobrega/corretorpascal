/*
 * ListaEntradas.java
 *
 * Created on 25 de Setembro de 2007, 00:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class ListaIO implements Serializable {
    
    public ArrayList<String> entradas = null;
    public ArrayList<String> gabaritos = null;
    
    /** Creates a new instance of ListaEntradas */
    public ListaIO() {
        entradas = new ArrayList<String>();
        gabaritos = new ArrayList<String>();
    }
    
    public void adicionarIO(String entrada, String gabarito) {
        entradas.add(entrada);
        gabaritos.add(gabarito);
    }
    
    public void alterarIO(int indice, String entrada, String gabarito) {
        if (indice >= 0) {
            String ent = entradas.get(indice);
            String gab = gabaritos.get(indice);
            entradas.get(indice);
            entradas.set(indice, entrada);
            gabaritos.get(indice);
            gabaritos.set(indice, gabarito);
        }
    }
    
    public void removerIO(int indice) {
        if (indice >= 0) {
            entradas.remove(indice);
            gabaritos.remove(indice);
        }
    }
    
    public String getEntrada(int indice){
        if (indice >= 0) {
            return entradas.get(indice);
        }
            return null;
    }
    
    public String getGabarito(int indice) {
        if (indice >= 0) {
            return gabaritos.get(indice);
        }
        return null;
    }
    
    public int getTamLista() {
        return entradas.size();
    }
    
}
