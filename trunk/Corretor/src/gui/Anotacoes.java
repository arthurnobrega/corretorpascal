package br.unb.cic.corretor.gui;

import javax.swing.JPanel;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.io.File;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import java.awt.Dimension;

/**
 * Janela que é utilizada para editar as anotações sobre um determinado
 * programa que foi corrigido.
 * 
 * @author arthurthiago
 *
 */
public class Anotacoes extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"

	private JPanel pnlAnotacoes = null;

	private JScrollPane scrlAnotacoes = null;

	private JEditorPane edpAnotacoes = null;

	private JPanel pnlBotoes = null;

	private JButton btnSalvar = null;
	
	private File diretorio = null;
	
	private String aluno = null;

	/** 
	 * Cria uma nova Janela de Anotações para um determinado aluno.
	 * @param pai O JFrame Principal que chama esta Janela de Ajuda.
	 * @param diretorio O diretório que estão localizadas as pastas dos programas corrigidos.
	 * @param aluno O nome da pasta de correção do programa de um aluno.
	 */
	public Anotacoes(Principal pai, File diretorio, String aluno) {
		super(pai, true);
		this.diretorio = diretorio;
		this.aluno = aluno;
		initialize();
	}

	/** 
	 * Este método inicializa esta Janela.
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setTitle("Anotações para o aluno " + aluno);
		this.setContentPane(getJContentPane());
		File diretorioAluno = new File(diretorio.getAbsolutePath() + "/" + aluno);
		boolean achou = false;
		for (String arquivo : diretorioAluno.list()) {
			if (arquivo.equals(Constantes.ARQ_ANOTACOES + ".txt")) {
				achou = true;
				break;
			}
		}
		if (achou) {
			edpAnotacoes.setText(Arquivos.getTextoArquivo(diretorio.getAbsolutePath() + 
					"/" + aluno + "/" +	Constantes.ARQ_ANOTACOES + ".txt"));
		} else {
			JOptionPane.showMessageDialog(null, "O arquivo " + Constantes.ARQ_ANOTACOES +
					".txt deste aluno foi criado.");
			Arquivos.salvarArquivo(diretorio.getAbsolutePath() + "/" + aluno + "/" + 
					Constantes.ARQ_ANOTACOES + ".txt", getEdpAnotacoes().getText());
		}
		Janelas.alinharContainer(this);
	}

	/** 
	 * Este método inicializa o jContentPane.
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.setSize(new Dimension(294, 182));
			jContentPane.add(getPnlAnotacoes(), null);
			jContentPane.add(getPnlBotoes(), null);
		}
		return jContentPane;
	}

	/** 
	 * Este método inicializa o Painel de Anotações.
	 * 	
	 * @return javax.swing.JPanel O Painel de Anotações.
	 */
	private JPanel getPnlAnotacoes() {
		if (pnlAnotacoes == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.weightx = 1.0;
			pnlAnotacoes = new JPanel();
			pnlAnotacoes.setLayout(new GridBagLayout());
			pnlAnotacoes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			pnlAnotacoes.add(getScrlAnotacoes(), gridBagConstraints);
		}
		return pnlAnotacoes;
	}

	/** 
	 * Este método inicializa o Painel de Rolagem que acopla o Painel de Anotações.	
	 * 	
	 * @return javax.swing.JScrollPane O Painel de Rolagem.
	 */
	private JScrollPane getScrlAnotacoes() {
		if (scrlAnotacoes == null) {
			scrlAnotacoes = new JScrollPane();
			scrlAnotacoes.setViewportView(getEdpAnotacoes());
		}
		return scrlAnotacoes;
	}

	/** 
	 * Este método inicializa a Caixa de Texto das Anotações.
	 * 	
	 * @return javax.swing.JEditorPane A Caixa de Texto.
	 */
	private JEditorPane getEdpAnotacoes() {
		if (edpAnotacoes == null) {
			edpAnotacoes = new JEditorPane();
		}
		return edpAnotacoes;
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
			pnlBotoes.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			pnlBotoes.add(getBtnSalvar(), null);
		}
		return pnlBotoes;
	}

	/** 
	 * Este método inicializa o Botão Salvar.
	 * 	
	 * @return javax.swing.JButton O Botão Salvar.
	 */
	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton();
			btnSalvar.setText("Salvar");
			btnSalvar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnSalvarActionPerformed();
				}
			});
		}
		return btnSalvar;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Salvar.
	 */
	private void btnSalvarActionPerformed() {
		Arquivos.salvarArquivo(diretorio.getAbsolutePath() + "/" + aluno + "/" +
				Constantes.ARQ_ANOTACOES + ".txt", getEdpAnotacoes().getText());
		this.dispose();
	}
}
