package adts;

/**
 * This is an interface for the abstract MatrixInterface data type. A matrix
 * manages a m x n sized array of elements.
 *
 * MatrixInterface will most commonly be used with Integers, but it could be
 * used with other numbers like: doubles, floats, longs, shorts, binary, octal,
 * hex It could also be extended and used with other objects.
 *
 *
 *
 * @author lunatunez
 */
public interface MatrixInterface {

    // *************************************************************************
    // *** STATIC METHODS ******************************************************
    public int getElement(int row, int column);

    public int getCapacity();

    public int getRows();

    public int getColumns();

    public boolean isZeroMatrix();

    public boolean isSquareMatrix();

    public boolean isBinaryMatrix();

    public void display();

    // public clone();
//    public Matrix getInverse();
//    public Matrix getIdentity();   
    // *************************************************************************
    // *** MUTATOR METHODS *****************************************************
    public void setElement(int row, int column, int newEntry);

    public void initialize(); // or initialize()

    public Matrix multiplyScalar(int scalar);

    public Matrix transpose(int adjustment);

    public Matrix addTo(Matrix anotherMatrix);

    public Matrix minus(Matrix anotherMatrix);

    public Matrix multiplyBy(Matrix anotherMatrix);

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
    
}
