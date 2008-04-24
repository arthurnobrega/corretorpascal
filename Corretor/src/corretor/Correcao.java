package corretor;

import dados.Questao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import logica.Arquivos;
import logica.Constantes;
import dados.Aluno;
import dados.ArquivoFonte;
import dados.Teste;
import dados.PastaCorrecao;
import dados.Saidas;

/**
 * 
 */
public class Correcao {
    
    Aluno aluno = null;
    
    /** Cria uma nova instância da classe Correcao. */
    public Correcao(Aluno aluno) {
        this.aluno = aluno;
    }
    
    /**
     * Cria um diretório para cada questão do aluno passado no construtor.
     */
    public void criarDiretorios() throws IOException {
        ArquivoFonte[] arquivosFontes = aluno.getFontes();
        ArrayList<ArquivoFonte> novosArquivosFontes = new ArrayList<ArquivoFonte>();
        
        for (int i = 0; i <= arquivosFontes.length - 1; i++) {
            ArquivoFonte arquivoFonte = arquivosFontes[i];
            File arqFonte = arquivoFonte.getArquivo();
            
            File diretorio = aluno.getDiretorioAluno();
            File pastaFonte = new File(diretorio.getAbsolutePath() + "/" + 
                    arqFonte.getName().substring(0, 
                    arqFonte.getName().length()- 4));
            
            String q = arqFonte.getName().substring(0, 
                    Constantes.NARQ_QUE.length());
            if (q.equalsIgnoreCase(Constantes.NARQ_QUE)) {
                try {
                    String temp1 = arqFonte.getName().substring(
                            Constantes.NARQ_QUE.length(), arqFonte.getName().length());
                    String[] temp2 = temp1.split(".pas");
                    int nro = Integer.parseInt(temp2[0]);
                    if (pastaFonte.mkdir()) {
                        File arquivoAntigo = new File(diretorio.getAbsolutePath() +
                                "/" + arqFonte.getName());
                        String texto = Arquivos.getTextoArquivo(arquivoAntigo);
                        arquivoAntigo.delete();
                        File novoArquivo = new File(pastaFonte.getAbsolutePath() +
                               "/" + arqFonte.getName());
                        Arquivos.salvarArquivo(novoArquivo, texto);
                        ArquivoFonte novoArquivoFonte = new ArquivoFonte(novoArquivo);
                        while (novosArquivosFontes.size() < (nro - 1)) {
                            novosArquivosFontes.add(null);
                        }
                        novosArquivosFontes.add(nro - 1, novoArquivoFonte);
                    }
                } catch (NumberFormatException ex) {
                    //ignorando
                }
            }
        }
        aluno.setFontes((ArquivoFonte[])novosArquivosFontes.toArray(new ArquivoFonte[] {}));
    }
    
    /**
     * Compila todos os arquivos de um determinado aluno.
     */
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
    
    /**
     * Corrige todos os arquivos .pas de um determinado aluno, tendo em vista que
     * já foram inseridos as Entradas e Gabaritos para cada questão.
     */
    public void corrigir() {
        ArrayList<Questao> questoes = PastaCorrecao.getInstancia().getQuestoes();
        ArquivoFonte[] arquivosFonte = aluno.getFontes();
        aluno.reiniciarContagem();
        int nroQuestoes = PastaCorrecao.getInstancia().getQuestoes().size();
        int limite = 0;
        
        if (nroQuestoes > arquivosFonte.length) {
            limite = arquivosFonte.length;
        } else {
            limite = nroQuestoes;
        }
        
        for (int i = 0; i <= limite - 1; i++) {
            ArquivoFonte arqFonte = arquivosFonte[i];
            ArrayList<Saidas> saidas = null;
            ArrayList<Double> pesos = arqFonte.getPorcentagens();
            double notaMax = PastaCorrecao.getInstancia().getQuestoes().get(i).getNotaMax();
            if (arqFonte != null) {
                ArrayList<Teste> testes = questoes.get(i).getTestes();
                saidas = new ArrayList<Saidas>();
                double notaFinal = 0;
                for (int j = 0; j <= testes.size() - 1; j++) {
                    Teste teste = testes.get(j);
                    String textoSaida = arqFonte.corrigir(teste.getEntradaConcatenada());
                    String textoRelatorio = arqFonte.testarGabarito(teste, textoSaida);
                    Saidas saida = new Saidas(textoSaida, textoRelatorio);
                    saidas.add(saida);
                    notaFinal += (pesos.get(j).intValue() * (notaMax * teste.getPorcentagemNotaMax())) / 10000;
                }
                aluno.addNotaQuestao((int) notaFinal);
            } else {
                aluno.addNotaQuestao(0);
            }
            arqFonte.setSaidas(saidas);
        }
    }
    
}