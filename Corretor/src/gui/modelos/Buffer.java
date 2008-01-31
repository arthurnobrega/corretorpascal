package gui.modelos;

class FimDeBufferAtingidoException extends Exception{
}

public class Buffer {
	char buffer[];
	int i;
	
	public Buffer(String b){
		this.buffer = b.toCharArray();
		if(buffer.length > 0){
			i = -1;
		}else{
			i = 0;
		}
	}
	
	public int getchar(){
		if(i < buffer.length){
			return buffer[++i];
		}else{
			return -1;
		}
	}
	
	public void ungetchar(){
		if(i >= 0){
			i--;
		}
	}
	
	public int length(){
		return buffer.length;
	}
}
