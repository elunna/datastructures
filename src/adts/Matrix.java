package adts;

import java.util.ArrayList;

/**
 * File: Description:
 *
 * @author lunatunez
 * @param <T>
 */
public class Matrix<T> implements MatrixInterface {
    // ArrayList<T[] > rows;   // an arrayList of rows

    private T[][] matrix;
    private int numberOfEntries;
                            // rows are arrays.
    // this way the matrix is dynamic
    // maybe I should have 2 matrixes.


    public Matrix(int rows, int columns) throws IllegalArgumentException {
        numberOfEntries = 0;
        if (       rows <= 0
                || columns <= 0) {
            throw new IllegalArgumentException("Bad constructor parameter(s)");
        }
        @SuppressWarnings("unchecked")
        T[][] tempMatrix = (T[][]) new Object[rows][columns]; // unchecked cast
        matrix = tempMatrix;
    }
    
    
    // core methods
    
    // add
    // toarray
    // isEmpty
    // isFull
    // toArray

}
