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
public class ArquivoFonte implements Serializable {
    
    private File arquivo = null;
    private boolean erroCompilacao = false;
    
    /** Creates a new instance of ArquivoFonte */
    public ArquivoFonte(File arquivo) {
        this.arquivo = arquivo;
    }

    public File getArquivo() {
        return arquivo;
    }
    
    public boolean getErroCompilacao() {
        return erroCompilacao;
    }
    
    public void setErroCompilacao(boolean erro) {
        erroCompilacao = erro;
    }
    
}
