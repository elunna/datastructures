package datastructures;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for Matrix.
 *
 * @author Erik Lunna
 */
public class MatrixTests {

    public MatrixTests() {
    }

    public Matrix getSmallestMatrix() {
        int rows = 1;
        int columns = 1;
        Matrix matrix = new Matrix(rows, columns);
        return matrix;
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getElement_invalidIndices_throwException() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);

        int result = matrix.getElement(-1, 0);
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void getElement_validIndices_returnsElement() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);

        int result = matrix.getElement(0, 0);
        int expResult = 1;
        assertEquals(expResult, result);
    }

    public void getCapacity_1x1matrix_returns1() {
        Matrix matrix = getSmallestMatrix();

        int result = matrix.getCapacity();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    public void getCapacity_2x2matrix_returns4() {
        Matrix matrix = getSmallestMatrix();

        int result = matrix.getCapacity();
        int expResult = 4;
        assertEquals(expResult, result);
    }

    @Test
    public void isZeroMatrix_newMatrix_equalsTrue() {
        Matrix matrix = getSmallestMatrix();

        boolean result = matrix.getElement(0, 0) == 0;
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isZeroMatrix_nonZeroElement_returnsFalse() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);

        boolean result = matrix.isZeroMatrix();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    public void isSquareMatrix_1x1matrix_returnsTrue() {
        Matrix matrix = getSmallestMatrix();

        boolean result = matrix.isSquareMatrix();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    public void isSquareMatrix_2x2matrix_returnsTrue() {
        int rows = 2;
        int columns = 2;
        Matrix matrix = new Matrix(rows, columns);

        boolean result = matrix.isSquareMatrix();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    public void isSquareMatrix_2x1matrix_returnsFalse() {
        int rows = 2;
        int columns = 1;
        Matrix matrix = new Matrix(rows, columns);

        boolean result = matrix.isSquareMatrix();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void isBinaryMatrix_contains1_returnsTrue() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);

        boolean result = matrix.isBinaryMatrix();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isBinaryMatrix_contains0_returnsTrue() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 0);
        boolean isBinary = matrix.isBinaryMatrix();

        boolean result = matrix.isBinaryMatrix();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isBinaryMatrix_contains2_returnsFalse() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 2);

        boolean result = matrix.isBinaryMatrix();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void isRowVector_1x10matrix_returnsTrue() {
        int rows = 1;
        int columns = 10;
        Matrix matrix = new Matrix(rows, columns);

        boolean result = matrix.isRowVector();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isRowVector_2x2matrix_returnsFalse() {
        int rows = 2;
        int columns = 2;
        Matrix matrix = new Matrix(rows, columns);

        boolean result = matrix.isRowVector();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void isColumnVector_10x1matrix_returnsTrue() {
        int rows = 10;
        int columns = 1;
        Matrix matrix = new Matrix(rows, columns);

        boolean result = matrix.isColumnVector();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void isColumnVector_2x2matrix_returnsFalse() {
        int rows = 2;
        int columns = 2;
        Matrix matrix = new Matrix(rows, columns);

        boolean result = matrix.isColumnVector();
        boolean expResult = false;
        assertEquals(expResult, result);
    }

    @Test
    public void setElement_validIndices_containsElement() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);

        int result = matrix.getElement(0, 0);
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void initialize() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1); // set element to 1
        matrix.initialize();

        int result = matrix.getElement(0, 0);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void multiplyScalar_by0_containsZero() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(0);

        int result = scalarResult.getElement(0, 0);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void multiplyScalar_0_isZeroMatrix() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(0);

        boolean result = scalarResult.isZeroMatrix();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void multiplyScalar_1_returnsEqualMatrix() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(1);

        boolean result = matrix.equals(scalarResult);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void multiplyScalar_2_doublesValues() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(2);

        int result = scalarResult.getElement(0, 0);
        int expResult = 2;
        assertEquals(expResult, result);
    }

    @Test
    public void transpose_0_returnsEqualMatrix() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1);
        Matrix transposed = matrix.transpose(0);

        boolean result = matrix.equals(transposed);
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void transpose_1_valuesRaisedOne() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1); // Set to one
        Matrix transposed = matrix.transpose(1);

        int result = transposed.getElement(0, 0);
        int expResult = 2;
        assertEquals(expResult, result);
    }

    @Test
    public void transpose_neg1_valuesLoweredOne() {
        Matrix matrix = getSmallestMatrix();
        matrix.setElement(0, 0, 1); // Set to one
        Matrix transposeResult = matrix.transpose(-1);

        int result = transposeResult.getElement(0, 0);
        int expResult = 0;
        assertEquals(expResult, result);
    }

    @Test
    public void sum_sameDimensionsMatrix_returnsSum() {
        Matrix A = getSmallestMatrix();
        Matrix B = getSmallestMatrix();
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix sum = A.sum(B);

        int result = sum.getElement(0, 0);
        int expResult = 3;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sum_diffDimensions_throwsException() {
        // in other words, if we face an invalid add'ee', 
        // we treat it as 0. This + 0 = This. Return this.
        Matrix A = getSmallestMatrix();
        Matrix B = new Matrix(2, 2);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix sum = A.sum(B);

    }

    @Test
    public void sum_zeroMatrix_returnsThisMatrix() {
        Matrix A = getSmallestMatrix();
        Matrix B = getSmallestMatrix();
        A.setElement(0, 0, 1);
        Matrix sum = A.sum(B);

        int result = sum.getElement(0, 0);
        int expResult = 1;
        assertEquals(expResult, result);

    }

//    @Test
//    public void addTo_inverseMatrix_returnsZeroMatrix() {
//        
//    }
    @Test
    public void difference_sameDimensions_returnsDifference() {
        Matrix A = getSmallestMatrix();
        Matrix B = getSmallestMatrix();
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix difference = A.difference(B);

        int result = difference.getElement(0, 0);
        int expResult = -1;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void difference_diffDimensions_throwsException() {
        // in other words, if we face an invalid add'ee', 
        // we treat it as 0. This - 0 = This. Return this.
        Matrix A = getSmallestMatrix();
        Matrix B = new Matrix(2, 2);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix difference = A.difference(B);

    }

    @Test
    public void difference_zeroMatrix_returnsThisMatrix() {
        Matrix A = getSmallestMatrix();
        Matrix B = getSmallestMatrix();
        A.setElement(0, 0, 1);
        Matrix diff = A.difference(B);

        int result = diff.getElement(0, 0);
        int expResult = 1;
        assertEquals(expResult, result);
    }

    @Test
    public void product_1x1Matrices_returnsProduct() {
        Matrix A = getSmallestMatrix();
        Matrix B = getSmallestMatrix();
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix product = A.product(B);

        int result = product.getElement(0, 0);
        int expResult = 2;
        assertEquals(expResult, result);
    }

    @Test
    public void product_mxrByrxnMatrix_returnsProduct() {
        // check element 1
        // the # of columns in A must equals the number of rows in B
        Matrix A = new Matrix(1, 2);

        Matrix B = new Matrix(2, 2);
        A.setElement(0, 0, 1); // set A to all ones
        A.setElement(0, 1, 1);

        B.setElement(0, 0, 1);
        B.setElement(0, 1, 0);
        B.setElement(1, 0, 1);
        B.setElement(1, 1, 0);
        Matrix product = A.product(B);

        int result1 = product.getElement(0, 0);
        int result2 = product.getElement(0, 1);

        boolean result = result1 == 2 && result2 == 0;
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void product_zeroMatrix_returnsZeroMatrix() {
        // check element 1
        // the # of columns in A must equals the number of rows in B
        Matrix A = new Matrix(2, 1);
        Matrix B = new Matrix(1, 2);
        A.setElement(0, 0, 1);
        A.setElement(1, 0, 2);
        Matrix product = A.product(B); // B is filled with 0's

        boolean result = product.isZeroMatrix();
        boolean expResult = true;
        assertEquals(expResult, result);
    }

    @Test
    public void product_squareMatrix_returnsProduct() {
        int rows = 2;
        int columns = 2;
        Matrix A = new Matrix(rows, columns);
        Matrix B = new Matrix(rows, columns);
        // Square of 1's
        A.setElement(0, 0, 1);
        A.setElement(0, 1, 1);
        A.setElement(1, 0, 1);
        A.setElement(1, 1, 1);
        // Square of 2's
        B.setElement(0, 0, 2);
        B.setElement(0, 1, 2);
        B.setElement(1, 0, 2);
        B.setElement(1, 1, 2);

        Matrix product = A.product(B);

        int result = product.getElement(0, 0); // should equal 4
        int expResult = 4;
        assertEquals(expResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void product_invalidDimensions_throwsException() {
        Matrix A = new Matrix(2, 1);
        Matrix B = new Matrix(2, 3);
        A.setElement(0, 0, 1);
        A.setElement(1, 0, 2);
        Matrix difference = A.product(B);
    }
}
