/*
 * TestaImportacao.java
 *
 * Created on 17 de Setembro de 2007, 20:15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

import java.io.File;
import java.io.IOException;
import dados.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaImportacao {
    
    public PastaCorrecao importar() throws IOException {
        GerenciaSerializacao gerSer = new GerenciaSerializacao();
        return gerSer.desserializar();
    }
    
}
