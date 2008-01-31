package gui.modelos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

class FullLineHighlightPainter implements Highlighter.HighlightPainter {
	Color color;
	
	public FullLineHighlightPainter(Color c){
		color = c;
	}
	
	public void paint(Graphics g, int p0, int p1, Shape bounds, JTextComponent c) {
		Rectangle r0 = null, r1 = null;
		
		try {  // convert positions to pixel coordinates
			r0 = c.modelToView(p0);
			r1 = c.modelToView(p1);
		} catch (BadLocationException ex) { return; }
		
		if ((r0 == null) || (r1 == null)) return;
		
		g.setColor(color);
		
		// special case if p0 and p1 are on the same line
		if (r0.y == r1.y) {
			g.fillRect(0, r0.y, c.getWidth(), r0.height);
		}else{
			g.fillRect(0, r0.y, c.getWidth(), r1.y - r0.y + r1.height);
		}
		return;
	}
}

/**
 * Modela uma linha do editor de texto. Contem a string que deve
 * ser escrita e os caracteres de inicio e final.
 * 
 * @autor Luciano Santos
 */
class Linha {
	/* Texto a ser escrito e caracteres inicial e final (posicao). */
	public String texto;
	public int posInicial;
	public int posFinal;
	public ArrayList tokens;
	public ArrayList styles;
	
	/**
	 * Instancia nova linha.
	 * 
	 * @param texto Texto que a linha contem.
	 * @param posInicial Posicao no texto do primeiro caractere da string.
	 * @param posFinal Posicao no texto do ultimo caractere da string.
	 */
	public Linha(String texto, int posInicial, int posFinal,
			ArrayList tokens, ArrayList styles){
		this.texto = texto;
		this.posInicial = posInicial;
		this.posFinal = posFinal;
		this.tokens = tokens;
		this.styles = styles;
	}
	
	/**
	 * Decompõe uma string em uma seqüência de linhas, marcando qual
	 * a posição do caractere inicial e final em cada linha.
	 * 
	 * @param texto Uma string com o texto a ser decomposto.
	 */
	public static ArrayList<Linha> decompor(String texto) throws Exception{
		ArrayList<Linha> arraytemp = new ArrayList<Linha>();
		char[] temp = texto.toCharArray();
		int i = 0;
		boolean ehComentCh = false;
		boolean ehComentPar = false;
		while(i < temp.length){
			String linhatemp = "";
			int posInicial = i;
			
			/*Lê a linha...*/
			while(i < temp.length){
				char a = temp[i];
				linhatemp += a;
				
				if(a == '\n'){
					break;
				}else{
					i++;
				}
			}
			
			int posFinal = i;
			
			if(i > temp.length){
				posFinal = i - 1;
			}
			
			/*Tokeniza a linha...*/
			ArrayList temptokens = new ArrayList();
			ArrayList tempstyles = new ArrayList();
			Anlex anlex = new Anlex(linhatemp);
			
			Token t;
			boolean fim = false;
			do{
				try{
                                        t = anlex.getToken();
					temptokens.add(new String(t.getValor()));
					
					String estilo = new String(CaixaTexto
							.estilos[CaixaTexto.REGULAR]);
					
					if((t.getId() == Token.EOLINE)||(t.getId() == Token.EOB)){
						fim = true;
					}
					
					if(ehComentCh||ehComentPar){
						estilo = new String(CaixaTexto
								.estilos[CaixaTexto.COMENTARIO]);
						if(ehComentCh){
							if(t.getId() == Token.ENDCOMMENT_CH){
								ehComentCh = false;
							}
						}else{
							if(t.getId() == Token.ENDCOMMENT_PAR){
								ehComentPar = false;
							}
						}
					}else{
						switch(t.getId()){
							case Token.IDENTIFIER:
								if(Token.ehPalavraChave(t.getValor())){
									estilo = new String(CaixaTexto
											.estilos[CaixaTexto.PALAVRA_CHAVE]);
								}else if(Token.ehTipo(t.getValor())){
									estilo = new String(CaixaTexto
											.estilos[CaixaTexto.TIPO]);
								}
								break;
							case Token.STRING:
								estilo = new String(CaixaTexto
										.estilos[CaixaTexto.LITERAL]);
								break;
							case Token.BEGINCOMMENT_CH:
								if(!ehComentPar){
									estilo = new String(CaixaTexto
											.estilos[CaixaTexto.COMENTARIO]);
									ehComentCh = true;
								}
								break;
							case Token.BEGINCOMMENT_PAR:
								if(!ehComentCh){
									estilo = new String(CaixaTexto
											.estilos[CaixaTexto.COMENTARIO]);
									ehComentPar = true;
								}
								break;
							case Token.PONT:
								estilo = new String(CaixaTexto
										.estilos[CaixaTexto.PONTUACAO]);
								break;
							case Token.NUM:
								estilo = new String(CaixaTexto
										.estilos[CaixaTexto.NUMEROS]);
								break;
						}
					}
					
					tempstyles.add(estilo);
				}catch(Exception e){
					throw e;
				}
			}while(!fim);
			
			arraytemp.add(new Linha(linhatemp, posInicial, posFinal,
					temptokens, tempstyles));
			
			/*Próxima linha...*/
			i++;
		}
		return arraytemp;
	}
}

