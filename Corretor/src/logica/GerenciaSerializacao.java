package logica;

import java.io.File;
import java.io.IOException;
import corretor.Arquivos;
import dados.PastaCorrecao;

/**
 * Classe que gerencia a serialização do objeto que é utilizado para a importação
 * da correção posteriormente.
 */
public class GerenciaSerializacao {
    
    /**
     * Serializa o objeto padrão na pasta da correção.
     */
    public void serializar() {
        Arquivos.serializarCorrecao();
    }
    
    /**
     * Desserializa o objeto padrão e o tras para a memória na forma do objeto
     * PastaCorrecao.
     */
    public PastaCorrecao desserializar(File diretorio) throws IOException {
        return Arquivos.desserializarCorrecao(diretorio);
    }
    
}
