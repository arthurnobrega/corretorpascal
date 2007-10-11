/*
 * TestaAddIO.java
 *
 * Created on 25 de Setembro de 2007, 00:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import java.io.IOException;
import src.Arquivos;
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
    
    public void adicionar() {
        pastaCorrecao.getListaIO().adicionarIO("", "");
    }
    
    public String[] getVetorIO() {
        ListaIO listaIO = pastaCorrecao.getListaIO();
        String[] nomesIO = new String[listaIO.getTamLista()];
        for (int i = 0; i <= nomesIO.length - 1; i++) {
            nomesIO[i] = "N�vel " + (i + 1);
        }
        
        return nomesIO;
    }
    
    public void removerIO(int indice) {
        pastaCorrecao.getListaIO().removerIO(indice);
    }
            
}