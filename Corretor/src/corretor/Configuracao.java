package corretor;

import dados.Aluno;
import dados.ArquivoFonte;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import dados.PastaCorrecao;
import logica.Constantes;

/**
 * Classe que é chamada para testar se no diretório informado existe alunos com
 * arquivos .pas e se existir já armazena os dados dos arquivos destes alunos na
 * memória.
 */
public class Configuracao {
    
    private File diretorio = null;
    
    /**
     * Cria uma nova instância da classe Configuração.
     * @param diretorio O diretoro que será testado se está de acordo com os padrões.
     */
    public Configuracao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    /**
     * Escaneia a pasta a procura dos subdiretórios dos alunos e seus arquivos .pas.
     */
    public PastaCorrecao escanearPastaCorrecao() throws IOException {
        Aluno[] alunos = procurarAlunos();
        PastaCorrecao pastaCorrecao = null;
        if (alunos.length > 0) {
            PastaCorrecao.setInstancia(diretorio, alunos);
            pastaCorrecao = PastaCorrecao.getInstancia();
        } else {
            throw new IOException();
        }
        
        return pastaCorrecao;
    }
    
    /**
     * Procura os alunos dentro do diretório informado no construtor.
     */
    private Aluno[] procurarAlunos() {
        File[] arquivos = diretorio.listFiles();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        for (File arq : arquivos) {            
            if (arq.isDirectory()) {
                ArquivoFonte[] arquivosPas = procurarPas(arq);
                if (arquivosPas.length > 0) {
                    Aluno aluno = new Aluno(arq, arquivosPas);
                    alunos.add(aluno);
                }
            }
        }
        
        return alunos.toArray(new Aluno[] {});
    }
    
    /**
     * Procura os arquivo .pas de um aluno que foi anteriormente encontrado.
     */
    private ArquivoFonte[] procurarPas(File pastaAluno) {
        File[] arquivos = pastaAluno.listFiles();
        ArrayList<File> listaPas = new ArrayList<File>();
        
        for (File arq : arquivos) {
            String nomeArq = arq.getName();
            int tamarq = nomeArq.length();
            
            if ((nomeArq.length() > 4) && (nomeArq.substring(tamarq - 4, tamarq).equals(".pas"))
            && (arq.isFile())) {
                if (nomeArq.toLowerCase().contains(Constantes.NARQ_QUE)) {
                    File arquivoFonte = new File(arq.getParent() + "/" +
                            nomeArq.substring(0,tamarq - 4) + "/" + arq.getName());
                    listaPas.add(arquivoFonte);
                }
            }
        }
        
        int tamLista = listaPas.size();
        ArquivoFonte[] arquivosFonte = new ArquivoFonte[tamLista];
        for (int i = 0; i <= tamLista - 1; i++) {
            arquivosFonte[i] = new ArquivoFonte(listaPas.get(i));
        }
        
        return arquivosFonte;
    }
    
}
