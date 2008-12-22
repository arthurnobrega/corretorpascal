package corretor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;
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
    boolean travou = false;
 
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
     * Executa um determinado processo com os parâmetros passados no construtor.
     */
    public void executar() {
        try {
            Runtime rt = Runtime.getRuntime();
            String texto = "";
            for (int i = 0; i <= args.length - 1; i++) {
                texto += args[i] + " ";
            }
            System.out.println("Executando:" + texto + "no diretório " + diretorio.getAbsolutePath());
            File dirFpc = new File(System.getProperty("user.dir") + "fpc");
            String[] env = new String[] {"PATH=" + System.getenv("PATH") +
                ";" + dirFpc.getAbsolutePath()};
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
                out.write((entrada).getBytes());
                
            while (outputGobbler.isAlive()) {
                Thread.currentThread().sleep(100);
                if (System.currentTimeMillis() - tempoInicial >
                        Constantes.getTempoMaximoExecucao()) {
                    proc.destroy();
                    String processo = args[2].substring(0, args[2].length() - 4);
                    String[] argsD = new String[] { "cmd", "/C", "tskill", processo};
                    Executador exec = new Executador(diretorio, argsD, null);
                    exec.executar();
                }
            }
                
//                testarTravamento();
                
                exitVal = proc.waitFor();
                saida = outputGobbler.getSaida();
            } else {
//                testarTravamento();
                while (outputGobbler.isAlive()) {
                    Thread.currentThread().sleep(100);
                    if (System.currentTimeMillis() - tempoInicial >
                            Constantes.getTempoMaximoExecucao()) {
                        proc.destroy();
                        String processo = args[2].substring(0, args[2].length() - 4);
                        String[] argsD = new String[] { "cmd", "/C", "tskill", processo};
                        Executador exec = new Executador(diretorio, argsD, null);
                        exec.executar();
                        outputGobbler.interrupt();
                        break;
                    }
                }
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
    
    private void testarTravamento() {
        travou = false;
        new TimeKiller(outputGobbler, Constantes.getTempoMaximoExecucao());
        try {
            System.out.println(
            (new Date()) + "  Starting fifty-milisecond pause...");
            outputGobbler.sleep(50);
	    } catch (InterruptedException e) {
            System.out.println(
            (new Date()) + "  Caught InterruptedException");
	    } catch (ThreadDeath e) {
            System.out.println((new Date()) + "  Caught ThreadDeath");
            throw e;
	    }
        System.out.println((new Date()) + "  Oops - pauses finished!");
	}

    /**
     * Classe interna utilizada para capturar as saídas e mensagens de erro
     * de um determinado processo.
     */
    class StreamGobbler extends Thread {
        InputStream is;
        String saida = null;
        String type;

        public StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
            this.saida = new String();
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(type + ">" + line);
                    saida += line + "\n";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * Retorna a saída do processo.
         */
        public String getSaida() {
            return saida;
        }
    }

    class TimeKiller implements Runnable {
        private Thread targetThread;
        private long millis;
        private Thread watcherThread;
        private boolean loop;
        private boolean enabled;

        /// Constructor.  Give it a thread to watch, and a timeout in milliseconds.
        // After the timeout has elapsed, the thread gets killed.  If you want
        // to cancel the kill, just call done().
        public TimeKiller(Thread targetThread, long millis) {
            this.targetThread = targetThread;
            this.millis = millis;
            watcherThread = new Thread(this);
            enabled = true;
            watcherThread.start();
            // Hack - pause a bit to let the watcher thread get started.
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {}
        }

        /// Constructor, current thread.
        public TimeKiller(long millis) {
            this(Thread.currentThread(), millis);
        }

        /// Call this when the target thread has finished.
        public synchronized void done() {
            loop = false;
            enabled = false;
            notify();
        }

        /// Call this to restart the wait from zero.
        public synchronized void reset() {
            loop = true;
            notify();
        }

        /// Call this to restart the wait from zero with a different timeout value.
        public synchronized void reset(long millis) {
            this.millis = millis;
            reset();
        }

        /// The watcher thread - from the Runnable interface.
        // This has to be pretty anal to avoid monitor lockup, lost
        // threads, etc.
        public synchronized void run() {
            Thread me = Thread.currentThread();
            me.setPriority(Thread.MAX_PRIORITY);
            if (enabled) {
                do {
                    loop = false;
                    try {
                        wait(millis);
                    }
                    catch (InterruptedException e) {}
                }
                while (enabled && loop);
            }
            if (enabled && targetThread.isAlive()) {
                targetThread.interrupt();
                travou = true;
                proc.destroy();
                String processo = args[2].substring(0, args[2].length() - 4);
                String[] argsD = new String[] { "cmd", "/C", "tskill", processo};
                Executador exec = new Executador(diretorio, argsD, null);
                exec.executar();
            }
        }
    }
}