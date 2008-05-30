package dados;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que armazena as listas de Entradas e Gabaritos para testar os arquivos
 * fontes.
 */
public class Teste implements Serializable {
    
    public static final String TIPOS[] = {"String", "Inteiro", "Real"};
    
    private ArrayList<LinhaEntrada> entradas = null;
    private ArrayList<LinhaGabarito> gabaritos = null;
    private ModeloLinhaGabarito modeloLinhaGabarito = null;
    private double porcentagemNota = 0;
    
    /** 
     * Cria uma nova inst�ncia da classe ListaIO. 
     */
    public Teste() {
        entradas = new ArrayList<LinhaEntrada>();
        gabaritos = new ArrayList<LinhaGabarito>();
    }
    
    public ModeloLinhaGabarito getModeloLinhaGabarito() {
        return modeloLinhaGabarito;
    }
    
    public void setModeloLinhaGabarito(ModeloLinhaGabarito modeloLinhaGabarito) {
        this.modeloLinhaGabarito = modeloLinhaGabarito;
    }
    
    /**
     * Retorna a entrada com o �ndice informada.
     * @param indice O �ndice da entrada que se deseja ter acesso.
     */
    public LinhaEntrada getEntrada(int indice) {
        if (indice >= 0) {
            return entradas.get(indice);
        }
            return null;
    }
    
    public void setLinhasEntrada(ArrayList<LinhaEntrada> entradas) {
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
     * Retorna o gabarito com o �ndice informada.
     * @param indice O �ndice do gabarito que se deseja ter acesso.
     */
    public LinhaGabarito getLinhaGabarito(int indice) {
        if (indice >= 0) {
            return gabaritos.get(indice);
        }
        return null;
    }
    
    public void setLinhasGabarito(ArrayList<LinhaGabarito> gabaritos) {
        this.gabaritos = gabaritos;
    }
    
    public ArrayList<LinhaGabarito> getLinhasGabarito() {
        return gabaritos;
    }
    
    /**
     * Retorna o tamanho da lista de Entradas/Gabaritos.
     */
    public int getNroLinhasEntradas() {
        return entradas.size();
    }
    
    public int getNroLinhasGabaritos() {
        return gabaritos.size();
    }
    
    /**
     * Limpa a lista de Entradas/Gabaritos.
     */
    public void limparLinhasTestes() {
        entradas.clear();
        gabaritos.clear();
    }
    
    /**
     * Retorna a nota m�xima que este teste pode ter.
     */
    public double getPorcentagemNotaMax() {
        return porcentagemNota;
    }
    
    /**
     * Seta a nota m�xima que esta teste pode ter.
     */
    public void setPorcentagemNotaMax(double porcentagemNota) {
        this.porcentagemNota = porcentagemNota;
    }
    
}
