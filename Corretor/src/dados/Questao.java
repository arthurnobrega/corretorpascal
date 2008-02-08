package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe guarda os dados de uma determinada quest�o, incluindo a lista de
 * entradas e gabaritos para esta quest�o e a nota m�xima que um aluno pode obter
 * nela.
 */
public class Questao implements Serializable {
    
    private ArrayList<Teste> testes = null;
    private int notaMax = 0;
    
    /** 
     * Cria uma nova inst�ncia da classe Questao.
     */
    public Questao() {
        testes = new ArrayList<Teste>();
    }
    
    /**
     * Retorna o �ndice da lista de entradas e gabaritos para esta quest�o.
     */
    public Teste getTeste(int indice) {
        return testes.get(indice);
    }
    
    /**
     * Seta a lista de entradas e gabaritos para esta quest�o.
     *
    public void setListaIO(ListaIO io) {
        this.io = io;
        PastaCorrecao.setModificado(true);
    }*/
    
    public void limparListaTestes() {
        testes = new ArrayList<Teste>();
    }
    
    /**
     * Retorna a nota m�xima que esta quest�o pode ter.
     */
    public int getNotaMax() {
        return notaMax;
    }
    
    /**
     * Seta a nota m�xima que esta quest�o pode ter.
     */
    public void setNotaMax(int notaQuestao) {
        this.notaMax = notaQuestao;
        PastaCorrecao.setModificado(true);
    }
    
}
