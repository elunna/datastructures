package datastructures;

import java.util.Arrays;

/**
 * A two-dimensional implementation of a Matrix data structure. The Matrix
 * contains m columns and n rows and has operations to access and mutate single
 * and multiple elements.
 *
 * @author Erik Lunna
 */
public class Matrix implements MatrixInterface {
    // ArrayList<T[] > rows;   // an arrayList of rows

    private int[][] matrix;
    private final int rows;
    private final int columns;

    public Matrix(int rows, int columns) throws IllegalArgumentException {

        if (rows <= 0
                || columns <= 0) {
            throw new IllegalArgumentException("Bad constructor parameter(s)");
        } else {
            this.rows = rows;
            this.columns = columns;
        }
        matrix = new int[rows][columns];
        initialize();
    }

    @Override
    public final void initialize() {
        matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    @Override
    public int getCapacity() {
        return rows * columns;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public int getColumns() {
        return this.columns;

    }

    @Override
    public int getElement(int row, int col) {
        if (isValidIndices(row, col)) {
            return matrix[row][col];

        } else {
//            isValidIndices throws exception();
            return 0;
        }

    }

    @Override
    public boolean isZeroMatrix() {
        // check if this is a numerical matrix...
        // check if all entries are 0
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isSquareMatrix() {
        //check if this matrix has the same number of rows.
        return rows == columns;

    }

    @Override
    public boolean isBinaryMatrix() {
        // check type for ints
        if (matrix instanceof int[][] == false) {
            return false;
        }
        // Iterate through matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < 0 || matrix[i][j] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidIndices(int row, int col) {
        if (row < 0 || row >= rows
                || col < 0 || col >= columns) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return true;
        }
    }

    public boolean isRowVector() {
        return rows == 1;
    }

    public boolean isColumnVector() {
        return columns == 1;

    }

    @Override
    public void setElement(int row, int col, int value) {
        if (isValidIndices(row, col)) {
            matrix[row][col] = value;
        }
//          else   isValidIndices throws exception();
    }

    @Override
    public Matrix transpose(int adjustment) {
        Matrix result = new Matrix(rows, columns);
        // copy this matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int newValue = matrix[i][j] + adjustment;
                result.setElement(i, j, newValue);
            }
        }
        return result;
    }

    @Override
    public Matrix multiplyScalar(int scalar) {

        Matrix product = new Matrix(rows, columns);
        // copy this matrix

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int newValue = this.getElement(i, j) * scalar;
                product.setElement(i, j, newValue);
            }
        }
        return product;
    }

    @Override
    public Matrix product(Matrix anotherMatrix) {
        // Check that both matrices are same size/dimensions
        if (this.getColumns() == anotherMatrix.getRows()) {

            // The product matrix is an (this.rows x that.columns) size matrix.
            Matrix product = new Matrix(this.rows, anotherMatrix.getColumns());

            for (int i = 0; i < product.getRows(); i++) {

                for (int j = 0; j < product.getColumns(); j++) {

                    int currentSum = 0;
                    for (int k = 0; k < anotherMatrix.getRows(); k++) {

                        currentSum += this.getElement(i, k) * anotherMatrix.getElement(k, j);

                    }
                    product.setElement(i, j, currentSum);
                }
            }

            return product;
        } else {
            throw new IllegalArgumentException();
            // create a copy of this matrix, return it.
        }

    }

    @Override
    public Matrix sum(Matrix anotherMatrix) {
        // Check that both matrices are same size/dimensions
        if (this.getColumns() == anotherMatrix.getColumns()
                && this.getRows() == anotherMatrix.getRows()) {
            Matrix sum = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int currentSum = this.getElement(i, j) + anotherMatrix.getElement(i, j);
                    sum.setElement(i, j, currentSum);
                }
            }
            return sum;
        } else {
            throw new IllegalArgumentException();
            // create a copy of this matrix, return it.
        }

    }

    @Override
    public Matrix difference(Matrix anotherMatrix) {
        // Check that both matrices are same size/dimensions
        if (this.getColumns() == anotherMatrix.getColumns()
                && this.getRows() == anotherMatrix.getRows()) {
            Matrix difference = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int currentSum = this.getElement(i, j) - anotherMatrix.getElement(i, j);
                    difference.setElement(i, j, currentSum);
                }
            }
            return difference;
        } else {
            throw new IllegalArgumentException();
            // create a copy of this matrix, return it.
        }
    }

    @Override
    public boolean equals(Object aThat) {
        if (this == aThat) {
            return true;
        }
        if (!(aThat instanceof Matrix)) {
            return false;
        }
        Matrix castedThat = (Matrix) aThat;
        if (this.rows != castedThat.getRows()) {
            return false;
        }
        if (this.columns != castedThat.getColumns()) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (this.getElement(i, j) != castedThat.getElement(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Arrays.deepHashCode(this.matrix);
        hash = 23 * hash + this.rows;
        hash = 23 * hash + this.columns;
        return hash;
    }

    @Override
    public String display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

//                System.out.print(" " + matrix[i][j]);
                sb.append(" ").append(matrix[i][j]);
            }
            System.out.println();
        }
        return sb.toString();
    }
}
//    public boolean isRealMatrix();
//    public boolean isComplexMatrix();
