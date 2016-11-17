package methods;

import Lab.Checker;
import Lab.Iterations;
import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.inversion.GaussJordanInverter;
import org.la4j.inversion.MatrixInverter;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.dense.BasicVector;

class AnbacahaytMetod extends CoefficientMatrices{
    private final double tau = 0.1;
    AnbacahaytMetod(Matrix A, Vector b){
        setA(A);
        setB(b);
    }

    private Matrix getC(){
        /*Matrix c = new Basic2DMatrix(A.rows(), A.columns());
        for (int i = 0; i < c.rows(); i++) {
            for (int j = 0; j < c.columns(); j++) {
                c.set(i, j, tau * A.get(i, j) / 2 + 0.1);
            }
        }*/
        double[][] c1 = new double[][]{{0.5, 0.1, 0.1}, {0.1, 0.5, 0}, {0.1, 0, 0.5}};
        Matrix c = new Basic2DMatrix(c1);
        return c;
    }

    @Override
    protected Matrix getQ(){
        MatrixInverter inverter = new GaussJordanInverter(getC());
        Basic2DMatrix inverseC = (Basic2DMatrix) inverter.inverse();
        Matrix tmp = new Basic2DMatrix(getA().rows(), getA().columns());
        for (int i = 0; i < tmp.rows(); i++) {
            for (int j = 0; j < tmp.columns(); j++) {
                if(i == j){
                    tmp.set(i, j, 1 - (inverseC.multiply(getA()).multiply(tau)).get(i, j));
                } else
                    tmp.set(i, j, 0 - (inverseC.multiply(getA()).multiply(tau)).get(i, j));
            }
        }
        return tmp;
    }

    @Override
    protected Vector getZ(){
        MatrixInverter inverter = new GaussJordanInverter(getC());
        Basic2DMatrix inverseC = (Basic2DMatrix) inverter.inverse();
        Vector tmp = new BasicVector(getB().length());
        for (int i = 0; i < tmp.length(); i++) {
            tmp.set(i, (inverseC.multiply(getB()).multiply(tau)).get(i));
        }
        return tmp;
    }
}
