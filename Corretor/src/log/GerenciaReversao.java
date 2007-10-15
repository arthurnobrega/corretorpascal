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
import src.Arquivos;
import src.PastaCorrecao;

/**
 *
 * @author UltraXP
 */
public class GerenciaReversao {
    
    PastaCorrecao[] pastasCorrecao = null;
    File diretorio = null;
    
    /** Creates a new instance of GerenciaReversao */
    public GerenciaReversao(File diretorio, PastaCorrecao[] pastasCorrecao) {
        this.pastasCorrecao = pastasCorrecao;
        this.diretorio = diretorio;
    }
    
    public void reverter() {
        try {
            for (PastaCorrecao pastaCorrecao : pastasCorrecao) {
                Aluno[] alunos = pastaCorrecao.getAlunos();
                for (Aluno aluno : alunos) {
                    File arquivoAntigo = aluno.getArquivoFonte();
                    String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                    Arquivos.salvarArquivo(new File(pastaCorrecao.getPasta().getAbsoluteFile() +
                            "/" + arquivoAntigo.getName()), texto);
                    Arquivos.deletarDiretorio(arquivoAntigo.getParentFile());
                }
            }
            
            File arqSer = new File(diretorio.getAbsolutePath() +
                                "/" + Constantes.NARQ_SER);
            Arquivos.deletarArquivo(arqSer);
            System.out.println("Reversão Concluída!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
