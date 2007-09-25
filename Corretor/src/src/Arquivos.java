package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class Arquivos {
	
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


}
