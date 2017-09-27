import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;



public class OneTriangle {	
	
	
	static Coordenada[][] matriz = Matriz.getMatriz();
	static int frameMaximo = Matriz.getFrame();
	static int MaxPessoas = Matriz.getQtdPessoa();
	
	protected static void setup( GL2 gl2, int width, int height ) {
        gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();
        
  //      System.out.println(frame);
  //      System.out.println(qtdPessoa);
     //   gl2.glViewport( 0, 0, width, height );
    }

    protected static void render( GL2 gl2, int width, int height ) {
        gl2.glClear( GL.GL_COLOR_BUFFER_BIT );

        // draw a triangle filling the window
        gl2.glLoadIdentity();
        
        for (int frame=0;frame<frameMaximo;frame++){
        	//varrer matriz frame a frame 
        	// a cada frame ler todas as coordenadas existentes nele e desenhar na tela
        	
        	//feito isso pula para o próximo frame e 
        }
        
       
        
        
        Coordenada atual = matriz[0][0];
      //  System.out.println(atual.getX());
        
        
        
        
        
        gl2.glBegin( GL.GL_TRIANGLES );
        gl2.glColor3f( 1, 0, 0 );
        gl2.glVertex2f( 0, 0 );
        gl2.glColor3f( 0, 1, 0 );
        gl2.glVertex2f( width, 0 );
        gl2.glColor3f( 0, 0, 1 );
        gl2.glVertex2f( width / 2, height );
        gl2.glEnd();
        
        
     
    }
}
