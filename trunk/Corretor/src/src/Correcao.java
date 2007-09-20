/*
 * Correcao.java
 *
 * Created on 15 de Setembro de 2007, 22:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import log.Constantes;

/**
 *
 * @author UltraXP
 */
public class Correcao {
    
    File diretorio = null;
    Thread thread = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(File diretorio) {
        this.diretorio = diretorio;
        corrigir();
    }
    
    public void corrigir() {
        GerenciaPas gp = new GerenciaPas(diretorio);
        ArrayList<File> listaAlunos = gp.procurarPas();
        ArrayList<File> pastasAlunos = null;

        int nroAlunos = listaAlunos.size();
        try {
            for (int i = 0; i <= listaAlunos.size() - 1; i++) {
                criarDiretorio(listaAlunos.get(i));
                pastasAlunos = gp.procurarPastasPas();
                compilarFonte(pastasAlunos.get(i), nroAlunos, i);
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void criarDiretorio(File fonteAluno) throws IOException {
        String aluno = fonteAluno.getName().substring(0, fonteAluno.getName().length() - 4);

        if (new File(diretorio.getAbsolutePath() + "/" + aluno).mkdir()) {
            String texto = Arquivos.getTextoArquivo(fonteAluno.getAbsolutePath());
            Arquivos.salvarArquivo(fonteAluno.getParent() + "/" + aluno + "/" + fonteAluno.getName(), texto);
        }
    }
    
    private synchronized void compilarFonte(File pastaAluno, int nroAlunos, int aluno) {
        Executador exec = new Executador("fpc " + pastaAluno.getAbsolutePath() + "/" 
                + pastaAluno.getName() + ".pas");
        criarArquivoRelatorio(pastaAluno, exec.getValorSaida());
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
