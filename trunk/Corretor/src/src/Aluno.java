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
    private ArrayList<Integer> notaQuestoes;
    
    /** Creates a new instance of ArquivoFonte */
    public Aluno(File diretorio, ArquivoFonte[] fontes) {
        this.diretorio = diretorio;
        this.fontes = fontes;
        notaQuestoes = new ArrayList<Integer>();
    }
    
    public void reiniciarContagem() {
        notaQuestoes = new ArrayList<Integer>();
        for (ArquivoFonte fonte : fontes) {
            fonte.reiniciarContagem();
        }
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
        return notaQuestoes.get(nroQuestao).intValue();
    }
    
    public void addNotaQuestao(int notaQuestao) {
        this.notaQuestoes.add(new Integer(notaQuestao));
    }
    
    public int getNotaFinal() {
        int nroQuestoes = notaQuestoes.size();
        int soma = 0;
        for (Integer inteiro : notaQuestoes) {
            soma += inteiro.intValue();
        }
        return soma/nroQuestoes;
    }
}
