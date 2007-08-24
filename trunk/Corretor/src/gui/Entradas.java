package br.unb.cic.corretor.gui;

import javax.swing.JPanel;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;

import br.unb.cic.algostep.gui.editortexto.CaixaTexto;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
 * Janela que é utilizada para que o usuário informe as entradas que serão
 * jogadas no programa testado, para que depois as saídas sejam comparadas
 * com o gabarito.
 * 
 * @author arthurthiago
 *
 */
public class Entradas extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	
	private File diretorio;

	private JSplitPane jSplitPane = null;

	private JPanel pnlLista = null;

	private JPanel pnlTexto = null;

	private JList lstLista = null;

	private JEditorPane edpEntradas = null;

	private JPanel pnlBotoes = null;

	private JButton btnSalvar = null;

	private JPanel pnlEntradas = null;
	
	private ArrayList<String> entradas = new ArrayList<String>();

	/**
	 * Cria uma nova Janela de Entradas para o usuário.
	 * @param pai O JFrame Principal que chama esta Janela de Ajuda.
	 * @param diretorio O diretório que estão localizadas as pastas dos programas corrigidos.
	 */
	public Entradas(Principal pai, File diretorio) {
		super(pai, true);
		this.diretorio = diretorio;
		initialize();
	}

	/**
	 * Este método inicializa esta Janela.
	 */
	private void initialize() {
		this.setSize(367, 210);
		this.setContentPane(getJContentPane());
		this.setTitle("Entradas");
		preencherLista();
		Janelas.alinharContainer(this);
	}

	/**
	 * Este método inicializa o jContentPane.
	 * 
	 * @return javax.swing.JPanel O jContentPane da janela.
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
			jContentPane.add(getPnlEntradas(), null);
			jContentPane.add(getPnlBotoes(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setDividerSize(10);
			jSplitPane.setDividerLocation(100);
			jSplitPane.setBackground(Color.white);
			jSplitPane.setLeftComponent(getPnlLista());
			jSplitPane.setRightComponent(getPnlTexto());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes pnlLista	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlLista() {
		if (pnlLista == null) {
			pnlLista = new JPanel();
			pnlLista.setLayout(new BoxLayout(getPnlLista(), BoxLayout.Y_AXIS));
			pnlLista.setBackground(Color.white);
			pnlLista.add(getLstLista(), null);
		}
		return pnlLista;
	}

	/**
	 * This method initializes pnlTexto	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlTexto() {
		if (pnlTexto == null) {
			pnlTexto = new JPanel();
			pnlTexto.setLayout(new BoxLayout(getPnlTexto(), BoxLayout.X_AXIS));
			pnlTexto.add(getEdpEntradas(), null);
		}
		return pnlTexto;
	}

	/**
	 * This method initializes lstLista	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getLstLista() {
		if (lstLista == null) {
			lstLista = new JList();
			lstLista
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							lstListaValueChanged();
						}
					});
		}
		return lstLista;
	}
	
	private void lstListaValueChanged() {
		String nomeArq = diretorio.getParent() + "/" + getLstLista().getSelectedValue();
		String texto = Arquivos.getTextoArquivo(nomeArq);
		getEdpEntradas().setText(texto);
	}

	/**
	 * This method initializes jTextPane	
	 * 	
	 * @return javax.swing.JTextPane	
	 */
	private JEditorPane getEdpEntradas() {
		if (edpEntradas == null) {
			edpEntradas = new JEditorPane();
		}
		return edpEntradas;
	}

	/**
	 * This method initializes pnlBotoes	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlBotoes() {
		if (pnlBotoes == null) {
			pnlBotoes = new JPanel();
			pnlBotoes.setLayout(new BoxLayout(getPnlBotoes(), BoxLayout.X_AXIS));
			pnlBotoes.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
			pnlBotoes.add(getBtnSalvar(), null);
		}
		return pnlBotoes;
	}

	/**
	 * This method initializes btnSalvar	
	 * 	
	 * @return javax.swing.JButton	
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
		String arquivo = diretorio.getParent() + "/" + (String) getLstLista().getSelectedValue();
		JOptionPane.showMessageDialog(null, arquivo);
		Arquivos.salvarArquivo(arquivo, getEdpEntradas().getText());
		this.dispose();
	}

	/**
	 * This method initializes pnlEntradas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlEntradas() {
		if (pnlEntradas == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.weighty = 1.0;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			pnlEntradas = new JPanel();
			pnlEntradas.setLayout(new GridBagLayout());
			pnlEntradas.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
			pnlEntradas.add(getJSplitPane(), gridBagConstraints2);
		}
		return pnlEntradas;
	}
	
	private void preencherLista() {
		File diretorioPai = new File(diretorio.getParent());
		for (String arquivo : diretorioPai.list()) {
 		   if (arquivo.contains(Constantes.ARQ_ENTRADA)) {
 			   entradas.add(arquivo);
 		   }
 	   	}
		getLstLista().setModel(new javax.swing.AbstractListModel() {
			public int getSize() { 
				return entradas.size();
			}
			public Object getElementAt(int i) { 
				return entradas.get(i);
			}
		});
		lstLista.setSelectedIndex(0);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
