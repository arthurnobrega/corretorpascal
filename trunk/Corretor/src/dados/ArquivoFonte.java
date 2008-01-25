/*
 * ArquivoFonte.java
 *
 * Created on 20 de Outubro de 2007, 23:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dados;

import corretor.Executador;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import dados.Saidas;

/**
 *
 * @author UltraXP
 */
public class ArquivoFonte implements Serializable {
    
    private boolean erroCompilacao = false;
    private File arquivoFonte = null;
    private ArrayList<Saidas> saidas = null;
    private ArrayList<Integer> notas = null;
    private long tempoExecucao = 0;
    
    /** Creates a new instance of ArquivoFonte */
    public ArquivoFonte(File arquivoFonte) {
        this.arquivoFonte = arquivoFonte;
        notas = new ArrayList<Integer>();
    }
    
    public void reiniciarContagem() {
        notas = new ArrayList<Integer>();
    }
    
    public long getTempoExecucao() {
        return tempoExecucao;
    }
    
    public File getArquivo() {
        return arquivoFonte;
    }
    
    public void setErroCompilacao(boolean erroCompilacao) {
        this.erroCompilacao = erroCompilacao;
    }
    
    public boolean getErroCompilacao() {
        return erroCompilacao;
    }
    
    public void setSaidas(ArrayList<Saidas> saidas) {
        this.saidas = saidas;
    }
    
    public ArrayList<Saidas> getSaidas() {
        return saidas;
    }
    
    public int getNota(int indice) {
        return notas.get(indice).intValue();
    }
    
    public void addNota(int nota) {
        notas.add(new Integer(nota));
    }
    
    public int getNotaTotal() {
        int somaNotas = 0;
        int nroTestes = notas.size();
        for (int i = 0; i <= nroTestes - 1; i++) {
            somaNotas += notas.get(i).intValue();
        }
        return somaNotas/nroTestes;
    }
    
    public String corrigir(String entrada) {
        String saida = null;
        String[] args = new String[] { "cmd", "/C",
            arquivoFonte.getName().substring(0, arquivoFonte.getName().length() - 4) + ".exe" };
        Executador ex = new Executador(arquivoFonte.getParentFile(), args, entrada);
        ex.executar();
        tempoExecucao = ex.getTempoExecucao();
        saida = ex.getSaida();
        
        return saida;
    }
    
    public String testarGabarito(String saida, String gabarito) {
        String relatorio = new String();
        String[] linhasSaida = saida.split("\n"), linhasGabarito = gabarito.split("\n");
        int nroSaida = linhasSaida.length, nroGabarito = linhasGabarito.length, 
                limite, nroAcertos = 0, nota;        
        
        limite = nroGabarito;
        
        if (nroSaida < nroGabarito) {
            limite = nroSaida;
        }
        
        for (int i = 0; i <= limite - 1; i++) {
            if (linhasSaida[i].contains(linhasGabarito[i])) {
                relatorio += "Acertou o quesito " + (i + 1) + "\n";
                        
                nroAcertos += 1;
            } else {
                relatorio += "Errou o quesito " + (i + 1) + "\n";
            }
            relatorio += "          Gabarito: (" + linhasGabarito[i] +
                        ")\n          Saída do Aluno: (" + linhasSaida[i] + ")\n";
        }
        
        nota = (int) (100 * ((double)nroAcertos / (double)nroGabarito));
        relatorio += "\nNota (0-100): " + nota;
        this.addNota(nota);
        
        return relatorio;
    }
    
}