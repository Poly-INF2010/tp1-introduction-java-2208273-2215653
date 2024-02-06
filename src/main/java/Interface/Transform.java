package Interface;

import Point.Point2d;

import java.util.Collection;

public class Transform implements Rotate, Translate{
    @Override
    public Collection<Point2d> rotate(Collection<Point2d> coords, Double angle) {
        coords.forEach(point -> point.rotate(angle));
        return coords;
    }

    @Override
    public Collection<Point2d> translate(Collection<Point2d> coords, Point2d translateVector) {
        coords.forEach(point -> point.translate(translateVector));
        return coords;
    }
}

