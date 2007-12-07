/*
 * TestaAddIO.java
 *
 * Created on 25 de Setembro de 2007, 00:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import src.ListaIO;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class GerenciaIO {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of TestaAddIO */
    public GerenciaIO(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
    }
    
    public void adicionarIO(int indice) {
        pastaCorrecao.getArrayListIO().get(indice).adicionarIO("", "");
    }
    
    public String[] getVetorIO(int indice) {
        ListaIO listaIO = pastaCorrecao.getArrayListIO().get(indice);
        String[] nomesIO = new String[listaIO.getTamLista()];
        for (int i = 0; i <= nomesIO.length - 1; i++) {
            nomesIO[i] = "Teste " + (i + 1);
        }
        
        return nomesIO;
    }
    
    public String[] setVetorQuestoes(int quant) {
        String[] vetorQuestoes = new String[quant];
        pastaCorrecao.getArrayListIO().clear();
        for (int i = 0; i <= quant - 1; i++) {
            String questao = "Quest�o " + (i+1);
            vetorQuestoes[i] = questao;
            pastaCorrecao.getArrayListIO().add(new ListaIO());
        }
        
        return vetorQuestoes;
    }
    
    public void removerIO(int nroQuestao, int indice) {
        pastaCorrecao.getArrayListIO().get(nroQuestao).removerIO(indice);
    }
            
}