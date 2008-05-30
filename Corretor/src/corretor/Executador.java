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
    private StreamGobbler outputGobbler = null;
    private static Process proc = null;
 
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
            String texto = "";
            for (int i = 0; i <= args.length - 1; i++) {
                texto += args[i] + " ";
            }
            System.out.println("Executando:" + texto);
            String[] env = new String[] {"PATH=" + System.getenv("PATH")};
//            File dirFpc = new File(PastaCorrecao.getInstancia().getDiretorio().
//                    getParentFile().getAbsolutePath() + "/fpc/bin/i386-win32/;");
//            String[] env = new String[] {"PATH=" + dirFpc};
            proc = rt.exec(args, env, diretorio);
            
            // alguma mensagem de erro?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERRO");

            // alguma saída?
            outputGobbler = new StreamGobbler(proc.getInputStream(), "SAÍDA");

            long tempoInicial = System.currentTimeMillis();
            errorGobbler.start();
            outputGobbler.start();
            
            if (entrada != null) {
                OutputStream out = proc.getOutputStream();
                out.write((entrada + "8\n8\n8\n8\n8\n8\n8\n8\n8\n8" +
                        "\n8\n8\n8\n8\n8\n8\n8\n8\n8\n8\n8\n8\n").getBytes());
                out.close();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(Constantes.getTempoMaximoExecucao());
                        } catch (InterruptedException e) {
                            //ignorando
                        }
                        if (outputGobbler.isAlive()) {
                            proc.destroy();
                            String processo = args[2].substring(0, args[2].length());
                            String[] argsD = new String[] { "cmd", "/C", "tskill", processo};
                            Executador exec = new Executador(diretorio, argsD, null);
                            exec.executar();
                        }
                    } 
                }).start();
                exitVal = proc.waitFor();
                saida = outputGobbler.getSaida();
            } else {
                exitVal = proc.waitFor();
            }
            tempoExecucao = System.currentTimeMillis() - tempoInicial;
             
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
        boolean flagParar = false;
        
        public void parar() {  
            flagParar = true;  
        } 

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
                    if (flagParar) {
                        System.out.flush();
                        return;
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