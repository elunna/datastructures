package datastructures;

/**
 * This is an interface for the abstract MatrixInterface data type. A matrix
 * manages a m x n sized array of elements.
 *
 * MatrixInterface will most commonly be used with Integers, but it could be
 * used with other numbers like: doubles, floats, longs, shorts, binary, octal,
 * hex It could also be extended and used with other objects.
 *
 * @author Erik Lunna
 */
public interface MatrixInterface {

    /**
     * Retrieves the value of the element at the specified row and column.
     *
     * @param row in Matrix
     * @param column in Matrix
     * @return value at row and column.
     */
    public int getElement(int row, int column);

    /**
     * Determines the maximum capacity of numbers this Matrix can hold.
     *
     * @return the capacity.
     */
    public int getCapacity();

    /**
     *
     * @return the number of rows in this Matrix.
     */
    public int getRows();

    /**
     *
     * @returnthe number of columns in this Matrix.
     */
    public int getColumns();

    /**
     * Determines if this Matrix is composed entirely of zeros.
     *
     * @return true if all zeros, false otherwise.
     */
    public boolean isZeroMatrix();

    /**
     * Determines if this Matrix has equal numbers of rows and columns.
     *
     * @return true if rows == columns, false otherwise.
     */
    public boolean isSquareMatrix();

    /**
     * Determines if this Matrix is composed of integers that are either 1's or
     * 0's.
     *
     * @return true if this Matrix is binary, false otherwise.
     */
    public boolean isBinaryMatrix();

    /**
     * Sets the element at the given row and column to the specified value.
     *
     * @param row in Matrix
     * @param column in Matrix
     * @param newEntry to replace the existing value.
     * @throws IllegalArgumentException if out of bounds indexes are given or if
     * newEntry is null.
     */
    public void setElement(int row, int column, int newEntry);

    /**
     * Sets all elements to a default value. All 0's if integer, 0.0 if decimal.
     */
    public void initialize();

    /**
     * Multiplies all elements in the Matrix by a specified scalar value.
     *
     * @param scalar value.
     * @return A new Matrix with all the values of this Matrix multiplied by the
     * scalar.
     */
    public Matrix multiplyScalar(int scalar);

    /**
     * Transposes all elements in the Matrix by a specified value.
     *
     * @param value up or down for all elements.
     * @return A new Matrix with all the values of this Matrix transposed by the
     * value.
     */
    public Matrix transpose(int value);

    /**
     * Finds the sum A+B between this set (A) and another set (B).
     *
     * @param matrix other Matrix with same number of rows and columns.
     * @return A new Matrix representing the sum.
     */
    public Matrix sum(Matrix matrix);

    /**
     * Finds the difference A-B between this set (A) and another set (B).
     *
     * @param matrix other Matrix with same number of rows and columns.
     * @return A new Matrix representing the difference.
     */
    public Matrix difference(Matrix matrix);

    /**
     * Finds the product A*B between this set (A) and another set (B).
     *
     * @param matrix another matrix with rows that equal this Matrix's columns
     * and columns that equal this Matrix's rows.
     * @return A new Matrix representing the product.
     */
    public Matrix product(Matrix matrix);

    /**
     * Returns a String representation of the contents of the Matrix.
     *
     * @return the string
     */
    public String display();
}

//    public Matrix reflectX();
//    public Matrix reflectY();
//    public Matrix rotate();
// Row operations
// interchange 2 rows
// multiply a row by a scalar
// sum with another (row * scalar) ??
// inRowEcheolon form?
// solve system of linear equations
// isDeterminant?
// public clone();
//    public Matrix getInverse();
//    public Matrix getIdentity();  

