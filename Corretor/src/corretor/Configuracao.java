/*
 * GerenciaPas.java
 *
 * Created on 17 de Setembro de 2007, 20:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package corretor;

import dados.Aluno;
import dados.ArquivoFonte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import dados.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class Configuracao {
    
    File diretorio = null;
    
    /** Creates a new instance of GerenciaPas */
    public Configuracao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    private ArquivoFonte[] procurarPas(File pastaAluno) {
        File[] arquivos = pastaAluno.listFiles();
        ArrayList<File> listaPas = new ArrayList<File>();
        
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if ((nomeArq.length() > 4) && (nomeArq.substring(tamarq - 4, tamarq).equals(".pas"))
            && (arq.isFile())) {
                File arquivoFonte = new File(arq.getParent() + "/" +
                        nomeArq.substring(0,tamarq - 4) + "/" + arq.getName());
                listaPas.add(arquivoFonte);
            }
        }
        
        int tamLista = listaPas.size();
        ArquivoFonte[] arquivosFonte = new ArquivoFonte[tamLista];
        for (int i = 0; i <= tamLista - 1; i++) {
            arquivosFonte[i] = new ArquivoFonte(listaPas.get(i));
        }
        
        return arquivosFonte;
    }
    
    private Aluno[] procurarAlunos() {
        File[] arquivos = diretorio.listFiles();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if (arq.isDirectory()) {
                ArquivoFonte[] arquivosPas = procurarPas(arq);
                if (arquivosPas.length > 0) {
                    Aluno aluno = new Aluno(arq, arquivosPas);
                    alunos.add(aluno);
                }
            }
        }
        
        return alunos.toArray(new Aluno[] {});
    }
    
    public PastaCorrecao escanearPastaCorrecao() throws IOException {
        Aluno[] alunos = procurarAlunos();
        PastaCorrecao pastaCorrecao = null;
        if (alunos.length > 0) {
            pastaCorrecao = PastaCorrecao.getInstancia(diretorio, alunos);
        } else {
            throw new IOException();
        }
        
        return pastaCorrecao;
    }
    
}
