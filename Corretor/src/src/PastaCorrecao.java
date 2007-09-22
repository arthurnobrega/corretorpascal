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
    
    private ArrayList<ArquivoFonte> arquivosPas = null;
    private File pasta = null;
    
    /** Creates a new instance of PastaCorrecao */
    public PastaCorrecao(File pasta, ArrayList<ArquivoFonte> arquivosPas) {
        this.pasta = pasta;
        this.arquivosPas = arquivosPas;
    }
    
    public ArrayList<ArquivoFonte> getArquivosPas() {
        return arquivosPas;
    }
    
    public File getPasta() {
        return pasta;
    }
    
}