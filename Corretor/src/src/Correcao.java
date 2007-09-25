/*
 * Correcao.java
 *
 * Created on 15 de Setembro de 2007, 22:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import log.Constantes;

/**
 *
 * @author UltraXP
 */
public class Correcao {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
    }
    
    public void criarDiretorios() throws IOException {        
        ArquivoFonte[] arqFontes = pastaCorrecao.getArquivosPas();
        
        for (ArquivoFonte fonteAluno : arqFontes) {
            File arqFonteAluno = fonteAluno.getArquivo();
            String nomePasta = arqFonteAluno.getName().substring(0, 
                    arqFonteAluno.getName().length() - 4);
            
            File diretorio = pastaCorrecao.getPasta();
            
            if (new File(diretorio.getAbsolutePath() + "/" + nomePasta).mkdir()) {
                String texto = Arquivos.getTextoArquivo(arqFonteAluno);
                Arquivos.salvarArquivo(new File(arqFonteAluno.getParent() + "/" + nomePasta + 
                        "/" + arqFonteAluno.getName()), texto);
            }
        }
    }
    
    public void compilarFontes() throws IOException {
        ArquivoFonte[] arqFontes = pastaCorrecao.getArquivosPas();
        
        for (ArquivoFonte fonteAluno : arqFontes) {
            String nomeArqFonte = fonteAluno.getArquivo().getName();
            String caminhoPasta = pastaCorrecao.getPasta().getAbsolutePath();
            
            File pastaAluno = new File(caminhoPasta + "/" + 
                    nomeArqFonte.substring(0, nomeArqFonte.length() - 4));
            
            Executador ex = new Executador("cd " + pastaAluno.getAbsolutePath() +
                    "&&" + "fpc " + nomeArqFonte);
            criarRelatorioErro(pastaAluno, ex.getValorSaida());
        }
    }
    
    private void criarRelatorioErro(File pastaAluno, int valorSaida) {
        try {
            if (valorSaida != 0) {
                for (ArquivoFonte arqFonte : pastaCorrecao.getArquivosPas()) {
                    String nomePasta = arqFonte.getArquivo().getName().substring(0, 
                    arqFonte.getArquivo().getName().length() - 4);
                    if (nomePasta.equals(pastaAluno.getName())) {
                        arqFonte.setErroCompilacao(true);
                    }
                }
                
                Arquivos.salvarArquivo(new File(pastaAluno.getAbsolutePath() + 
                        "/relatorio.txt"), Constantes.E_COMPILACAO);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
