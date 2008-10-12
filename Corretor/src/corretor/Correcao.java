package corretor;

import dados.Questao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import logica.Arquivos;
import logica.Constantes;
import dados.Aluno;
import dados.ArquivoFonte;
import dados.ListaQuestoes;
import dados.PastaCorrecao;
import dados.Teste;
import dados.Saidas;
import logica.Utilitarios;

/**
 * 
 */
public class Correcao {
    
    Aluno aluno = null;
    
    private static Correcao instancia = null;
    
    /** Cria uma nova instância da classe Correcao. */
    public Correcao(Aluno aluno) {
        this.aluno = aluno;
        instancia = this;
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
    
    public void criarArquivoQuestoesAluno() throws IOException {
        ArquivoFonte[] fontes = aluno.getFontes();
        String nomeAluno = aluno.getDiretorioAluno().getName();
        String texto = nomeAluno + "\n\n";
        int cont = 1;
        for (ArquivoFonte fonte : fontes) {
            if (fonte != null) {
                File arquivo = fonte.getArquivo();
                texto += "-----------------------" + "Questao " + cont + 
                        "-----------------------\n";
                texto += Arquivos.getTextoArquivo(arquivo) + "\n\n";
            }
            cont++;
        }
        File dirRelatorios = new File(PastaCorrecao.getInstancia().getDiretorio() +
                "/relatorios/");
        if (!dirRelatorios.exists()) dirRelatorios.mkdir();
        File arqAluno = new File(dirRelatorios + "/" + nomeAluno + ".txt");
        Arquivos.salvarArquivo(arqAluno, texto);
    }
    
    public void adicionaRelatorioArquivoAluno(int nroQuestao, ArrayList<Saidas> saidas) throws IOException {
        String nomeAluno = aluno.getDiretorioAluno().getName();
        File dirRelatorios = new File(PastaCorrecao.getInstancia().getDiretorio() +
                "/relatorios/");
        File arqAluno = new File(dirRelatorios.getAbsolutePath() +
                "/" + nomeAluno + ".txt");
        String texto = Arquivos.getTextoArquivo(arqAluno) + "\n\n";
        String abertura = "----------> RELATORIO DA QUESTAO " + (nroQuestao + 1) + " <----------";
        if (texto.contains(abertura)) {
            int indice = texto.indexOf(abertura);
            texto = texto.substring(0, indice);
        }
        texto += abertura + "\n\n";
        texto += "TESTE\tSAIDA DO PROGRAMA DO ALUNO\tGABARITO\tNOTA\n";
        ArrayList<Teste> testes = ListaQuestoes.getArrayListQuestoes().get(nroQuestao).getTestes();
        for (int i = 0; i <= saidas.size() - 1; i++) {
            Saidas saida = saidas.get(i);
            for (int j = 0; j <= saida.getLinhasSaida().size() - 1; j++) {
                String linhaSaida = saida.getLinhasSaida().get(j);
                if (testes.get(i).getLinhasGabarito().size() > j) {
                    String[] linhasGabarito = testes.get(i).getLinhaGabarito(j).getLinhaString().split("\n");
                    String linhaGabarito = linhasGabarito[0];
                    if (linhaSaida.length() > 26) {
                        linhaSaida = linhaSaida.substring(0, 23) + "...";
                    } else {
                        linhaSaida = Utilitarios.preencheCom(linhaSaida, " ", 26, 2);
                    }
                    if (linhaGabarito.length() > 8) {
                        linhaGabarito = linhaGabarito.substring(0, 7) + "...";
                    } else {
                        linhaGabarito =Utilitarios.preencheCom(linhaGabarito, " ", 8, 2);
                    }
                    double notaQuestao = aluno.getFontes()[nroQuestao].getPorcentagem(i);
                    texto += (i + 1) + "\t\t" + linhaSaida + "\t" + linhaGabarito + "\t" + notaQuestao + "\n";
                }
            }
        }
        Arquivos.salvarArquivo(arqAluno, texto);
    }
    
    public void adicionaRelatorioArquivoAluno(int nroQuestao, String mensagem) throws IOException {
        String nomeAluno = aluno.getDiretorioAluno().getName();
        File dirRelatorios = new File(PastaCorrecao.getInstancia().getDiretorio() +
                "/relatorios/");
        File arqAluno = new File(dirRelatorios.getAbsolutePath() +
                "/" + nomeAluno + ".txt");
        String texto = Arquivos.getTextoArquivo(arqAluno) + "\n\n";
        texto += "----------> RELATORIO DA QUESTAO " + ++nroQuestao + " <----------";
        texto += "\n\n" + mensagem;
        Arquivos.salvarArquivo(arqAluno, texto);
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
                    "cmd", "/C","fpc", arqFonte.getName()}, null);
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
        ArrayList<Questao> questoes = ListaQuestoes.getArrayListQuestoes();
        ArquivoFonte[] arquivosFonte = aluno.getFontes();
        aluno.reiniciarContagem();
        int nroQuestoes = ListaQuestoes.getArrayListQuestoes().size();
        int limite = 0;
        
