/*
 * Correcao.java
 *
 * Created on 15 de Setembro de 2007, 22:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import gui.BarraProgresso;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import log.Constantes;

/**
 *
 * @author UltraXP
 */
public class Correcao extends Thread {
    
    File diretorio = null;
    BarraProgresso barraProgresso = null;
    Thread thread = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(File diretorio, BarraProgresso barraProgresso) {
        this.diretorio = diretorio;
        this.barraProgresso = barraProgresso;
    }
    
    public void run() {
        GerenciaPas gp = new GerenciaPas(diretorio);
        ArrayList<File> listaAlunos = gp.procurarPas();
        ArrayList<File> pastasAlunos = null;

        int nroAlunos = listaAlunos.size();
        try {
            for (int i = 0; i <= listaAlunos.size() - 1; i++) {
                criarDiretorio(listaAlunos.get(i));
                pastasAlunos = gp.procurarPastasPas();
                compilarFonte(pastasAlunos.get(i));
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setarValorBarra(int valor) {
        barraProgresso.getBarraProgresso().setValue(valor);
        if (barraProgresso.getBarraProgresso().getValue() == 100) {
            barraProgresso.dispose();
        }
    }
    
    private void criarDiretorio(File fonteAluno) throws IOException {
        String aluno = fonteAluno.getName().substring(0, fonteAluno.getName().length() - 4);

        if (new File(diretorio.getAbsolutePath() + "/" + aluno).mkdir()) {
            String texto = Arquivos.getTextoArquivo(fonteAluno.getAbsolutePath());
            Arquivos.salvarArquivo(fonteAluno.getParent() + "/" + aluno + "/" + fonteAluno.getName(), texto);
        }
    }
    
    private void compilarFonte(File pastaAluno) throws IOException {
        Executador ex = new Executador("fpc " + pastaAluno.getAbsolutePath() + "/" 
                + pastaAluno.getName() + ".pas");
        criarArquivoRelatorio(pastaAluno, ex.getValorSaida());
    }
    
    private void criarArquivoRelatorio(File pastaAluno, int valorSaida) {
        try {
            if (valorSaida != 0) {
                Arquivos.salvarArquivo(pastaAluno.getAbsolutePath() + 
                        "/relatorio.txt", Constantes.E_COMPILACAO);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void testarProgramas() {
        
    }
    
}
