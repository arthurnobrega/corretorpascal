package logica;

import dados.Aluno;
import dados.ArquivoFonte;
import dados.ListaQuestoes;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import dados.PastaCorrecao;


/**
 * Esta classe cont�m m�todos que manipulam arquivos de diversas formas.
 */
public abstract class Arquivos {
	
    /** 
     * Retorna o texto que est� contido em um determinado arquivo.
     * na forma de String. 
     * @param arquivo O Nome do Arquivo.
     * @return O texto do arquivo em forma de String.
     */
    public static String getTextoArquivo(File arquivo) throws IOException {
        StringBuffer buffer = new StringBuffer();
        BufferedReader in = new BufferedReader (new InputStreamReader (
                                new FileInputStream (arquivo), "UTF-8"));
        String line;
        while((line = in.readLine()) != null) {
            buffer.append(line + "\n");
        }
        in.close();
        return buffer.toString();
    }

    /** 
     * Grava os dados que s�o passados dentro do arquivo e o fecha.
     * @param arquivo O caminho completo do arquivo no qual ser� gravado os dados.
     * @param texto O texto que ser� gravado no arquivo.
     */
    public static void salvarArquivo(File arquivo, String texto) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(arquivo), "UTF-8"));
        out.write(texto);
        out.close();
    }
    
    /**
     * Copia um arquivo para determinada quest�o dos alunos.
     * @param arquivo O arquivo que ser� copiado.
     * @param indiceQuestao O �ndice da quest�o para onde o arquivo ser� copiado.
     */
    public static void copiarArquivo(File arquivo, int indiceQuestao) throws IOException {
        Aluno[] todosAlunos = PastaCorrecao.getInstancia().getAlunos();
        for (Aluno aluno : todosAlunos) {
            ArquivoFonte[] fontes = aluno.getFontes();
            if ((fontes.length > indiceQuestao) && (fontes[indiceQuestao] != null)) {
                String diretorio = fontes[indiceQuestao].getArquivo().getParentFile().getAbsolutePath();
                File novoArquivo = new File(diretorio + "/" + arquivo.getName());
                InputStream in = new FileInputStream(arquivo);
                OutputStream out = new FileOutputStream(novoArquivo);

                // Transfere os bytes de um arquivo para o outro.
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            }
        }
    }

    /** 
     * Deleta um determinado arquivo.
     * @param arquivo O arquivo que ser� deletado.
     */
    public static void deletarArquivo(File arquivo) throws IOException {
        if (!arquivo.delete()) {
            throw new IOException();
        }
    }
    
    /**
     * Deleta um determinado dir�torio e todos os arquivos e subdiret�rios contidos nele.
     * @param diretorio O diret�rio que ser� deletado.
     * @return Um valor true se foi bem sucedido e falso caso contr�rio.
     */
    public static boolean deletarDiretorio(File diretorio) {
        // Para ver se o diret�rio � atualmente um link simb�lico para um diret�rio,
        // n�s precisamos pegar o caminho Can�nico - isto �, n�s seguimos o link para
        // o arquivo que ele est� atualmente linkado.
        File candir;
        try {
            candir = diretorio.getCanonicalFile();
        } catch (IOException e) {
            return false;
        }
  
        // Um link simb�lico tem um caminho can�nico diferente do que o seu
        // caminho atual, a menos que seja um link para si mesmo.
        if (!candir.equals(diretorio.getAbsoluteFile())) {
            // Este arquivo � um link simb�lico, e n�o h� nenhuma raz�o para
            // segu�-lo, porque poder�amos apagar algo que n�o deveria ser apagado.
            return false;
        }
  
        // Agora temos de passar por todos os arquivos e subdiret�rios no
        // diret�rio e elimin�-los um por um.
        File[] files = candir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
  
                	
                // No caso deste diret�rio ser realmente uma liga��o simb�lica,
                // ou ele est� vazio, queremos tentar apagar o link antes de 
                // tentarmos qualquer coisa.
                boolean deleted = file.delete();
                if (!deleted) {
                    // Deletar o arquivo falhou, talvez seja um diret�rio n�o vazio.
                    if (file.isDirectory()) {
                        deletarDiretorio(file);
                    }
  
                   // Caso contr�rio, n�o h� nada mais que possamos fazer.
                }
            }
        }
  
        // Agora que tentamos limpar o diret�rio de fora, podemos tentar apag�-lo
        // novamente.
        return diretorio.delete();  
    }
    
    /**
     * Salva os dados armazenados na vari�vel de classe PastaCorrecao em um arquivo
     * que ser� utilizado para a importa��o posteriormente.
     */
    public static void serializarDados() {
       File arqCorrecao = new File(PastaCorrecao.getInstancia().getDiretorio().getAbsolutePath() + 
               "/" + Constantes.NARQ_COR);
       File arqListaQuestoes = new File(PastaCorrecao.getInstancia().getDiretorio().getAbsolutePath() + 
               "/" + Constantes.NARQ_LIS);
       FileOutputStream fosCorrecao, fosListaQuestoes;
       ObjectOutputStream oosCorrecao, oosListaQuestoes;
       
       try {
          fosCorrecao = new FileOutputStream(arqCorrecao);
          oosCorrecao = new ObjectOutputStream(fosCorrecao);
          fosListaQuestoes = new FileOutputStream(arqListaQuestoes);
          oosListaQuestoes = new ObjectOutputStream(fosListaQuestoes);
          
          oosCorrecao.writeObject((PastaCorrecao) PastaCorrecao.getInstancia());
          oosCorrecao.close();
          
          oosListaQuestoes.writeObject((ListaQuestoes) ListaQuestoes.getInstancia());
          oosListaQuestoes.close();
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    
    /**
     * Importa os dados armazenados no arquivo para a mem�ria na forma da vari�vel
     * de classe PastaCorrecao.
     * @return A inst�ncia da vari�vel que foi desserializada, ou seja, importada de
     * um arquivo.
     */
    public static PastaCorrecao desserializarCorrecao(File diretorio) throws IOException {
       File arqCorrecao = new File(diretorio.getAbsolutePath() + "/" + Constantes.NARQ_COR);
       InputStream isCorrecao;
       ObjectInputStream oisCorrecao;  
       PastaCorrecao pastaCorrecao = null;
       
       if (arqCorrecao.exists()) {
           try {
              isCorrecao = new FileInputStream(arqCorrecao);
              oisCorrecao = new ObjectInputStream(isCorrecao);
              pastaCorrecao =  (PastaCorrecao) oisCorrecao.readObject();
           } catch (ClassNotFoundException e) {
              e.printStackTrace();
           }
       } else {
           throw new IOException();
       }
       return pastaCorrecao;
    }
    
    public static ListaQuestoes desserializarListaQuestoes(File arqListaQuestoes) throws IOException {
       InputStream isListaQuestoes;
       ObjectInputStream oisListaQuestoes;
       ListaQuestoes listaQuestoes = null;
       
       if (arqListaQuestoes.exists()) {
           try {
              isListaQuestoes = new FileInputStream(arqListaQuestoes);
              oisListaQuestoes = new ObjectInputStream(isListaQuestoes);
              listaQuestoes =  (ListaQuestoes) oisListaQuestoes.readObject();
           } catch (ClassNotFoundException e) {
              e.printStackTrace();
           }
       } else {
           throw new IOException();
       }
       return listaQuestoes;
    }
}
