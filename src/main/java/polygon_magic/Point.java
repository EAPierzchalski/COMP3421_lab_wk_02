package polygon_magic;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 8/08/13
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class Point {
    final double x;
    final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double[] xy) {
        this.x = xy[0];
        this.y = xy[1];
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
