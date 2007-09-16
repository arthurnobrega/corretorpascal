/*
 * TestaCorrecao.java
 *
 * Created on 15 de Setembro de 2007, 23:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import java.io.IOException;
import src.Correcao;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
    
    File diretorio = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaCorrecao(File diretorio) throws IOException {
        this.diretorio = diretorio;
        testarPas();
        Correcao cor = new Correcao(diretorio);
        try {
            cor.criarDiretorios();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void testarPas() throws IOException {
        String[] arquivos = diretorio.list();
        boolean achou = false;
        for (String arq : arquivos) {
            int tamarq = arq.length();
            if (arq.substring(tamarq - 4, tamarq).equals(".pas")) {
                achou = true;
                break;
            }
        }
        
        if (!achou) {
            throw new IOException();
        }
    }
    
}
