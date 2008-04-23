package logica;

import dados.Aluno;
import dados.ArquivoFonte;
import dados.PastaCorrecao;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

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
        if (saida.equalsIgnoreCase(gabarito)) {
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
    
    public static String[] retirarElementosNulos(String[] vetor) {
        ArrayList<String> lista = new ArrayList<String>();
        for (String el : vetor) {
            if (!el.equals("")) {
                lista.add(el);
            }
        }
        return (String[]) lista.toArray(new String[0]);
    }
    
    public static int[] calcularNotas(int tamVetor) {
        int notas[] = null;
        if (tamVetor > 0) {
            notas = new int[tamVetor];
            int notaDividida = 100 / tamVetor;
            int mult = notaDividida * tamVetor;
            for (int i = 0; i <= tamVetor - 1; i++) {
                notas[i] = notaDividida;
            }
            if (mult != 100) {
                int i = 0, nroIndices = notas.length;
                int resto = 100 - mult;
                while(resto != 0) {
                    notas[i] += 1;
                    resto--;
                    if (i < nroIndices) {
                        i++;
                    } else {
                        i = 0;
                    }
                }
            }
        }
        return notas;
    }
    
}
