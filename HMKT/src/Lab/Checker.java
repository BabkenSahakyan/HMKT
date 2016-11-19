package Lab;

import org.la4j.Matrix;
import org.la4j.Vector;

public class Checker{

    public static boolean isCorrectAnswer(Matrix A, Vector X, Vector b, int scale){
        Vector a = A.multiply(X);
        double precision = 1 / Math.pow(10, scale);
        for (int i = 0; i < X.length(); i++) {
            if (Math.abs(round(b.get(i), scale) - a.get(i)) <= precision){
                return true;
            }
        }
        return false;
    }

    private static double round(double number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        double tmp = number * pow;
        return (double) (int) ((tmp - (int) tmp) >= 0.5 ? tmp + 1 : tmp) / pow;
    }
}
