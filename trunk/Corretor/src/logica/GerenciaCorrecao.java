package logica;

import java.io.IOException;
import dados.Aluno;
import corretor.Correcao;
import dados.PastaCorrecao;

/**
 * Classe utilizada para gerenciar a corre��o das quest�es. Tem como presuposto
 * que a lista de Entradas/Gabaritos n�o � nula.
 */
public class GerenciaCorrecao {
     
    /**
     * Corrige todos os arquivos chamando m�todos mais internos.
     */
    public void corrigir() {
        PastaCorrecao pastaCorrecao = PastaCorrecao.getInstancia();
        Aluno[] alunos = pastaCorrecao.getAlunos();
        for (Aluno aluno : alunos) {
            // Corrige todos os arquivos fontes de cada aluno.
            Correcao cor = new Correcao(aluno);
            cor.corrigir();
            GerenciaSerializacao gerSer = new GerenciaSerializacao();
            gerSer.serializar();
        }
    }
    
}
