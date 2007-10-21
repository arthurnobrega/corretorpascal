/*
 * ArquivoFonte.java
 *
 * Created on 20 de Outubro de 2007, 23:28
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
    
    private boolean erroCompilacao = false;
    private File arquivoFonte = null;
    
    /** Creates a new instance of ArquivoFonte */
    public ArquivoFonte(File arquivoFonte) {
        this.arquivoFonte = arquivoFonte;
    }
    
    public File getArquivo() {
        return arquivoFonte;
    }
    
    public void setErroCompilacao(boolean erroCompilacao) {
        this.erroCompilacao = erroCompilacao;
    }
    
    public boolean getErroCompilacao() {
        return erroCompilacao;
    }
    
}