package src;

import java.io.BufferedReader;
import java.io.File;

public class Executador{
    
    private int exitVal = 0;
    private BufferedReader br = null;
    private String args = null;
 
    public Executador(File diretorio, String args, String entrada, File saida) {
        
        try {
            Runtime rt = Runtime.getRuntime();
            System.out.println("Setando diret�rio: " + diretorio.getAbsolutePath());
            System.out.println("Executando: " + args);
            String[] env = new String[] {"PATH=" + System.getenv("PATH")};
            Process proc = rt.exec(args, env, diretorio);
            
            // alguma mensagem de erro?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");

            // alguma sa�da?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");

            errorGobbler.start();
            outputGobbler.start();
            
            br = outputGobbler.getBufferedReader();            
            exitVal = proc.waitFor();
            
            System.out.println("Valor de Sa�da: " + exitVal);
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