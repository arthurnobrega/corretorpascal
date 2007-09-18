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
    
    public ArrayList<File> procurarPas() {
        File[] arquivos = diretorio.listFiles();
        ArrayList<File> listaAlunos = new ArrayList<File>();
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if ((nomeArq.length() > 4) && (nomeArq.substring(tamarq - 4, tamarq).equals(".pas")) 
                    && (arq.isFile())) {
                listaAlunos.add(arq);
            }
            
        }

        return listaAlunos;
    }
    
    public ArrayList<File> procurarPastasPas() {
        File[] arquivos = diretorio.listFiles();
        ArrayList<File> pastasAlunos = new ArrayList<File>();
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if (arq.isDirectory()) {
                GerenciaPas gp = new GerenciaPas(arq);
                if (gp.procurarPas().size() > 0 && 
                        gp.procurarPas().get(0).getName().equals(arq.getName() + ".pas")) {
                    pastasAlunos.add(arq);
                }
            }
        }
        
        return pastasAlunos;
    }
    
}
