package br.unb.cic.corretor.gui;

 
import javax.swing.JPanel;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JScrollPane;

/**
 * Esta janela é responsável por dar ao usuário a escolha da saída que
 * ele deseja visualizar, tendo em visto que podem haver várias saídas,
 * de acordo com o número de entradas que ele fornecer.
 * 
 * @author arthurthiago
 *
 */
public class Saidas extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel pnlLista = null;

	private JPanel pnlBotoes = null;

	private JList lstLista = null;

	private JButton btnVisualizar = null;

	private JScrollPane scrlLista = null;
	
	private File diretorio = null;
	
	private ArrayList<String> saidas = new ArrayList<String>(); 
	
	private Principal pai = null;
	
	private String aluno = null;

	/** 
	 * Cria uma nova Janela de Saídas para o usuário.
	 * @param pai O JFrame Principal que chama esta Janela de Relatório.
	 * @param diretorio O diretório que estão localizadas as pastas dos programas corrigidos.
	 * @param aluno O nome da pasta de correção do programa de um aluno.
	 */
	public Saidas(Principal pai, File diretorio, String aluno) {
		super(pai,true);
		this.pai = pai;
		this.diretorio = diretorio;
		this.aluno = aluno;
		initialize();
	}

	/**
	 * Este método inicializa esta janela.
	 */
	private void initialize() {
		this.setSize(165, 200);
		this.setTitle("Saídas");
		this.setContentPane(getJContentPane());
		preencherLista();
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
			jContentPane.add(getPnlLista(), null);
			jContentPane.add(getPnlBotoes(), null);
		}
		return jContentPane;
	}

	/**
	 * Este método inicializa o Painel da lista.	
	 * 	
	 * @return javax.swing.JPanel O painel da lista.
	 */
	private JPanel getPnlLista() {
		if (pnlLista == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.weightx = 1.0;
			pnlLista = new JPanel();
			pnlLista.setLayout(new GridBagLayout());
			pnlLista.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			pnlLista.add(getScrlLista(), gridBagConstraints1);
		}
		return pnlLista;
	}

	/**
	 * Este método inicializa o Painel dos Botões.	
	 * 	
	 * @return javax.swing.JPanel O painel dos botões.
	 */
	private JPanel getPnlBotoes() {
		if (pnlBotoes == null) {
			pnlBotoes = new JPanel();
			pnlBotoes.setLayout(new BoxLayout(getPnlBotoes(), BoxLayout.X_AXIS));
			pnlBotoes.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
			pnlBotoes.add(getBtnVisualizar(), null);
		}
		return pnlBotoes;
	}

	/**
	 * Este método inicializa a lista de saídas.
	 * 	
	 * @return javax.swing.JList A lista de saídas.
	 */
	private JList getLstLista() {
		if (lstLista == null) {
			lstLista = new JList();
		}
		return lstLista;
	}

	/**
	 * Este método inicializa o botão Visualizar.	
	 * 	
	 * @return javax.swing.JButton O botão Visualizar.
	 */
	private JButton getBtnVisualizar() {
		if (btnVisualizar == null) {
			btnVisualizar = new JButton();
			btnVisualizar.setText("Visualizar");
			btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnVisualizarActionPerformed();
				}
			});
		}
		return btnVisualizar;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Visualizar.
	 */
	private void btnVisualizarActionPerformed() {
		String saidaSelecionada = (String) lstLista.getSelectedValue();
		String saidaAluno = null;
        saidaAluno = Arquivos.getTextoArquivo(diretorio + "/" + aluno + "/" + saidaSelecionada);
        pai.getEditorTexto().getCaixaTexto().setHighlighted(false);
        pai.getEditorTexto().getCaixaTexto().setText(saidaAluno);
    	this.dispose();
	}

	/**
	 * Este método inicializa a Barra de Rolagem da lista.	
	 * 	
	 * @return javax.swing.JScrollPane A barra de rolagem da lista.
	 */
	private JScrollPane getScrlLista() {
		if (scrlLista == null) {
			scrlLista = new JScrollPane();
			scrlLista.setViewportView(getLstLista());
		}
		return scrlLista;
	}
	
	/**
	 * Este método preenche a lista com todas as saídas que forem encontradas.
	 */
	private void preencherLista() {
		String[] arquivos = new File(diretorio.getAbsolutePath() + "/" + aluno).list();
		for (String arquivo : arquivos) {
 		   if (arquivo.contains(Constantes.ARQ_SAIDA)) {
 			   saidas.add(arquivo);
 		   }
 	   	}
		getLstLista().setModel(new javax.swing.AbstractListModel() {
			public int getSize() { 
				return saidas.size();
			}
			public Object getElementAt(int i) { 
				return saidas.get(i);
			}
		});
		lstLista.setSelectedIndex(0);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
