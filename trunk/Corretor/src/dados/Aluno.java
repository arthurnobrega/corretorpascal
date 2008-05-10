package dados;

import dados.ArquivoFonte;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que guarda todas as informa��es de um determinado aluno, incluindo todos
 * os arquivos fontes, as notas de cada arquivo e o diret�rio do aluno.
 */
public class Aluno implements Serializable {
    private ArquivoFonte[] fontes = null;
    private File diretorio = null;
    private ArrayList<Integer> notaQuestoes;
    
    /** 
     * Cria uma nova inst�ncia da classe ArquivoFonte.
     * @param diretorio O diret�rio do aluno.
     * @param fontes Vetor de arquivos fontes do aluno.
     */
    public Aluno(File diretorio, ArquivoFonte[] fontes) {
        this.diretorio = diretorio;
        this.fontes = fontes;
        notaQuestoes = new ArrayList<Integer>();
    }
    
    /**
     * Retorna o vetor de arquivos fontes do aluno.
     */
    public ArquivoFonte[] getFontes() {
        return fontes;
    }
    
    /**
     * Modifica o vetor de arquivos fontes do aluno.
     * @param fontes O novo vetor de arquivos fontes do aluno.
     */
    public void setFontes(ArquivoFonte[] fontes) {
        this.fontes = fontes;
        PastaCorrecao.getInstancia().setModificado(true);
    }
    
    /**
     * Retorna o File para o diret�rio do aluno.
     */
    public File getDiretorioAluno() {
        return diretorio;
    }
    
    /**
     * Retorna a nota de uma determinada quest�o do aluno.
     */
    public int getNotaQuestao(int nroQuestao) {
        return notaQuestoes.get(nroQuestao).intValue();
    }
    
    /**
     * Adiciona uma nova nota de uma quest�o na lista. A quest�o que a nota
     * se refere � exatamente o �ndice desta nota na lista.
     */
    public void addNotaQuestao(int notaQuestao) {
        this.notaQuestoes.add(new Integer(notaQuestao));
        PastaCorrecao.getInstancia().setModificado(true);
    }
    
    /**
     * Retorna a nota final do aluno, que � a soma da nota de cada
     * quest�o deste aluno.
     */
    public int getNotaFinal() {
        int soma = 0;
        for (Integer inteiro : notaQuestoes) {
            soma += inteiro.intValue();
        }
        return soma;
    }
        
    /**
     * Reinicia a contagem da nota do aluno.
     */
    public void reiniciarContagem() {
        notaQuestoes.clear();
        for (ArquivoFonte fonte : fontes) {
            //reinicia a contagem da nota de cada arquivo fonte do aluno.
            if (fonte != null) {
                fonte.reiniciarContagem();
            }
        }
        PastaCorrecao.getInstancia().setModificado(true);
    }
}
