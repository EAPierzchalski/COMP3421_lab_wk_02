package polygon_magic;

import com.jogamp.opengl.util.FPSAnimator;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 7/08/13
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DrawingView implements GLEventListener {

    public static int PANEL_WIDTH = 800;
    public static int PANEL_HEIGHT = 600;

    private DrawingModel drawingModel = new DrawingModel();

    public DrawingView(DrawingModel drawingModel) {
        this.drawingModel = drawingModel;
    }

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {
        //To change body of implemented methods use File | Settings | File Templates.
        GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(1,1,1,1);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        gl.glColor4d(0,0,0,1);

        for (List<Point> polygon : drawingModel.getCompletedPolygons()) {
            drawPolygon(polygon, gl);
        }

        gl.glBegin(GL.GL_LINE_STRIP); {
            for (Point p : drawingModel.getCurrentPolygon()) {
                gl.glVertex2d(p.getX(), p.getY());
            }
            Point currentPoint = drawingModel.getCurrentPoint();
            if (currentPoint != null) {
                gl.glVertex2d(currentPoint.getX(), currentPoint.getY());
            }
        }
        gl.glEnd();

        Mouse.update(gl);
    }

    private void drawPolygon(List<Point> polygon, GL2 gl) {
        gl.glBegin(GL2.GL_POLYGON); {
            for (Point p : polygon) {
                gl.glVertex2d(p.getX(), p.getY());
            }
        }
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i2, int i3, int i4) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) {
        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities glCapabilities = new GLCapabilities(glProfile);

        GLJPanel panel = new GLJPanel(glCapabilities);

        final JFrame jFrame = new JFrame("Polygon Drawing Magic");
        jFrame.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        jFrame.add(panel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingModel drawingModel = new DrawingModel();

        DrawingView drawingView = new DrawingView(drawingModel);

        DrawingController drawingController = new DrawingController(drawingModel);

        panel.addGLEventListener(drawingView);
        panel.addMouseMotionListener(Mouse.theMouse);
        panel.addMouseListener(drawingController);
        panel.addMouseMotionListener(drawingController);

        FPSAnimator animator = new FPSAnimator(panel, 60);
        animator.start();
    }
}
