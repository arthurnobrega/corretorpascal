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
    private ArrayList<Integer> notaQuestao;
    
    /** Creates a new instance of ArquivoFonte */
    public Aluno(File diretorio, ArquivoFonte[] fontes) {
        this.diretorio = diretorio;
        this.fontes = fontes;
        notaQuestao = new ArrayList<Integer>();
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
    
    public int getNotaQuestao(int nroQuestao) {
        return notaQuestao.get(nroQuestao).intValue();
    }
    
    public void addNotaQuestao(int notaQuestao) {
        this.notaQuestao.add(new Integer(notaQuestao));
    }
    
    public int getNotaFinal() {
        int nroQuestoes = notaQuestao.size();
        int soma = 0;
        for (Integer inteiro : notaQuestao) {
            soma += inteiro.intValue();
        }
        return soma/nroQuestoes;
    }
}
