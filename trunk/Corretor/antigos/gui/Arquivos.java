package br.unb.cic.corretor.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	public static String getTextoArquivo(String nomeArquivo){
		StringBuffer buffer = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (
					new FileInputStream (nomeArquivo), "UTF-8"));
	        String line;
	        while((line = in.readLine()) != null) {
	            buffer.append(line + "\n");
	        }
	        in.close();
	        
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Constantes.ERRO_LEITURA);
		}
		return buffer.toString();
	}
	
	/** 
	 * Este método grava os dados que são passados dentro do arquivo e o fecha.
	 * @param caminhoArquivo O caminho completo do arquivo no qual será gravado os dados.
	 * @param texto O texto que será gravado no arquivo.
	 */
	public static void salvarArquivo(String caminhoArquivo, String texto) {
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(caminhoArquivo), "UTF8"));
			out.write(texto);
			out.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, Constantes.ERRO_SALVAR);
		}
	}

}
