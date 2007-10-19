package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.StringTokenizer;
import log.Constantes;

public class Executador {
    
    private int exitVal = 0;
    private BufferedReader br = null;
    private String args = null;
    private File diretorio = null ;
    private String entrada = null;
    private File saida = null;
 
    public Executador(File diretorio, String args, String entrada, File saida) {
        this.diretorio = diretorio;
        this.args = args;
        this.entrada = entrada;
        this.saida = saida;
    }

    public void executar() {
        try {
            Runtime rt = Runtime.getRuntime();
            System.out.println("Setando diretório: " + diretorio.getAbsolutePath());
            System.out.println("Executando: " + args);
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
            
            if (saida != null && entrada != null) {
                Arquivos.salvarArquivo(saida, "");
                OutputStream out = proc.getOutputStream();
                out.write((entrada + "\n\n").getBytes());
                out.close();
                br = outputGobbler.getBufferedReader();
                String linha = null;
            }
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
    
    
    class StreamGobbler extends Thread {
        InputStream is = null;
        String type = null;
        BufferedReader br = null;

        StreamGobbler(InputStream is, String type) {
            this.is = is;
            this.type = type;
        }

        public void run() {
            try {
                InputStreamReader isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String line = null;
                while ( (line = br.readLine()) != null) {
                    System.out.println(type + ">" + line);
                    if (type.equals(Constantes.TS_SAI) && saida != null) {
                        String texto = Arquivos.getTextoArquivo(saida);
                        Arquivos.salvarArquivo(saida, texto + line);
                    }
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        public BufferedReader getBufferedReader() {
            return br;
        }
    }
}