/*
 * TestaCorrecao.java
 *
 * Created on 7 de Outubro de 2007, 23:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import gui.BarraProgresso;
import java.io.File;
import src.Aluno;
import src.Correcao;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaCorrecao(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
        Aluno[] alunos = pastaCorrecao.getAlunos();
        
        //BarraProgresso barraP = new BarraProgresso();
        //barraP.start();
        for (Aluno aluno : alunos) {
            Correcao cor = new Correcao(aluno);
            cor.corrigir(pastaCorrecao.getArrayListIO());
            GerenciaSerializacao gerSer = new GerenciaSerializacao(pastaCorrecao.getDiretorio());
            gerSer.serializar(pastaCorrecao);
        }
        //barraP.notify();
    }
    
    
}
