package Point;

import java.util.*;

public final class PointOperator {

    public static void translate(Double[] vector, Double[] translateVector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] += translateVector[i];
        }
    }

    public static void rotate(Double[] vector, Double[][] rotationMatrix) {
        Double[] result = new Double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            result[i] = 0.0;
            for (int j = 0; j < vector.length; j++) {
                result[i] += rotationMatrix[i][j] * vector[j];
            }
        }
        System.arraycopy(result, 0, vector, 0, vector.length);
    }

public static void divide(Double[] vector, Double divider) {
    for (int i = 0; i < vector.length; i++) {
        vector[i] /= divider;
    }
}

public static void multiply(Double[] vector, Double multiplier) {
    for (int i = 0; i < vector.length; i++) {
        vector[i] *= multiplier;
    }
}

public static void add(Double[] vector, Double adder) {
    for (int i = 0; i < vector.length; i++) {
        vector[i] += adder;
    }
}
}
