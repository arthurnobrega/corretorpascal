package logica;

/**
 * Classe que é utilizada para armazenar as constantes que serão chamadas no
 * decorrer do programa.
 *
 */
public abstract class Constantes {
    
    public static final String SEPARADOR_MENSAGEM_ERRO = "!- <INF. CORRETOR>";
    
    public static final String E_COMPILACAO = "ERRO DE COMPILA\u00c7\u00c3O";
    
    public static final String NARQ_COR = "Correcao.ser";
    public static final String NARQ_LIS = "Questoes.ser";
    
    public static final String NARQ_QUE = "questao";
    
    public static long tempoMaximoExecucao = 10000;
    
    public static void setTempoMaximoExecucao(long tempo) {
        tempoMaximoExecucao = tempo;
    }
    
    public static long getTempoMaximoExecucao() {
        return tempoMaximoExecucao;
    }
}
