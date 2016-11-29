package hasarak.iteracianer;

import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.inversion.GaussJordanInverter;
import org.la4j.inversion.MatrixInverter;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.dense.BasicVector;


public class ModifikacvacMetod extends CoefficientMatrices{
    public ModifikacvacMetod(Matrix A, Vector b){
        setA(A);
        setB(b);
        setName("Մոդիֆիկացված մեթոդ");
    }

    private Matrix getD(){
        double d = getA().max();
        Matrix D = new Basic2DMatrix(getA().rows(), getA().columns());
        for (int i = 0; i < D.rows(); i++) {
            for (int j = 0; j < D.columns(); j++) {
                if (i == j){
                    D.set(i, j, d);
                }
            }
        }
        return D;
    }

    @Override
    protected Matrix getQ(){
        MatrixInverter inverter = new GaussJordanInverter(getD());
        Basic2DMatrix inverseD = (Basic2DMatrix) inverter.inverse();
        Matrix tmp = new Basic2DMatrix(getA().rows(), getA().columns());
        for (int i = 0; i < tmp.rows(); i++) {
            for (int j = 0; j < tmp.columns(); j++) {
                if(i == j){
                    tmp.set(i, j, 1 - (inverseD.multiply(getA())).get(i, j));
                } else
                    tmp.set(i, j, 0 - (inverseD.multiply(getA())).get(i, j));
            }
        }
        return tmp;
    }

    @Override
    protected Vector getZ(){
        MatrixInverter inverter = new GaussJordanInverter(getD());
        Basic2DMatrix inverseD = (Basic2DMatrix) inverter.inverse();
        Vector tmp = new BasicVector(getB().length());
        for (int i = 0; i < tmp.length(); i++) {
            tmp.set(i, (inverseD.multiply(getB())).get(i));
        }
        return tmp;
    }
}
