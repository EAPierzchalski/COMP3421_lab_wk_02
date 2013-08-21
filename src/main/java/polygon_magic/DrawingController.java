package polygon_magic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 7/08/13
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DrawingController implements MouseListener, MouseMotionListener {

    private DrawingModel drawingModel;

    public DrawingController(DrawingModel drawingModel) {
        this.drawingModel = drawingModel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //TODO
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            drawingModel.appendToCurrentPolygon(new Point(Mouse.getPosition()));
        } else if (e.getButton() == MouseEvent.BUTTON2 || e.getButton() == MouseEvent.BUTTON3) {
            drawingModel.completeCurrentPolygon();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        updateMousePosition(drawingModel);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        updateMousePosition(drawingModel);
    }

    private void updateMousePosition(DrawingModel drawingModel) {
        double[] position = Mouse.getPosition();
        drawingModel.setCurrentPoint(new Point(position[0], position[1]));
    }
}
