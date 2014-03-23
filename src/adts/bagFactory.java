package adts;

/**
 *
 * @author Erik Lunna
 */
public class bagFactory {
    public ArrayBag createBag(int size) {
        ArrayBag newBag = null;
        if (size < 0) {
            return null;
        }
        else if (size >= 0) {
            newBag = new ArrayBag(size);
        }
        return newBag;
    }
}
