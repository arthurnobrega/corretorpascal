/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Arthur
 */
public class ListaQuestoes extends ArrayList<Questao> implements Serializable {
    
    private static ListaQuestoes instancia = null;
    
    public static ArrayList<Questao> getArrayListQuestoes() {
        if (instancia == null) {
            instancia = new ListaQuestoes();
        } 
        ArrayList<Questao> listaQuestoes = new ArrayList<Questao>();
        for (int i = 0; i <= instancia.size() - 1; i++) {
            listaQuestoes.add(instancia.get(i));
        }
        return listaQuestoes;
    }
    
    public static ListaQuestoes getInstancia() {
        if (instancia == null) {
            instancia = new ListaQuestoes();
        } 
        return instancia;
    }
    
    public static void setInstancia(ArrayList<Questao> lista) {
        if (lista != null) {
            instancia = new ListaQuestoes();
            int i = 0;
            for (Questao questao : lista) {
                instancia.add(questao);
                i++;
            }
        }
    }
    
    public static void setInstancia(ListaQuestoes lista) {
        if (lista != null) {
            instancia = lista;
        }
    }
    
}
