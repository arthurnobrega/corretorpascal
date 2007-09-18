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
import src.Arquivos;
import src.Correcao;
import src.GerenciaPas;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
    
    File diretorio = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaCorrecao(File diretorio) throws IOException {
        this.diretorio = diretorio;
        
        GerenciaPas gp = new GerenciaPas(diretorio);
        if (gp.procurarPas().size() == 0) {
            throw new IOException();
        }
        
        Correcao cor = new Correcao(diretorio);
        
        try {
            cor.criarDiretorios();
            cor.compilarFontes();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
