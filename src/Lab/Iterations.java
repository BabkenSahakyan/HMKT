package Lab;

import org.la4j.Matrix;
import org.la4j.Vector;

public class Iterations {
    public static Vector answer(Matrix A, Vector X, Vector b) {
        Vector ans = X;
        return A.multiply(ans).add(b);
    }
}
