/*
 * TestaCorrecao.java
 *
 * Created on 7 de Outubro de 2007, 23:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.IOException;
import src.Aluno;
import src.Correcao;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
    
    PastaCorrecao pastaCorrecao = null;
    Aluno[] alunos = null;
    
    /** Creates a new instance of TestaCorrecao */
    public TestaCorrecao(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
        this.alunos = pastaCorrecao.getAlunos();
        
    }
    
    public void testar() throws IOException {
        if (pastaCorrecao.getArrayListIO().isEmpty()) {
            throw new IOException();
        }
        for (Aluno aluno : alunos) {
            Correcao cor = new Correcao(pastaCorrecao, aluno);
            cor.corrigir(pastaCorrecao.getArrayListIO());
            GerenciaSerializacao gerSer = new GerenciaSerializacao(pastaCorrecao.getDiretorio());
            gerSer.serializar(pastaCorrecao);
        }
    }
    
}
