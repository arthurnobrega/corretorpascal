/*
 * TestaCorrecao.java
 *
 * Created on 7 de Outubro de 2007, 23:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

import java.io.IOException;
import dados.Aluno;
import corretor.Correcao;
import dados.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class TestaCorrecao {
     
    public void testar() throws IOException {
        PastaCorrecao pastaCorrecao = PastaCorrecao.getInstancia();
        Aluno[] alunos = pastaCorrecao.getAlunos();
        if (pastaCorrecao.getArrayListIO().isEmpty()) {
            throw new IOException();
        }
        for (Aluno aluno : alunos) {
            Correcao cor = new Correcao(aluno);
            cor.corrigir();
            GerenciaSerializacao gerSer = new GerenciaSerializacao();
            gerSer.serializar();
        }
    }
    
}
