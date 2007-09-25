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
        try {
            int nroElementos = pastaCorrecao.getListaIO().getTamLista();
            int nro = nroElementos + 1;
            
            File entrada = new File(pastaCorrecao.getPasta().getAbsolutePath() +
            "/" + Constantes.NARQ_ENT + nro + ".txt");
            Arquivos.salvarArquivo(entrada, "");
            
            File gabarito = new File(pastaCorrecao.getPasta().getAbsolutePath() +
            "/" + Constantes.NARQ_GAB + nro + ".txt");
            Arquivos.salvarArquivo(gabarito, "");
            
            pastaCorrecao.getListaIO().adicionarIO(entrada, gabarito);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public ListaIO getListaIO() {
        return pastaCorrecao.getListaIO();
    }
    
}
