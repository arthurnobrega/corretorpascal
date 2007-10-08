package src;

import java.io.BufferedReader;
import java.io.File;

public class Executador{
    
    private int exitVal = 0;
    private BufferedReader br = null;
    private String args = null;
 
    public Executador(File diretorio, String args, File entrada, File saida) {
        
        try {
            Runtime rt = Runtime.getRuntime();
            System.out.println("Setando diretório: " + diretorio.getAbsolutePath());
            System.out.println("Executando: " + args);
            String[] env = new String[] {"PATH=" + System.getenv("PATH")};
            Process proc = rt.exec(args, env, diretorio);
            
            // alguma mensagem de erro?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");

            // alguma saída?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");

            errorGobbler.start();
            outputGobbler.start();
            
            br = outputGobbler.getBufferedReader();            
            exitVal = proc.waitFor();
            
            System.out.println("Valor de Saída: " + exitVal);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    public int getValorSaida() {
        return exitVal;
    }
    
    public BufferedReader getBufferSaida() {
        return br;
    }
}