/*
 * TestaImportacao.java
 *
 * Created on 17 de Setembro de 2007, 20:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import src.GerenciaPas;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaImportacao {
    
    File diretorio = null;
    PastaCorrecao[] pastasAlunos = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaImportacao(File diretorio) throws IOException {
        this.diretorio = diretorio;
        
        GerenciaPas gp = new GerenciaPas(diretorio);
        pastasAlunos = gp.procurarPastasPas();
        if (pastasAlunos.length == 0) {
            throw new IOException();
        }
    }
    
    public PastaCorrecao[] getListaAlunos() {
        return pastasAlunos;
    }
    
}
