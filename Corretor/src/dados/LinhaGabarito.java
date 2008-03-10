package dados;

import java.io.Serializable;

/**
 *
 * @author UltraXP
 */
public class LinhaGabarito implements Serializable {
    
    private String[] linha = null;

    /** Creates a new instance of Testes */
    public LinhaGabarito(String[] linha) {
        this.linha = linha;
    }
    
    public String[] getLinha() {
        return linha;
    }
    
    public String getLinhaString() {
        String strLinha = new String();
        for (int i = 0; i <= linha.length - 1; i++) {
            if (i == linha.length - 1) {
                strLinha += linha[i];
                break;
            }
            strLinha += linha[i] + " ";
        }
        return strLinha;
    }
    
    public String getColuna(int indice) {
        return linha[indice];
    }
    
    public void setLinha(String[] linha) {
        this.linha = linha;
    }

}