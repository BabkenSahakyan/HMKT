package hasarak.iteracianer;

import org.la4j.Matrix;
import org.la4j.Vector;

public class BacahaytMetod extends CoefficientMatrices{

    public BacahaytMetod(Matrix A, Vector b) {
        setA(A);
        setB(b);
        setName("Հասարակ իտերացիաների բացահայտ մեթոդ");
    }

    @Override
    protected Matrix getQ(){
        return getA();
    }

    @Override
    protected Vector getZ(){
        return getB();
    }
}

