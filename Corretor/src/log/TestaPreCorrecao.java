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
import src.Aluno;
import src.Correcao;
import src.Configuracao;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaPreCorrecao {
    
    File diretorio = null;
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaPreCorrecao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    public PastaCorrecao preCorrigir() throws IOException {
        if (diretorio == null) {
             throw new IOException();
        }
        
        Configuracao config = new Configuracao(diretorio);
        pastaCorrecao = config.escanearPastaCorrecao();
        
        try {
            Aluno[] alunos = pastaCorrecao.getAlunos();
            int i = 0;
            /*
            Thread conc = new Thread(new Runnable() {
                public void run() {
                    barraProgresso.setVisible(true);
                    barraProgresso.getBarraProgresso().setValue((1 / 1) * 100);
                    barraProgresso.getBarraProgresso().paintImmediately(barraProgresso.getBarraProgresso().getBounds());
                    barraProgresso.dispose();
            }});
            conc.start();
             */
            for (Aluno aluno : alunos) {
                i++;
                Correcao cor = new Correcao(pastaCorrecao, aluno);
                cor.criarDiretorios();
                cor.compilarFontes();
            }
            GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
            gerSer.serializar(pastaCorrecao);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return pastaCorrecao;
    }
}
