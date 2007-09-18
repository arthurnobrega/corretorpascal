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
import javax.swing.JOptionPane;
import log.Constantes;

/**
 *
 * @author UltraXP
 */
public class Correcao {
    
    File diretorio = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(File diretorio) {
        this.diretorio = diretorio;
    }
    
    public void criarDiretorios() throws IOException {
        GerenciaPas gp = new GerenciaPas(diretorio);
        
        ArrayList<File> listaAlunos = gp.procurarPas();
        
        for (File fonteAluno : listaAlunos) {
            String aluno = fonteAluno.getName().substring(0, fonteAluno.getName().length() - 4);
            
            if (new File(diretorio.getAbsolutePath() + "/" + aluno).mkdir()) {
                String texto = Arquivos.getTextoArquivo(fonteAluno.getAbsolutePath());
                Arquivos.salvarArquivo(fonteAluno.getParent() + "/" + aluno + "/" + fonteAluno.getName(), texto);
            }
        }
    }
    
    public void compilarFontes() throws IOException {
        GerenciaPas gp = new GerenciaPas(diretorio);
        
        ArrayList<File> pastasAlunos = gp.procurarPastasPas();
        
        for (File pastaAluno : pastasAlunos) {
            Executador ex = new Executador("fpc " + pastaAluno.getAbsolutePath() + "/" 
                    + pastaAluno.getName() + ".pas");
            criarArquivoRelatorio(pastaAluno, ex.getValorSaida());
        }
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
    
    public void testarProgramas() {
        
    }
    
}
