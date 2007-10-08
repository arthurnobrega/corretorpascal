/*
 * TestaCorrecao.java
 *
 * Created on 7 de Outubro de 2007, 23:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import src.Correcao;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
    
    PastaCorrecao[] pastasCorrecao = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaCorrecao(File diretorio, PastaCorrecao[] pastasCorrecao) {
        this.pastasCorrecao = pastasCorrecao;
        
        for (PastaCorrecao pastaCorrecao : pastasCorrecao) {
            Correcao cor = new Correcao(pastaCorrecao);
            cor.gerarSaidas();
            GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
            gerSer.serializar(pastasCorrecao);
        }
    }
    
    
}
