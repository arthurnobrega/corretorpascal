package logica;

import dados.ListaIO;
import dados.PastaCorrecao;
import dados.Questao;

/**
 * Classe que gerencia as modificações nas Entradas e Gabaritos. Também gerencia
 * as alterações no vetor de Questões, pois estas duas classificações estão ligadas,
 * visto que para cada Questão podemos ter um conjunto de Entradas e Gabaritos.
 */
public class GerenciaIO {
    
    /** Adiciona uma Entrada/Gabarito em branco na Questão fornecida. 
     * @param indice O índice da Questão onde serão adicionados a Entrada/Gabarito.
     */    
    public void adicionarIO(int indice) {
        PastaCorrecao.getInstancia().getQuestoes().get(indice).getListaIO().adicionarIO("", "");
    }
    
    /**
     * Remove um determinado conjunto de Entrada/Gabarito da lista.
     * @param nroQuestao O número da questão que está a Entrada/Gabarito.
     * @param indice O índice do conjunto de Entrada/Gabarito que se deseja remover.
     */
    public void removerIO(int nroQuestao, int indice) {
        PastaCorrecao.getInstancia().getQuestoes().get(nroQuestao).getListaIO().removerIO(indice);
    }
    
    /** Este método retorna o vetor de Entradas/Gabaritos de uma Questão.
     * @param indice O índice da Questão que se deseja o vetor de Entradas/Gabaritos.
     * @return Um vetor com Strings no número de Entradas/Gabaritos da Questão.
     */
    public String[] getVetorIO(int indice) {
        ListaIO listaIO = PastaCorrecao.getInstancia().getQuestoes().get(indice).getListaIO();
        String[] nomesIO = new String[listaIO.getTamLista()];
        for (int i = 0; i <= nomesIO.length - 1; i++) {
            nomesIO[i] = "Teste " + (i + 1);
        }
        
        return nomesIO;
    }
            
}