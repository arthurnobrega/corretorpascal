package corretor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import logica.Constantes;

/**
 * Classe que executa processos externos.
 */
public class Executador {
    
    private int exitVal = 0;
    private BufferedReader br = null;
    private String[] args = null;
    private File diretorio = null ;
    private String entrada = null;
    private String saida = null;
    private long tempoExecucao = 0;
 
    /**
     * Cria uma nova instância da classe Executador.
     * @param diretorio O diretório padrão que terá o processo.
     * @param args Um vetor de argumentos que serão executados no processo.
     * @param entrada A entrada que o processo terá.
     */
    public Executador(File diretorio, String[] args, String entrada) {
        this.diretorio = diretorio;
        this.args = args;
        this.entrada = entrada;
    }

    /**
     * Executa um determinado processo com os parâmetros passado no construtor.
     */
    public void executar() {
        try {
            Runtime rt = Runtime.getRuntime();
            System.out.println("Setando diretório: " + diretorio.getAbsolutePath());
            System.out.print("Executando: ");
            for (int i = 0; i <= args.length - 1; i++) {
                System.out.print(args[i] + " ");
            }
            System.out.println();
            String[] env = new String[] {"PATH=" + System.getenv("PATH")};
            Process proc = rt.exec(args, env, diretorio);
            
            // alguma mensagem de erro?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERRO");

            // alguma saída?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "SAÍDA");

            tempoExecucao = System.currentTimeMillis();
            errorGobbler.start();
            outputGobbler.start();
            
            if (entrada != null) {
                OutputStream out = proc.getOutputStream();
                out.write((entrada + "\n\n").getBytes());
                out.close();
                
                while(outputGobbler.isAlive()) { }
                saida = outputGobbler.getSaida();
            }
            tempoExecucao = System.currentTimeMillis() - tempoExecucao;
            exitVal = proc.waitFor();
            
            System.out.println("Valor de Saída: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Retorna o tempo de execução do processo.
     */
    public long getTempoExecucao() {
        return tempoExecucao;
    }
    
    /**
     * Retorna a saída do processo.
     */
    public String getSaida() {
        return saida;
    }
    
    /**
     * Retorna o valor de saída do processo.
     */
    public int getValorSaida() {
        return exitVal;
    }   
    
    /**
     * Classe interna utilizada para capturar as saídas e mensagens de erro
     * de um determinado processo.
     */
    class StreamGobbler extends Thread {
        InputStream is = null;
        String type = null;
        String saida = null;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
            this.saida = new String();
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String line = null;
                while ( (line = br.readLine()) != null) {
                    System.out.println(type + ">" + line);
                    if (saida != null) {
                        saida += line + "\n";
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        /**
         * Retorna a saída do processo.
         */
        public String getSaida() {
            return saida;
        }
    }
}