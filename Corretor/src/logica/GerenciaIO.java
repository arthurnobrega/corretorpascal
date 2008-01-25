/*
 * TestaAddIO.java
 *
 * Created on 25 de Setembro de 2007, 00:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

import dados.ListaIO;
import dados.PastaCorrecao;

/**
 * Classe que gerencia as modificações nas Entradas e Gabaritos. Também gerencia
 * as alterações no vetor de Questões, pois estas duas classificações estão ligadas,
 * visto que para cada Questão podemos ter um conjunto de Entradas e Gabaritos.
 */
public class GerenciaIO {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Cria uma nova instância de GerenciaIO. 
     * @param pastaCorrecao O objeto que guarda todas as configurações do programa.
     */ 
    public GerenciaIO(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
    }
    
    /** Adiciona uma Entrada/Gabarito em branco na Questão fornecida. 
     * @param indice O índice da Questão onde serão adicionados a Entrada/Gabarito.
     */    
    public void adicionarIO(int indice) {
        pastaCorrecao.getArrayListIO().get(indice).adicionarIO("", "");
    }
    
    /** Este método retorna o vetor de Entradas/Gabaritos de uma Questão.
     * @param indice O índice da Questão que se deseja o vetor de Entradas/Gabaritos.
     * @return Um vetor com Strings no número de Entradas/Gabaritos da Questão.
     */
    public String[] getVetorIO(int indice) {
        ListaIO listaIO = pastaCorrecao.getArrayListIO().get(indice);
        String[] nomesIO = new String[listaIO.getTamLista()];
        for (int i = 0; i <= nomesIO.length - 1; i++) {
            nomesIO[i] = "Teste " + (i + 1);
        }
        
        return nomesIO;
    }
    
    public String[] setVetorQuestoes(int quant) {
        String[] vetorQuestoes = new String[quant];
        pastaCorrecao.getArrayListIO().clear();
        for (int i = 0; i <= quant - 1; i++) {
            String questao = "Questão " + (i+1);
            vetorQuestoes[i] = questao;
            pastaCorrecao.getArrayListIO().add(new ListaIO());
        }
        
        return vetorQuestoes;
    }
    
    public void removerIO(int nroQuestao, int indice) {
        pastaCorrecao.getArrayListIO().get(nroQuestao).removerIO(indice);
    }
            
}