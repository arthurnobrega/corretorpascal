package gui.modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * Modela o editor, com a caixa de texto e dois botoes de seta.
 *
 * @author Luciano Santos
 */
public class EditorTexto extends JPanel {	
	CaixaTexto texto; //caixa de texto com o codigo fonte
	private JTextArea numeracoes = new JTextArea("");
	private int linhas = 0;
	
	/**
	 * Cria novo EditorTexto.
	 */
	public EditorTexto(){
		construir("");
	}
	
	/**
	 * Constroi novo EditorTexto.
	 * 
	 * @param texto Texto a ser inserido na caixa de texto.
	 */
	public EditorTexto(String texto){
		construir(texto);
	}
	
	public  CaixaTexto getCaixaTexto(){
		return texto;
	}
        
	/**
	 * Constroi o componente posicionando os objetos na tela.
	 * 
	 * @param textoinicial Texto inicial da caixa de texto
	 */
	private void construir(String textoinicial){
		JPanel painel = new JPanel();
		painel.setLayout(new GridBagLayout());
		GridBagConstraints gb = new GridBagConstraints();
		
		/*Adiciona o rótulo das linhas...*/
		construirNumeracoes(textoinicial);
		gb.anchor = GridBagConstraints.NORTHWEST;
		gb.fill = GridBagConstraints.VERTICAL;
		gb.gridx = 0;
		gb.gridy = 0;
		gb.gridheight = gb.gridwidth = 1;
		gb.weightx = 0;
		gb.weighty = 1;
		painel.add(numeracoes, gb);
		
		/*Cria e adiciona a caixa de texto...*/
		texto = new CaixaTexto(textoinicial);
		texto.setEditable(false);
		gb.anchor = GridBagConstraints.NORTHWEST;
		gb.fill = GridBagConstraints.BOTH;
		gb.gridx = 1;
		gb.gridy = 0;
		gb.gridheight = gb.gridwidth = 1;
		gb.weightx = 1;
		gb.weighty = 1;
		painel.add(texto, gb);
		
		/*Cria o componente...*/
		this.setLayout(new GridBagLayout());
		GridBagConstraints gb2 = new GridBagConstraints();
		gb2.anchor = GridBagConstraints.NORTHWEST;
		gb2.fill = GridBagConstraints.BOTH;
		gb2.gridx = gb2.gridy = 0;
		gb2.gridwidth = gb2.gridheight = 1;
		gb2.weightx = gb2.weighty = 1;
		add(new JScrollPane(painel), gb2);
	}
	
	private void construirNumeracoes(String s){
		numeracoes = new JTextArea("");
		numeracoes.setFont(new Font("Courier New", Font.PLAIN, 14));
		numeracoes.setForeground(Color.GRAY);
		numeracoes.setBackground(new Color(215, 215, 215));
		numeracoes.setEditable(false);
		numeracoes.setAutoscrolls(false);
		renumerar(obterLinhas(s));
	}
	
	private void renumerar(int num_linhas){
		if(num_linhas > 0){
			int i = 1;
			String temp;
			
			if(num_linhas > linhas){
				i = linhas+1;
				temp = numeracoes.getText();
			}else{
				i = 1;
				temp = "";
			}
			
			for(; i <= num_linhas; i++){
				temp += "  " + i + " \n";
			}
			numeracoes.setText(temp);
			linhas = num_linhas;
		}
	}
	
	private int obterLinhas(String s){
		char temp[] = s.toCharArray();
		int linhas = 0;
		if(temp.length > 0){
			linhas++;
			for(int i = 0; i < temp.length; i++){
				if(temp[i] == '\n'){
					linhas++;
				}
			}
		}
		return linhas;
	}
}
