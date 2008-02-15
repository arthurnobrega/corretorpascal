package logica;

import dados.Teste;
import dados.PastaCorrecao;
import dados.Questao;
import java.util.ArrayList;

/**
 * Classe que gerencia as modifica��es nas Entradas e Gabaritos. Tamb�m gerencia
 * as altera��es no vetor de Quest�es, pois estas duas classifica��es est�o ligadas,
 * visto que para cada Quest�o podemos ter um conjunto de Entradas e Gabaritos.
 */
public class GerenciaTestes {
    
    private ArrayList<Questao> questoes = null;
    
    public GerenciaTestes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }
    
    public String[] getVetorQuestoes() {
        int numeroQuestoes = questoes.size();
        String[] vetorQuestoes = null;
        if (numeroQuestoes != 0) {
            vetorQuestoes = new String[numeroQuestoes];
            for (int i = 0; i <= numeroQuestoes - 1; i++) {
                String questao = "Quest�o " + (i + 1);
                vetorQuestoes[i] = questao;
            }
        }
        
        return vetorQuestoes;
    }
       
    /** Este m�todo retorna o vetor de Entradas/Gabaritos de uma Quest�o.
     * @param indice O �ndice da Quest�o que se deseja o vetor de Entradas/Gabaritos.
     * @return Um vetor com Strings no n�mero de Entradas/Gabaritos da Quest�o.
     */
    public String[] getVetorTestes(int indiceQuestao) {
        ArrayList<Teste> testes = questoes.get(indiceQuestao).getTestes();
        String[] nomesTestes = new String[testes.size()];
        for (int i = 0; i <= nomesTestes.length - 1; i++) {
            nomesTestes[i] = "Teste " + (i + 1);
        }
        
        return nomesTestes;
    }
            
}