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
    
    Aluno aluno = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void criarDiretorios() throws IOException {
        ArquivoFonte[] arquivosFontes = aluno.getFontes();
        ArquivoFonte[] novosArquivosFontes = new ArquivoFonte[arquivosFontes.length];
        
        for (int i = 0; i <= arquivosFontes.length - 1; i++) {
            ArquivoFonte arquivoFonte = arquivosFontes[i];
            File arqFonte = arquivoFonte.getArquivo();
            
            File diretorio = aluno.getDiretorio();
            File pastaFonte = new File(diretorio.getAbsolutePath() + "/" + 
                    arqFonte.getName().substring(0, arqFonte.getName().length()- 4));
            
            if (pastaFonte.mkdir()) {
                File arquivoAntigo = new File(diretorio.getAbsolutePath() +
                        "/" + arqFonte.getName());
                String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                arquivoAntigo.delete();
                File novoArquivo = new File(pastaFonte.getAbsolutePath() + "/" + arqFonte.getName());
                Arquivos.salvarArquivo(novoArquivo, texto);
                ArquivoFonte novoArquivoFonte = new ArquivoFonte(novoArquivo);
                novosArquivosFontes[i] = novoArquivoFonte;
            }
        }
        aluno.setFontes(novosArquivosFontes);
    }
    
    public void compilarFontes() throws IOException {
        ArquivoFonte[] arquivosFontes = aluno.getFontes();
        
        for (int i = 0; i <= arquivosFontes.length - 1; i++) {
            ArquivoFonte arquivoFonte = arquivosFontes[i];
            File arqFonte = arquivoFonte.getArquivo();
            
            Executador ex = new Executador(arqFonte.getParentFile(), new String[] {
                "fpc", arqFonte.getName()}, null, null);
            ex.executar();
            if (ex.getValorSaida() != 0) {
                criarRelatorioErro(arquivoFonte);
            }
        }
    }
    
    private void criarRelatorioErro(ArquivoFonte arquivoFonte) {
        try {
            arquivoFonte.setErroCompilacao(true);
            Arquivos.salvarArquivo(new File(arquivoFonte.getArquivo().getParent() + 
                    "/" + Constantes.NARQ_REL), Constantes.E_COMPILACAO);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void gerarSaidas() {/*
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
                    String entrada = pastaCorrecao.getListaIO().getEntrada(i);
                    String args = "cmd /C " + nomeAluno;
                    
                    Executador ex = new Executador(fonte.getParentFile(), args, entrada, saida);
                    ex.executar();
                }
            }
        }*/
    }
    
    private void gerarSaidaUnitaria(ArrayList<ListaIO> listaIO, Aluno aluno) {
        
    }
    
}
