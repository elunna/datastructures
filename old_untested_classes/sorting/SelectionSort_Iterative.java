package sorting;

/**
 * File: Description:
 *
 * @author lunatunez
 */
public class SelectionSort_Iterative {

    /**
     * Sorts the first n objects in an array into ascending order.
     *
     * @param <T>
     * @param a an array of Comparable objects
     * @param n an integer > 0
     */
    public static <T extends Comparable<? super T>> void sort(T[] a, int n) {
        for (int index = 0; index < n - 1; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
        }
    }

    /**
     * Finds the index of the smallest value in a portion of an array.
     *
     * @param a an array of Comparable objects
     * @param first an integer >= 0 and lessThen a.length that is the index of
     * the first array entry to consider @param last an integer >= first and
     * lessThan a.length that is the index of the last array entry to consider
     * @return the index of the smallest value among a[first], a[first+ 1], . .
     * . , a[last]
     */
    private static <T extends Comparable<? super T>>
            int getIndexOfSmallest(T[] a, int first, int last) {

        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            }
            // Assertion: min is the smallest of a[first] through a[index].
        }
        return indexOfMin;
    }

    /**
     * Swaps the array entries a[i] and a[j].
     *
     * @param a an array of objects
     * @param i an integer >= 0 and less than a.length 
     * @param j an integer >= 0 and less than a.length
     */
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    
}
