/*
 * TestaImportacao.java
 *
 * Created on 17 de Setembro de 2007, 20:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import java.io.IOException;
import dados.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaImportacao {
    
    File diretorio = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaImportacao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    public PastaCorrecao importar() throws IOException {
        GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
        return gerSer.desserializar();
    }
    
}
