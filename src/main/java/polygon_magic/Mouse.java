package polygon_magic;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashMap;
import java.util.Map;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

/**
 * COMMENT: Comment Mouse 
 *
 * @author malcolmr
 */
public class Mouse extends MouseAdapter {

    public static final Mouse theMouse = new Mouse();
    private MouseEvent myMouse;

    private double myMouseCoords[];

    private Mouse() {
        myMouse = null;
        myMouseCoords = new double[3];
    }
    
    public static double[] getPosition() {
        return theMouse.myMouseCoords;
    }
    
    public static void update(GL2 gl) {
        theMouse.computeMousePosition(gl);
    }
    
    private void computeMousePosition(GL2 gl) {
        int viewport[] = new int[4];
        double mvmatrix[] = new double[16];
        double projmatrix[] = new double[16];

        if (myMouse != null) {
            int x = myMouse.getX();
            int y = myMouse.getY();

            gl.glGetIntegerv(GL2.GL_VIEWPORT, viewport, 0);
            gl.glGetDoublev(GL2.GL_MODELVIEW_MATRIX, mvmatrix, 0);
            gl.glGetDoublev(GL2.GL_PROJECTION_MATRIX, projmatrix, 0);

            GLU glu = new GLU();
            /* note viewport[3] is height of window in pixels */
            y = viewport[3] - y - 1;

            glu.gluUnProject((double) x, (double) y, 0.0, //
                mvmatrix, 0, projmatrix, 0, viewport, 0, myMouseCoords, 0);

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        myMouse = e;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        myMouse = e;
    }
    
}
