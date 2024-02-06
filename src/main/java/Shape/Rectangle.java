package Shape;

import Point.Point2d;
import java.util.Collection;

public class Rectangle extends BaseShape {
    public Rectangle(Double width, Double height) {
        super(RectangleCoords(width, height));
    }

    public Rectangle(Point2d dimensions) {
        super(RectangleCoords(dimensions.X(), dimensions.Y()));
    }

    private Rectangle(Collection<Point2d> coords) {
        super(coords);
    }

    @Override
    public Rectangle clone() {
        return new Rectangle(cloneCoords());
    }

    private static Collection<Point2d> RectangleCoords(Double width, Double height) {
        Collection<Point2d> rectangleCoords = new java.util.ArrayList<>();

        double halfWidth = width / 2.0;
        double halfHeight = height / 2.0;

        for (double x = -halfWidth; x <= halfWidth; x += 0.5) {
            for (double y = -halfHeight; y <= halfHeight; y += 0.5) {
                rectangleCoords.add(new Point2d(x, y));
            }
        }

        return rectangleCoords;
    }
}
