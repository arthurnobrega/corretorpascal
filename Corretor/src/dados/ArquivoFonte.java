package dados;

import corretor.Executador;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import dados.Saidas;
import logica.Utilitarios;

/**
 * Classe que guarda informações de um determinado arquivo fonte de um aluno.
 */
public class ArquivoFonte implements Serializable {
    
    private boolean erroCompilacao = false;
    private File arquivo = null;
    private ArrayList<Saidas> saidas = null;
    private ArrayList<Double> notas = null;
    private ArrayList<Long> tempoExecucao = null;
    
    /**
     * Cria uma nova instância da classe ArquivoFonte.
     * @param arquivo O endereço do arquivo fonte.
     */
    public ArquivoFonte(File arquivo) {
        this.arquivo = arquivo;
        notas = new ArrayList<Double>();
        saidas = new ArrayList<Saidas>();
        tempoExecucao = new ArrayList<Long>();
    }
    
    /**
     * Retorna o objeto File para o arquivo fonte.
     */
    public File getArquivo() {
        return arquivo;
    }
    
    /**
     * Retorna true se ocorreu erro de compilação no arquivo e false caso contrário.
     */
    public boolean getErroCompilacao() {
        return erroCompilacao;
    }
    
    /**
     * Seta se ocorreu um erro de compilação para este arquivo fonte.
     * @param erroCompilacao O valor booleano que diz se ocorreu um erro de compilação.
     */
    public void setErroCompilacao(boolean erroCompilacao) {
        this.erroCompilacao = erroCompilacao;
        PastaCorrecao.getInstancia().setModificado(true);
    }
    
    /**
     * Retorna a lista de saídas que tem o mesmo tamanho do número de entradas
     * fornecidas.
     */
    public ArrayList<Saidas> getSaidas() {
        return saidas;
    }
    
    /**
     * Seta a lista de saidas para este arquivo fonte.
     */
    public void setSaidas(ArrayList<Saidas> saidas) {
        this.saidas = saidas;
        PastaCorrecao.getInstancia().setModificado(true);
    }
    
    /**
     * Retorna a nota de uma determinada entrada para este arquivo fonte.
     * @param indice O índice da nota que se quer ter acesso.
     */
    public double getPorcentagem(int indice) {
        return notas.get(indice).doubleValue();
    }
    
    public ArrayList<Double> getPorcentagens() {
        return notas;
    }
    
    
    /**
     * Adiciona uma nota para este arquivo fonte. Lembrando que o índice da nota
     * está ligado diretamente à ordem das entradas fornecidas.
     */    
    public void adicionarPorcentagem(double nota) {
        notas.add(new Double(nota));
    }
    
    /**
     * Retorna a nota total deste arquivo fonte que é a soma das notas dividida
     * pelo número delas. 
     */
    public double getPorcentagemTotal() {
        double somaNotas = 0;
        int nroNotas = notas.size();
        for (int i = 0; i <= nroNotas - 1; i++) {
            somaNotas += notas.get(i).doubleValue();
        }
        return somaNotas/nroNotas;
    }
    
    /**
     * Corrige o arquivo fonte para uma determinada entrada fornecida.
     * @return A saída que o programa gerou para a entrada em forma de String.
     */
    public String corrigir(String entrada) {
        String saida = null;
        String[] args = new String[] { "cmd", "/C",
            arquivo.getName().substring(0, arquivo.getName().length() - 4) + ".exe" };
        Executador ex = new Executador(arquivo.getParentFile(), args, entrada);
        ex.executar();
        tempoExecucao.add(ex.getTempoExecucao());
        saida = ex.getSaida();
        
        return saida;
    }
    
    
    /**
     * Testa se a saida e o gabarito informados são equivalentes.
     * @param saida A saida que se deseja testar com o gabarito.
     * @param gabarito O gabarito para se testar a saida.
     */
    public String testarGabarito(Teste teste, String saida) {
        ArrayList<LinhaGabarito> linhasGabarito = teste.getLinhasGabarito();
        ModeloLinhaGabarito modeloLinhaGabarito = teste.getModeloLinhaGabarito();
        String relatorio = new String();
        String[] linhasSaida = null;
        int limiteLinhas = 0;
        int nroAcertos = 0;
        int nota = 0;
        ArrayList<Integer> colunasErradas = new ArrayList<Integer>();
        
        linhasSaida = saida.split("\n");
        
        limiteLinhas = linhasGabarito.size();
        if (linhasSaida.length < linhasGabarito.size()) {
            limiteLinhas = linhasSaida.length;
        }
        
        for (int i = 0; i <= limiteLinhas - 1; i++) {
            int limiteColunas = 0;
            String[] colunasLinha = null;
            
            colunasErradas.clear();
            
            colunasLinha = linhasSaida[i].split(" ");
            colunasLinha = Utilitarios.retirarElementosNulos(colunasLinha);
            
            limiteColunas = modeloLinhaGabarito.getNroColunas();
            if (colunasLinha.length < modeloLinhaGabarito.getNroColunas()) {
                limiteColunas = colunasLinha.length;
            }
            for (int j = 0; j <= limiteColunas - 1; j++) {
                String tipo = modeloLinhaGabarito.getColuna(j);
                if (tipo.equals("String")) { //String
                    if (!Utilitarios.compararStrings(colunasLinha[j], linhasGabarito.get(i).getColuna(j))) {
                        colunasErradas.add(new Integer(j));
                    }
                } else if (tipo.equals("Inteiro")) { //Inteiro
                    if (!Utilitarios.compararInteiros(colunasLinha[j], linhasGabarito.get(i).getColuna(j))) {
                        colunasErradas.add(new Integer(j));
                    }
                } else if (tipo.equals("Real")) { //Real
                    if (!Utilitarios.compararReais(colunasLinha[j], linhasGabarito.get(i).getColuna(j))) {
                        colunasErradas.add(new Integer(j));
                    }
                }
            }
            if (colunasErradas.isEmpty()) {
                relatorio += "Acertou a linha " + (i + 1) + "\n" + 
                        "          Gabarito: (" + linhasGabarito.get(i).getLinhaString() +
                        ")\n          Saída do Aluno: (" + linhasSaida[i] + ")\n";
                nroAcertos++;
            } else {
                relatorio += "Errou a linha " + (i + 1) + "\n" +
                        "          Gabarito: (" + linhasGabarito.get(i).getLinhaString() +
                        ")\n          Saída do Aluno: (" + linhasSaida[i] + ")\n";
            }
        }
        
        if (nroAcertos == linhasGabarito.size()) {
            nota = 100;
        } else {
            nota = 0;
        }
        relatorio += "\nNota (0 ou 100)%: " + nota;
        this.adicionarPorcentagem(nota);
        PastaCorrecao.getInstancia().setModificado(true);
        return relatorio;
    }
    
    /**
     * Retorna o tempo de execução de acordo com o número da entrada.
     * @param indice Número da entrada para o arquivo fonte que gerou o tempo.
     */
    public long getTempoExecucao(int indice) {
        return tempoExecucao.get(indice);
    }
        
    /**
     * Reinicia a contagem das notas deste arquivo fonte. Lembrando que para
     * cada entrada/gabarito o arquivo fonte tem uma nota.
     */
    public void reiniciarContagem() {
        saidas.clear();
        notas.clear();
        tempoExecucao.clear();
        PastaCorrecao.getInstancia().setModificado(true);
    }
    
}