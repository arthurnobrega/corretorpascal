package dados;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que armazena as listas de Entradas e Gabaritos para testar os arquivos
 * fontes.
 */
public class ListaIO implements Serializable {
    
    private ArrayList<String> entradas = null;
    private ArrayList<String> gabaritos = null;
    private int notaQuestao = 0;
    
    /** 
     * Cria uma nova instância da classe ListaIO. 
     */
    public ListaIO() {
        entradas = new ArrayList<String>();
        gabaritos = new ArrayList<String>();
    }
    
    /**
     * Adiciona um conjunto de Entrada/Gabarito.
     * @param entrada A entrada que se deseja adicionar.
     * @param gabarito O gabarito que se deseja adicionar.
     */
    public void adicionarIO(String entrada, String gabarito) {
        entradas.add(entrada);
        gabaritos.add(gabarito);
    }
    
    /**
     * Remove um conjunto de Entrada/Gabarito.
     * @param indice O índice da Entrada/Gabarito na lista.
     */
    public void removerIO(int indice) {
        if (indice >= 0) {
            entradas.remove(indice);
            gabaritos.remove(indice);
        }
    }
    
    /**
     * Altera um conjunto de Entrada/Gabarito.
     * @param indice O índice na lista da Entrada/Gabarito que se deseja alterar.
     */
    public void alterarIO(int indice, String entrada, String gabarito) {
        if (indice >= 0) {
            String ent = entradas.get(indice);
            String gab = gabaritos.get(indice);
            entradas.get(indice);
            entradas.set(indice, entrada);
            gabaritos.get(indice);
            gabaritos.set(indice, gabarito);
        }
    }
    
    /**
     * Retorna a entrada com o índice informada.
     * @param indice O índice da entrada que se deseja ter acesso.
     */
    public String getEntrada(int indice){
        if (indice >= 0) {
            return entradas.get(indice);
        }
            return null;
    }
    
    /**
     * Retorna o gabarito com o índice informada.
     * @param indice O índice do gabarito que se deseja ter acesso.
     */
    public String getGabarito(int indice) {
        if (indice >= 0) {
            return gabaritos.get(indice);
        }
        return null;
    }
    
    /**
     * Retorna o tamanho da lista de Entradas/Gabaritos.
     */
    public int getTamLista() {
        return entradas.size();
    }
    
    /**
     * Limpa a lista de Entradas/Gabaritos.
     */
    public void limparLista() {
        entradas.clear();
        gabaritos.clear();
    }
}
