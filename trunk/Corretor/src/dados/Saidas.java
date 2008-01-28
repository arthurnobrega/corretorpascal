package dados;

import java.io.Serializable;

/**
 * Classe que guarda a sa�da e o relat�rio de um determinado arquivo fonte.
 */
public class Saidas implements Serializable {
    
    private String relatorio = null;
    private String saida = null;
    
    /**
     * Cria uma nova inst�ncia da classe Saidas.
     */
    public Saidas(String saida, String relatorio) {
        this.saida = saida;
        this.relatorio = relatorio;
    }
    
    /**
     * Retorna o relat�rio em forma de String.
     */
    public String getRelatorio() {
        return relatorio;
    }
    
    /**
     * Retorna a sa�da em forma de string.
     */
    public String getSaida() {
        return saida;
    }
    
}
