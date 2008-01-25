package corretor;

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
import logica.Constantes;
import dados.PastaCorrecao;

public abstract class Arquivos {
	
    /** 
     * Este método retorna o texto que está contido em um determinado arquivo
     * na forma de String. 
     * @param filename O Nome do Arquivo.
     * @return Uma String que contém o texto do arquivo.
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
     * Este método grava os dados que são passados dentro do arquivo e o fecha.
     * @param caminhoArquivo O caminho completo do arquivo no qual será gravado os dados.
     * @param texto O texto que será gravado no arquivo.
     */
    public static void salvarArquivo(File arquivo, String texto) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(arquivo), "UTF8"));
        out.write(texto);
        out.close();
    }

    public static void deletarArquivo(File arquivo) throws IOException {
        if (!arquivo.delete()) {
            throw new IOException();
        }
    }
    
    public static boolean deletarDiretorio(File dir) {
        // to see if this directory is actually a symbolic link to a directory,
        // we want to get its canonical path - that is, we follow the link to
        // the file it's actually linked to
        File candir;
        try {
            candir = dir.getCanonicalFile();
        } catch (IOException e) {
            return false;
        }
  
        // a symbolic link has a different canonical path than its actual path,
        // unless it's a link to itself
        if (!candir.equals(dir.getAbsoluteFile())) {
            // this file is a symbolic link, and there's no reason for us to
            // follow it, because then we might be deleting something outside of
            // the directory we were told to delete
            return false;
        }
  
        // now we go through all of the files and subdirectories in the
        // directory and delete them one by one
        File[] files = candir.listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
  
                // in case this directory is actually a symbolic link, or it's
                // empty, we want to try to delete the link before we try
                // anything
                boolean deleted = file.delete();
                if (!deleted) {
                    // deleting the file failed, so maybe it's a non-empty
                    // directory
                    if (file.isDirectory()) deletarDiretorio(file);
  
                    // otherwise, there's nothing else we can do
                }
            }
        }
  
        // now that we tried to clear the directory out, we can try to delete it
        // again
        return dir.delete();  
    }
    
    public static void serializarCorrecao(PastaCorrecao pastaCorrecao) {
       File arq = new File(pastaCorrecao.getDiretorio().getAbsolutePath() + "/" + Constantes.NARQ_SER);
       FileOutputStream fos;
       ObjectOutputStream oos;
       
       try {
          fos = new FileOutputStream(arq);
          oos = new ObjectOutputStream(fos);
          oos.writeObject((PastaCorrecao) pastaCorrecao);
          oos.close();
       } catch (IOException e) {
          e.printStackTrace();
       }
    }
    
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
