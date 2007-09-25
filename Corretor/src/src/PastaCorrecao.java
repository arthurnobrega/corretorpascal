/*
 * PastaCorrecao.java
 *
 * Created on 22 de Setembro de 2007, 16:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class PastaCorrecao {
    
    private ListaIO io = null;
    private ArquivoFonte[] arquivosPas = null;
    private File pasta = null;
    
    /** Creates a new instance of PastaCorrecao */
    public PastaCorrecao(File pasta, ArquivoFonte[] arquivosPas) {
        this.pasta = pasta;
        this.arquivosPas = arquivosPas;
        io = new ListaIO();
    }
    
    public ListaIO getListaIO() {
        return io;
    }
    
    public ArquivoFonte[] getArquivosPas() {
        return arquivosPas;
    }
    
    public File getPasta() {
        return pasta;
    }
    
}