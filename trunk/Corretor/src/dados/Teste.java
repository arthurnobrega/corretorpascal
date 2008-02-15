package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que armazena as listas de Entradas e Gabaritos para testar os arquivos
 * fontes.
 */
public class Teste implements Serializable {
    
    private ArrayList<LinhaTeste> entradas = null;
    private ArrayList<LinhaTeste> gabaritos = null;
    
    /** 
     * Cria uma nova instância da classe ListaIO. 
     */
    public Teste() {
        entradas = new ArrayList<LinhaTeste>();
        gabaritos = new ArrayList<LinhaTeste>();
    }
    
    /**
     * Retorna a entrada com o índice informada.
     * @param indice O índice da entrada que se deseja ter acesso.
     */
    public LinhaTeste getEntrada(int indice) {
        if (indice >= 0) {
            return entradas.get(indice);
        }
            return null;
    }
    
    public void setLinhasEntrada(ArrayList<LinhaTeste> entradas) {
        this.entradas = entradas;
    }
    
    public String getEntradaConcatenada() {
        String conc = new String();
        for (int i = 0; i <= entradas.size() - 1; i++) {
            conc += entradas.get(i).getValor() + "\n";
        }
        return conc;
    }
    
    /**
     * Retorna o gabarito com o índice informada.
     * @param indice O índice do gabarito que se deseja ter acesso.
     */
    public LinhaTeste getGabarito(int indice) {
        if (indice >= 0) {
            return gabaritos.get(indice);
        }
        return null;
    }
    
    public void setLinhasGabarito(ArrayList<LinhaTeste> gabaritos) {
        this.gabaritos = gabaritos;
    }
    
    public ArrayList<LinhaTeste> getLinhasGabarito() {
        return gabaritos;
    }
    
    /**
     * Retorna o tamanho da lista de Entradas/Gabaritos.
     */
    public int getTamListaEntradas() {
        return entradas.size();
    }
    
    public int getTamListaGabaritos() {
        return gabaritos.size();
    }
    
    /**
     * Limpa a lista de Entradas/Gabaritos.
     */
    public void limparLinhasTestes() {
        entradas.clear();
        gabaritos.clear();
    }
    
}
