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
            
            if (entrada != null && saida != null) {
                InputStream in = proc.getInputStream();
                int c;
                StringBuilder texto = new StringBuilder();
                StringTokenizer tokenizer = new StringTokenizer(entrada);
                String token = null;
                while (tokenizer.hasMoreTokens()) {
                    while ((c = in.read()) != -1) {
                        if (c == 13) {
                            OutputStream out = proc.getOutputStream();
                            token = tokenizer.nextToken();
                            out.write(token.getBytes());
                        }

                        char caracter = (char) c;
                        texto.append(caracter);
                    }
                }
                Arquivos.salvarArquivo(saida, texto.toString());
                in.close();
            }
            
            // alguma mensagem de erro?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");

            // alguma saï¿½da?
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
                while ( (line = br.readLine()) != null)
                    System.out.println(type + ">" + line);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        public BufferedReader getBufferedReader() {
            return br;
        }
    }
}