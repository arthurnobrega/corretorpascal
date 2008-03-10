package logica;

import java.io.File;
import java.io.IOException;
import logica.Arquivos;
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
        PastaCorrecao.getInstancia().setModificado(false);
    }
    
    /**
     * Desserializa o objeto padr�o e o tras para a mem�ria na forma do objeto
     * PastaCorrecao.
     */
    public void desserializar(File diretorio) throws IOException {
        PastaCorrecao.getInstancia(Arquivos.desserializarCorrecao(diretorio));
        PastaCorrecao.getInstancia().setModificado(false);
    }
    
}
