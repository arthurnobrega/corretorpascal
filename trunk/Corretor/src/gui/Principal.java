package br.unb.cic.corretor.gui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import br.unb.cic.algostep.gui.editortexto.EditorTexto;

/**
 * Janela Principal do programa, onde serão chamadas todas
 * as outras janelas.
 * 
 * @author arthurthiago
 *
 */
public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JMenuBar barraMenu = null;

	private JMenu menuArquivo = null;

	private JMenuItem itemNova = null;

	private JMenuItem itemImportar = null;

	private JPanel pnlCentral = null;

	private JList lstLista = null;

	private JButton btnFonte = null;

	private JButton btnSaidas = null;

	private JButton btnRelatorio = null;

	private JButton btnRodar = null;

	private JScrollPane scrlLista = null;

	private File diretorio = null;

	private JMenu menuAjuda = null;

	private JMenuItem itemSobre = null;

	private JPanel pnlDados = null;

	private JPanel pnlBotoes = null;

	private JPanel pnlTexto = null;

	private JPanel pnlLista = null;
	
	private EditorTexto caixa = null;

	private JSplitPane splitPnl = null;

	private JMenuItem itemSair = null;

	private JMenuItem itemAjuda = null;

	private JMenu menuFerramentas = null;

	private JMenuItem itemAnotacoes = null;

	private JMenuItem itemGerarRelatorio = null;

	private JMenuItem itemEntradas = null;

	private JMenuItem itemGabarito = null;

	/** 
	 * Cria uma nova Janela do Programa de Correção.
	 */
	public Principal() {
		super();
		initialize();
	}
	
	/**
	 * Este método inicializa esta Janela.
	 */
	private void initialize() {
		this.setSize(558, 357);
		this.setJMenuBar(getBarraMenu());
		this.setContentPane(getJContentPane());
		this.setTitle("Corretor de Programas em Pascal");
		desativarOpcoes(1);
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
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPnlCentral(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	/** 
	 * Este método inicializa a Barra de Menu.
	 * 	
	 * @return javax.swing.JMenuBar A Barra de Menu.
	 */
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.setName("menu");
			barraMenu.add(getMenuArquivo());
			barraMenu.add(getMenuFerramentas());
			barraMenu.add(getMenuAjuda());
		}
		return barraMenu;
	}

	/**
	 * Este método inicializa o Menu Arquivo.
	 * 	
	 * @return javax.swing.JMenu O Menu Arquivo.
	 */
	private JMenu getMenuArquivo() {
		if (menuArquivo == null) {
			menuArquivo = new JMenu();
			menuArquivo.setText("Arquivo");
			menuArquivo.add(getItemNova());
			menuArquivo.add(getItemImportar());
			menuArquivo.add(getItemSair());
		}
		return menuArquivo;
	}

	/**
	 * Este método inicializa o Item Nova Correção.
	 * 	
	 * @return javax.swing.JMenuItem O Item Nova Correção.
	 */
	private JMenuItem getItemNova() {
		if (itemNova == null) {
			itemNova = new JMenuItem();
			itemNova.setText("Nova Correção");
			itemNova.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						itemCorrigirActionPerformed();
					} catch (IOException excecao){
						JOptionPane.showMessageDialog(null, Constantes.ERRO_DIRETORIO);
					}
				}
			});
		}
		return itemNova;
	}
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Corrigir.
	 */
	private void itemCorrigirActionPerformed() throws IOException {
		JFileChooser fc = new JFileChooser();

        /* Restringe a escolha somente a diretórios. */
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int res = fc.showOpenDialog(null);
        diretorio = fc.getSelectedFile();

        if (res == JFileChooser.APPROVE_OPTION) {
            	new Thread(new Runnable() {
            		public void run() {
            			try {
	            			/* Executa o programa de corrigir os códigos fontes. */            			
	                        
	                        StringBuilder builder = new StringBuilder(diretorio.getParent()
	                        		+ "/a.out");
	                        String dir = diretorio.getAbsolutePath() + "/";
	                        for (String aluno : diretorio.list()) {
	                            builder.append(" ");
	                            builder.append(dir);
	                            builder.append(aluno);
	                        }
	            			Runtime.getRuntime().exec(builder.toString());
	            		} catch (IOException e) {
	                        JOptionPane.showMessageDialog(null, Constantes.ERRO_CORRECAO);
	                    }
            		}
            	}).start();
                preencherLista();
                ativarOpcoes(1);
        }
	}

	/**
	 * Este método inicializa o Item Importar.
	 * 	
	 * @return javax.swing.JMenuItem O item Importar.
	 */
	private JMenuItem getItemImportar() {
		if (itemImportar == null) {
			itemImportar = new JMenuItem();
			itemImportar.setText("Importar Correção...");
			itemImportar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemImportarActionPerformed();
				}
			});
		}
		return itemImportar;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Importar.
	 */
	private void itemImportarActionPerformed() {
		JFileChooser fc = new JFileChooser();

        /* Restringe a escolha somente a diretorios. */
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int res = fc.showOpenDialog(null);

        if (res == JFileChooser.APPROVE_OPTION) {
            diretorio = fc.getSelectedFile();
            preencherLista();
            ativarOpcoes(1);
        }
	}

	/**
	 * Este método inicializar o Painel Central.	
	 * 	
	 * @return javax.swing.JPanel O Painel Central.
	 */
	private JPanel getPnlCentral() {
		if (pnlCentral == null) {
			pnlCentral = new JPanel();
			pnlCentral.setLayout(new BoxLayout(getPnlCentral(), BoxLayout.X_AXIS));
			pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			pnlCentral.add(getSplitPnl(), null);
		}
		return pnlCentral;
	}

	/**
	 * Este método inicializa a lista dos diretórios dos alunos.
	 * 	
	 * @return javax.swing.JList A lista dos diretórios dos alunos.
	 */
	private JList getLstLista() {
		if (lstLista == null) {
			lstLista = new JList();
		}
		return lstLista;
	}

	/**
	 * Este método inicializa o botão Fonte.
	 * 	
	 * @return javax.swing.JButton	O Botão Fonte.
	 */
	private JButton getBtnFonte() {
		if (btnFonte == null) {
			btnFonte = new JButton();
			btnFonte.setText("Fonte");
			btnFonte.setHorizontalAlignment(SwingConstants.LEFT);
			btnFonte.setToolTipText("");
			btnFonte.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnFonteActionPerformed();
				}
			});
		}
		return btnFonte;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Fonte.
	 */
	private void btnFonteActionPerformed() {
		String aluno = (String) getLstLista().getSelectedValue();
		if (aluno != null) {
	        String diretorioAluno = diretorio.getAbsolutePath() + "/" + aluno;
	        String fonteAluno = null;
	        fonteAluno = Arquivos.getTextoArquivo(diretorioAluno + "/" + aluno + ".pas");
	        getEditorTexto().getCaixaTexto().setText(fonteAluno);
	        getEditorTexto().getCaixaTexto().setHighlighted(true);
		}
	}

	/**
	 * Este método inicializa o botão Saídas.
	 * 	
	 * @return javax.swing.JButton O Botão Saídas.
	 */
	private JButton getBtnSaidas() {
		if (btnSaidas == null) {
			btnSaidas = new JButton();
			btnSaidas.setText("Saídas");
			btnSaidas.setHorizontalAlignment(SwingConstants.LEFT);
			btnSaidas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnSaidaActionPerformed();
				}
			});
		}
		return btnSaidas;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Saída.
	 */
	private void btnSaidaActionPerformed() {
		String aluno = (String) lstLista.getSelectedValue();
		if (aluno != null) {
	        Saidas saidas = new Saidas(this, diretorio, aluno);
	        saidas.setVisible(true);
		}
	}

	/**
	 * Este método inicializa o botão Relatorio.	
	 * 	
	 * @return javax.swing.JButton O botão Relatório.
	 */
	private JButton getBtnRelatorio() {
		if (btnRelatorio == null) {
			btnRelatorio = new JButton();
			btnRelatorio.setText("Relatório");
			btnRelatorio.setHorizontalAlignment(SwingConstants.LEFT);
			btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnRelatorioActionPerformed();
				}
			});
		}
		return btnRelatorio;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Relatório.
	 */
	private void btnRelatorioActionPerformed() {
		String aluno = (String) lstLista.getSelectedValue();
		if (aluno != null) {
	        String diretorioAluno = diretorio.getAbsolutePath() + "/" + aluno;
	        String relatorioAluno = null;
	        relatorioAluno = Arquivos.getTextoArquivo(diretorioAluno + "/erros.txt");
	        getEditorTexto().getCaixaTexto().setHighlighted(false);
	        getEditorTexto().getCaixaTexto().setText(relatorioAluno);
		}
	}

	/**
	 * Este método inicializa o botão Rodar.	
	 * 	
	 * @return javax.swing.JButton O botão Rodar.
	 */
	private JButton getBtnRodar() {
		if (btnRodar == null) {
			btnRodar = new JButton();
			btnRodar.setText("Rodar Programa");
			btnRodar.setHorizontalAlignment(SwingConstants.LEFT);
			btnRodar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					btnRodarActionPerformed();
				}
			});
		}
		return btnRodar;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no Botão Rodar.
	 */
	private void btnRodarActionPerformed() {
		String aluno = (String) lstLista.getSelectedValue();
		if (aluno != null) {
			try {
	            Process processo = Runtime.getRuntime().exec("konsole ");
	            BufferedWriter out = new BufferedWriter(
	            		new OutputStreamWriter(processo.getOutputStream()));
	            out.write("cd");
	            out.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	}

	/**
	 * Este método inicializa a barra de rolagem da lista.	
	 * 	
	 * @return javax.swing.JScrollPane a barra de rolagem da lista.
	 */
	private JScrollPane getScrlLista() {
		if (scrlLista == null) {
			scrlLista = new JScrollPane();
			scrlLista.setViewportView(getLstLista());
		}
		return scrlLista;
	}

	public EditorTexto getEditorTexto() {
		if (caixa == null) {
			caixa = new EditorTexto();
			caixa.getCaixaTexto().setText("");
			caixa.getCaixaTexto().setEditable(false);
			caixa.getCaixaTexto().setHighlighted(false);
		}
		return caixa;
	}

	/**
	 * Este método inicializa o menu Ajuda.	
	 * 	
	 * @return javax.swing.JMenu O menu Ajuda.
	 */
	private JMenu getMenuAjuda() {
		if (menuAjuda == null) {
			menuAjuda = new JMenu();
			menuAjuda.setText("Ajuda");
			menuAjuda.add(getItemAjuda());
			menuAjuda.add(getItemSobre());
		}
		return menuAjuda;
	}

	/**
	 * Este método inicializa o item Sobre.	
	 * 	
	 * @return javax.swing.JMenuItem O item Sobre.
	 */
	private JMenuItem getItemSobre() {
		if (itemSobre == null) {
			itemSobre = new JMenuItem();
			itemSobre.setText("Sobre");
			itemSobre.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemSobreActionPerformed();
				}
			});
		}
		return itemSobre;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no item Sobre.
	 */
	private void itemSobreActionPerformed() {
		new Sobre(this).setVisible(true);
	}

	/**
	 * Este método inicializa o Painel dos Dados.	
	 * 	
	 * @return javax.swing.JPanel O painel dos dados.
	 */
	private JPanel getPnlDados() {
		if (pnlDados == null) {
			pnlDados = new JPanel();
			pnlDados.setLayout(new BoxLayout(getPnlDados(), BoxLayout.Y_AXIS));
			pnlDados.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			pnlDados.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			pnlDados.add(getPnlBotoes(), null);
			pnlDados.add(getPnlTexto(), null);
		}
		return pnlDados;
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
			pnlBotoes.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			pnlBotoes.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			pnlBotoes.setName("pnlBotoes");
			pnlBotoes.add(getBtnFonte(), null);
			pnlBotoes.add(getBtnSaidas(), null);
			pnlBotoes.add(getBtnRelatorio(), null);
			pnlBotoes.add(getBtnRodar(), null);
		}
		return pnlBotoes;
	}

	/**
	 * Este método inicializa o Painel do Texto.	
	 * 	
	 * @return javax.swing.JPanel O Painel do Texto.
	 */
	private JPanel getPnlTexto() {
		if (pnlTexto == null) {
			pnlTexto = new JPanel();
			pnlTexto.setLayout(new BorderLayout());
			pnlTexto.setName("pnlTexto");
			pnlTexto.add(getEditorTexto(), BorderLayout.CENTER);
		}
		return pnlTexto;
	}

	/**
	 * Este método inicializa o Painel da lista.	
	 * 	
	 * @return javax.swing.JPanel O Painel da Lista.
	 */
	private JPanel getPnlLista() {
		if (pnlLista == null) {
			pnlLista = new JPanel();
			pnlLista.setLayout(new BoxLayout(getPnlLista(), BoxLayout.X_AXIS));
			pnlLista.add(getScrlLista(), null);
		}
		return pnlLista;
	}

	/**
	 * Este método inicializa o Painel de Divisão.	
	 * 	
	 * @return javax.swing.JSplitPane O Painel de Divisão.
	 */
	private JSplitPane getSplitPnl() {
		if (splitPnl == null) {
			splitPnl = new JSplitPane();
			splitPnl.setDividerLocation(130);
			splitPnl.setLeftComponent(getPnlLista());
			splitPnl.setRightComponent(getPnlDados());
		}
		return splitPnl;
	}

	/**
	 * Este método inicializa o item Sair.	
	 * 	
	 * @return javax.swing.JMenuItem O item sair.
	 */
	private JMenuItem getItemSair() {
		if (itemSair == null) {
			itemSair = new JMenuItem();
			itemSair.setText("Sair");
			itemSair.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemSairActionPerformed();
				}
			});
		}
		return itemSair;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no item Sair.
	 */
	private void itemSairActionPerformed() {
		this.dispose();
	}

	/**
	 * Este método inicializa o item Ajuda.	
	 * 	
	 * @return javax.swing.JMenuItem O item Ajuda.
	 */
	private JMenuItem getItemAjuda() {
		if (itemAjuda == null) {
			itemAjuda = new JMenuItem();
			itemAjuda.setText("Conteúdos de Ajuda");
			itemAjuda.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemAjudaActionPerformed();
				}
			});
		}
		return itemAjuda;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no item Ajuda.
	 */
	private void itemAjudaActionPerformed() {
		new Ajuda(this).setVisible(true);
	}

	/**
	 * Este método inicializa o menu Ferramentas.	
	 * 	
	 * @return javax.swing.JMenu O menu Ferramentas.
	 */
	private JMenu getMenuFerramentas() {
		if (menuFerramentas == null) {
			menuFerramentas = new JMenu();
			menuFerramentas.setText("Ferramentas");
			menuFerramentas.add(getItemEntradas());
			menuFerramentas.add(getItemGabarito());
			menuFerramentas.add(getItemAnotacoes());
			menuFerramentas.add(getItemGerarRelatorio());
		}
		return menuFerramentas;
	}

	/**
	 * Este método inicializa o item Anotacoes.	
	 * 	
	 * @return javax.swing.JMenuItem O item Anotações.
	 */
	private JMenuItem getItemAnotacoes() {
		if (itemAnotacoes == null) {
			itemAnotacoes = new JMenuItem();
			itemAnotacoes.setText("Anotações");
			itemAnotacoes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemAnotacoesActionPerformed();
				}
			});
		}
		return itemAnotacoes;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no item Anotações.
	 */
	private void itemAnotacoesActionPerformed() {
		if (lstLista.getSelectedValue() != null) {
			String aluno = (String) lstLista.getSelectedValue();
			new Anotacoes(this, diretorio, aluno).setVisible(true);
		}
	}

	/**
	 * Este método inicializa o item Gerar Relatório.	
	 * 	
	 * @return javax.swing.JMenuItem O item Gerar Relatório.
	 */
	private JMenuItem getItemGerarRelatorio() {
		if (itemGerarRelatorio == null) {
			itemGerarRelatorio = new JMenuItem();
			itemGerarRelatorio.setText("Gerar Relatório de Anotações");
			itemGerarRelatorio.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemGerarRelatorioActionPerformed();
				}
			});
		}
		return itemGerarRelatorio;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no item Gerar Relatório.
	 */
	private void itemGerarRelatorioActionPerformed() {
		new Relatorio(this, diretorio).setVisible(true);
	}

	/**
	 * Este método inicializa o item Entradas.	
	 * 	
	 * @return javax.swing.JMenuItem O item Entradas.
	 */
	private JMenuItem getItemEntradas() {
		if (itemEntradas == null) {
			itemEntradas = new JMenuItem();
			itemEntradas.setText("Editar Entradas");
			itemEntradas.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemEntradasActionPerformed();
				}
			});
		}
		return itemEntradas;
	}
	
	private void itemEntradasActionPerformed() {
		new Entradas(this, diretorio).setVisible(true);
	}

	/**
	 * Este método inicializa o item Gabarito.
	 * 	
	 * @return javax.swing.JMenuItem O item Gabarito.
	 */
	private JMenuItem getItemGabarito() {
		if (itemGabarito == null) {
			itemGabarito = new JMenuItem();
			itemGabarito.setText("Editar Gabaritos");
			itemGabarito.setMnemonic(KeyEvent.VK_UNDEFINED);
			itemGabarito.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					itemGabaritoActionPerformed();
				}
			});
		}
		return itemGabarito;
	}
	
	/** 
	 * Este método é chamado quando ocorre o evento de ActionPerformed no item Gabarito.
	 */
	private void itemGabaritoActionPerformed() {
		new Gabaritos(this, diretorio).setVisible(true);
	}

	/**
	 * Este é o método que roda o programa principal.
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Principal thisClass = new Principal();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
   
   /** Lista os diretórios dos alunos na lista. 
    */
   private void preencherLista() {
       getLstLista().setModel(new javax.swing.AbstractListModel() {
    	   String[] alunos = diretorio.list();
    	   
           public int getSize() { 
               return alunos.length;
           }
           
           public Object getElementAt(int i) {
        	   Arrays.sort(alunos);
               return alunos[i];
           }
       });
       getLstLista().setSelectedIndex(0);
   }
   
   private void ativarOpcoes(int opcaoAtivacao) {
	   if (opcaoAtivacao == 1) {
		   getItemEntradas().setEnabled(true);
		   getItemGabarito().setEnabled(true);
		   getItemAnotacoes().setEnabled(true);
		   getItemGerarRelatorio().setEnabled(true);
		   getPnlCentral().setVisible(true);
	   }
   }
   
   private void desativarOpcoes(int opcaoDesativacao) {
	   if (opcaoDesativacao == 1) {
		   getItemEntradas().setEnabled(false);
		   getItemGabarito().setEnabled(false);
		   getItemAnotacoes().setEnabled(false);
		   getItemGerarRelatorio().setEnabled(false);
		   getPnlCentral().setVisible(false);
	   }
   }


}  //  @jve:decl-index=0:visual-constraint="10,10"
