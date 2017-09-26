/**
 * Created by allan on 30/08/17.
 */

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;

import javax.swing.JFrame;

import java.util.ArrayList;

import static com.jogamp.opengl.GL.*;

public class Desenho extends JFrame implements GLEventListener {
    private static final long serialVersionUID = 1L;
    final private int width = 500;
    final private int height = 500;
    private ArrayList<Pessoa> listaPessoas;
    private int proporcao = 10;
    private int frameMaximo;
    
    private int x, y;

    public Desenho(int largura, int altura, ArrayList<Pessoa> listaPessoas, int frameMaximo) {
        super("Minimal OpenGL");
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);

        this.listaPessoas = listaPessoas;
        this.frameMaximo = frameMaximo;

        this.setName("Minimal OpenGL");
        this.getContentPane().add(canvas);

//        this.setSize(width, height);
        this.setSize(largura, altura);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(true);
        canvas.requestFocusInWindow();
    }
    
    @Override
    public void init(GLAutoDrawable drawable) {
//    	GL2 gl = drawable.getGL().getGL2();
//        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {}

    @Override
    public void display(GLAutoDrawable drawable) {
    	GL2 gl = drawable.getGL().getGL2();
        // Define a cor de desenho: vermelha
        float fl1 = 0;
        float fl2 = 0;
        float fl3 = 0;
//        gl.glLineWidth(2);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glClearColor(0,0,0,0);
        gl.glColor3f(0, 0, 1);
        gl.glLineWidth(3);

        int tempoAtual = 1;

        while(tempoAtual <= frameMaximo){
            for (int i = 0; i < listaPessoas.size(); i++) {
                Pessoa pessoa = listaPessoas.get(i);
                if(tempoAtual == pessoa.getFilaCoordenadas().head().getTempo()){
                    Coordenada coordenada = pessoa.getFilaCoordenadas().dequeue();
                    if(pessoa.getFilaCoordenadas().isEmpty())
                        listaPessoas.remove(i);

                    gl.glBegin( GL.GL_LINE_LOOP );
                    gl.glVertex2f( coordenada.getX()-proporcao, coordenada.getY()-proporcao);
                    gl.glVertex2f( coordenada.getX()-proporcao, coordenada.getY()+proporcao);
                    gl.glVertex2f( coordenada.getX()+proporcao, coordenada.getY()+proporcao);
                    gl.glVertex2f( coordenada.getX()+proporcao, coordenada.getY()-proporcao);
                    gl.glEnd();

                }
            }
            tempoAtual++;
//            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
//            gl.glLoadIdentity();
            gl.glClearColor(0,0,0,0);
            System.out.println(tempoAtual);
        }

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();

        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, 1000, 1000, 0.0f);

        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();

        // Limpa a janela de visualização com a cor preta
//        gl.glClearColor(0,0,0,0);

    }

    public void play() {

    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
    
    
}