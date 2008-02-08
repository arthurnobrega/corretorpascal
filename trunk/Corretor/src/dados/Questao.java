package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta classe guarda os dados de uma determinada questão, incluindo a lista de
 * entradas e gabaritos para esta questão e a nota máxima que um aluno pode obter
 * nela.
 */
public class Questao implements Serializable {
    
    private ArrayList<Teste> testes = null;
    private int notaMax = 0;
    
    /** 
     * Cria uma nova instância da classe Questao.
     */
    public Questao() {
        testes = new ArrayList<Teste>();
    }
    
    /**
     * Retorna o índice da lista de entradas e gabaritos para esta questão.
     */
    public Teste getTeste(int indice) {
        return testes.get(indice);
    }
    
    /**
     * Seta a lista de entradas e gabaritos para esta questão.
     *
    public void setListaIO(ListaIO io) {
        this.io = io;
        PastaCorrecao.setModificado(true);
    }*/
    
    public void limparListaTestes() {
        testes = new ArrayList<Teste>();
    }
    
    /**
     * Retorna a nota máxima que esta questão pode ter.
     */
    public int getNotaMax() {
        return notaMax;
    }
    
    /**
     * Seta a nota máxima que esta questão pode ter.
     */
    public void setNotaMax(int notaQuestao) {
        this.notaMax = notaQuestao;
        PastaCorrecao.setModificado(true);
    }
    
}
