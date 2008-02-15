package logica;

import dados.Aluno;
import dados.ArquivoFonte;
import dados.PastaCorrecao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe que guarda métodos Utilitários que serão utilizados no decorrer do
 * programa.
 */
public abstract class Utilitarios {

    /**
     * Procura por alunos que tenham feito determinada questão.
     * @param indiceQuestao O número da questão que se deseja procurar pelos alunos
     * que a fizeram.
     * @return Um vetor dos Alunos que fizeram esta questão.
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
    
    public static boolean compararStrings(String saida, String gabarito) {
        if (saida.contains(gabarito)) {
            return true;
        }
        return false;
    }
    
    public static boolean compararInteiros(String saida, String gabarito) {
        try {
            int nro1 = Integer.parseInt(saida);
            int nro2 = Integer.parseInt(gabarito);
            if (nro1 == nro2) {
                return true;
            }
        } catch (NumberFormatException ex) {
            if (saida.contains(gabarito)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean compararReais(String saida, String gabarito) {
        try {
            double nro1 = Double.parseDouble(saida);
            double nro2 = Double.parseDouble(gabarito);
            if (Double.compare(nro1, nro2) == 0) {
                return true;
            }
        } catch (NumberFormatException ex) {
            if (saida.contains(gabarito)) {
                return true;
            }
        }
        return false;
    }
    
}
