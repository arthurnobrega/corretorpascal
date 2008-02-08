package dados;

import java.io.Serializable;

/**
 *
 * @author UltraXP
 */
public class LinhaTeste implements Serializable {

    public static final String TIPOS[] = {"String", "Inteiro", "Real"};
    
    private int tipo = -1;
    private String valor = null;

    /** Creates a new instance of Testes */
    public LinhaTeste(String valor, String tipo) {
        this.valor = valor;
        for (int i = 0; i <= TIPOS.length - 1; i++) {
            if (TIPOS[i] == tipo) {
                this.tipo = i;
                break;
            }
        }
    }

    public String getTipo() {
        return TIPOS[tipo];
    }

    public String getValor() {
        return valor;
    }

}