/**
 * Modela uma caixa de texto com código-fonte em Pascal.
 * 
 * @author Renan e Luciano Santos
 */
public class CaixaTexto extends JTextPane {
	
	/* Lista interna das linhas de texto. */
	ArrayList linhas;
	
	/*Define se o texto conterá higlighting ou não...*/
	private boolean highlighted = true;
	
	/*Define qual linha deve ser destacada. Se for menor que zero, nenhuma.*/
	private int linha_destacada = -1;
	
	/*Índices de acesso aos nomes dos estilos...*/
	public static final String[] estilos = {"regular", "palavra_chave",
		"literal", "comentario", "pontuacao", "num", "tipo"};
	
	/*Cores do highlighting e do destaque.*/
	private Color cores[] = {Color.BLACK, Color.BLUE, Color.RED,
			new Color(180,180,180),Color.BLACK, new Color(180, 50, 180),
			new Color(0, 100, 50), new Color(255, 255, 0)};
	
	/*Fonte básica...*/
	Font fonte_basica = new Font("Courier New", Font.PLAIN, 14);
	
	
	/*Constantes para identificar as cores a serem alteradas...*/
	public static final int REGULAR 	  	= 0;
	public static final int PALAVRA_CHAVE 	= 1;
	public static final int LITERAL 		= 2;
	public static final int COMENTARIO 		= 3;
	public static final int PONTUACAO 		= 4;
	public static final int NUMEROS 		= 5;
	public static final int TIPO 			= 6;
	public static final int DESTAQUE 		= 7;
	
	
	/**
	 * Constrói nova CaixaTexto usando o método construtor básico.
	 */
    public CaixaTexto() {
    	super();
    	linhas = new ArrayList();
    	construirTexto();
    	this.setHighlighter(new DefaultHighlighter());
    }
    
    /**
	 * Constrói nova CaixaTexto.
	 * 
	 * @param texto texto inicial da caixa de texto.
	 */
    public CaixaTexto(String texto){
    	super();    	
    	try{
    		linhas = Linha.decompor(texto);
    	}catch(Exception e){
    		linhas = new ArrayList();
    	}
    	construirTexto();
    	this.setHighlighter(new DefaultHighlighter());
    }
	
    public void setText(String texto){    	
    	try{
    		linhas = Linha.decompor(texto);
    	}catch(Exception e){
    		linhas = new ArrayList();
    	}
    	construirTexto();
    }
    
    public void setText(Reader reader) throws IOException{
    	StringBuffer s = new StringBuffer("");
		BufferedReader r = new BufferedReader(reader);
		String linha = null;
		try{
			while((linha = r.readLine()) != null)
				s.append(linha + "\n");
		}catch(IOException e){
			throw e;
		}
    	
    	this.setText(s.toString());
    }
    
    public void setHighlighted(boolean high){
    	if(highlighted != high){
    		highlighted = high;
    		construirTexto();
    	}
    }
    
