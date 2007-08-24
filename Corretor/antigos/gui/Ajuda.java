package br.unb.cic.corretor.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.GridLayout;

/**
 * Janela que é utilizada como apoio para os usuários e contém
 * algumas dicas de como utilizar o programa.
 * 
 * @author arthurthiago
 *
 */
public class Ajuda extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JLabel jLabel = null;

	/** 
	 * Cria uma nova Janela de Ajuda para o usuário.
	 * @param pai O JFrame Principal que chama esta Janela de Ajuda.
	 */
	public Ajuda(Principal pai) {
		super(pai, true);
		initialize();
	}

	/** 
	 * Este método inicializa esta Janela.
	 */
	private void initialize() {
		this.setSize(294, 199);
		this.setTitle("Conteúdos de Ajuda");
		this.setContentPane(getJContentPane());
		Janelas.alinharContainer(this);
	}

	/** 
	 * Este método inicializa o jContentPane.
	 * 
	 * @return javax.swing.JPanel O jContentPane da janela.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Em Construção...");
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(jLabel, gridBagConstraints);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
