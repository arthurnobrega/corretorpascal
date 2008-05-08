package logica;

import java.io.File;
import java.io.IOException;
import dados.Aluno;
import corretor.Correcao;
import corretor.Configuracao;
import dados.PastaCorrecao;

/**
 * Esta classe testa a configura��o do programa de acordo com o diretorio informado
 * pelo usu�rio, ou seja, testa se o diret�rio est� nos padr�es que o programa exige.
 */
public class TestaConfiguracao {
    
    /**
     * Testa se a configura��o das pastas e arquivos no diret�rio informado segue
     * os padr�es que o programa exige.
     */
    public void testarConfiguracao(File diretorio) throws IOException {
        if (diretorio == null) {
             throw new IOException();
        }
        
        Configuracao config = new Configuracao(diretorio);
        PastaCorrecao.setInstancia(config.escanearPastaCorrecao());
        try {
            Aluno[] alunos = PastaCorrecao.getInstancia().getAlunos();
            int i = 0;
            /*
            Thread conc = new Thread(new Runnable() {
                public void run() {
                    barraProgresso.setVisible(true);
                    barraProgresso.getBarraProgresso().setValue((1 / 1) * 100);
                    barraProgresso.getBarraProgresso().paintImmediately(barraProgresso.getBarraProgresso().getBounds());
                    barraProgresso.dispose();
            }});
            conc.start();
             */
            for (Aluno aluno : alunos) {
                i++;
                Correcao cor = new Correcao(aluno);
                cor.criarDiretorios();
                cor.criarArquivoAluno();
                cor.compilarFontes();
            }
            GerenciaSerializacao gerSer = new GerenciaSerializacao();
            gerSer.serializar();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
