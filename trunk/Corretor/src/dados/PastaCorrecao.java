package dados;

import java.io.File;
import java.io.Serializable;

/**
 * Classe que centraliza todas as informa��es do programa, pois todos os outros dados
 * s�o aninhados a esta classe. Implementei um Singleton nesta classe para ter apenas
 * uma inst�ncia.
 */
public class PastaCorrecao implements Serializable {
    
    private Aluno[] alunos = null;
    private File diretorio = null;
    
    private static boolean modificado = false;
    private static PastaCorrecao instancia = null;
    
    /** 
     * Cria uma inst�ncia da classe PastaCorrecao. 
     * @param diretorio O diret�rio que cont�m todos os subdiret�rios dos alunos.
     * @param alunos O vetor de alunos da pasta de corre��o.
     */
    private PastaCorrecao(File diretorio, Aluno[] alunos) {
        this.diretorio = diretorio;
        this.alunos = alunos;
    }
    
    /**
     * M�todo que retorna a inst�ncia anteriormente j� criada do objeto singleton.
     */
    public static PastaCorrecao getInstancia() {
        return instancia;
    }
    
    /**
     * M�todo que retorna a inst�ncia do objeto singleton criada.
     * @param diretorio O diret�rio que cont�m todos os subdiret�rios dos alunos.
     * @param alunos O vetor de alunos da pasta de corre��o.
     */
    public static void setInstancia(File diretorio, Aluno[] alunos) {
        instancia = new PastaCorrecao(diretorio, alunos);
        modificado = true;
    }
    
    public static void setInstancia() {
        instancia = null;
    }
    
    /**
     * M�todo que retorna a inst�ncia do objeto singleton criada.
     * @param pastaCorrecao Um objeto da mesma classe onde seus dados ser�o copiados
     * para o objeto de classe singleton.
     */
    public static void setInstancia(PastaCorrecao pastaCorrecao) {
        if (pastaCorrecao != null) {
            instancia = new PastaCorrecao(pastaCorrecao.getDiretorio(), pastaCorrecao.getAlunos());
        } else {
            instancia = null;
        }
        modificado = true;
    }
    
    /**
     * Retorna o diret�rio da pasta de corre��o.
     */
    public File getDiretorio() {
        return diretorio;
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