/*
 * ArquivoFonte.java
 *
 * Created on 22 de Setembro de 2007, 16:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class Aluno implements Serializable {
    private ArquivoFonte[] fontes = null;
    private File diretorio = null;
    private int notaFinal = 0;
    
    /** Creates a new instance of ArquivoFonte */
    public Aluno(File diretorio, ArquivoFonte[] fontes) {
        this.diretorio = diretorio;
        this.fontes = fontes;
    }

    public void setFontes(ArquivoFonte[] fontes) {
        this.fontes = fontes;
    }
    
    public ArquivoFonte[] getFontes() {
        return fontes;
    }
    
    public File getDiretorio() {
        return diretorio;
    }
    
    public int getNotaFinal() {
        return notaFinal;
    }
    
    public void setNotaFinal(int notaFinal) {
        this.notaFinal = notaFinal;
    }
}
