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
        ArrayList<ArquivoFonte> novosArquivosFontes = new ArrayList<ArquivoFonte>();
        
        for (int i = 0; i <= arquivosFontes.length - 1; i++) {
            ArquivoFonte arquivoFonte = arquivosFontes[i];
            File arqFonte = arquivoFonte.getArquivo();
            
            File diretorio = aluno.getDiretorio();
            File pastaFonte = new File(diretorio.getAbsolutePath() + "/" + 
                    arqFonte.getName().substring(0, arqFonte.getName().length()- 4));
            
            if (arqFonte.getName().startsWith(Constantes.NARQ_QUE) && pastaFonte.mkdir()) {
                File arquivoAntigo = new File(diretorio.getAbsolutePath() +
                        "/" + arqFonte.getName());
                String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                arquivoAntigo.delete();
                File novoArquivo = new File(pastaFonte.getAbsolutePath() + "/" + arqFonte.getName());
                Arquivos.salvarArquivo(novoArquivo, texto);
                ArquivoFonte novoArquivoFonte = new ArquivoFonte(novoArquivo);
                String[] temp1 = null;
                String temp2 = null;
                temp1 = arqFonte.getName().split(Constantes.NARQ_QUE);
                temp2 = temp1[0];
                temp1 = temp2.split(".pas");
                int nro = Integer.parseInt(temp1[0]);
                
                novosArquivosFontes.add(novoArquivoFonte);
            }
        }
        aluno.setFontes((ArquivoFonte[])novosArquivosFontes.toArray());
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
                arquivoFonte.setErroCompilacao(true);
            }
        }
    }
    
    public void corrigir(ArrayList<ListaIO> listaIO) {
        ArquivoFonte[] arquivosFonte = aluno.getFontes();
        for (int i = 0; i <= arquivosFonte.length - 1; i++) {
            ArquivoFonte arqFonte = arquivosFonte[i];
            
            arqFonte.corrigir("");
        }
        
    }
    
}
