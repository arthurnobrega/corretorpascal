package dados;

import java.io.File;
import java.io.Serializable;

/**
 * Classe que centraliza todas as informações do programa, pois todos os outros dados
 * são aninhados a esta classe. Implementei um Singleton nesta classe para ter apenas
 * uma instância.
 */
public class Preferencias implements Serializable {
    
    private File diretorioNavegacao = null;    
    private static Preferencias instancia = null;
    
    /**
     * Método que retorna a instância anteriormente já criada do objeto singleton.
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