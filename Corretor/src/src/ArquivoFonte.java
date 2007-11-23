/*
 * ArquivoFonte.java
 *
 * Created on 20 de Outubro de 2007, 23:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class ArquivoFonte implements Serializable {
    
    private boolean erroCompilacao = false;
    private File arquivoFonte = null;
    private ArrayList<Saidas> saidas = null;
    private int nota = 0;
    
    /** Creates a new instance of ArquivoFonte */
    public ArquivoFonte(File arquivoFonte) {
        this.arquivoFonte = arquivoFonte;
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
    
    public int getNota() {
        return nota;
    }
    
    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public String corrigir(String entrada, String gabarito) {
        String saida = null;
        String[] args = new String[] { "cmd", "/C",
            arquivoFonte.getName().substring(0, arquivoFonte.getName().length() - 4) + ".exe" };
        Executador executador = new Executador(arquivoFonte.getParentFile(), args, entrada);
        executador.executar();
        saida = executador.getSaida();
        testarGabaritos(saida, gabarito);
        
        return saida;
    }
    
    public void testarGabaritos(String saida, String gabarito) {
        String[] linhasSaida = saida.split("\n");
        String[] linhasGabarito = gabarito.split("\n");
        int nroSaida = linhasSaida.length;
        int nroGabarito = linhasGabarito.length;
        int limite;
        int nroAcertos = 0;
        
        limite = nroGabarito;
        
        if (nroSaida < nroGabarito) {
            limite = nroSaida;
        }
        
        for (int i = 0; i <= limite - 1; i++) {
            if (linhasSaida[i].contains(linhasGabarito[i])) {
                nroAcertos++;
            }
        }
        
        setNota(100 * (nroAcertos/nroGabarito));
    }
    
}