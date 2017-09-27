import java.util.ArrayList;

import com.jogamp.opengl.GL;

/**
 * Created by allan on 30/08/17.
 */
public class Main {
    public static void main(String[] args) {
        LeituraArquivo leituraArquivo = new LeituraArquivo(ArquivosDataSet.BRASIL_BR01);
        ArrayList<Pessoa> listaPessoas = leituraArquivo.ler();
        Desenho desenho = new Desenho(leituraArquivo.getMaxY(),leituraArquivo.getMaxX(), listaPessoas, leituraArquivo.getFrame());
        desenho.play();
        
        /*
        int tempoAtual = 0;
        int frameMaximo = leituraArquivo.getFrame();
        while(tempoAtual <= frameMaximo){
        	System.out.println("\nFrame " + tempoAtual);
	        for (int i = 0; i < listaPessoas.size(); i++) {
	            Pessoa pessoa = listaPessoas.get(i);
	            if(tempoAtual == pessoa.getFilaCoordenadas().head().getTempo()){
	                Coordenada coordenada = pessoa.getFilaCoordenadas().dequeue();
	                if(pessoa.getFilaCoordenadas().isEmpty())
	                    listaPessoas.remove(i);
		            System.out.println("X:"+ coordenada.getX() + " - " + "Y:"+ coordenada.getY());	               
	            }
	        }
	        tempoAtual++;
        }
        */
    }
}