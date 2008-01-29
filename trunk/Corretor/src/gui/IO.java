/*
 * Entradas.java
 *
 * Created on 15 de Setembro de 2007, 21:09
 */

package gui;

import dados.Questao;
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.GerenciaIO;
import logica.Arquivos;
import dados.ListaIO;
import dados.PastaCorrecao;

/**
 *
 * @author  UltraXP
 */
public class IO extends javax.swing.JDialog {
    
    File diretorio = PastaCorrecao.getInstancia().getDiretorio();
    
    /** Creates new form Entradas */
    public IO(java.awt.Frame parent) {
        super(parent, true);
        this.diretorio = diretorio;
        initComponents();
        Janelas.alinharContainer(this);
        mudarCorEditor(0);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Código Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGabarito = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaQuestoes = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaEntradas = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        txtNroQuestoes = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entradas e Gabaritos");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Entrada");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Gabarito");

        btnSalvar.setText("Salvar Altera\u00e7\u00f5es");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtGabarito.setColumns(20);
        txtGabarito.setRows(5);
        jScrollPane2.setViewportView(txtGabarito);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista (Entradas / Gabaritos)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 11), new java.awt.Color(0, 0, 0)));
        String[] questoes = getCorrecoes();
        if (questoes != null) {
            listaQuestoes.setListData(questoes);
            listaQuestoes.setSelectedIndex(0);
            atualizarListaIO();
        }

        listaQuestoes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaQuestoesValueChanged(evt);
            }
        });

        jScrollPane4.setViewportView(listaQuestoes);

        listaEntradas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaEntradasValueChanged(evt);
            }
        });

        jScrollPane1.setViewportView(listaEntradas);

        jLabel3.setText("N\u00famero de Quest\u00f5es:");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .add(25, 25, 25))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtNroQuestoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAlterar)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(btnAdicionar)
                    .add(btnRemover, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnAdicionar, btnRemover}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(txtNroQuestoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAlterar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(btnAdicionar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnRemover))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        txtEntrada.setColumns(20);
        txtEntrada.setRows(5);
        jScrollPane3.setViewportView(txtEntrada);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(jLabel2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 36, Short.MAX_VALUE)
                                .add(btnSalvar))
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(btnVoltar)))
                .addContainerGap())
        );

        layout.linkSize(new java.awt.Component[] {jScrollPane2, jScrollPane3}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnVoltar)
                    .add(btnSalvar))
                .add(14, 14, 14))
        );

        layout.linkSize(new java.awt.Component[] {jScrollPane2, jScrollPane3}, org.jdesktop.layout.GroupLayout.VERTICAL);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            int numeroQuestoes = Integer.parseInt(txtNroQuestoes.getText());
            if (numeroQuestoes == 0) {
                listaQuestoes.setListData(new String[0]);
                listaEntradas.setListData(new String[0]);
                txtEntrada.setText("");
                txtGabarito.setText("");
                mudarCorEditor(0);
                PastaCorrecao.getInstancia().getQuestoes().clear();
                return;
            } else if (numeroQuestoes < 0) {
                JOptionPane.showMessageDialog(null, "Informe um n�mero inteiro maior ou igual a 0!", "Erro!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int notasQuestoes[] = new int[numeroQuestoes];
            int notaDividida = 100 / numeroQuestoes;
            int mult = notaDividida * numeroQuestoes;
            for (int i = 0; i <= numeroQuestoes - 1; i++) {
                notasQuestoes[i] = notaDividida;
            }
            if (mult != 100) {
                int i = 0, nroIndices = notasQuestoes.length;
                int resto = 100 - mult;
                while(resto != 0) {
                    notasQuestoes[i] += 1;
                    resto--;
                    if (i < nroIndices) {
                        i++;
                    } else {
                        i = 0;
                    }
                }
            }
            String[] vetorQuestoes = new String[numeroQuestoes];
            PastaCorrecao.getInstancia().getQuestoes().clear();
            ArrayList<Questao> questoes = new ArrayList<Questao>();
            for (int i = 0; i <= numeroQuestoes - 1; i++) {
                String nomeQuestao = "Quest�o " + (i+1);
                vetorQuestoes[i] = nomeQuestao;
                Questao questao = new Questao();
                questao.setNotaMax(notasQuestoes[i]);
                questoes.add(questao);
            }
            PastaCorrecao.getInstancia().setQuestoes(questoes);
            listaQuestoes.setListData(vetorQuestoes);
            listaQuestoes.setSelectedIndex(0);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero inteiro maior ou igual a 0!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        GerenciaIO gerencia = new GerenciaIO();
        gerencia.removerIO(listaQuestoes.getSelectedIndex(), listaEntradas.getSelectedIndex());
        atualizarListaIO();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        ListaIO listaIO = PastaCorrecao.getInstancia().getQuestoes().get(listaQuestoes.getSelectedIndex()).getListaIO();
        
        listaIO.alterarIO(listaEntradas.getSelectedIndex(), txtEntrada.getText(), txtGabarito.getText());
        Arquivos.serializarCorrecao();
        JOptionPane.showMessageDialog(null, "Altera��es salvas com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void listaEntradasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaEntradasValueChanged
        String entrada = PastaCorrecao.getInstancia().getQuestoes().get(listaQuestoes.getSelectedIndex()).getListaIO().getEntrada(listaEntradas.getSelectedIndex());
        String gabarito = PastaCorrecao.getInstancia().getQuestoes().get(listaQuestoes.getSelectedIndex()).getListaIO().getGabarito(listaEntradas.getSelectedIndex());
        
        if (entrada != null) {
            mudarCorEditor(1);
            txtEntrada.setText(entrada);
            txtGabarito.setText(gabarito);
        }
    }//GEN-LAST:event_listaEntradasValueChanged

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        int indice = listaQuestoes.getSelectedIndex();
        GerenciaIO gerIO = new GerenciaIO();
        gerIO.adicionarIO(indice);
        atualizarListaIO();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void listaQuestoesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaQuestoesValueChanged
        if (listaQuestoes.getSelectedIndex() >= 0) {
            atualizarListaIO();
            mudarCorEditor(0);
        }
    }//GEN-LAST:event_listaQuestoesValueChanged

    private void mudarCorEditor(int modo) {
        if (modo == 0) {
            txtEntrada.setBackground(Color.LIGHT_GRAY);
            txtGabarito.setBackground(Color.LIGHT_GRAY);
            txtEntrada.setEnabled(false);
            txtGabarito.setEnabled(false);
        } else if (modo == 1) {
            txtEntrada.setBackground(Color.WHITE);
            txtGabarito.setBackground(Color.WHITE);
            txtEntrada.setEnabled(true);
            txtGabarito.setEnabled(true);
        }
    }
    
    private String[] getCorrecoes() {
        int numeroQuestoes = PastaCorrecao.getInstancia().getQuestoes().size();
        String[] vetorQuestoes = null;
        if (numeroQuestoes != 0) {
            vetorQuestoes = new String[numeroQuestoes];
            for (int i = 0; i <= numeroQuestoes - 1; i++) {
                String questao = "Quest�o " + (i+1);
                vetorQuestoes[i] = questao;
            }
        }
        
        return vetorQuestoes;
    }
    
    private void atualizarListaIO() {
        txtEntrada.setText("");
        txtGabarito.setText("");
        GerenciaIO gerencia = new GerenciaIO();
        listaEntradas.setListData(gerencia.getVetorIO(listaQuestoes.getSelectedIndex()));
    }
    
    // Declaração de variáveis - não modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaEntradas;
    private javax.swing.JList listaQuestoes;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtGabarito;
    private javax.swing.JTextField txtNroQuestoes;
    // Fim da declaração de variáveis//GEN-END:variables
    
}
