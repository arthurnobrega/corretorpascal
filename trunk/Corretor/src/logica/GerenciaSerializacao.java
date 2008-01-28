package logica;

import java.io.File;
import java.io.IOException;
import corretor.Arquivos;
import dados.PastaCorrecao;

/**
 * Classe que gerencia a serializa��o do objeto que � utilizado para a importa��o
 * da corre��o posteriormente.
 */
public class GerenciaSerializacao {
    
    /**
     * Serializa o objeto padr�o na pasta da corre��o.
     */
    public void serializar() {
        Arquivos.serializarCorrecao();
    }
    
    /**
     * Desserializa o objeto padr�o e o tras para a mem�ria na forma do objeto
     * PastaCorrecao.
     */
    public PastaCorrecao desserializar(File diretorio) throws IOException {
        return Arquivos.desserializarCorrecao(diretorio);
    }
    
}
