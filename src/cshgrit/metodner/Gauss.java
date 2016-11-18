package cshgrit.metodner;

import org.la4j.Matrix;
import org.la4j.Vector;

public class Gauss extends CommonOperations{

    public Gauss(Matrix A, Vector b) {
        this.A = A.copy();
        this.b = b.copy();
    }

    @Override
    public void solve() {
        System.out.println("Գաուսի մեթոդ");

        System.out.println("A մատրիցն է սկզբում");
        System.out.println(A);
        System.out.println("B մատրիցն է");
        System.out.println(b + "\n");

        for (int i = 0; i < A.rows() - 1; i++) {
            //SortRows(i);
            for (int j = i + 1; j < A.columns(); j++) {
                if (A.get(i, i) != 0) {
                    double multElement = A.get(j, i) / A.get(i, i);
                    for (int k = i; k < A.columns(); k++) {
                        A.set(j, k, A.get(j, k) - A.get(i, k) * multElement);
                    }
                    b.set(j, b.get(j) - b.get(i) * multElement);
                } else {
                    SortRows(i);
                }
            }
        }

        //Find Answers X's
        X = b;
        for (int i = A.rows() - 1; i >= 0; i--) {
            for (int j = A.columns() - 1; j > i; j--) {
                X.set(i, X.get(i) - A.get(i, j) * b.get(j));
            }
            X.set(i, X.get(i) / A.get(i, i));
        }

        System.out.println("A մատրիցն է վերջում");
        System.out.println(A);

        System.out.println("պատասխանն է");
        System.out.println(X + "\n");
    }

}
