package project;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import com.jogamp.opengl.util.AnimatorBase;
import com.jogamp.opengl.util.FPSAnimator;


public class SimpleScene implements GLEventListener {
  
  private double theta = 0;
  private double s = 0;
  private double c = 0;
  
  public static void main(String[] args) {
    GLProfile glp = GLProfile.getDefault();
    GLCapabilities caps = new GLCapabilities(glp);
    GLCanvas canvas = new GLCanvas(caps);
    
    canvas.addGLEventListener(new SimpleScene());
    
    JFrame frame = new JFrame("AWT Window Test");
    frame.setSize(300, 300);
    frame.add(canvas);
    frame.setVisible(true);
    
    // With JOGL, JFrame doesn't quit like usual when you click X. I guess
    // there's some extra thread still running.
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    AnimatorBase animator = new FPSAnimator(60);
    animator.add(canvas);
    animator.start();
  }
  
  //////// GLEventListener
  
  public void display(GLAutoDrawable drawable) {
    // put your drawing code here.
    
    update();
    render(drawable);
  }
  
  public void init(GLAutoDrawable drawable) {
    // put your OpenGL initialization code here.
  }
  
  public void dispose(GLAutoDrawable drawable) {
    // put your cleanup code here
  }
  
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    // called when the user resizes the window.
  }
  
  
  ////////
  
  private void update() {
    theta += 0.1;
    s = Math.sin(theta);
    c = Math.cos(theta);
  }
  
  private void render(GLAutoDrawable drawable) {
    
    GL2 gl = drawable.getGL().getGL2();
    
    // clear the background.
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    
    // draw a triangle filling the window.
    gl.glBegin(GL.GL_TRIANGLES);
    gl.glColor3f(1, 0, 0);
    gl.glVertex2d(-c, -c);
    
    gl.glColor3f(0, 1, 0);
    gl.glVertex2d(0, c);
    
    gl.glColor3f(0, 0, 1);
    gl.glVertex2d(s, -s);
    gl.glEnd();
  }
  
}
