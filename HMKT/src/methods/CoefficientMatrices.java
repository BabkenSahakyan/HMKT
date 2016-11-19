package methods;

import Lab.Checker;
import Lab.Iterations;
import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.vector.dense.BasicVector;

abstract class CoefficientMatrices {
    private Matrix A;
    private Vector b;

    abstract protected Matrix getQ();
    abstract protected Vector getZ();

    protected Matrix getA(){
        return A;
    }

    protected Vector getB(){
        return b;
    }

    protected void setA(Matrix A){
        this.A = A;
    }

    protected void setB(Vector b){
        this.b = b;
    }

    void solve(long maxIterations, int scale) {
        Vector X = new BasicVector(getB().length());
        int i = 0;

        do {
            X = Iterations.answer(getQ(), X, getZ());
            i++;
            if (i == maxIterations) {
                System.out.println("\nՊատասխանը չի գտնվել");
                break;
            }
        } while (!Checker.isCorrectAnswer(getA(), X, getB(), scale));

        System.out.println("answer is");
        System.out.println(X + "\n");
    }
}
