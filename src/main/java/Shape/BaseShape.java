package Shape;

import Interface.Transform;
import Point.Point2d;

import java.util.*;
import java.util.stream.Collectors;

public class BaseShape extends Transform implements Cloneable {
    private final Collection<Point2d> coords;

    //helper function to clone a list of points
    public Collection<Point2d> cloneCoords(Collection<Point2d> coords) {
        return coords.stream().map(Point2d::clone).collect(Collectors.toList());
    }

    public BaseShape() {
        this.coords = new ArrayList<>();
    }

    public BaseShape(Collection<Point2d> coords) {
        this.coords = cloneCoords(coords);
    }

    public BaseShape add(Point2d coord) {
        this.coords.add(coord.clone());
        return this;
    }

    public BaseShape add(BaseShape shape) {
        this.coords.addAll(shape.cloneCoords());
        return this;
    }

    public BaseShape addAll(Collection<Point2d> coords) {
        this.coords.addAll(cloneCoords(coords));
        return this;
    }

    public BaseShape remove(Point2d coord) {
        coords.remove(coord);
        return this;
    }

    public BaseShape remove(BaseShape shape) {
        coords.removeAll(shape.getCoords());
        return this;
    }

    public BaseShape removeAll(Collection<Point2d> coords) {
        this.coords.removeAll(coords);
        return this;
    }

    public BaseShape replaceAll(Collection<Point2d> newCoords) {
        return new BaseShape(newCoords);
    }

    public Collection<Point2d> getCoords() {
        return new ArrayList<>(coords);
    }

    public Collection<Point2d> cloneCoords() {
        return cloneCoords(coords);
    }

    public Double getMaxX() {
        double maxX = -Double.MAX_VALUE;
        for (Point2d point : coords) {
            maxX = Math.max(maxX, point.X());
        }
        return maxX;
    }

    public Double getMaxY() {
        double maxY = -Double.MAX_VALUE;
        for (Point2d point : coords) {
            maxY = Math.max(maxY, point.Y());
        }
        return maxY;
    }

    public Point2d getMaxCoord() {
        return new Point2d(getMaxX(), getMaxY());
    }

    public Double getMinX() {
        double minX = Double.MAX_VALUE;
        for (Point2d point : coords) {
            minX = Math.min(minX, point.X());
        }
        return minX;
    }

    public Double getMinY() {
        double minY = Double.MAX_VALUE;
        for (Point2d point : coords) {
            minY = Math.min(minY, point.Y());
        }
        return minY;
    }

    public Point2d getMinCoord() {
        return new Point2d(getMinX(), getMinY());
    }

    public BaseShape clone() {
        return new BaseShape(cloneCoords(coords));
    }
}
