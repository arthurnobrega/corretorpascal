/*
 * GerenciaSerializacao.java
 *
 * Created on 28 de Setembro de 2007, 10:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

import java.io.File;
import java.io.IOException;
import corretor.Arquivos;
import dados.PastaCorrecao;

/**
 *
 * @author e0631205
 */
public class GerenciaSerializacao {
      
    public void serializar() {
        Arquivos.serializarCorrecao();
    }
    
    public PastaCorrecao desserializar() throws IOException {
        return Arquivos.desserializarCorrecao();
    }
    
}
