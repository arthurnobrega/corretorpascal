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
    
    private static PastaCorrecao instancia = null;
    
    /** Creates a new instance of PastaCorrecao */
    private PastaCorrecao(File diretorio, Aluno[] alunos) {
        this.diretorio = diretorio;
        this.alunos = alunos;
        io = new ArrayList<ListaIO>();
    }
    
    public static PastaCorrecao getInstancia() {
        return instancia;
    }
    
    public static PastaCorrecao getInstancia(File diretorio, Aluno[] alunos) {
        instancia = new PastaCorrecao(diretorio, alunos);
        return instancia;
    }
    
    public static PastaCorrecao getInstancia(PastaCorrecao pastaCorrecao) {
        instancia = new PastaCorrecao(pastaCorrecao.getDiretorio(), pastaCorrecao.getAlunos());
        instancia.setArrayListIO(pastaCorrecao.getArrayListIO());
        return instancia;
    }
    
    public ArrayList<ListaIO> getArrayListIO() {
        return io;
    }
    
    public void setArrayListIO(ArrayList<ListaIO> io) {
        this.io = io;
    }
    
    public Aluno[] getAlunos() {
        return alunos;
    }
    
    public File getDiretorio() {
        return diretorio;
    }
    
}