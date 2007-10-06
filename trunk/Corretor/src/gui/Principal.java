package gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.event.ListDataListener;
import log.GerenciaSerializacao;
import log.TestaCorrecao;
import log.Constantes;
import log.TestaImportacao;
import src.PastaCorrecao;

/**
 *
 * @author  UltraXP
 */
public class Principal extends javax.swing.JFrame {
    
    /** Creates new form Principal */
    public Principal() {
        initComponents();
        inicializarJFileChooser();
        Janelas.alinharContainer(this);
        //setExtendedState(MAXIMIZED_BOTH);
    }
    
    private void inicializarJFileChooser() {
        UIManager.put("FileChooser.openDialogTitleText", "Nova Corre��o");
        UIManager.put("FileChooser.acceptAllFileFilterText", "Todos os arquivos");
        
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir diret�rio selecionado");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar di�logo");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        
        UIManager.put("FileChooser.lookInLabelText", "Examinar:");
        UIManager.put("FileChooser.fileNameLabelText", "Nome do arquivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Arquivos do tipo:");
        
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalhes");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.upFolderToolTipText", "Um n�vel acima");
        UIManager.put("FileChooser.newFolderToolTipText", "Criar nova pasta");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemNova = new javax.swing.JMenuItem();
        itemImportar = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();
        menuFerramentas = new javax.swing.JMenu();
        itemEntradas = new javax.swing.JMenuItem();
        itemReverter = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        itemAjuda = new javax.swing.JMenuItem();
        itemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Corretor de Programas em Pascal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        menuArquivo.setText("Arquivo");
        itemNova.setText("Nova Corre\u00e7\u00e3o");
        itemNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNovaActionPerformed(evt);
            }
        });

        menuArquivo.add(itemNova);

        itemImportar.setText("Importar Corre\u00e7\u00e3o...");
        itemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemImportarActionPerformed(evt);
            }
        });

        menuArquivo.add(itemImportar);

        itemSair.setText("Sair");
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });

        menuArquivo.add(itemSair);

        barraMenu.add(menuArquivo);

        menuFerramentas.setText("Ferramentas");
        itemEntradas.setText("Entradas e Gabaritos");
        itemEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEntradasActionPerformed(evt);
            }
        });

        menuFerramentas.add(itemEntradas);

        itemReverter.setText("Reverter Corre\u00e7\u00e3o");
        itemReverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReverterActionPerformed(evt);
            }
        });

        menuFerramentas.add(itemReverter);

        barraMenu.add(menuFerramentas);

        menuAjuda.setText("Ajuda");
        itemAjuda.setText("Conte\u00fados de Ajuda");
        itemAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAjudaActionPerformed(evt);
            }
        });

        menuAjuda.add(itemAjuda);

        itemSobre.setText("Sobre");
        itemSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSobreActionPerformed(evt);
            }
        });

        menuAjuda.add(itemSobre);

        barraMenu.add(menuAjuda);

        setJMenuBar(barraMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 670, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 429, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemReverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReverterActionPerformed
        
    }//GEN-LAST:event_itemReverterActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (pastasCorrecao != null) {
            GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
            gerSer.serializar(pastasCorrecao);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (pastasCorrecao != null) {
            GerenciaSerializacao gerSer = new GerenciaSerializacao(diretorio);
            gerSer.serializar(pastasCorrecao);
        }
    }//GEN-LAST:event_formWindowClosed

    private void itemAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAjudaActionPerformed
        Ajuda ajuda = new Ajuda(this, true);
        ajuda.setVisible(true);
    }//GEN-LAST:event_itemAjudaActionPerformed

    private void itemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreActionPerformed
        Sobre sobre = new Sobre(this, true);
        sobre.setVisible(true);
    }//GEN-LAST:event_itemSobreActionPerformed

    private void itemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImportarActionPerformed
        UIManager.put("FileChooser.openDialogTitleText", "Importar Corre��o...");
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(this);
        Janelas.alinharContainer(fc);
        diretorio = fc.getSelectedFile();
        TestaImportacao ti = new TestaImportacao(diretorio);
        try {
            pastasCorrecao = ti.importar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, log.Constantes.E_IMP, Constantes.ET_DIR,
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemImportarActionPerformed

    private void itemNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovaActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = fc.showOpenDialog(this);
        Janelas.alinharContainer(fc);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            diretorio = null;
        } else {
            diretorio = fc.getSelectedFile();
            try {
                TestaCorrecao tc = new TestaCorrecao(diretorio);
                pastasCorrecao = tc.getPastasCorrecao();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, log.Constantes.E_DIR, Constantes.ET_DIR,
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_itemNovaActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_itemSairActionPerformed

    private void itemEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEntradasActionPerformed
        IO ent = new IO(this, pastasCorrecao);
        ent.setVisible(true);
    }//GEN-LAST:event_itemEntradasActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    File diretorio = null;
    PastaCorrecao[] pastasCorrecao = null;
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem itemAjuda;
    private javax.swing.JMenuItem itemEntradas;
    private javax.swing.JMenuItem itemImportar;
    private javax.swing.JMenuItem itemNova;
    private javax.swing.JMenuItem itemReverter;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuFerramentas;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
