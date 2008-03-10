package dados;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe que centraliza todas as informações do programa, pois todos os outros dados
 * são aninhados a esta classe. Implementei um Singleton nesta classe para ter apenas
 * uma instância.
 */
public class PastaCorrecao implements Serializable {
    
    private ArrayList<Questao> questoes = null;
    private Aluno[] alunos = null;
    private File diretorio = null;
    
    private static boolean modificado = false;
    private static PastaCorrecao instancia = null;
    
    /** 
     * Cria uma instância da classe PastaCorrecao. 
     * @param diretorio O diretório que contém todos os subdiretórios dos alunos.
     * @param alunos O vetor de alunos da pasta de correção.
     */
    private PastaCorrecao(File diretorio, Aluno[] alunos) {
        this.diretorio = diretorio;
        this.alunos = alunos;
        questoes = new ArrayList<Questao>();
    }
    
    /**
     * Método que retorna a instância anteriormente já criada do objeto singleton.
     */
    public static PastaCorrecao getInstancia() {
        return instancia;
    }
    
    /**
     * Método que retorna a instância do objeto singleton criada.
     * @param diretorio O diretório que contém todos os subdiretórios dos alunos.
     * @param alunos O vetor de alunos da pasta de correção.
     */
    public static PastaCorrecao getInstancia(File diretorio, Aluno[] alunos) {
        instancia = new PastaCorrecao(diretorio, alunos);
        modificado = true;
        return instancia;
    }
    
    /**
     * Método que retorna a instância do objeto singleton criada.
     * @param pastaCorrecao Um objeto da mesma classe onde seus dados serão copiados
     * para o objeto de classe singleton.
     */
    public static PastaCorrecao getInstancia(PastaCorrecao pastaCorrecao) {
        if (pastaCorrecao != null) {
            instancia = new PastaCorrecao(pastaCorrecao.getDiretorio(), pastaCorrecao.getAlunos());
            instancia.setQuestoes(pastaCorrecao.getQuestoes());
        } else {
            instancia = null;
        }
        modificado = true;
        return instancia;
    }
    
    /**
     * Retorna o diretório da pasta de correção.
     */
    public File getDiretorio() {
        return diretorio;
    }
    
    /**
     * Retorna a lista de questões.
     */
    public Questao getQuestao(int indice) {
        return questoes.get(indice);
    }
    
    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }
    
    /**
     * Seta a lista de questões.
     * @param questoes A lista de questões que será atribuida.
     */
    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
        setModificado(true);
    }
    
    /**
     * Retorna o vetor de alunos.
     */
    public Aluno[] getAlunos() {
        return alunos;
    }
    
    /**
     * Retorna se o objeto PastaCorrecao foi modificado.
     */
    public static boolean getModificado() {
        return modificado;
    }
    
    /**
     * Altera o estado de modificado para o valor passado.
     * @param mod Um valor true, se o objeto foi modificado e um valor false
     * caso contrario.
     */
    public void setModificado(boolean mod) {
        modificado = mod;
    }
}