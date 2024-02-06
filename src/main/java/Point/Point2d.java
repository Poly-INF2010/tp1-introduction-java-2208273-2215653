package Point;

public class Point2d extends AbstractPoint {
    private final Integer X = 0;
    private final Integer Y = 1;

    public Point2d(Double x, Double y) {
        super(new double[]{x, y});
    }

    public Point2d(Double[] vector) {
        super(new double[]{vector[0], vector[1]});
    }

    public double X() { return vector[X];}

    public double Y() { return vector[Y];}

    @Override
    public Point2d translate(Double[] translateVector) {
        vector[X] += translateVector[0];
        vector[Y] += translateVector[1];
        return this;
    }

    public Point2d translate(Point2d translateVector) {
        vector[X] += translateVector.X();
        vector[Y] += translateVector.Y();
        return this;
    }

    @Override
    public Point2d rotate(Double[][] rotationMatrix) {
        double rotatedX = (rotationMatrix[0][0] * vector[X]) + (rotationMatrix[0][1] * vector[Y]);
        double rotatedY = (rotationMatrix[1][0] * vector[X]) + (rotationMatrix[1][1] * vector[Y]);
        vector[X] = rotatedX;
        vector[Y] = rotatedY;
        return this;
    }

    public Point2d rotate(Double angle) {
        double sinusAngle = Math.sin(angle);
        double cosinusAngle = Math.cos(angle);
        double rotatedX = (cosinusAngle * vector[X]) - (sinusAngle * vector[Y]);
        double rotatedY = (sinusAngle * vector[X]) + (cosinusAngle * vector[Y]);
        vector[X] = rotatedX;
        vector[Y] = rotatedY;
        return this;
    }

    @Override
    public Point2d divide(Double divider) {
        vector[X] /= divider;
        vector[Y] /= divider;
        return this;
    }

    @Override
    public Point2d multiply(Double multiplier) {
        vector[X] *= multiplier;
        vector[Y] *= multiplier;
        return this;
    }

    @Override
    public Point2d add(Double adder) {
        vector[X] += adder;
        vector[Y] += adder;
        return this;
    }

    @Override
    public Point2d clone() {
        return new Point2d(vector[X], vector[Y]);
    }
}
