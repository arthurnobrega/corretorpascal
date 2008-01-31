package gui.modelos;

/**
 * Modela um token da linguagem Pascal.
 * 
 * @author Luciano Santos
 */
public class Token {
	/* Constantes de identificação dos tokens */
	public static final int WHITESPACE					= 0;
	public static final int BEGINCOMMENT_CH				= 1;
	public static final int ENDCOMMENT_CH				= 2;
	public static final int BEGINCOMMENT_PAR			= 3;
	public static final int ENDCOMMENT_PAR				= 4;
	public static final int OTHER						= 5;
	public static final int EOLINE						= 6;
	public static final int PONT						= 7;
	public static final int IDENTIFIER					= 8;
	public static final int STRING						= 11;
	public static final int BAD_STRING					= 12;
	public static final int NUM							= 12;
	public static final int EOB							= 13;
	
	private int id_token;
	private String valor_token;
	
	public static final String palavras[] = {
		"and", "array", "begin", "case", "const", "div", "do",
		"downto", "else", "end", "file", "for", "function", "goto",
		"if", "in", "label", "mod", "nil", "not", "of", "packed",
		"procedure", "program", "record", "repeat", "set", "then",
		"to", "type", "until", "var", "while", "with"};
	
	public static final String tipos[] = {
		"integer", "shortint", "longint", "byte", "word",
		"real", "single", "double", "extended", "comp",
		"char", "string", "boolean"};
	
	public Token(){
		this.id_token = 0;
		this.valor_token = "";
	}
	
	public Token(int id_token, String valor_token){
		this.id_token = id_token;
		this.valor_token = valor_token;
	}
	
	public int getId(){
		return id_token;
	}
	
	public String getValor(){
		return valor_token;
	}
	
	public void setId(int id){
		this.id_token = id;
	}
	
	public void setValor(String valor){
		this.valor_token = valor;
	}
	
	public void appendToValor(char a){
		valor_token += a;
	}
	
	public static boolean ehPalavraChave(String identificador){
		for(int i = 0; i < palavras.length; i++){
			if(palavras[i].compareToIgnoreCase(identificador) == 0){
				return true;
			}
		}
		return false;
	}
	
	public static boolean ehTipo(String identificador){
		for(int i = 0; i < tipos.length; i++){
			if(tipos[i].compareToIgnoreCase(identificador) == 0){
				return true;
			}
		}
		return false;
	}
}
