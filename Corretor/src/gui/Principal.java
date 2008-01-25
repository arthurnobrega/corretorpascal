package gui;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import logica.GerenciaReversao;
import logica.GerenciaSerializacao;
import logica.TestaCorrecao;
import logica.TestaPreCorrecao;
import logica.Constantes;
import logica.TestaImportacao;
import dados.PastaCorrecao;

/**
 *
 * @author  UltraXP
 */
public class Principal extends javax.swing.JFrame {
    
    private static int OPCAO_ENT = 0;
    private static int OPCAO_REV = 1;
    private static int OPCAO_COR = 2;
    private static int OPCAO_NOT = 3;
    private static int OPCAO_COP = 4;
    private static int OPCAO_SAL = 5;
    
    private PastaCorrecao pastaCorrecao = PastaCorrecao.getInstancia();
    
    /** Creates new form Principal */
    public Principal() {
        initComponents();
        inicializarJFileChooser();
        inicializarJOptionPane();
        Janelas.alinharContainer(this);
        javax.swing.ImageIcon icone = new javax.swing.ImageIcon(Imagens.CORRETOR_I);
        java.awt.Image img = icone.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        this.setIconImage(img);
        limparContentPane();
        desabilitarOpcoes(new int[] { 0, 1, 2, 3, 4, 5});
    }
    
