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

/**
 *
 * @author UltraXP
 */
public class Correcao {
    
    File diretorio = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    public void criarDiretorios() throws IOException {
        String[] arquivos = diretorio.list();
        
        for (String arq : arquivos) {
            int tamarq = arq.length();
            String aluno = new String();
            
            if (arq.substring(tamarq - 4, tamarq).equals(".pas")) {
                aluno = arq.substring(0, tamarq - 4);
                
                if (new File(diretorio.getAbsolutePath() + "/" + aluno).mkdir()) {
                    String texto = Arquivos.getTextoArquivo(diretorio.getAbsolutePath() + "/" + arq);
                    Arquivos.salvarArquivo(diretorio.getAbsolutePath() + "/" + aluno + "/" + arq, texto);
                }
            }
        }
    }
    
    public void compilarFontes() throws IOException {
        String[] arquivos = diretorio.list();
        
        for (String arq : arquivos) {
            int tamarq = arq.length();
            String aluno = new String();
            
            if (arq.substring(tamarq - 4, tamarq).equals(".pas")) {
                aluno = arq.substring(0, tamarq - 4);
                
                Runtime.getRuntime().exec("fpc " + arq);
                
                if (new File(diretorio.getAbsolutePath() + "/" + aluno).mkdir()) {
                    String texto = Arquivos.getTextoArquivo(diretorio.getAbsolutePath() + "/" + arq);
                    Arquivos.salvarArquivo(diretorio.getAbsolutePath() + "/" + aluno + "/" + arq, texto);
                }
            }
        }
    }
    
    public void testarProgramas() {
        
    }
    
}
