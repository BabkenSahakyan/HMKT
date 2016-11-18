package main;

import Lab.CommonTask;
import cshgrit.metodner.Gauss;
import cshgrit.metodner.GaussJordan;
import hasarak.iteracianer.*;
import org.la4j.Matrix;
import org.la4j.Vector;

class Main {
    public static void main(String[] args) {
        CommonTask commonTask = new CommonTask(3);
        Matrix matrix = commonTask.getMatrix();
        Vector vector = commonTask.getVector();
        new BacahaytMetod(matrix, vector).solve(1000, 5);
        new AnbacahaytMetod(matrix, vector).solve(1000, 5);
        new ModifikacvacMetod(matrix, vector).solve(1000, 5);
        new Zeydel(matrix, vector).solve(1000, 100);
        new NvazaguynQarakusineriMetod(matrix, vector).solve(1000, 5);

        new Gauss(matrix, vector).solve();//
        new GaussJordan(matrix, vector).solve();
    }
}
