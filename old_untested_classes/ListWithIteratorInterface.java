package adts;
import java.util.Iterator;

/**
 *
 * @author lunatic007
 */
public interface ListWithIteratorInterface<T> extends ListInterface<T>
{
public Iterator<T> getIterator();
} // end ListWithIteratorInterface
