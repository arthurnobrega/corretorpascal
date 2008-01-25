/*
 * TestaCorrecao.java
 *
 * Created on 15 de Setembro de 2007, 23:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

import java.io.File;
import java.io.IOException;
import dados.Aluno;
import corretor.Correcao;
import corretor.Configuracao;
import dados.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaPreCorrecao {
    
    public PastaCorrecao preCorrigir(File diretorio) throws IOException {
        PastaCorrecao pastaCorrecao = null;
        if (diretorio == null) {
             throw new IOException();
        }
        
        Configuracao config = new Configuracao(diretorio);
        pastaCorrecao = config.escanearPastaCorrecao(diretorio);
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
                Correcao cor = new Correcao(aluno);
                cor.criarDiretorios();
                cor.compilarFontes();
            }
            PastaCorrecao.getInstancia(pastaCorrecao);
            GerenciaSerializacao gerSer = new GerenciaSerializacao();
            gerSer.serializar();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return pastaCorrecao;
    }
}
