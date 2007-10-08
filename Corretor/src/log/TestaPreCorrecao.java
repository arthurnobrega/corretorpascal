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
    
    /** Creates a new instance of TestaCorrecao */
    public TestaPreCorrecao(File diretorio) throws IOException {
        this.diretorio = diretorio;
        GerenciaPas gp = new GerenciaPas(diretorio);
        pastasCorrecao = gp.procurarPastasPas();
        
        if (pastasCorrecao.length == 0) {
            throw new IOException();
        }
        try {
            for (PastaCorrecao pastaCorrecao : pastasCorrecao) {
                Correcao cor = new Correcao(pastaCorrecao);
                cor.criarDiretorios();
                cor.compilarFontes();
                GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
                gerSer.serializar(pastasCorrecao);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public PastaCorrecao[] getPastasCorrecao() {
        return pastasCorrecao;
    }
}
