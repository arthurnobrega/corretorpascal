package br.unb.cic.corretor.gui;

import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

/**
 * Esta janela é responsável por mostrar ao usuário algumas
 * informações sobre o programa, como a versão que ele está
 * utilizando e os desenvolvedores do mesmo.
 * @author arthurthiago
 *
 */
public class Sobre extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel1 = null;

	private JPanel jPanel = null;

	private JPanel jPanel1 = null;

	private JButton jButton = null;

	private JEditorPane jEditorPane = null;

	/** 
	 * Cria uma nova Janela de Relatório para o usuário.
	 * @param pai O JFrame Principal que chama esta Janela de Relatório.
	 */
	public Sobre(Principal pai) {
		super(pai, true);
		initialize();
	}

	/**
	 * Este método inicializa esta Janela.
	 * 
	 */
	private void initialize() {
		this.setSize(423, 254);
		this.setTitle("Sobre");
		this.setContentPane(getJContentPane());
		Janelas.alinharContainer(this);
	}

	/**
	 * Este método inicializa o jContentPane.
	 * 
	 * @return javax.swing.JPanel O jContentPane.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Área para o Logo");
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJPanel1(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = -1;
			gridBagConstraints1.gridy = -1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = -1;
			gridBagConstraints.gridy = -1;
			jPanel = new JPanel();
			jPanel.setLayout(new BoxLayout(getJPanel(), BoxLayout.X_AXIS));
			jPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			jPanel.add(jLabel1, null);
			jPanel.add(getJEditorPane(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BoxLayout(getJPanel1(), BoxLayout.X_AXIS));
			jPanel1.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
			jPanel1.add(getJButton(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("OK");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnOkActionPerformed();
				}
			});
		}
		return jButton;
	}
	
	private void btnOkActionPerformed() {
		this.dispose();
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane();
			jEditorPane.setText("Corretor de Programas em Pascal\n\nVersão: 1.0.0\n\n" +
					"Este programa faz parte de um projeto dirigido pelo professor Homero " +
					"Luiz Piccolo que têm em vista automatizar algumas funcionalidades da disciplina " +
					"de Introdução à Ciência da Computação (ICC) da Universidade de Brasília (UnB).\n\n2007");
			jEditorPane.setEditable(false);
			jEditorPane.setFont(new Font("Arial", Font.PLAIN, 12));
		}
		return jEditorPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
