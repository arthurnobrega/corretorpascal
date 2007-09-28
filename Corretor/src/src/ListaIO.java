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
    
    public ArrayList<File> entradas = null;
    public ArrayList<File> gabaritos = null;
    
    /** Creates a new instance of ListaEntradas */
    public ListaIO() {
        entradas = new ArrayList<File>();
        gabaritos = new ArrayList<File>();
    }
    
    public void adicionarIO(File entrada, File gabarito) {
        entradas.add(entrada);
        gabaritos.add(gabarito);
    }
    
    public File getEntrada(int indice){
        if (indice >= 0) {
            return entradas.get(indice);
        }
            return null;
    }
    
    public void removerEntrada(int indice) {
        if (indice >= 0) {
            entradas.remove(indice);
        }
    }
    
    public File getGabarito(int indice) {
        if (indice >= 0) {
            return gabaritos.get(indice);
        }
        return null;
    }    
    
    public void removerGabarito(int indice) throws IOException {
        if (indice >= 0) {
            gabaritos.remove(indice);
        }
    }
    
    public int getTamLista() {
        return entradas.size();
    }
    
}
