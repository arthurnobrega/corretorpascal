/*
 * GerenciaReversao.java
 *
 * Created on 5 de Outubro de 2007, 23:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package logica;

import java.io.File;
import java.io.IOException;
import dados.Aluno;
import dados.ArquivoFonte;
import corretor.Arquivos;
import dados.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class GerenciaReversao {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of GerenciaReversao */
    public GerenciaReversao() {
        this.pastaCorrecao = PastaCorrecao.getInstancia();
    }
    
    public void reverter() {
        try {
            Aluno[] alunos = pastaCorrecao.getAlunos();
            for (Aluno aluno : alunos) {
                ArquivoFonte[] arquivosFontes = aluno.getFontes();
                for (int i = 0; i <= arquivosFontes.length - 1; i++) {
                    File arquivoAntigo = arquivosFontes[i].getArquivo();
                    if (arquivoAntigo != null) {
                        String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                        Arquivos.salvarArquivo(new File(aluno.getDiretorio() + 
                                "/" + arquivoAntigo.getName()), texto);
                        Arquivos.deletarDiretorio(arquivoAntigo.getParentFile());
                    }
                }
            }
            
            File arqSer = new File(pastaCorrecao.getDiretorio().getAbsolutePath() +
                                "/" + Constantes.NARQ_SER);
            pastaCorrecao = null;
            Arquivos.deletarArquivo(arqSer);
            System.out.println("Revers�o Conclu�da!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
