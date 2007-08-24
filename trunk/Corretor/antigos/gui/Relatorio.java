package br.unb.cic.corretor.gui;

import javax.swing.JPanel;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.BorderFactory;

/**
 * Esta janela é dá ao usuário a oportunidade de gerar um relatório das
 * anotações feitas por ele para cada programa corrigido.
 * 
 * @author arthurthiago
 *
 */
public class Relatorio extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private File diretorio = null;

	private JPanel pnlTexto = null;

	private JPanel pnlBotoes = null;

	private JRadioButton bl1 = null;

	private JRadioButton bl2 = null;

	private JRadioButton bl3 = null;

	private JPanel jPanel2 = null;

	private JButton btnGerar = null;

	private JTextPane texto = null;

	/** 
	 * Cria uma nova Janela de Relatório para o usuário.
	 * @param pai O JFrame Principal que chama esta Janela de Relatório.
	 * @param diretorio O diretório que estão localizadas as pastas dos programas corrigidos.
	 */
	public Relatorio(Principal pai, File diretorio) {
		super(pai, true);
		this.diretorio = diretorio;
		initialize();
	}

	/**
	 * Este método inicializa esta Janela.
	 * 
	 */
	private void initialize() {
		this.setSize(300, 238);
		this.setTitle("Relatório de Anotações");
		this.setContentPane(getJContentPane());
		getBl1().setSelected(true);
		bl1ActionPerformed();
		Janelas.alinharContainer(this);
	}

	/**
	 * Este método inicializa o jContentPane.
	 * 
	 * @return javax.swing.JPanel O jContentPane.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.add(getPnlTexto(), null);
			jContentPane.add(getPnlBotoes(), null);
			jContentPane.add(getJPanel2(), null);
		}
		return jContentPane;
	}
	
	/**
	 * Este método procura por todas as anotações feitas sobre os alunos e gera uma string
	 * onde estará o relatório que será gravado no arquivo com o Layout que o usuário escolher.
	 * @return O relatório em forma de String.
	 */
	private String getRelatorio() {
		StringBuilder relatorio = new StringBuilder();
		String[] alunos = diretorio.list();
		for (String aluno : alunos) {
			File diretorioAluno = new File(diretorio.getAbsolutePath() + "/" + aluno);
			String[] arquivos = diretorioAluno.list();
			for (String arquivo : arquivos) {
				if (arquivo.equals(Constantes.ARQ_ANOTACOES + ".txt")) {
					if (getBl1().isSelected()) {
						relatorio.append(aluno + "\n--------------------\n");
					} else if (getBl2().isSelected()) {
						relatorio.append("----> " + aluno + "\n");
					} else if (getBl3().isSelected()) {
						relatorio.append(aluno + "\t\t");
					}
					relatorio.append(Arquivos.getTextoArquivo(diretorioAluno.getAbsolutePath() + 
							"/" + Constantes.ARQ_ANOTACOES + ".txt"));
					relatorio.append("\n");
					break;
				}
			}
		}
		return relatorio.toString();
	}

	/**
	 * Este método inicializa o Painel de Texto.	
	 * 	
	 * @return javax.swing.JPanel O Painel de Texto.
	 */
	private JPanel getPnlTexto() {
		if (pnlTexto == null) {
			pnlTexto = new JPanel();
			pnlTexto.setLayout(new BoxLayout(getPnlTexto(), BoxLayout.X_AXIS));
			pnlTexto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			pnlTexto.add(getTexto(), null);
		}
		return pnlTexto;
	}

	/**
	 * Este método inicializa o Painel dos Botões.	
	 * 	
	 * @return javax.swing.JPanel O Painel dos Botões.
	 */
	private JPanel getPnlBotoes() {
		if (pnlBotoes == null) {
			pnlBotoes = new JPanel();
			pnlBotoes.setLayout(new BoxLayout(getPnlBotoes(), BoxLayout.X_AXIS));
			pnlBotoes.add(getBl1(), null);
			pnlBotoes.add(getBl2(), null);
			pnlBotoes.add(getBl3(), null);
			ButtonGroup grupo = new ButtonGroup();
			grupo.add(getBl1());
			grupo.add(getBl2());
			grupo.add(getBl3());
		}
		return pnlBotoes;
	}

	/**
	 * Este método inicializa o RadioButton 1.	
	 * 	
	 * @return javax.swing.JRadioButton	 O primeiro RadioButton.
	 */
	private JRadioButton getBl1() {
		if (bl1 == null) {
			bl1 = new JRadioButton();
			bl1.setText("Opção 1");
			bl1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bl1ActionPerformed();
				}
			});
		}
		return bl1;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão 1.
	 */
	private void bl1ActionPerformed() {
		getTexto().setText("aluno1\n----------------\nAnotações feitas...\n\n" +
				"aluno2\n----------------\nAnotações feitas...");
	}

	/**
	 * Este método inicializa o RadioButton 2.
	 * 	
	 * @return javax.swing.JRadioButton	O Segundo RadioButton.
	 */
	private JRadioButton getBl2() {
		if (bl2 == null) {
			bl2 = new JRadioButton();
			bl2.setText("Opção 2");
			bl2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bl2ActionPerformed();
				}
			});
		}
		return bl2;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão 2.
	 */
	private void bl2ActionPerformed() {
		getTexto().setText("----> aluno1\nAnotações feitas...\n\n" +
				"----> aluno2\nAnotações feitas...\n.\n.\n.");
	}

	/**
	 * Este método inicializa o RadioButton 3.
	 * 	
	 * @return javax.swing.JRadioButton	O terceiro RadioButton.
	 */
	private JRadioButton getBl3() {
		if (bl3 == null) {
			bl3 = new JRadioButton();
			bl3.setText("Opção 3");
			bl3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bl3ActionPerformed();
				}
			});
		}
		return bl3;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão 3.
	 */
	private void bl3ActionPerformed() {
		getTexto().setText("aluno1\tAnotações feitas...\n\naluno2\tAnotações " +
				"feitas...\n\naluno3\tAnotações feitas...\n.\n.\n.");
	}

	/**
	 * Este método inicializa o Painel dos Botões.
	 * 	
	 * @return javax.swing.JPanel O Painel dos Botões
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BoxLayout(getJPanel2(), BoxLayout.X_AXIS));
			jPanel2.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
			jPanel2.add(getBtnGerar(), null);
		}
		return jPanel2;
	}

	/**
	 * Este método inicializa o Botão Gerar Relatório.	
	 * 	
	 * @return javax.swing.JButton O Botão Gerar Relatório.
	 */
	private JButton getBtnGerar() {
		if (btnGerar == null) {
			btnGerar = new JButton();
			btnGerar.setText("Gerar Relatório");
			btnGerar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnGerarActionPerformed();
				}
			});
		}
		return btnGerar;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Gerar Relaório.
	 */
	private void btnGerarActionPerformed() {
		String nomeArquivo = diretorio.getParent() + "/" + Constantes.ARQ_RELATORIO + 
		"_" +  diretorio.getName() + ".txt";
		Arquivos.salvarArquivo(nomeArquivo, getRelatorio());
		this.dispose();
	}

	/**
	 * Este método inicializa a Área do Texto.	
	 * 	
	 * @return javax.swing.JTextPane A Área do Texto.
	 */
	private JTextPane getTexto() {
		if (texto == null) {
			texto = new JTextPane();
			texto.setEditable(false);
		}
		return texto;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
