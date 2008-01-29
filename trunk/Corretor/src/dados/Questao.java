package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe guarda os dados de uma determinada quest�o, incluindo a lista de
 * entradas e gabaritos para esta quest�o e a nota m�xima que um aluno pode obter
 * nela.
 */
public class Questao implements Serializable {
    
    private ListaIO io = null;
    private int notaMax = 0;
    
    /** 
     * Cria uma nova inst�ncia da classe Questao.
     */
    public Questao() {
        io = new ListaIO();
    }
    
    /**
     * Retorna a lista de entradas e gabaritos para esta quest�o.
     */
    public ListaIO getListaIO() {
        return io;
    }
    
    /**
     * Seta a lista de entradas e gabaritos para esta quest�o.
     */
    public void setListaIO(ListaIO io) {
        this.io = io;
        PastaCorrecao.setModificado(true);
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
