package methods;

import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.inversion.GaussJordanInverter;
import org.la4j.inversion.MatrixInverter;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.dense.BasicVector;

class NvazaguynQarakusineriMetod extends CoefficientMatrices{
    NvazaguynQarakusineriMetod(Matrix A, Vector b){
        setA(A);
        setB(b);
    }

    private Matrix getC(){
        Matrix C = new Basic2DMatrix(getA().rows(), getA().columns());
        for (int i = 0; i < C.rows(); i++) {
            for (int j = 0; j <= i; j++) {
                C.set(i, j, getA().get(i, j));
            }
        }
        return C;
    }

    @Override
    protected Matrix getQ(){
        MatrixInverter inverter = new GaussJordanInverter(getC());
        Basic2DMatrix inverseC = (Basic2DMatrix) inverter.inverse();
        Matrix tmp = new Basic2DMatrix(getA().rows(), getA().columns());
        for (int i = 0; i < tmp.rows(); i++) {
            for (int j = 0; j < tmp.columns(); j++) {
                if(i == j){
                    tmp.set(i, j, 1 - ((inverseC.multiply(getA().transpose())).multiply(getA())).get(i, j));
                } else
                    tmp.set(i, j, 0 - ((inverseC.multiply(getA().transpose())).multiply(getA())).get(i, j));
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
            tmp.set(i, (inverseC.multiply(getA().transpose()).multiply(getB())).get(i));
        }
        return tmp;
    }
}
