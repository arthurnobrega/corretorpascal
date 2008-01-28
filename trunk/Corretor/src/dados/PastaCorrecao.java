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
        return instancia;
    }
    
    /**
     * Método que retorna a instância do objeto singleton criada.
     * @param pastaCorrecao Um objeto da mesma classe onde seus dados serão copiados
     * para o objeto de classe singleton.
     */
    public static PastaCorrecao getInstancia(PastaCorrecao pastaCorrecao) {
        instancia = new PastaCorrecao(pastaCorrecao.getDiretorio(), pastaCorrecao.getAlunos());
        instancia.setQuestoes(pastaCorrecao.getQuestoes());
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
    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }
    
    /**
     * Seta a lista de questões.
     * @param questoes A lista de questões que será atribuida.
     */
    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }
    
    /**
     * Retorna o vetor de alunos.
     */
    public Aluno[] getAlunos() {
        return alunos;
    }
}