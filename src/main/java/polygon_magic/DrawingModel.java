package polygon_magic;

import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 7/08/13
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class DrawingModel {
    private List<List<Point>> completedPolygons = new ArrayList<List<Point>>();
    private List<Point> currentPolygon = new ArrayList<Point>();
    private Point currentPoint = null;

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public List<Point> getCurrentPolygon() {
        return currentPolygon;
    }

    public void appendToCurrentPolygon(Point point) {
        this.currentPolygon.add(point);
    }

    public void completeCurrentPolygon() {
        this.completedPolygons.add(this.currentPolygon);
        this.currentPolygon = new ArrayList<Point>();
    }

    public List<List<Point>> getCompletedPolygons() {
        return completedPolygons;
    }

}