    public void setMarcada(int linha){
    	if(linha != linha_destacada){
	    	if(linha > linhas.size()){
	    		linha_destacada = linhas.size();
	    	}else{
	    		linha_destacada = linha;
	    	}
	    	
	    	try{
		    	DefaultHighlighter dh = (DefaultHighlighter) this.getHighlighter();
		    	dh.removeAllHighlights();
		    	
		    	if(linha_destacada > 0){
		    		Linha temp = (Linha) linhas.get(linha_destacada-1);
		    		dh.addHighlight(temp.posInicial, temp.posFinal,
		    			new FullLineHighlightPainter(cores[DESTAQUE]));
		    		
		    	}
		    	
		    	this.update(this.getGraphics());
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}
    }
    
    public void setBaseFont(Font f){
    	this.fonte_basica = f;
    	construirTexto();
    }
    
    /**
     * 	Muda uma das cores de highlighting/destaque.
     * 
     *  Espera uma constante definindo qual cor deve ser mudada.
     *  
     * @param const_cor Espera uma das constantes informando qual cor deve ser alterada.
     * @param c Nova cor.
     */
    public void setColor(int const_cor, Color c){
    	if((const_cor >= REGULAR) && (const_cor <= TIPO)){
    		cores[const_cor] = c;
    	}else{
    		cores[REGULAR] = c;
    	}
    	construirTexto();
    }
    
    public int getMarcada(){
    	return linha_destacada;
    }
        
    private void construirTexto(){
    	super.setText("");
    	StyledDocument doc = getStyledDocument();
        addStyles(doc);
    	try {
    		Iterator ilinhas = linhas.iterator();
    		int i = 0;
    		while(ilinhas.hasNext()){
    			Linha temp = (Linha) ilinhas.next();
    			Iterator itokens = temp.tokens.iterator();
    			Iterator istyles = temp.styles.iterator();
    			
    			while(itokens.hasNext()){
    				String nome_estilo = highlighted ?
						((String) istyles.next())
						:(new String(estilos[REGULAR]));    				
    				doc.insertString(doc.getLength(), (String) itokens.next(),
	    				doc.getStyle(nome_estilo));
    			}
    			i++;
    		}
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
	private void addStyles(StyledDocument doc){
		Style def = StyleContext.getDefaultStyleContext().
        getStyle(StyleContext.DEFAULT_STYLE);
		
		/*Remove estilos antes de adicionar...*/
		for(int i = 0; i <= TIPO; i++){
			doc.removeStyle(estilos[i]);
			doc.addStyle(estilos[i], def);
		}
		
		/*Estilo para texto qualquer...*/
		Style s = doc.getStyle("regular");
		StyleConstants.setFontFamily(def, fonte_basica.getFamily());
		StyleConstants.setFontSize(def, fonte_basica.getSize());
		
		/*Estilo para palavras chave...*/
		s = doc.getStyle("palavra_chave");
		StyleConstants.setBold(s, true);
		StyleConstants.setForeground(s, cores[PALAVRA_CHAVE]);
		
		/*Estilo para literais...*/
		s = doc.getStyle("literal");
		StyleConstants.setBold(s, false);
		StyleConstants.setForeground(s, cores[LITERAL]);
		
		/*Estilo para comentários...*/
		s = doc.getStyle("comentario");
		StyleConstants.setBold(s, false);
		StyleConstants.setItalic(s, true);
		StyleConstants.setForeground(s, cores[COMENTARIO]);
		
		/*Estilo para pontuação...*/
		s = doc.getStyle("pontuacao");
		StyleConstants.setBold(s, true);
		StyleConstants.setItalic(s, false);
		StyleConstants.setForeground(s, cores[PONTUACAO]);
		
		/*Estilo para numeração...*/
		s = doc.getStyle("num");
		StyleConstants.setBold(s, false);
		StyleConstants.setItalic(s, false);
		StyleConstants.setForeground(s, cores[NUMEROS]);
		
		/*Estilo para tipos...*/
		s = doc.getStyle("tipo");
		StyleConstants.setBold(s, true);
		StyleConstants.setItalic(s, false);
		StyleConstants.setForeground(s, cores[TIPO]);
		
//		/*Remove estilos antes de adicionar...*/
//		for(int i = 0; i <= TIPO; i++){
//			Style temp = doc.getStyle(estilos[i]);
//			temp = doc.addStyle(estilos[i] + "_marcado", temp);
//			StyleConstants.setBackground(temp, cores[DESTAQUE]);
//		}
	}
	
//	protected void paintComponent(Graphics g){		
//		Rectangle r = this.getBounds();
//		Insets insets = this.getInsets();
//		
//		super.paintComponent(g);
//		
//		// ...e desenhamos o highlighting
//		int altura = this.getFontMetrics(this.fonte_basica).getHeight(); 
//		int y = altura * (linha_destacada + 1);
//		g.setColor(cores[DESTAQUE]);
//		g.fillRect(0, y + 1, r.width, altura + 1);
//		
//		Font f = this.fonte_basica.deriveFont(Font.BOLD);
//		g.setFont(f);
//		g.setColor(Color.BLACK);
//		g.drawString(((Linha) linhas.get(linha_destacada)).texto, 0, y + altura - 2);
//	}
}
