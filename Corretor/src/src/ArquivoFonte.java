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
    
    public String corrigir(String entrada) {
        String[] args = new String[] { 
            arquivoFonte.getName().substring(0, arquivoFonte.getName().length() - 4) };
        String saida = null;
        Executador executador = new Executador(arquivoFonte.getParentFile(), args, entrada, saida);
        executador.executar();
        
        return saida;
    }
    
}