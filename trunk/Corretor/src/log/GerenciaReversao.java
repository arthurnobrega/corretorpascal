/*
 * GerenciaReversao.java
 *
 * Created on 5 de Outubro de 2007, 23:04
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package log;

import java.io.File;
import java.io.IOException;
import src.Aluno;
import src.ArquivoFonte;
import src.Arquivos;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class GerenciaReversao {
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of GerenciaReversao */
    public GerenciaReversao(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
    }
    
    public void reverter() {
        try {
            Aluno[] alunos = pastaCorrecao.getAlunos();
            for (Aluno aluno : alunos) {
                ArquivoFonte[] arquivosFontes = aluno.getFontes();
                for (int i = 0; i <= arquivosFontes.length - 1; i++) {
                    File arquivoAntigo = arquivosFontes[i].getArquivo();
                    String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                    Arquivos.salvarArquivo(new File(aluno.getDiretorio() + 
                            "/" + arquivoAntigo.getName()), texto);
                    Arquivos.deletarDiretorio(arquivoAntigo.getParentFile());
                }
            }
            
            File arqSer = new File(pastaCorrecao.getDiretorio().getAbsolutePath() +
                                "/" + Constantes.NARQ_SER);
            Arquivos.deletarArquivo(arqSer);
            System.out.println("Reversão Concluída!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
