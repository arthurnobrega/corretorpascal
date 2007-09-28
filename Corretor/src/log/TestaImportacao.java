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
import java.util.ArrayList;
import src.GerenciaPas;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaImportacao {
    
    File diretorio = null;
    PastaCorrecao[] pastasCorrecao = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaImportacao(File diretorio) {
        this.diretorio = diretorio;
        this.pastasCorrecao = pastasCorrecao;
    }
    
    public PastaCorrecao[] importar() {
        GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
        return gerSer.desserializar();
    }
    
}
