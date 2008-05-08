package logica;

import dados.ListaQuestoes;
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
        Arquivos.serializarDados();
        PastaCorrecao.getInstancia().setModificado(false);
    }
    
    /**
     * Desserializa o objeto padr�o e o tras para a mem�ria na forma do objeto
     * PastaCorrecao.
     */
    public void desserializar(File diretorio) throws IOException {
        PastaCorrecao.setInstancia(Arquivos.desserializarCorrecao(diretorio));
        ListaQuestoes.setInstancia(Arquivos.desserializarListaQuestoes(diretorio));
        PastaCorrecao.getInstancia().setModificado(false);
    }
    
    public void desserializarListaQuestoes(File arquivo) throws IOException {
        ListaQuestoes.setInstancia(Arquivos.desserializarListaQuestoes(arquivo));
        PastaCorrecao.getInstancia().setModificado(true);
    }
    
}
