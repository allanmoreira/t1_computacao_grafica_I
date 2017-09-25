import java.util.ArrayList;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.awt.GLCanvas;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by allan on 30/08/17.
 */
public class Main {
    public static void main(String[] args) {
        // Abre uma janela contendo a casinha do exercício dado em aula.
        // Testado no Linux. Nao funciona no Windows
//        Game game = new Game();
//        game.play();

        // Realiza a leitura do dataset e imprime no console
        
    	/*
    	LeituraArquivo leituraArquivo = new LeituraArquivo(ArquivosDataSet.BRASIL_BR01);
        ArrayList<Pessoa> listaPessoas = leituraArquivo.ler();
        
        Game game = new Game(leituraArquivo.getMaxX(), leituraArquivo.getMaxY());
        
        int cont = 1;
        System.out.println("Nome do arquivo: " + leituraArquivo.getNomeArquivo());
        System.out.println("Qtde de pessoas no data set: " + listaPessoas.size());
        for (Pessoa p: listaPessoas) {
            Queue<Coordenada> filaCoordenadas = p.getFilaCoordenadas();
            System.out.println("\nPessoa " + cont++);
            while(!filaCoordenadas.isEmpty()){
                System.out.print(" " + filaCoordenadas.dequeue().toString());
            }
        }
        
        
        game.play();
        */
    	
    	
    	GLProfile glprofile = GLProfile.getDefault();
        GLCapabilities glcapabilities = new GLCapabilities( glprofile );
        final GLCanvas glcanvas = new GLCanvas( glcapabilities );

        glcanvas.addGLEventListener( new GLEventListener() {
            
            @Override
            public void reshape( GLAutoDrawable glautodrawable, int x, int y, int width, int height ) {
                OneTriangle.setup( glautodrawable.getGL().getGL2(), width, height );
            }
            
            @Override
            public void init( GLAutoDrawable glautodrawable ) {
            }
            
            @Override
            public void dispose( GLAutoDrawable glautodrawable ) {
            }
            
            @Override
            public void display( GLAutoDrawable glautodrawable ) {
                OneTriangle.render( glautodrawable.getGL().getGL2(), glautodrawable.getSurfaceWidth(), glautodrawable.getSurfaceHeight() );
            }
        });

        final Frame frame = new Frame( "One Triangle AWT" );
        frame.add( glcanvas );
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent windowevent ) {
                frame.remove( glcanvas );
                frame.dispose();
                System.exit( 0 );
            }
        });

        frame.setSize( 640, 480 );
        frame.setVisible( true );
    }
}