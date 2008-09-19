package logica;

import dados.Aluno;
import dados.ArquivoFonte;
import dados.PastaCorrecao;
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
        if (saida == null || saida.equals("")) {
            return false;
        } else if (saida.equalsIgnoreCase(gabarito)) {
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
 
    /*
    ->A String "532835" representa A Linha ou texto a ser preenchido
    ->A String "0" representa A Letra ou Número que será inserido
    ->O Integer 14 representa o tamanho total que a String a ser preenchida precisa ter
    ->O Integer 1 informa ao método que a String "0" será preenchida a Esquerda 
    OBS: 1 preenche a Esquerda, 2 preenche a direita ok.
    */
    public static String preencheCom(String linha_a_preencher, String letra, int tamanho, int direcao){
        //Checa se Linha a preencher é nula ou branco
        if (linha_a_preencher == null || linha_a_preencher.trim() == "" ) {linha_a_preencher = "";} 
        //Enquanto Linha a preencher possuir 2 espaços em branco seguidos, substitui por 1 espaço apenas
        while (linha_a_preencher.contains("  ")) {linha_a_preencher = linha_a_preencher.replaceAll("  "," ").trim();}
        //Retira caracteres estranhos
        linha_a_preencher = linha_a_preencher.replaceAll("[./-]","");
        StringBuffer sb = new StringBuffer(linha_a_preencher);
        if (direcao==1){ //a Esquerda
            for (int i=sb.length() ; i<tamanho ; i++){
                sb.insert(0,letra);
            }
        } else if (direcao==2) {//a Direita
            for (int i=sb.length() ; i<tamanho ; i++){
                sb.append(letra);
            }
        }
        return sb.toString();
    }

    
}
