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
    
    PastaCorrecao pastaCorrecao = null;
    Aluno aluno = null;
    
    /** Creates a new instance of Correcao */
    public Correcao(PastaCorrecao pastaCorrecao, Aluno aluno) {
        this.pastaCorrecao = pastaCorrecao;
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
                try {
                    String[] temp1 = null;
                    String temp2 = null;
                    temp1 = arqFonte.getName().split(Constantes.NARQ_QUE);
                    temp2 = temp1[1];
                    temp1 = temp2.split(".pas");
                    int nro = Integer.parseInt(temp1[0]);
                    
                    File arquivoAntigo = new File(diretorio.getAbsolutePath() +
                            "/" + arqFonte.getName());
                    String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                    arquivoAntigo.delete();
                    File novoArquivo = new File(pastaFonte.getAbsolutePath() + "/" + arqFonte.getName());
                    Arquivos.salvarArquivo(novoArquivo, texto);
                    ArquivoFonte novoArquivoFonte = new ArquivoFonte(novoArquivo);
                    while (novosArquivosFontes.size() < (nro - 1)) {
                        novosArquivosFontes.add(null);
                    }
                    novosArquivosFontes.add(nro - 1, novoArquivoFonte);
                } catch (NumberFormatException ex) {
                    //ignorando
                }
            }
        }
        aluno.setFontes((ArquivoFonte[])novosArquivosFontes.toArray(new ArquivoFonte[] {}));
    }
    
    public void compilarFontes() throws IOException {
        ArquivoFonte[] arquivosFontes = aluno.getFontes();
        
        for (int i = 0; i <= arquivosFontes.length - 1; i++) {
            ArquivoFonte arquivoFonte = arquivosFontes[i];
            if (arquivoFonte != null) {
                File arqFonte = arquivoFonte.getArquivo();

                Executador ex = new Executador(arqFonte.getParentFile(), new String[] {
                    "fpc", arqFonte.getName()}, null);
                ex.executar();
                if (ex.getValorSaida() != 0) {
                arquivoFonte.setErroCompilacao(true);
                }
            } else {
                //Colocar uma flag mostrando o erro.
            }
        }
    }
    
    public void corrigir(ArrayList<ListaIO> listaIO) {
        ArquivoFonte[] arquivosFonte = aluno.getFontes();
        aluno.reiniciarContagem();
        int nroFontes = arquivosFonte.length;
        
        for (int i = 0; i <= nroFontes - 1; i++) {
            ArquivoFonte arqFonte = arquivosFonte[i];
            ArrayList<Saidas> saidas = null;
            if (arqFonte != null) {
                ListaIO io = listaIO.get(i);
                saidas = new ArrayList<Saidas>();
                for (int j = 0; j <= io.getTamLista() - 1; j++) {
                    String textoSaida = arqFonte.corrigir(io.getEntrada(j));
                    System.out.println("TEMPO DECORRIDO: " + arqFonte.getTempoExecucao() + "ms");
                    String textoRelatorio = arqFonte.testarGabarito(textoSaida, io.getGabarito(j));
                    Saidas saida = new Saidas(textoSaida, textoRelatorio);
                    saidas.add(saida);
                }
                int notaMax = pastaCorrecao.getArrayListIO().get(i).getNotaQuestao();
                aluno.addNotaQuestao((int) (arqFonte.getNotaTotal() * notaMax) / 100);
            } else {
                aluno.addNotaQuestao(0);
            }
            arqFonte.setSaidas(saidas);
        }
    }
    
}
