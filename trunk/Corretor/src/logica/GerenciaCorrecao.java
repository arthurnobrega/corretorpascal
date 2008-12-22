package logica;

import dados.Aluno;
import corretor.Correcao;
import dados.LinhaGabarito;
import dados.ListaQuestoes;
import dados.PastaCorrecao;
import dados.Questao;
import dados.Teste;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe utilizada para gerenciar a correção das questões. Tem como presuposto
 * que a lista de Entradas/Gabaritos não é nula.
 */
public class GerenciaCorrecao {
     
    private static GerenciaCorrecao instancia = null;
    int nroExecucao = 0;
    
    public GerenciaCorrecao() {
        instancia = this;
    }
    
    public static GerenciaCorrecao getInstancia() {
        return instancia;
    }
    
    public int getNumeroExecucao() {
        return nroExecucao;
    }
    
    /**
     * Corrige todos os arquivos chamando métodos mais internos.
     */
    public void corrigir() {
        /*BarraProgresso barra = new BarraProgresso(Principal.getInstancia());
        Thread thread = new Thread(barra);
        thread.start();*/
        
        Aluno[] alunos = PastaCorrecao.getInstancia().getAlunos();
        int mult = 100 / alunos.length;
        int nro = 0;
//        MyDialog dialog = new MyDialog();
//        new Thread(dialog).start();
        for (Aluno aluno : alunos) {
            nroExecucao = ++nro * mult;
            // Corrige todos os arquivos fontes de cada aluno.
            Correcao cor = new Correcao(aluno);
            cor.corrigir();
            GerenciaSerializacao gerSer = new GerenciaSerializacao();
            gerSer.serializar();
        }
        criarArquivosTestes();
        nroExecucao = 100;
    }
    
    
    
    public void criarArquivosTestes() {
        ArrayList<Questao> listaQuestoes = ListaQuestoes.getArrayListQuestoes();
        int i = 1;
        File pastaCor = new File(PastaCorrecao.getInstancia().getDiretorio().getAbsolutePath() + 
                    "/correcao");
        if (pastaCor.mkdir()) {
            for (Questao questao : listaQuestoes) {
                File pastaQuestao = new File(pastaCor.getAbsolutePath() + 
                        "/questao" + i);
                if (pastaQuestao.mkdir()) {
                    ArrayList<Teste> testes = questao.getTestes();
                    int j = 1;
                    for (Teste teste : testes) {
                        String gabarito = new String();
                        File arqTeste = new File(pastaQuestao.getAbsolutePath() +
                                "/teste" + j + ".txt");
                        ArrayList<LinhaGabarito> linhasGabarito = teste.getLinhasGabarito();
                        for (LinhaGabarito linhaGabarito : linhasGabarito) {
                            gabarito += linhaGabarito.getLinhaString() + "\n";
                        }
                        String texto = "---------------ENTRADA---------------\n" + 
                                teste.getEntradaConcatenada() +
                                "\n---------------GABARITO---------------\n" +
                                gabarito;
                        try {
                            Arquivos.salvarArquivo(arqTeste, texto);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        j++;
                    }   
                }
                i++;
            }
        }
    }
}
