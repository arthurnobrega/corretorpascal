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
import java.util.ArrayList;
import src.Arquivos;
import src.Correcao;
import src.GerenciaPas;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaPreCorrecao {
    
    File diretorio = null;
    PastaCorrecao[] pastasCorrecao = null;
    BarraProgresso barraProgresso = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaPreCorrecao(File diretorio, BarraProgresso barraProgresso) {
        this.diretorio = diretorio;
        this.barraProgresso = barraProgresso;
    }
    
    public PastaCorrecao[] preCorrigir() throws IOException {
        if (diretorio == null) {
             throw new IOException();
        }
        
        GerenciaPas gp = new GerenciaPas(diretorio);
        pastasCorrecao = gp.procurarPastasPas();
        
        if (pastasCorrecao.length == 0) {
            throw new IOException();
        }
        try {
            int nroCorrecoes = pastasCorrecao.length;
            int i = 0;
            Thread conc = new Thread(new Runnable() {
                public void run() {
                    barraProgresso.setVisible(true);
            }});
            conc.start();
            for (PastaCorrecao pastaCorrecao : pastasCorrecao) {
                i++;
                Correcao cor = new Correcao(pastaCorrecao);
                cor.criarDiretorios();
                cor.compilarFontes();
                barraProgresso.getBarraProgresso().setValue((i / nroCorrecoes) * 100);
                barraProgresso.getBarraProgresso().paintImmediately(barraProgresso.getBarraProgresso().getBounds());
            }
            barraProgresso.dispose();
            GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
            gerSer.serializar(pastasCorrecao);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return pastasCorrecao;
    }
}
