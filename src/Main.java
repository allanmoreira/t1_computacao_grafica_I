import java.util.ArrayList;
import java.util.Arrays;

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by allan on 30/08/17.
 */
public class Main {
    public static void main(String[] args) {
        LeituraArquivo leituraArquivo = new LeituraArquivo(ArquivosDataSet.BRASIL_BR01);
        ArrayList<Pessoa> listaPessoas = leituraArquivo.ler();
        Desenho desenho = new Desenho(leituraArquivo.getMaxY(),leituraArquivo.getMaxX(), listaPessoas, leituraArquivo.getFrame());
        desenho.play();
    }
    
    /*
     * Cria a Matriz de Pessoas/frames
     */
    private static Coordenada[][] criaMatriz(int frames, int qtdPessoa, ArrayList<Pessoa> listaPessoas){
    	
    	Coordenada[][] matriz = new Coordenada[qtdPessoa][frames];
    	
    	for (int x=0;x<qtdPessoa;x++){
    		Pessoa atual = listaPessoas.get(x);
    		int y = 0;
    	//	for (int y=0;y<atual.getQtdeMovimentos();y++){    			
    			Queue<Coordenada> filaCoordenadas = atual.getFilaCoordenadas();                
                while(!filaCoordenadas.isEmpty()){
                	// System.out.print(" " + filaCoordenadas.dequeue().toString());                	
                	Coordenada i = filaCoordenadas.dequeue();
                	matriz[x][y] = i;
                	y++;
                }
    	//	}
    	}
    	
    	
    	return matriz;
    }
}