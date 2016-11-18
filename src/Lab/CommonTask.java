package Lab;

import org.la4j.Matrix;
import org.la4j.Vector;
import org.la4j.matrix.dense.Basic2DMatrix;
import org.la4j.vector.dense.BasicVector;

import java.util.Scanner;

public class CommonTask{
    private Matrix matrix;
    private Vector vector;
    public CommonTask(int n){
        matrix = new Basic2DMatrix(n, n);
        vector = new BasicVector(n);
        task();
    }
    private void task(){
//        Scanner stream = new Scanner(System.in);
//        for (int i = 0; i < matrix.rows(); i++) {
//            for (int j = 0; j < matrix.columns(); j++) {
//                System.out.print("A[" + i + "][" + j + "] = ");
//                matrix.set(i, j, stream.nextDouble());
//            }
//            System.out.print("b[" + i + "] = ");
//            vector.set(i, stream.nextDouble());
//        }
        /*double[][] matrix1  = new double[][]{{3, 2, 5}, {-2, 1, -1}, {8, -1, 4}};
        matrix = Matrix.from2DArray(matrix1);
        double[] vector1 = new double[]{1, 0, 1};
        vector = Vector.fromArray(vector1);*/
        double[][] matrix1  = new double[][]{{4, 1, -1}, {1, 2, 0}, {-1, 0, 3}};
        matrix = Matrix.from2DArray(matrix1);
        double[] vector1 = new double[]{7, 0, -2};
        vector = Vector.fromArray(vector1);
    }

    public Matrix getMatrix(){
        return matrix;
    }

    public Vector getVector(){
        return vector;
    }

}
