package Shape;

import Point.Point2d;
import java.util.Collection;

public class Ellipse extends BaseShape {
    public Ellipse(Double widthDiameter, Double heightDiameter) {
        super(EllipseCoords(widthDiameter, heightDiameter));
    }

    public Ellipse(Point2d dimensions) {
        super(EllipseCoords(dimensions.X(), dimensions.Y()));
    }

    private Ellipse(Collection<Point2d> coords) {
        super(coords);
    }

    @Override
    public Ellipse clone() {
        return new Ellipse(cloneCoords());
    }

    private static Collection<Point2d> EllipseCoords(Double widthDiameter, Double heightDiameter) {
        Collection<Point2d> ellipseCoords = new java.util.ArrayList<>();

        double halfWidth = widthDiameter / 2.0;
        double halfHeight = heightDiameter / 2.0;

        for (double x = -halfWidth; x <= halfWidth; x += 0.5) {
            for (double y = -halfHeight; y <= halfHeight; y += 0.5) {
                if ((x / halfWidth) * (x / halfWidth) + (y / halfHeight) * (y / halfHeight) <= 1.0) {
                    ellipseCoords.add(new Point2d(x, y));
                }
            }
        }

        return ellipseCoords;
    }
}
