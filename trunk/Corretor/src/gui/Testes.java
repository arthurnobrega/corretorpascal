/*
 * Entradas.java
 *
 * Created on 15 de Setembro de 2007, 21:09
 */

package gui;

import dados.Questao;
import dados.Teste;
import gui.modelos.KeyListenerJanela;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.GerenciaTestes;
import dados.ListaQuestoes;
import java.io.IOException;
import logica.Utilitarios;
import logica.GerenciaSerializacao;

/**
 *
 * @author  UltraXP
 */
public class Testes extends javax.swing.JDialog {
    
    private ArrayList<Questao> questoes = null;
    
    /** Creates new form Entradas */
    public Testes(Principal pai) {
        super(pai, "Testes dos programas", true);
        this.questoes = new ArrayList<Questao>();
        initComponents();
        Janelas.alinharContainer(this);
        btnAdicionar.setEnabled(false);
        btnRemover.setEnabled(false);
        btnEditar.setEnabled(false);
        this.addKeyListener(new KeyListenerJanela());
    }
    
    public Testes(Principal pai, ArrayList<Questao> questoes) {
        super(pai, "Testes dos programas", true);
        this.questoes = questoes;
        initComponents();
        iniciarListas();
        Janelas.alinharContainer(this);
        this.addKeyListener(new KeyListenerJanela());
    }
    
