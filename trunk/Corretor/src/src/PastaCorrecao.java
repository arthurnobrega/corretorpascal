/*
 * PastaCorrecao.java
 *
 * Created on 22 de Setembro de 2007, 16:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package src;

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
    
    /** Creates a new instance of PastaCorrecao */
    public PastaCorrecao(File diretorio, Aluno[] alunos) {
        this.diretorio = diretorio;
        this.alunos = alunos;
        io = new ArrayList<ListaIO>();
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