package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import log.Constantes;

public class Executador {
    
    private int exitVal = 0;
    private BufferedReader br = null;
    private String[] args = null;
    private File diretorio = null ;
    private String entrada = null;
    private String saida = null;
 
    public Executador(File diretorio, String[] args, String entrada) {
        this.diretorio = diretorio;
        this.args = args;
        this.entrada = entrada;
    }

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
                StreamGobbler(proc.getErrorStream(), Constantes.TS_ERR);

            // alguma saï¿½da?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), Constantes.TS_SAI);

            errorGobbler.start();
            outputGobbler.start();
            
            if (entrada != null) {
                OutputStream out = proc.getOutputStream();
                out.write((entrada + "\n\n").getBytes());
                out.close();
                
                while(outputGobbler.isAlive()) { }
                saida = outputGobbler.getSaida();
            }
            exitVal = proc.waitFor();
            
            System.out.println("Valor de Saída: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public String getSaida() {
        return saida;
    }
    
    public int getValorSaida() {
        return exitVal;
    }
    
    public BufferedReader getBufferSaida() {
        return br;
    }
    
    
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

        public String getSaida() {
            return saida;
        }
    }
}