    private void iniciarListas() {
        if (!questoes.isEmpty()) {
            GerenciaTestes ger = new GerenciaTestes(questoes);
            listaQuestoes.setListData(ger.getVetorQuestoes());
            listaQuestoes.setSelectedIndex(0);
            
            listaTestes.setListData(ger.getVetorTestes(listaQuestoes.getSelectedIndex()));
            btnAdicionar.setEnabled(false);
            if (listaTestes.getModel().getSize() > 0) { 
                listaTestes.setSelectedIndex(0);
                
                btnRemover.setEnabled(true);
                btnEditar.setEnabled(true);
            } else {
                btnRemover.setEnabled(false);
                btnEditar.setEnabled(false);
            }
            
            btnAdicionar.setEnabled(true);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C�digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        btnSalvar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaQuestoes = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTestes = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        txtNroQuestoes = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entradas e Gabaritos");
        btnSalvar.setText("Salvar Altera\u00e7\u00f5es");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista (Entradas / Gabaritos)", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 0)));
        listaQuestoes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaQuestoesValueChanged(evt);
            }
        });

        jScrollPane4.setViewportView(listaQuestoes);

        jScrollPane1.setViewportView(listaTestes);

        jLabel3.setText("N\u00famero de Quest\u00f5es:");

        btnAdicionar.setText("Adicionar Teste");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover Teste");
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

        btnEditar.setText("Editar Teste");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
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
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtNroQuestoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnAlterar))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(btnRemover, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnAdicionar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(btnEditar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnAdicionar, btnEditar, btnRemover}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

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
                        .add(btnRemover)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(btnEditar))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                    .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnAdicionar, btnEditar, btnRemover}, org.jdesktop.layout.GroupLayout.VERTICAL);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(btnCancelar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 197, Short.MAX_VALUE)
                        .add(btnSalvar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnCancelar)
                    .add(btnSalvar))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int testeSelecionado = listaTestes.getSelectedIndex();
        Questao questao = questoes.get(listaQuestoes.getSelectedIndex());
        TabelasTeste tab = new TabelasTeste(null, testeSelecionado, questao.getTeste(testeSelecionado));
        tab.setVisible(true);
        questao.editarTeste(testeSelecionado, tab.getTeste());
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        questoes = null;
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        try {
            int numeroQuestoes = Integer.parseInt(txtNroQuestoes.getText());
            if (numeroQuestoes == 0) {
                questoes.clear();
                listaQuestoes.setListData(new Object[0]);
                listaTestes.setListData(new Object[0]);
                btnAdicionar.setEnabled(false);
                btnRemover.setEnabled(false);
                btnEditar.setEnabled(false);
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
            questoes.clear();
            ArrayList<Questao> novasQuestoes = new ArrayList<Questao>();
            for (int i = 0; i <= numeroQuestoes - 1; i++) {
                String nomeQuestao = "Quest�o " + (i+1);
                vetorQuestoes[i] = nomeQuestao;
                Questao questao = new Questao();
                questao.setNotaMax(notasQuestoes[i]);
                novasQuestoes.add(questao);
            }
            questoes = novasQuestoes;
            listaQuestoes.setListData(vetorQuestoes);
            listaQuestoes.setSelectedIndex(0);
            btnAdicionar.setEnabled(true);
            txtNroQuestoes.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Informe um n�mero inteiro maior ou igual a 0!", "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int testeSelecionado = listaTestes.getSelectedIndex();
        int questaoSelecionada = listaQuestoes.getSelectedIndex();
        questoes.get(questaoSelecionada).removerTeste(testeSelecionado);        
        GerenciaTestes ger = new GerenciaTestes(questoes);
        listaTestes.setListData(ger.getVetorTestes(questaoSelecionada));
        if (listaTestes.getModel().getSize() == 0) {
            btnRemover.setEnabled(false);
            btnEditar.setEnabled(false);
        } else {
            listaTestes.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        int nroQuestoes = questoes.size();
        GerenciaTestes ger = new GerenciaTestes(questoes);
        
        try {
            /* Faz o c�lculo das notas padr�es m�ximas das quest�es e dos testes. */
            int[] notasQuestoes = Utilitarios.calcularNotas(nroQuestoes);
            for (int i = 0; i <= nroQuestoes - 1; i++) {
                int nroTestes = ger.getVetorTestes(i).length;
                if (nroTestes == 0) {
                    throw new IOException();
                }
                int[] notasTestes = Utilitarios.calcularNotas(nroTestes);
                questoes.get(i).setNotaMax(notasQuestoes[i]);
                if (notasTestes != null) {
                    for (int j = 0; j <= nroTestes - 1; j++) {
                        questoes.get(i).getTeste(j).setPorcentagemNotaMax(notasTestes[j]);
                    }
                }
            }

            ListaQuestoes.setInstancia(questoes);
            GerenciaSerializacao ser = new GerenciaSerializacao();
            ser.serializar();
            JOptionPane.showMessageDialog(null, "Altera��es salvas com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Existe uma quest�o que n�o tem " +
                    "nenhum teste associado!\n Por favor adicione no m�nimo um teste!", 
                    "Quest�o sem teste!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Questao questao = questoes.get(listaQuestoes.getSelectedIndex());
        TabelasTeste tab = new TabelasTeste((java.awt.Frame)this.getParent(), listaTestes.getModel().getSize());
        tab.setVisible(true);
        Teste teste = tab.getTeste();
        if (teste != null) {
            questao.adicionarTeste();
            questao.editarTeste(listaTestes.getModel().getSize(), teste);
            GerenciaTestes ger = new GerenciaTestes(questoes);
            listaTestes.setListData(ger.getVetorTestes(listaQuestoes.getSelectedIndex()));
            listaTestes.setSelectedIndex(0);
            btnRemover.setEnabled(true);
            btnEditar.setEnabled(true);
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void listaQuestoesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaQuestoesValueChanged
        if (listaQuestoes.getSelectedIndex() >= 0) {
            GerenciaTestes ger = new GerenciaTestes(questoes);
            listaTestes.setListData(ger.getVetorTestes(listaQuestoes.getSelectedIndex()));
            if (listaTestes.getModel().getSize() > 0) {
                listaTestes.setSelectedIndex(0);
                btnRemover.setEnabled(true);
                btnEditar.setEnabled(true);
            } else {
                btnRemover.setEnabled(false);
                btnEditar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_listaQuestoesValueChanged
    
    // Declara��o de vari�veis - n�o modifique//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList listaQuestoes;
    private javax.swing.JList listaTestes;
    private javax.swing.JTextField txtNroQuestoes;
    // Fim da declara��o de vari�veis//GEN-END:variables
    
}
