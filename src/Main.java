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
        
  //      System.out.println(listaPessoas.size());
//        int numP = 1;
//        for (Pessoa pessoa: listaPessoas) {
//        	Queue<Coordenada> filaCoordenadas = pessoa.getFilaCoordenadas();
//        	
//        	while (!filaCoordenadas.isEmpty()) {
//        		Coordenada coordenada = pessoa.getFilaCoordenadas().dequeue();
//        		System.out.println(coordenada.getX() + " " + coordenada.getY()+ " " + numP + " " + coordenada.getTempo());
//        	}
//        	numP++;
//        }
//        
////        
//        int tempoAtual = 1;
//        int frameMaximo = leituraArquivo.getFrame();
//        while(tempoAtual <= frameMaximo){
//        	System.out.println("\nFrame " + tempoAtual);
//	        for (int i = 0; i < listaPessoas.size(); i++) {	        	
//	            Pessoa pessoa = listaPessoas.get(i);
//	            if(pessoa.getFilaCoordenadas().isEmpty()) {
//                   continue;
//                }
//	            
//	            if(tempoAtual == pessoa.getFilaCoordenadas().peek().getTempo()){
//	                Coordenada coordenada = pessoa.getFilaCoordenadas().poll();
//	               
//		            System.out.println("X:"+ coordenada.getX() + " - " + "Y:"+ coordenada.getY());	               
//	            }
//	        }
//	        tempoAtual++;
//        }
    
      //  System.out.println(listaPessoas.size());
        
        
    	}
    }
