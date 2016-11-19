package methods;

import org.la4j.Matrix;
import org.la4j.Vector;

class BacahaytMetod extends CoefficientMatrices{

    BacahaytMetod(Matrix A, Vector b) {
        setA(A);
        setB(b);
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

