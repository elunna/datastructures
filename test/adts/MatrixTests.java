package adts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lunatunez
 */
public class MatrixTests {

    public MatrixTests() {
    }
    // *************************************************************************
    // *** STATIC METHODS ******************************************************

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getElement_invalidIndices_throwException() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        assertEquals(1, matrix.getElement(-1, 0));
    }

    @Test
    public void getElement_validIndices_returnsElement() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        assertEquals(1, matrix.getElement(0, 0));
    }

    public void getCapacity_1x1matrix_returns1() {
        Matrix matrix = new Matrix(1, 1);
        int size = matrix.getCapacity();
        assertEquals(1, size);
    }

    public void getCapacity_2x2matrix_returns4() {
        Matrix matrix = new Matrix(1, 1);
        int size = matrix.getCapacity();
        assertEquals(4, size);
    }

    @Test
    public void isZeroMatrix_newMatrix_equalsTrue() {
        Matrix matrix = new Matrix(1, 1);
        boolean isZero = matrix.getElement(0, 0) == 0;
        assertTrue(isZero);
    }

    @Test
    public void isZeroMatrix_nonZeroElement_returnsFalse() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        boolean isZero = matrix.isZeroMatrix();
        assertFalse(isZero);
    }

    public void isSquareMatrix_1x1matrix_returnsTrue() {
        Matrix matrix = new Matrix(1, 1);
        boolean isSquare = matrix.isSquareMatrix();
        assertTrue(isSquare);
    }

    public void isSquareMatrix_2x2matrix_returnsTrue() {
        Matrix matrix = new Matrix(2, 2);
        boolean isSquare = matrix.isSquareMatrix();
        assertTrue(isSquare);
    }

    public void isSquareMatrix_2x1matrix_returnsFalse() {
        Matrix matrix = new Matrix(2, 1);
        boolean isSquare = matrix.isSquareMatrix();
        assertFalse(isSquare);
    }

    @Test
    public void isBinaryMatrix_contains1_returnsTrue() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        boolean isBinary = matrix.isBinaryMatrix();
        assertTrue(isBinary);
    }

    @Test
    public void isBinaryMatrix_contains0_returnsTrue() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 0);
        boolean isBinary = matrix.isBinaryMatrix();
        assertTrue(isBinary);
    }

    @Test
    public void isBinaryMatrix_contains2_returnsFalse() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 2);
        boolean isBinary = matrix.isBinaryMatrix();
        assertFalse(isBinary);
    }

    @Test
    public void isRowVector_1x10matrix_returnsTrue() {
        Matrix matrix = new Matrix(1, 10);
        boolean result = matrix.isRowVector();
        assertTrue(result);
    }

    @Test
    public void isRowVector_2x2matrix_returnsFalse() {
        Matrix matrix = new Matrix(2, 2);
        boolean result = matrix.isRowVector();
        assertFalse(result);
    }

    @Test
    public void isColumnVector_10x1matrix_returnsTrue() {
        Matrix matrix = new Matrix(10, 1);
        boolean result = matrix.isColumnVector();
        assertTrue(result);
    }

    @Test
    public void isColumnVector_2x2matrix_returnsFalse() {
        Matrix matrix = new Matrix(2, 2);
        boolean result = matrix.isColumnVector();
        assertFalse(result);
    }

    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    @Test
    public void setElement_validIndices_containsElement() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        assertEquals(1, matrix.getElement(0, 0));
    }

    @Test
    public void initialize() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1); // set element to 1
        matrix.initialize();
        int result = matrix.getElement(0, 0);
        assertEquals(0, result);

    }

    // multiplyScalar
    @Test
    public void multiplyScalar_by0_containsZero() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(0);
        int result = scalarResult.getElement(0, 0);
        assertEquals(0, result);
    }

    @Test
    public void multiplyScalar_0_isZeroMatrix() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(0);
        boolean isZeroMatrix = scalarResult.isZeroMatrix();
        assertTrue(isZeroMatrix);
    }

    @Test
    public void multiplyScalar_1_returnsEqualMatrix() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(1);
        boolean equalMatrices = matrix.equals(scalarResult);
        assertTrue(equalMatrices);
    }

    @Test
    public void multiplyScalar_2_doublesValues() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        Matrix scalarResult = matrix.multiplyScalar(2);
        assertEquals(2, scalarResult.getElement(0, 0));
    }

    @Test
    public void transpose_0_returnsEqualMatrix() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1);
        Matrix transposeResult = matrix.transpose(0);
        boolean equalMatrices = matrix.equals(transposeResult);
        assertTrue(equalMatrices);

    }

    @Test
    public void transpose_1_valuesRaisedOne() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1); // Set to one
        Matrix transposeResult = matrix.transpose(1);
        assertEquals(2, transposeResult.getElement(0, 0));
    }

    @Test
    public void transpose_neg1_valuesLoweredOne() {
        Matrix matrix = new Matrix(1, 1);
        matrix.setElement(0, 0, 1); // Set to one
        Matrix transposeResult = matrix.transpose(-1);
        assertEquals(0, transposeResult.getElement(0, 0));
    }

    @Test
    public void addTo_sameDimensionsMatrix_returnsSum() {
        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(1, 1);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix sum = A.addTo(B);
        int result = sum.getElement(0, 0);
        assertEquals(3, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addTo_diffDimensions_throwsException() {
        // in other words, if we face an invalid add'ee', 
        // we treat it as 0. This + 0 = This. Return this.

        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(2, 2);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix sum = A.addTo(B);
        int result = sum.getElement(0, 0);
        assertEquals(1, result);
    }

    @Test
    public void addTo_zeroMatrix_returnsThisMatrix() {
        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(1, 1);
        A.setElement(0, 0, 1);
        Matrix sum = A.addTo(B);
        int result = sum.getElement(0, 0);
        assertEquals(1, result);
    }

//    @Test
//    public void addTo_inverseMatrix_returnsZeroMatrix() {
//        
//    }
    @Test
    public void minus_sameDimensions_returnsDifference() {
        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(1, 1);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix difference = A.minus(B);
        int result = difference.getElement(0, 0);
        assertEquals(-1, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void minus_diffDimensions_throwsException() {
        // in other words, if we face an invalid add'ee', 
        // we treat it as 0. This - 0 = This. Return this.
        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(2, 2);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix difference = A.minus(B);
    }

    @Test
    public void minus_zeroMatrix_returnsThisMatrix() {
        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(1, 1);
        A.setElement(0, 0, 1);
        Matrix product = A.minus(B);
        int result = product.getElement(0, 0);
        assertEquals(1, result);
    }

    // multiplyBy
    @Test
    public void multiplyBy_1x1Matrices_returnsProduct() {
        Matrix A = new Matrix(1, 1);
        Matrix B = new Matrix(1, 1);
        A.setElement(0, 0, 1);
        B.setElement(0, 0, 2);
        Matrix product = A.multiplyBy(B);
        int result = product.getElement(0, 0);
        assertEquals(2, result);
    }

    @Test
    public void multiplyBy_mxrByrxnMatrix_returnsProduct() {
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
        Matrix product = A.multiplyBy(B);
        
        // test the first element
        int result1 = product.getElement(0, 0);
        assertEquals(2, result1);

        // test the second element
        int result2 = product.getElement(0, 1);
        assertEquals(0, result2);
        
    }

    @Test
    public void multiplyBy_zeroMatrix_returnsZeroMatrix() {
        // check element 1
        // the # of columns in A must equals the number of rows in B
        Matrix A = new Matrix(2, 1);
        Matrix B = new Matrix(1, 2);
        A.setElement(0, 0, 1);
        A.setElement(1, 0, 2);
        Matrix product = A.multiplyBy(B); // B is filled with 0's
        boolean result = product.isZeroMatrix();
        assertTrue(result);
    }

    @Test
    public void multiplyBy_squareMatrix_returnsProduct() {
        Matrix A = new Matrix(2, 2);
        Matrix B = new Matrix(2, 2);
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
        
        Matrix product = A.multiplyBy(B);
        int result = product.getElement(0, 0); // should equal 4
        
        assertEquals(4, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyBy_invalidDimensions_throwsException() {
        Matrix A = new Matrix(2, 1);
        Matrix B = new Matrix(2, 3);
        A.setElement(0, 0, 1);
        A.setElement(1, 0, 2);
        Matrix difference = A.multiplyBy(B);
    }
}
