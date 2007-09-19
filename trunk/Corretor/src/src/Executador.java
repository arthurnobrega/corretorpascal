package src;

import java.io.BufferedReader;

public class Executador {
    
    private int exitVal = 0;
    private BufferedReader br = null;
 
    public Executador(String args) {

        try {
            String osName = System.getProperty("os.name");
            String[] cmd = new String[3];
            if (osName.equals("Windows NT") || osName.equals("Windows XP")) {
                cmd[0] = "cmd.exe";
                cmd[1] = "/C";
                cmd[2] = args;
            } else if (osName.equals("Linux")) {
                cmd[0] = "konsole";
                cmd[1] = "";
                cmd[2] = args;
            } else if (osName.equals("Windows 95")) {
                cmd[0] = "command.com";
                cmd[1] = "/C";
                cmd[2] = args;
            }

            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + cmd[0] + " " + cmd[1] 
                               + " " + cmd[2]);
            Process proc = rt.exec(cmd);
            
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