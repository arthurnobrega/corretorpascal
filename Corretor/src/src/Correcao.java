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
    
    PastaCorrecao pastaCorrecao = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(PastaCorrecao pastaCorrecao) {
        this.pastaCorrecao = pastaCorrecao;
    }
    
    public void criarDiretorios() throws IOException {        
        Aluno[] arqFontes = pastaCorrecao.getAlunos();
        
        for (Aluno fonteAluno : arqFontes) {
            File arqFonteAluno = fonteAluno.getArquivoFonte();
            File diretorio = pastaCorrecao.getPasta();
            
            if (new File(arqFonteAluno.getParent()).mkdir()) {
                File arquivoAntigo = new File(diretorio.getAbsolutePath() +
                        "/" + arqFonteAluno.getName());
                String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                arquivoAntigo.delete();
                Arquivos.salvarArquivo(new File(arqFonteAluno.getAbsolutePath()), texto);
            }
        }
    }
    
    public void compilarFontes() throws IOException {
        Aluno[] arqFontes = pastaCorrecao.getAlunos();
        
        for (Aluno fonteAluno : arqFontes) {
            String nomeArqFonte = fonteAluno.getArquivoFonte().getName();
            String caminhoPasta = pastaCorrecao.getPasta().getAbsolutePath();
            
            File pastaAluno = new File(caminhoPasta + "/" + 
                    nomeArqFonte.substring(0, nomeArqFonte.length() - 4));
            
            Executador ex = new Executador(pastaAluno, "fpc " + nomeArqFonte, null, null);
            if (ex.getValorSaida() != 0) {
                criarRelatorioErro(pastaAluno, fonteAluno);
            }
        }
    }
    
    private void criarRelatorioErro(File pastaAluno, Aluno fonteAluno) {
        try {
            fonteAluno.setErroCompilacao(true);
            Arquivos.salvarArquivo(new File(pastaAluno.getAbsolutePath() + 
                    "/" + Constantes.NARQ_REL + ".txt"), Constantes.E_COMPILACAO);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void gerarSaidas() {
        Aluno[] fontesAlunos = pastaCorrecao.getAlunos();
        for (Aluno aluno : fontesAlunos) {
            if (!aluno.getErroCompilacao()) {
                File fonte = aluno.getArquivoFonte();
                String nomeAluno = fonte.getName().substring(0, fonte.getName().length() - 4);
                File executavel = new File(fonte.getParent() + "/" + nomeAluno + ".exe");
                
                int tamLista = pastaCorrecao.getListaIO().getTamLista();
                for (int i = 0; i <= tamLista - 1; i++) {
                    File saida = new File(fonte.getParent() + "/" + Constantes.NARQ_SAI +
                            (i + 1) + ".txt");
                    File entrada = pastaCorrecao.getListaIO().getEntrada(i);
                    String args = nomeAluno + ".exe";
                    
                    Executador ex = new Executador(fonte.getParentFile(), args, entrada, saida);
                }
            }
        }
    }
    
}
