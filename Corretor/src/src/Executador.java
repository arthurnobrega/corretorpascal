package src;

import java.io.BufferedReader;
import java.io.File;

public class Executador{
    
    private int exitVal = 0;
    private BufferedReader br = null;
    private String args = null;
 
    public Executador(File diretorio, String args) {
        
        try {
            /*
            String osName = System.getProperty("os.name");
            String[] cmd = new String[3];
            if (osName.equals("Windows NT") || osName.equals("Windows XP")) {
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                cmd[2] = args;
            } else if (osName.equals("Linux")) {
                cmd[0] = diretorio.getAbsolutePath() + "/" + args;
                cmd[1] = "";
                cmd[2] = "";
            } else if (osName.equals("Windows 95")) {
                cmd[0] = "command.com";
                cmd[1] = "/C";
                cmd[2] = args;
            }
             */

            Runtime rt = Runtime.getRuntime();
            System.out.println("Setando diretório: " + diretorio.getAbsolutePath());
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
            
            System.out.println("ExitValue: " + exitVal);
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