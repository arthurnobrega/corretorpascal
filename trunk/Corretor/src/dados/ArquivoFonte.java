package dados;

import corretor.Executador;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import dados.Saidas;

/**
 * Classe que guarda informa��es de um determinado arquivo fonte de um aluno.
 */
public class ArquivoFonte implements Serializable {
    
    private boolean erroCompilacao = false;
    private File arquivo = null;
    private ArrayList<Saidas> saidas = null;
    private ArrayList<Integer> notas = null;
    private ArrayList<Long> tempoExecucao = null;
    
    /**
     * Cria uma nova inst�ncia da classe ArquivoFonte.
     * @param arquivo O endere�o do arquivo fonte.
     */
    public ArquivoFonte(File arquivo) {
        this.arquivo = arquivo;
        notas = new ArrayList<Integer>();
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
     * Retorna true se ocorreu erro de compila��o no arquivo e false caso contr�rio.
     */
    public boolean getErroCompilacao() {
        return erroCompilacao;
    }
    
    /**
     * Seta se ocorreu um erro de compila��o para este arquivo fonte.
     * @param erroCompilacao O valor booleano que diz se ocorreu um erro de compila��o.
     */
    public void setErroCompilacao(boolean erroCompilacao) {
        this.erroCompilacao = erroCompilacao;
        PastaCorrecao.setModificado(true);
    }
    
    /**
     * Retorna a lista de sa�das que tem o mesmo tamanho do n�mero de entradas
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
        PastaCorrecao.setModificado(true);
    }
    
    /**
     * Retorna a nota de uma determinada entrada para este arquivo fonte.
     * @param indice O �ndice da nota que se quer ter acesso.
     */
    public int getNota(int indice) {
        return notas.get(indice).intValue();
    }
    
    
    /**
     * Adiciona uma nota para este arquivo fonte. Lembrando que o �ndice da nota
     * est� ligado diretamente � ordem das entradas fornecidas.
     */    
    public void addNota(int nota) {
        notas.add(new Integer(nota));
    }
    
    /**
     * Retorna a nota total deste arquivo fonte que � a soma das notas dividida
     * pelo n�mero delas. 
     */
    public int getNotaTotal() {
        int somaNotas = 0;
        int nroNotas = notas.size();
        for (int i = 0; i <= nroNotas - 1; i++) {
            somaNotas += notas.get(i).intValue();
        }
        return somaNotas/nroNotas;
    }
    
    /**
     * Corrige o arquivo fonte para uma determinada entrada fornecida.
     * @return A sa�da que o programa gerou para a entrada em forma de String.
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
     * Testa se a saida e o gabarito informados s�o equivalentes.
     * @param saida A saida que se deseja testar com o gabarito.
     * @param gabarito O gabarito para se testar a saida.
     */
    public String testarGabarito(String saida, String gabarito) {
        String relatorio = new String();
        String[] linhasSaida = saida.split("\n"), linhasGabarito = gabarito.split("\n");
        int nroSaida = linhasSaida.length, nroGabarito = linhasGabarito.length, 
                limite, nroAcertos = 0, nota;        
        
        limite = nroGabarito;
        
        if (nroSaida < nroGabarito) {
            limite = nroSaida;
        }
        
        for (int i = 0; i <= limite - 1; i++) {
            if (linhasSaida[i].contains(linhasGabarito[i])) {
                relatorio += "Acertou o quesito " + (i + 1) + "\n";
                        
                nroAcertos += 1;
            } else {
                relatorio += "Errou o quesito " + (i + 1) + "\n";
            }
            relatorio += "          Gabarito: (" + linhasGabarito[i] +
                        ")\n          Sa�da do Aluno: (" + linhasSaida[i] + ")\n";
        }
        
        if (nroAcertos == nroGabarito) {
            nota = 100;
        } else {
            nota = 0;
        }
        //nota = (int) (100 * ((double)nroAcertos / (double)nroGabarito));
        relatorio += "\nNota (0 ou 100): " + nota;
        this.addNota(nota);
        PastaCorrecao.setModificado(true);
        return relatorio;
    }
    
    /**
     * Retorna o tempo de execu��o de acordo com o n�mero da entrada.
     * @param indice N�mero da entrada para o arquivo fonte que gerou o tempo.
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
        PastaCorrecao.setModificado(true);
    }
    
}