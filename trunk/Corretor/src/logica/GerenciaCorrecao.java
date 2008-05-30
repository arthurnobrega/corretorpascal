package logica;

import dados.Aluno;
import corretor.Correcao;
import dados.PastaCorrecao;
import gui.BarraProgresso;
import gui.Principal;

/**
 * Classe utilizada para gerenciar a correção das questões. Tem como presuposto
 * que a lista de Entradas/Gabaritos não é nula.
 */
public class GerenciaCorrecao {
     
    private static GerenciaCorrecao instancia = null;
    int nroExecucao = 0;
    
    public GerenciaCorrecao() {
        instancia = this;
    }
    
    public static GerenciaCorrecao getInstancia() {
        return instancia;
    }
    
    public int getNumeroExecucao() {
        return nroExecucao;
    }
    
    /**
     * Corrige todos os arquivos chamando métodos mais internos.
     */
    public void corrigir() {
        /*BarraProgresso barra = new BarraProgresso(Principal.getInstancia());
        Thread thread = new Thread(barra);
        thread.start();*/
        
        Aluno[] alunos = PastaCorrecao.getInstancia().getAlunos();
        int mult = 100 / alunos.length;
        int nro = 0;
        for (Aluno aluno : alunos) {
            nroExecucao = ++nro * mult;
            // Corrige todos os arquivos fontes de cada aluno.
            Correcao cor = new Correcao(aluno);
            cor.corrigir();
            GerenciaSerializacao gerSer = new GerenciaSerializacao();
            gerSer.serializar();
        }
        nroExecucao = 100;
    }
    
}