        if (nroQuestoes > arquivosFonte.length) {
            limite = arquivosFonte.length;
        } else {
            limite = nroQuestoes;
        }
        
        for (int i = 0; i <= limite - 1; i++) {
            ArquivoFonte arqFonte = arquivosFonte[i];
            ArrayList<Saidas> saidas = null;
            Questao questao = ListaQuestoes.getArrayListQuestoes().get(i);
            double notaMax = questao.getNotaMax();
            
            if (arqFonte != null && !arqFonte.getErroCompilacao()) {
                ArrayList<Double> pesos = arqFonte.getPorcentagens();
                ArrayList<Teste> testes = questoes.get(i).getTestes();
                saidas = new ArrayList<Saidas>();
                double notaFinal = 0;
                
                for (int j = 0; j <= testes.size() - 1; j++) {
                    Teste teste = testes.get(j);
                    String textoSaida = "";
                    String textoEntrada = "";
                    if (teste.getNomeArquivoEntrada() != null) {
                        try {
                            String caminhoArq = arqFonte.getArquivo().getParent();
                            Arquivos.salvarArquivo(new File(caminhoArq + "/" + 
                                    teste.getNomeArquivoEntrada()), teste.getEntradaConcatenada());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        textoEntrada = teste.getEntradaConcatenada();
                    }
                    textoSaida = arqFonte.corrigir(textoEntrada);
                    if (questao.getNomeArquivoSaida() != null) {
                        File arqSaida = new File(arqFonte.getArquivo().getParent() + 
                                "/" + questao.getNomeArquivoSaida());
                        try {
                            textoSaida = Arquivos.getTextoArquivo(arqSaida);
                        } catch (IOException e) {
                            textoSaida = Constantes.SEPARADOR_MENSAGEM_ERRO + " O " +
                                    "arquivo de saída deste aluno não foi encontrado. " +
                                    Constantes.SEPARADOR_MENSAGEM_ERRO;
                        }
                    }
                    String textoRelatorio = arqFonte.testarGabarito(teste, textoSaida);
                    Saidas saida = new Saidas(textoSaida, textoRelatorio);
                    saidas.add(saida);
                    notaFinal += (pesos.get(j).intValue() * (notaMax * teste.getPorcentagemNotaMax())) / 10000;
                }
                aluno.addNotaQuestao((int) notaFinal);
                arqFonte.setSaidas(saidas);
                try {
                    adicionaRelatorioArquivoAluno(i, saidas);
                } catch (IOException e) {
                        e.printStackTrace();
                }
            } else {
                if (arqFonte.getErroCompilacao()) {
                    try {
                        adicionaRelatorioArquivoAluno(i, "Erro de Compilação nesta Questão!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (arqFonte == null) {
                    try {
                        adicionaRelatorioArquivoAluno(i, "O Aluno não fez esta Questão!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                aluno.addNotaQuestao(0);
            }
        }
    }
    
}