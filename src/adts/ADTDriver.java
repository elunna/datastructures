package adts;

/**
 *
 *
 * @author lunatic007
 */
public class ADTDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MatrixInterface matrix1 = new Matrix(2, 4);
//        System.out.println("Analyzing new matrix");
//        analyzeMatrix(matrix1);
        matrix1.setElement(0, 0, 2);
        matrix1.setElement(0, 1, 3);
        matrix1.setElement(0, 2, 2);
        matrix1.setElement(0, 3, 3);
        matrix1.setElement(1, 0, 1);
        matrix1.setElement(1, 1, 4);
        matrix1.setElement(1, 2, 1);
        matrix1.setElement(1, 3, 4);
        analyzeMatrix(matrix1);

        MatrixInterface matrix2 = new Matrix(4, 2);
        matrix2.setElement(0, 0, 4);
        matrix2.setElement(0, 1, 0);
        matrix2.setElement(1, 0, 1);
        matrix2.setElement(1, 1, -1);
        matrix2.setElement(2, 0, 2);
        matrix2.setElement(2, 1, -1);
        matrix2.setElement(3, 0, 5);
        matrix2.setElement(3, 1, 6);

        analyzeMatrix(matrix2);

//        System.out.println("Adding matrices together");
//        MatrixInterface matrixSum = matrix1.addTo((Matrix) matrix2);
//        System.out.println("Displaying the sum:");
//        analyzeMatrix(matrixSum);
        System.out.println("Multiplying matrices");
        MatrixInterface matrixProduct = matrix1.multiplyBy((Matrix) matrix2);
        System.out.println("Displaying the product:");
        analyzeMatrix(matrixProduct);
    }

    public static void analyzeMatrix(MatrixInterface matrix) {
        System.out.println("---------------------------------");
        System.out.println("Displaying matrix: ");

        matrix.display();

        if (matrix.isBinaryMatrix()) {
            System.out.println("This matrix is a Binary Matrix");
        }
        if (matrix.isZeroMatrix()) {
            System.out.println("This matrix is a Zero Matrix");
        }
        if (matrix.isSquareMatrix()) {
            System.out.println("This matrix is a Square Matrix");
        }

    }
}
