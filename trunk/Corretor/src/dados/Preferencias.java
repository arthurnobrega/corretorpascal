package dados;

import java.io.File;
import java.io.Serializable;

/**
 * Classe que centraliza todas as informa��es do programa, pois todos os outros dados
 * s�o aninhados a esta classe. Implementei um Singleton nesta classe para ter apenas
 * uma inst�ncia.
 */
public class Preferencias implements Serializable {
    
    private File diretorioNavegacao = null;    
    private static Preferencias instancia = null;
    
    /**
     * M�todo que retorna a inst�ncia anteriormente j� criada do objeto singleton.
     */
    public static Preferencias getInstancia() {
        if (instancia == null) {
            instancia = new Preferencias();
        }
        return instancia;
    }
    
    public File getDiretorioNavegacao() {
        return diretorioNavegacao;
    }
    
    public void setDiretorioNavegacao(File dir) {
        this.diretorioNavegacao = dir;
    }
}