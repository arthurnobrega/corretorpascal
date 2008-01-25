/*
 * PastaCorrecao.java
 *
 * Created on 22 de Setembro de 2007, 16:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package dados;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author UltraXP
 */
public class PastaCorrecao implements Serializable {
    
    private ArrayList<ListaIO> io = null;
    private Aluno[] alunos = null;
    private File diretorio = null;
    
    private static PastaCorrecao instancia;
    
    /** Creates a new instance of PastaCorrecao */
    private PastaCorrecao(File diretorio, Aluno[] alunos) {
        this.diretorio = diretorio;
        this.alunos = alunos;
        io = new ArrayList<ListaIO>();
    }
    
    public static PastaCorrecao getInstancia(File diretorio, Aluno[] alunos) {
        if (instancia == null) {
            instancia = new PastaCorrecao(diretorio, alunos);
        }
        return instancia;
    }
    
    public ArrayList<ListaIO> getArrayListIO() {
        return io;
    }
    
    public Aluno[] getAlunos() {
        return alunos;
    }
    
    public File getDiretorio() {
        return diretorio;
    }
    
}