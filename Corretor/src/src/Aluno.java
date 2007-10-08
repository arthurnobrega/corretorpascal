/*
 * ArquivoFonte.java
 *
 * Created on 22 de Setembro de 2007, 16:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author UltraXP
 */
public class Aluno implements Serializable {
    
    private File saida = null;
    private File fonte = null;
    private boolean erroCompilacao = false;
    
    /** Creates a new instance of ArquivoFonte */
    public Aluno(File fonte) {
        this.fonte = fonte;
    }

    public File getArquivoFonte() {
        return fonte;
    }
    
    public void setErroCompilacao(boolean erro) {
        erroCompilacao = erro;
    }
    
    public boolean getErroCompilacao() {
        return erroCompilacao;
    }
    
    public void setArquivoSaida(File saida) {
        this.saida = saida;
    }
    
    public File getArquivoSaida() {
        return saida;
    }
    
}