    private void inicializarJFileChooser() {
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
    
    private void inicializarJOptionPane() {
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "N�o");
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jToolBar1 = new javax.swing.JToolBar();
        btnNova = new javax.swing.JButton();
        btnImportar = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        btnEntradas = new javax.swing.JButton();
        btnReverter = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        btnCorrigir = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemNova = new javax.swing.JMenuItem();
        itemImportar = new javax.swing.JMenuItem();
        itemSalvar = new javax.swing.JMenuItem();
        itemSair = new javax.swing.JMenuItem();
        menuFerramentas = new javax.swing.JMenu();
        itemEntradas = new javax.swing.JMenuItem();
        itemNotas = new javax.swing.JMenuItem();
        itemCopia = new javax.swing.JMenuItem();
        itemReverter = new javax.swing.JMenuItem();
        menuConstruir = new javax.swing.JMenu();
        itemCorrigir = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        itemAjuda = new javax.swing.JMenuItem();
        itemSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Corretor de Programas em Pascal");
        jToolBar1.setFloatable(false);
        jToolBar1.setMaximumSize(new java.awt.Dimension(9, 32));
        jToolBar1.setMinimumSize(new java.awt.Dimension(9, 32));
        jToolBar1.setPreferredSize(new java.awt.Dimension(100, 32));
        btnNova.setToolTipText("Nova Corre\u00e7\u00e3o");
        btnNova.setMaximumSize(new java.awt.Dimension(30, 30));
        btnNova.setMinimumSize(new java.awt.Dimension(30, 30));
        btnNova.setPreferredSize(new java.awt.Dimension(30, 30));
        javax.swing.ImageIcon iconTbNova = new javax.swing.ImageIcon(Imagens.NOVACORRECAO);
        java.awt.Image imgTbNova = iconTbNova.getImage().getScaledInstance(26, 26, java.awt.Image.SCALE_AREA_AVERAGING);
        btnNova.setIcon(new javax.swing.ImageIcon(imgTbNova));
        btnNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaActionPerformed(evt);
            }
        });

        jToolBar1.add(btnNova);

        btnImportar.setToolTipText("Importar Corre\u00e7\u00e3o");
        btnImportar.setMaximumSize(new java.awt.Dimension(30, 30));
        btnImportar.setMinimumSize(new java.awt.Dimension(30, 30));
        btnImportar.setPreferredSize(new java.awt.Dimension(30, 30));
        javax.swing.ImageIcon iconTbImportar = new javax.swing.ImageIcon(Imagens.IMPCORRECAO);
        java.awt.Image imgTbImportar = iconTbImportar.getImage().getScaledInstance(26, 26, java.awt.Image.SCALE_AREA_AVERAGING);
        btnImportar.setIcon(new javax.swing.ImageIcon(imgTbImportar));
        btnImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportarActionPerformed(evt);
            }
        });

        jToolBar1.add(btnImportar);

        jToolBar2.setFloatable(false);
        btnEntradas.setToolTipText("Entradas e Gabaritos");
        btnEntradas.setMaximumSize(new java.awt.Dimension(30, 30));
        btnEntradas.setMinimumSize(new java.awt.Dimension(30, 30));
        btnEntradas.setPreferredSize(new java.awt.Dimension(30, 30));
        javax.swing.ImageIcon iconTbEntradas = new javax.swing.ImageIcon(Imagens.ENTRADAS);
        java.awt.Image imgTbEntradas = iconTbEntradas.getImage().getScaledInstance(26, 26, java.awt.Image.SCALE_AREA_AVERAGING);
        btnEntradas.setIcon(new javax.swing.ImageIcon(imgTbEntradas));
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });

        jToolBar2.add(btnEntradas);

        btnReverter.setToolTipText("Reverter Corre\u00e7\u00e3o");
        btnReverter.setMaximumSize(new java.awt.Dimension(30, 30));
        btnReverter.setMinimumSize(new java.awt.Dimension(30, 30));
        btnReverter.setPreferredSize(new java.awt.Dimension(30, 30));
        javax.swing.ImageIcon iconTbReverter = new javax.swing.ImageIcon(Imagens.REVERTER);
        java.awt.Image imgTbReverter = iconTbReverter.getImage().getScaledInstance(26, 26, java.awt.Image.SCALE_AREA_AVERAGING);
        btnReverter.setIcon(new javax.swing.ImageIcon(imgTbReverter));
        btnReverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReverterActionPerformed(evt);
            }
        });

        jToolBar2.add(btnReverter);

        jToolBar3.setFloatable(false);
        btnCorrigir.setToolTipText("Corrigir");
        btnCorrigir.setMaximumSize(new java.awt.Dimension(30, 30));
        btnCorrigir.setMinimumSize(new java.awt.Dimension(30, 30));
        btnCorrigir.setPreferredSize(new java.awt.Dimension(30, 30));
        javax.swing.ImageIcon iconTbCorrigir = new javax.swing.ImageIcon(Imagens.CORRIGIR);
        java.awt.Image imgTbCorrigir = iconTbCorrigir.getImage().getScaledInstance(26, 26, java.awt.Image.SCALE_AREA_AVERAGING);
        btnCorrigir.setIcon(new javax.swing.ImageIcon(imgTbCorrigir));
        btnCorrigir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorrigirActionPerformed(evt);
            }
        });

        jToolBar3.add(btnCorrigir);

        menuArquivo.setText("Arquivo");
        itemNova.setText("Nova Corre\u00e7\u00e3o");
        javax.swing.ImageIcon iconNova = new javax.swing.ImageIcon(Imagens.NOVACORRECAO);
        java.awt.Image imgNova = iconNova.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemNova.setIcon(new javax.swing.ImageIcon(imgNova));
        itemNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNovaActionPerformed(evt);
            }
        });

        menuArquivo.add(itemNova);

        itemImportar.setText("Importar Corre\u00e7\u00e3o...");
        javax.swing.ImageIcon iconImp = new javax.swing.ImageIcon(Imagens.IMPCORRECAO);
        java.awt.Image imgImp = iconImp.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemImportar.setIcon(new javax.swing.ImageIcon(imgImp));
        itemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemImportarActionPerformed(evt);
            }
        });

        menuArquivo.add(itemImportar);

        itemSalvar.setText("Salvar");
        javax.swing.ImageIcon iconSalvar = new javax.swing.ImageIcon(Imagens.SALVAR);
        java.awt.Image imgSalvar = iconSalvar.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemSalvar.setIcon(new javax.swing.ImageIcon(imgSalvar));
        itemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalvarActionPerformed(evt);
            }
        });

        menuArquivo.add(itemSalvar);

        itemSair.setText("Sair");
        javax.swing.ImageIcon iconSair = new javax.swing.ImageIcon(Imagens.BRANCO);
        java.awt.Image imgSair = iconSair.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemSair.setIcon(new javax.swing.ImageIcon(imgSair));
        itemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSairActionPerformed(evt);
            }
        });

        menuArquivo.add(itemSair);

        barraMenu.add(menuArquivo);

        menuFerramentas.setText("Ferramentas");
        itemEntradas.setText("Entradas e Gabaritos");
        javax.swing.ImageIcon iconEntradas = new javax.swing.ImageIcon(Imagens.ENTRADAS);
        java.awt.Image imgEntradas = iconEntradas.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemEntradas.setIcon(new javax.swing.ImageIcon(imgEntradas));
        itemEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEntradasActionPerformed(evt);
            }
        });

        menuFerramentas.add(itemEntradas);

        itemNotas.setText("Notas das Quest\u00f5es");
        javax.swing.ImageIcon iconNotas = new javax.swing.ImageIcon(Imagens.NOTAS);
        java.awt.Image imgNotas = iconNotas.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemNotas.setIcon(new javax.swing.ImageIcon(imgNotas));
        itemNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNotasActionPerformed(evt);
            }
        });

        menuFerramentas.add(itemNotas);

        itemCopia.setText("C\u00f3pia de Arquivo");
        javax.swing.ImageIcon iconCopia = new javax.swing.ImageIcon(Imagens.COPIA);
        java.awt.Image imgCopia = iconCopia.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemCopia.setIcon(new javax.swing.ImageIcon(imgCopia));
        itemCopia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCopiaActionPerformed(evt);
            }
        });

        menuFerramentas.add(itemCopia);

        itemReverter.setText("Reverter Corre\u00e7\u00e3o");
        javax.swing.ImageIcon iconReverter = new javax.swing.ImageIcon(Imagens.REVERTER);
        java.awt.Image imgReverter = iconReverter.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemReverter.setIcon(new javax.swing.ImageIcon(imgReverter));
        itemReverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemReverterActionPerformed(evt);
            }
        });

        menuFerramentas.add(itemReverter);

        barraMenu.add(menuFerramentas);

        menuConstruir.setText("Construir");
        itemCorrigir.setText("Corrigir");
        javax.swing.ImageIcon iconCorrigir = new javax.swing.ImageIcon(Imagens.CORRIGIR);
        java.awt.Image imgCorrigir = iconCorrigir.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemCorrigir.setIcon(new javax.swing.ImageIcon(imgCorrigir));
        itemCorrigir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCorrigirActionPerformed(evt);
            }
        });

        menuConstruir.add(itemCorrigir);

        barraMenu.add(menuConstruir);

        menuAjuda.setText("Ajuda");
        itemAjuda.setText("Conte\u00fados de Ajuda");
        javax.swing.ImageIcon iconAjuda = new javax.swing.ImageIcon(Imagens.CONTAJUDA);
        java.awt.Image imgAjuda = iconAjuda.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemAjuda.setIcon(new javax.swing.ImageIcon(imgAjuda));
        itemAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAjudaActionPerformed(evt);
            }
        });

        menuAjuda.add(itemAjuda);

        itemSobre.setText("Sobre");
        javax.swing.ImageIcon iconSobre = new javax.swing.ImageIcon(Imagens.SOBRE);
        java.awt.Image imgSobre = iconSobre.getImage().getScaledInstance(18, 18, java.awt.Image.SCALE_AREA_AVERAGING);
        itemSobre.setIcon(new javax.swing.ImageIcon(imgSobre));
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
            .add(layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jToolBar3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(jToolBar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .add(408, 408, 408))
            .add(layout.createSequentialGroup()
                .add(jToolBar2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(jToolBar3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {jToolBar1, jToolBar2}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalvarActionPerformed
        GerenciaSerializacao gerSer = new GerenciaSerializacao();
        gerSer.serializar();
        JOptionPane.showMessageDialog(null, "Altera��es salvas com sucesso!", "Altera��es Salvas!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_itemSalvarActionPerformed

    private void itemCopiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCopiaActionPerformed
        new CopiaArquivo(this).setVisible(true);
    }//GEN-LAST:event_itemCopiaActionPerformed

    private void itemNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNotasActionPerformed
        new NotasQuestoes(this).setVisible(true);
    }//GEN-LAST:event_itemNotasActionPerformed

    private void btnCorrigirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorrigirActionPerformed
        corrigir();
    }//GEN-LAST:event_btnCorrigirActionPerformed

    private void btnReverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReverterActionPerformed
        reverter();
    }//GEN-LAST:event_btnReverterActionPerformed

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        entradas();
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void btnImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportarActionPerformed
        importarCorrecao();
    }//GEN-LAST:event_btnImportarActionPerformed

    private void btnNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaActionPerformed
        novaCorrecao();
    }//GEN-LAST:event_btnNovaActionPerformed

    public void limparContentPane() {
        JPanel container = new JPanel(new FlowLayout());
        this.setContentPane(container);
    }
    
    public void novaCorrecao() {
        UIManager.put("FileChooser.openDialogTitleText", "Nova Corre��o");
        File diretorio = null;
        
        limparContentPane();
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = fc.showOpenDialog(this);
        Janelas.alinharContainer(fc);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            diretorio = null;
        } else {
            diretorio = fc.getSelectedFile();
            try {
                TestaPreCorrecao tc = new TestaPreCorrecao();
                pastaCorrecao = tc.preCorrigir(diretorio);
                habilitarOpcoes(new int[] { 0, 1, 5 });
                JOptionPane.showMessageDialog(this, "Organiza��o das pastas conclu�da!", "Conclu�do!",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, logica.Constantes.E_DIR, Constantes.ET_DIR,
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void importarCorrecao() {
        UIManager.put("FileChooser.openDialogTitleText", "Importar Corre��o...");
        File diretorio = null;
        
        limparContentPane();
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resultado = fc.showOpenDialog(this);
        Janelas.alinharContainer(fc);
        if (resultado == JFileChooser.CANCEL_OPTION) {
            diretorio = null;
        } else {
            diretorio = fc.getSelectedFile();
            try {
                TestaImportacao ti = new TestaImportacao();
                pastaCorrecao = ti.importar();
                if (pastaCorrecao.getArrayListIO().size() >= 1) {
                    habilitarOpcoes(new int[] { 0, 1, 2, 3, 4, 5 });
                } else {
                    habilitarOpcoes(new int[] { 0, 1, 5 });
                }
                JOptionPane.showMessageDialog(this, "Importa��o Conclu�da!", "Conclu�do!",
                    JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, logica.Constantes.E_IMP, Constantes.ET_DIR,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void entradas() {
        IO ent = new IO(this);
        ent.setVisible(true);
        if (pastaCorrecao.getArrayListIO().size() >= 1) {
            habilitarOpcoes(new int[] { 2, 3, 4 });
        } else {
            desabilitarOpcoes(new int[] { 2, 3, 4 });
        }
    }
    
    public void corrigir() {
        TestaCorrecao testaCor = new TestaCorrecao();
        limparContentPane();
        try {
            testaCor.testar();
            this.getContentPane().setVisible(false);
            this.setContentPane(new TabelaNotas(this));
            this.getContentPane().setVisible(true);
            JOptionPane.showMessageDialog(this, "Corre��o Conclu�da!", "Conclu�do!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Antes informe as Entradas e " +
                    "Gabaritos para corrigir os programas.", "Foi encontrado um " +
                    "erro!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void reverter() {
        int opcao = JOptionPane.showConfirmDialog(this, "Voc� tem certeza que deseja " +
                "reverter a corre��o?", "Confirma��o!", JOptionPane.YES_NO_OPTION);
        if (opcao == 0) {
            GerenciaReversao gerRev = new GerenciaReversao();
            gerRev.reverter();
            pastaCorrecao = null;
            limparContentPane();
            desabilitarOpcoes(new int[] { 0, 1, 2, 3, 4});
            JOptionPane.showMessageDialog(this, "Revers�o Conclu�da!", "Conclu�do!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void itemCorrigirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCorrigirActionPerformed
        corrigir();
    }//GEN-LAST:event_itemCorrigirActionPerformed

    private void itemReverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemReverterActionPerformed
        reverter();
    }//GEN-LAST:event_itemReverterActionPerformed

    private void itemAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAjudaActionPerformed
        Ajuda ajuda = new Ajuda(this);
        ajuda.setVisible(true);
    }//GEN-LAST:event_itemAjudaActionPerformed

    private void itemSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSobreActionPerformed
        Sobre sobre = new Sobre(this);
        sobre.setVisible(true);
    }//GEN-LAST:event_itemSobreActionPerformed

    private void itemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemImportarActionPerformed
        importarCorrecao();
    }//GEN-LAST:event_itemImportarActionPerformed

    private void itemNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNovaActionPerformed
        novaCorrecao();
    }//GEN-LAST:event_itemNovaActionPerformed

    private void itemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_itemSairActionPerformed

    private void itemEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEntradasActionPerformed
        entradas();
    }//GEN-LAST:event_itemEntradasActionPerformed
    
    private void desabilitarOpcoes(int[] opcoes) {
        for (int opcao : opcoes) {
            if (opcao == OPCAO_ENT) {
                itemEntradas.setEnabled(false);
            } else if (opcao == OPCAO_REV) {
                itemReverter.setEnabled(false);
            } else if (opcao == OPCAO_COR) {
                itemCorrigir.setEnabled(false);
            } else if (opcao == OPCAO_NOT) {
                itemNotas.setEnabled(false);
            } else if (opcao == OPCAO_COP) {
                itemCopia.setEnabled(false);
            } else if (opcao == OPCAO_SAL) {
                itemSalvar.setEnabled(false);
            }
        }
    }
    
    private void habilitarOpcoes(int[] opcoes) {
        for (int opcao : opcoes) {
            if (opcao == OPCAO_ENT) {
                itemEntradas.setEnabled(true);
            } else if (opcao == OPCAO_REV) {
                itemReverter.setEnabled(true);
            } else if (opcao == OPCAO_COR) {
                itemCorrigir.setEnabled(true);
            } else if (opcao == OPCAO_NOT) {
                itemNotas.setEnabled(true);
            } else if (opcao == OPCAO_COP) {
                itemCopia.setEnabled(true);
            } else if (opcao == OPCAO_SAL) {
                itemSalvar.setEnabled(true);
            }
        }
    }
    
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
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JButton btnCorrigir;
    private javax.swing.JButton btnEntradas;
    private javax.swing.JButton btnImportar;
    private javax.swing.JButton btnNova;
    private javax.swing.JButton btnReverter;
    private javax.swing.JMenuItem itemAjuda;
    private javax.swing.JMenuItem itemCopia;
    private javax.swing.JMenuItem itemCorrigir;
    private javax.swing.JMenuItem itemEntradas;
    private javax.swing.JMenuItem itemImportar;
    private javax.swing.JMenuItem itemNotas;
    private javax.swing.JMenuItem itemNova;
    private javax.swing.JMenuItem itemReverter;
    private javax.swing.JMenuItem itemSair;
    private javax.swing.JMenuItem itemSalvar;
    private javax.swing.JMenuItem itemSobre;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuConstruir;
    private javax.swing.JMenu menuFerramentas;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
