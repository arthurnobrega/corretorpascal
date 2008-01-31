package logica;

import dados.Aluno;
import dados.ArquivoFonte;
import dados.PastaCorrecao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que guarda m�todos Utilit�rios que ser�o utilizados no decorrer do
 * programa.
 */
public abstract class Utilitarios {

    /**
     * Procura por alunos que tenham feito determinada quest�o.
     * @param indiceQuestao O n�mero da quest�o que se deseja procurar pelos alunos
     * que a fizeram.
     * @return Um vetor dos Alunos que fizeram esta quest�o.
     */
    public static Aluno[] encontrarAlunos(int indiceQuestao) {
        Aluno[] todosAlunos = PastaCorrecao.getInstancia().getAlunos();
        ArrayList<Aluno> selecionados = new ArrayList<Aluno>();
        for (Aluno aluno : todosAlunos) {
            ArquivoFonte[] fontes = aluno.getFontes();
            if ((fontes.length > indiceQuestao) && (fontes[indiceQuestao] != null)) {
                selecionados.add(aluno);
            }
        }
        
        return (Aluno[]) selecionados.toArray(new Aluno[0]);
    }
    
    public static boolean compararInteiros(String n1, String n2) {
        double teste = Double.parseDouble("7.500000000000000E+001");
        return true;
    }
    
}
