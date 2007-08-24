package br.unb.cic.corretor.gui;

/**
 * Classe que é utilizada para armazenar as constantes que serão chamadas no
 * decorrer do programa, tanto quando ocorrer um erro e quiser mostrar os dados
 * para o usuário, quanto para pegar os nomes de arquivos padrões do programa. 
 * @author arthurthiago
 *
 */
public class Constantes {
	
	/* Constantes para os nomes dos arquivos que serão utilizados no programa. */
	public final static String ARQ_ANOTACOES = "Anotações";
	public final static String ARQ_RELATORIO = "Relatório";
	public final static String ARQ_ENTRADA = "entrada";
	public final static String ARQ_GABARITO = "gabarito";
	public final static String ARQ_SAIDA = "saida";
	
	/* Constantes para as mensagens de erros que poderão ocorrer no uso do programa. */
	public final static String ERRO_CORRECAO = "Ocorreu um erro ao rodar o programa de Correção.";
	public final static String ERRO_LEITURA = "Ocorreu um erro ao tentar ler o arquivo!";
	public final static String ERRO_SALVAR = "Ocorreu um erro ao tentar salvar o arquivo!";
	public final static String ERRO_DIRETORIO = "Diretório inválido. Por favor informe um diretório que contenha somente os *.pas.";

}
