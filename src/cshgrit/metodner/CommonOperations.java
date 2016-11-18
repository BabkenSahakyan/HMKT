package cshgrit.metodner;

import org.la4j.Matrix;
import org.la4j.Vector;

/**
 * Created by babken on 11/18/16.
 */
abstract class CommonOperations {
    protected Matrix A;
    protected Vector b;
    protected Vector X;

    public abstract void solve();

    void SortRows(int sortIndex){
        double MaxElement = A.get(sortIndex, sortIndex);
        int MaxElementIndex = sortIndex;
        for (int i = sortIndex + 1; i < A.rows(); i++) {
            if (A.get(i, sortIndex) > MaxElement)
            {
                MaxElement = A.get(i, sortIndex);
                MaxElementIndex = i;
            }
        }

        if (MaxElementIndex > sortIndex) {
            double temp;

            temp = b.get(MaxElementIndex);
            b.set(MaxElementIndex, b.get(sortIndex));
            b.set(sortIndex, temp);

            for (int i = 0; i < A.columns(); i++)
            {
                temp = A.get(MaxElementIndex, i);
                A.set(MaxElementIndex, i, A.get(sortIndex, i));
                A.set(sortIndex, i, temp);
            }
        }
    }
}
