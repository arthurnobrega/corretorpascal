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
 * Classe que gerencia as modifica��es nas Entradas e Gabaritos. Tamb�m gerencia
 * as altera��es no vetor de Quest�es, pois estas duas classifica��es est�o ligadas,
 * visto que para cada Quest�o podemos ter um conjunto de Entradas e Gabaritos.
 */
public class GerenciaIO {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Cria uma nova inst�ncia de GerenciaIO. 
     * @param pastaCorrecao O objeto que guarda todas as configura��es do programa.
     */ 
    public GerenciaIO(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
    }
    
    /** Adiciona uma Entrada/Gabarito em branco na Quest�o fornecida. 
     * @param indice O �ndice da Quest�o onde ser�o adicionados a Entrada/Gabarito.
     */    
    public void adicionarIO(int indice) {
        pastaCorrecao.getArrayListIO().get(indice).adicionarIO("", "");
    }
    
    /** Este m�todo retorna o vetor de Entradas/Gabaritos de uma Quest�o.
     * @param indice O �ndice da Quest�o que se deseja o vetor de Entradas/Gabaritos.
     * @return Um vetor com Strings no n�mero de Entradas/Gabaritos da Quest�o.
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
            String questao = "Quest�o " + (i+1);
            vetorQuestoes[i] = questao;
            pastaCorrecao.getArrayListIO().add(new ListaIO());
        }
        
        return vetorQuestoes;
    }
    
    public void removerIO(int nroQuestao, int indice) {
        pastaCorrecao.getArrayListIO().get(nroQuestao).removerIO(indice);
    }
            
}