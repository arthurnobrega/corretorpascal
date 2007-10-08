/*
 * GerenciaPas.java
 *
 * Created on 17 de Setembro de 2007, 20:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class GerenciaPas {
    
    File diretorio = null;
    
    /** Creates a new instance of GerenciaPas */
    public GerenciaPas(File diretorio) {
        this.diretorio = diretorio;
    }
    
    private Aluno[] procurarPas() {
        File[] arquivos = diretorio.listFiles();
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if ((nomeArq.length() > 4) && (nomeArq.substring(tamarq - 4, tamarq).equals(".pas")) 
                    && (arq.isFile())) {
                File arquivoFonte = new File(arq.getParent() + "/" + 
                        nomeArq.substring(0,tamarq - 4) + "/" + arq.getName());
                Aluno arqFonte = new Aluno(arquivoFonte);
                listaAlunos.add(arqFonte);
            }
            
        }

        return listaAlunos.toArray(new Aluno[] {});
    }
    
    public PastaCorrecao[] procurarPastasPas() {
        File[] arquivos = diretorio.listFiles();
        ArrayList<PastaCorrecao> pastasCorrecao = new ArrayList<PastaCorrecao>();
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if (arq.isDirectory()) {
                GerenciaPas gp = new GerenciaPas(arq);
                Aluno[] arquivosPas = gp.procurarPas();
                if (arquivosPas.length > 0) {
                    PastaCorrecao pastaCor = new PastaCorrecao(arq, arquivosPas);
                    pastasCorrecao.add(pastaCor);
                }
            }
        }
        
        return pastasCorrecao.toArray(new PastaCorrecao[] {});
    }
    
}
