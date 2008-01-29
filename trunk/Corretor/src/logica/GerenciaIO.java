package logica;

import dados.ListaIO;
import dados.PastaCorrecao;
import dados.Questao;

/**
 * Classe que gerencia as modifica��es nas Entradas e Gabaritos. Tamb�m gerencia
 * as altera��es no vetor de Quest�es, pois estas duas classifica��es est�o ligadas,
 * visto que para cada Quest�o podemos ter um conjunto de Entradas e Gabaritos.
 */
public class GerenciaIO {
    
    /** Adiciona uma Entrada/Gabarito em branco na Quest�o fornecida. 
     * @param indice O �ndice da Quest�o onde ser�o adicionados a Entrada/Gabarito.
     */    
    public void adicionarIO(int indice) {
        PastaCorrecao.getInstancia().getQuestoes().get(indice).getListaIO().adicionarIO("", "");
    }
    
    /**
     * Remove um determinado conjunto de Entrada/Gabarito da lista.
     * @param nroQuestao O n�mero da quest�o que est� a Entrada/Gabarito.
     * @param indice O �ndice do conjunto de Entrada/Gabarito que se deseja remover.
     */
    public void removerIO(int nroQuestao, int indice) {
        PastaCorrecao.getInstancia().getQuestoes().get(nroQuestao).getListaIO().removerIO(indice);
    }
    
    /** Este m�todo retorna o vetor de Entradas/Gabaritos de uma Quest�o.
     * @param indice O �ndice da Quest�o que se deseja o vetor de Entradas/Gabaritos.
     * @return Um vetor com Strings no n�mero de Entradas/Gabaritos da Quest�o.
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