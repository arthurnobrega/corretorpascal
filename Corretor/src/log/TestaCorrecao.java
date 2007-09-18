/*
 * TestaCorrecao.java
 *
 * Created on 15 de Setembro de 2007, 23:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import gui.BarraProgresso;
import java.io.File;
import java.io.IOException;
import javax.swing.JProgressBar;
import src.Arquivos;
import src.Correcao;
import src.GerenciaPas;
import src.ThreadBarra;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
    
    File diretorio = null;
    ThreadBarra tb = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaCorrecao(File diretorio, ThreadBarra tb) throws IOException {
        this.diretorio = diretorio;
        this.tb = tb;
        
        GerenciaPas gp = new GerenciaPas(diretorio);
        if (gp.procurarPas().size() == 0) {
            throw new IOException();
        }
        
        Correcao cor = new Correcao(diretorio, tb);
        cor.corrigir();
    }
}
