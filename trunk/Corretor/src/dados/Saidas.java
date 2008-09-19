package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que guarda a sa�da e o relat�rio de um determinado arquivo fonte.
 */
public class Saidas implements Serializable {
    
    private String relatorio = null;
    private String saida = null;
    private ArrayList<String> linhasSaida = null;
    
    /**
     * Cria uma nova inst�ncia da classe Saidas.
     */
    public Saidas(String saida, String relatorio) {
        this.saida = saida;
        this.relatorio = relatorio;
        String[] linhas = saida.split("\n");
        linhasSaida = new ArrayList<String>();
        for (String linha : linhas) {
            linhasSaida.add(linha);
        }
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
    
    public ArrayList<String> getLinhasSaida() {
        return linhasSaida;
    }
    
}
