package logica;

import java.io.File;
import java.io.IOException;
import dados.Aluno;
import dados.ArquivoFonte;
import dados.PastaCorrecao;

/**
 * Classe que gerencia a revers�o da corre��o corrente, ou seja, retorna os arquivos
 * para a forma inicial.
 */
public class GerenciaReversao {
    
    /** 
     * Cria uma nova inst�ncia da classe GerenciaReversao.
     */
    public GerenciaReversao() {
    }
    
    /**
     * Retorna todas as pastas da corre��o para a forma inicial, ou seja, todos
     * os arquivos fonte dos alunos nas pastas dos mesmos e n�o em um subdiret�rio
     * com o nome do arquivo fonte.
     */
    public void reverter() {
        try {
            Aluno[] alunos = PastaCorrecao.getInstancia().getAlunos();
            for (Aluno aluno : alunos) {
                ArquivoFonte[] arquivosFontes = aluno.getFontes();
                File arqAluno = new File(aluno.getDiretorioAluno().getAbsolutePath() +
                "/" + aluno.getDiretorioAluno().getName() + ".txt");
                Arquivos.deletarArquivo(arqAluno);
                for (int i = 0; i <= arquivosFontes.length - 1; i++) {
                    File arquivoAntigo = arquivosFontes[i].getArquivo();
                    if (arquivoAntigo != null) {
                        String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                        Arquivos.salvarArquivo(new File(aluno.getDiretorioAluno() + 
                                "/" + arquivoAntigo.getName()), texto);
                        Arquivos.deletarDiretorio(arquivoAntigo.getParentFile());
                    }
                }
            }
            
            File arqSer = new File(PastaCorrecao.getInstancia().getDiretorio().getAbsolutePath() +
                                "/" + Constantes.NARQ_COR);
            PastaCorrecao.setInstancia(null);
            Arquivos.deletarArquivo(arqSer);
            System.out.println("Revers�o Conclu�da!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
