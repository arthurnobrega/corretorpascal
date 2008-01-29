package logica;

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
import java.io.OutputStreamWriter;
import dados.PastaCorrecao;


/**
 * Esta classe contém métodos que manipulam arquivos de diversas formas.
 */
public abstract class Arquivos {
	
    /** 
     * Retorna o texto que está contido em um determinado arquivo.
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
     * Grava os dados que são passados dentro do arquivo e o fecha.
     * @param arquivo O caminho completo do arquivo no qual será gravado os dados.
     * @param texto O texto que será gravado no arquivo.
     */
    public static void salvarArquivo(File arquivo, String texto) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(arquivo), "UTF8"));
        out.write(texto);
        out.close();
    }

    /** 
     * Deleta um determinado arquivo.
     * @param arquivo O arquivo que será deletado.
     */
    public static void deletarArquivo(File arquivo) throws IOException {
        if (!arquivo.delete()) {
            throw new IOException();
        }
    }
    
    /**
     * Deleta um determinado dirétorio e todos os arquivos e subdiretórios contidos nele.
     * @param diretorio O diretório que será deletado.
     * @return Um valor true se foi bem sucedido e falso caso contrário.
     */
    public static boolean deletarDiretorio(File diretorio) {
        // Para ver se o diretório é atualmente um link simbólico para um diretório,
        // nós precisamos pegar o caminho Canônico - isto é, nós seguimos o link para
        // o arquivo que ele está atualmente linkado.
        File candir;
        try {
            candir = diretorio.getCanonicalFile();
        } catch (IOException e) {
            return false;
        }
  
        // Um link simbólico tem um caminho canônico diferente do que o seu
        // caminho atual, a menos que seja um link para si mesmo.
        if (!candir.equals(diretorio.getAbsoluteFile())) {
            // Este arquivo é um link simbólico, e não há nenhuma razão para
            // seguí-lo, porque poderíamos apagar algo que não deveria ser apagado.
            return false;
        }
  
        // Agora temos de passar por todos os arquivos e subdiretórios no
        // diretório e eliminá-los um por um.
        File[] files = candir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
  
                	
                // No caso deste diretório ser realmente uma ligação simbólica,
                // ou ele está vazio, queremos tentar apagar o link antes de 
                // tentarmos qualquer coisa.
                boolean deleted = file.delete();
                if (!deleted) {
                    // Deletar o arquivo falhou, talvez seja um diretório não vazio.
                    if (file.isDirectory()) {
                        deletarDiretorio(file);
                    }
  
                   // Caso contrário, não há nada mais que possamos fazer.
                }
            }
        }
  
        // Agora que tentamos limpar o diretório de fora, podemos tentar apagá-lo
        // novamente.
        return diretorio.delete();  
    }
    
    /**
     * Salva os dados armazenados na variável de classe PastaCorrecao em um arquivo
     * que será utilizado para a importação posteriormente.
     */
    public static void serializarCorrecao() {
       File arq = new File(PastaCorrecao.getInstancia().getDiretorio().getAbsolutePath() + "/" + Constantes.NARQ_SER);
       FileOutputStream fos;
       ObjectOutputStream oos;
       
       try {
          fos = new FileOutputStream(arq);
          oos = new ObjectOutputStream(fos);
          oos.writeObject((PastaCorrecao) PastaCorrecao.getInstancia());
          oos.close();
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    
    /**
     * Importa os dados armazenados no arquivo para a memória na forma da variável
     * de classe PastaCorrecao.
     * @return A instância da variável que foi desserializada, ou seja, importada de
     * um arquivo.
     */
    public static PastaCorrecao desserializarCorrecao(File diretorio) throws IOException {
       File arq = new File(diretorio.getAbsolutePath() + "/" + Constantes.NARQ_SER);
       InputStream is;
       ObjectInputStream ois;  
       PastaCorrecao pastaCorrecao = null;
       
       if (arq.exists()) {
           try {
              is = new FileInputStream(arq);
              ois = new ObjectInputStream(is);
              pastaCorrecao =  (PastaCorrecao) ois.readObject();
           } catch (IOException e) {
              e.printStackTrace();
           } catch (ClassNotFoundException e) {
              e.printStackTrace();
           }
       } else {
           throw new IOException();
       }
       return pastaCorrecao;
    }
}
