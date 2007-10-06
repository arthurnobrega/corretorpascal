/*
 * GerenciaSerializacao.java
 *
 * Created on 28 de Setembro de 2007, 10:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import java.io.IOException;
import src.Arquivos;
import src.PastaCorrecao;

/**
 *
 * @author e0631205
 */
public class GerenciaSerializacao {
    
    File diretorio = null;
    
    /** Creates a new instance of GerenciaSerializacao */
    public GerenciaSerializacao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    public void serializar(PastaCorrecao[] pastasCorrecao) {
        Arquivos.serializarCorrecao(diretorio, pastasCorrecao);
    }
    
    public PastaCorrecao[] desserializar() throws IOException {
        return Arquivos.desserializarCorrecao(diretorio);
    }
    
}
