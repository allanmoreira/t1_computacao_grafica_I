import java.util.ArrayList;

public class Matriz {		
	
	private static Coordenada[][] matriz;
	private static int  frame, qtdPessoa;
	
	
    public static int getFrame() {
		return frame;
	}



	public static void setFrame(int frame) {
		Matriz.frame = frame;
	}







	public static int getQtdPessoa() {
		return qtdPessoa;
	}



	public static void setQtdPessoa(int qtdPessoa) {
		Matriz.qtdPessoa = qtdPessoa;
	}



	public Matriz(Coordenada[][] matriz, int frame, int qtdPessoa){
    	this.frame = frame;
    	this.qtdPessoa = qtdPessoa;
    	this.matriz=matriz;
    	
    }



	public static Coordenada[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(Coordenada[][] matriz) {
		this.matriz = matriz;
	}
	
    
	
	
}
