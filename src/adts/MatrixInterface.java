package adts;

/**
 *
 * @author lunatunez
 * @param <T>
 */
public interface MatrixInterface<T> {

    // m columns, n rows
    // elements or entries
    public T getElement(int column, int row);

    public void setElement(int column, int row, T newEntry);

    public Matrix multiplyBy(Matrix anotherMatrix);

    public Matrix multiplyScalar(int scalar);

    public Matrix addTo(Matrix anotherMatrix);
    public int getNumberOfElements();
    public int getCapacity();
    public void transpose();

    public void getInverse();

    public boolean getBinary(); // Or is it something else?

    public boolean isSquareMatrix();

//    public boolean isBinaryMatrix();

//    public boolean isInteger();
//    public boolean isRealMatrix();
//    public boolean isComplexMatrix();
//    public boolean isEmptyMatrix(); // no rows/col
//    public boolean isRowVector(); // no rows/col
//    public boolean isColumnVector(); // no rows/col
    
    

    // booleanMatrix extends Matrix
    // private addRow, private addCol
    // private plusElement(int n, int m, T element);
    // private minusElement(int n, int m, T element);
    
    
    
    // reflect x-axis
    // reflect y-axis
    // rotate (square)
    
    
    // Identity
//    The identity matrix In of size n is the n-by-n matrix 
//    in which all the elements on the main diagonal are 
//    equal to 1 and all other elements are equal to 0, e.g.
    
    
    // public void addRow(int columns): 
//    append a row to the end of the matrix, specify # of column
    // use an ArrayList of Rows. 
    // We will be able to build any kind of matrix that way.
    // Diagonal matrix will be easy to build
    // col 1
    // col 2
    // col 3, etc..
    
}
