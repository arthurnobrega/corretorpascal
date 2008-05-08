package logica;

import dados.ListaQuestoes;
import java.io.File;
import java.io.IOException;
import logica.Arquivos;
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
        Arquivos.serializarDados();
        PastaCorrecao.getInstancia().setModificado(false);
    }
    
    /**
     * Desserializa o objeto padrão e o tras para a memória na forma do objeto
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
