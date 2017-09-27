/**
 * Created by allan on 30/08/17.
 */

import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

import javax.swing.JFrame;

import java.util.ArrayList;

import static com.jogamp.opengl.GL.*;

public class Desenho extends JFrame implements GLEventListener {
    private static final long serialVersionUID = 1L;
    final private int largura;
    final private int altura;
    private ArrayList<Pessoa> listaPessoas;
    private int proporcao = 10;
    private int frameMaximo;
    private int tempoAtual = 1;
    private static final int FPS = 10;
    
    private int x, y;

    public Desenho(int largura, int altura, ArrayList<Pessoa> listaPessoas, int frameMaximo) {
        super("Minimal OpenGL");
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        
        final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);

        this.listaPessoas = listaPessoas;
        this.frameMaximo = frameMaximo;

        this.setName("Minimal OpenGL");
        this.getContentPane().add(canvas);

        this.largura = 1200;
        this.altura = 700;

        this.setSize(this.largura, this.altura);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        animator.start();
        this.setResizable(false);
        canvas.requestFocusInWindow();
    }
    
    @Override
    public void init(GLAutoDrawable drawable) {
    	GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode( GL2.GL_PROJECTION );
        gl.glLoadIdentity();

        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, largura, 0.0f, altura);

        gl.glMatrixMode( GL2.GL_MODELVIEW );
        gl.glLoadIdentity();
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {}

    @Override
    public void display(GLAutoDrawable drawable) {
    	GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); 
        gl.glClearColor(0,0,0,0);
        gl.glColor3f(0, 0, 1);
        gl.glLineWidth(3);
            
        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            if(tempoAtual == pessoa.getFilaCoordenadas().head().getTempo()){
                Coordenada coordenada = pessoa.getFilaCoordenadas().dequeue();
                if(pessoa.getFilaCoordenadas().isEmpty())
                    listaPessoas.remove(i);

                gl.glBegin( GL.GL_LINE_LOOP );
                gl.glVertex2f(coordenada.getX()-proporcao, altura -(coordenada.getY()-proporcao));
                gl.glVertex2f(coordenada.getX()-proporcao, altura -(coordenada.getY()+proporcao));
                gl.glVertex2f(coordenada.getX()+proporcao, altura -(coordenada.getY()+proporcao));
                gl.glVertex2f(coordenada.getX()+proporcao, altura -(coordenada.getY()-proporcao));
                gl.glEnd();

            }
        }
        tempoAtual++;
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

    }

    public void play() {}

    
    
}