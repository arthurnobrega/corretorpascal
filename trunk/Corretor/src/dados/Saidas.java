package dados;

import java.io.Serializable;

/**
 * Classe que guarda a saída e o relatório de um determinado arquivo fonte.
 */
public class Saidas implements Serializable {
    
    private String relatorio = null;
    private String saida = null;
    
    /**
     * Cria uma nova instância da classe Saidas.
     */
    public Saidas(String saida, String relatorio) {
        this.saida = saida;
        this.relatorio = relatorio;
    }
    
    /**
     * Retorna o relatório em forma de String.
     */
    public String getRelatorio() {
        return relatorio;
    }
    
    /**
     * Retorna a saída em forma de string.
     */
    public String getSaida() {
        return saida;
    }
    
}
