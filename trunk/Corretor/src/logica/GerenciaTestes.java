package logica;

import dados.Teste;
import dados.PastaCorrecao;
import dados.Questao;
import java.util.ArrayList;

/**
 * Classe que gerencia as modificações nas Entradas e Gabaritos. Também gerencia
 * as alterações no vetor de Questões, pois estas duas classificações estão ligadas,
 * visto que para cada Questão podemos ter um conjunto de Entradas e Gabaritos.
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
                String questao = "Questão " + (i + 1);
                vetorQuestoes[i] = questao;
            }
        }
        
        return vetorQuestoes;
    }
       
    /** Este método retorna o vetor de Entradas/Gabaritos de uma Questão.
     * @param indice O índice da Questão que se deseja o vetor de Entradas/Gabaritos.
     * @return Um vetor com Strings no número de Entradas/Gabaritos da Questão.
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