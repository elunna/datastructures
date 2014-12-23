package knapsack;
/**
 * A class that represents a knapsack of items and their total value.
 *
 */
public class Knapsack {
    private BagInterface<KnapsackItem> contents; // bag of knapsack contents
    private int capacity;			   // size of the knapsack
    private int totalValue;          // value of the entire contents
    private int sizeOfContents;      // total size of items in contents
    private static final int INITIAL_SIZE = 10;

    /**
     * Constructor: Creates an empty knapsack of size 10.
     */
    public Knapsack() {
        this(INITIAL_SIZE);
    }

    /**
     * Constructor: Creates an empty knapsack of a given size.
     *
     * @param desiredSize the desired size (> 1) of the knapsack
     */
    public Knapsack(int desiredSize) {
        contents = new ArrayBag<>(desiredSize);
        capacity = desiredSize;
        totalValue = 0;
        sizeOfContents = 0;
    }

    /**
     * Constructor: Creates a knapsack of a given size that contains the items
     * in a given knapsack.
     *
     * @param desiredSize the desired size of the knapsack
     * @param source the given knapsack; must not be larger than desiredSize
     */
    public Knapsack(int desiredSize, Knapsack source) {
        this(desiredSize);
        assert source.capacity <= desiredSize;

        // Add everything in the given knapsack 
        Object[] arrayOfContents = (source.contents).toArray();
        for (Object arrayOfContent : arrayOfContents) {
            contents.add((KnapsackItem) arrayOfContent);
        }
        totalValue = source.totalValue;
        sizeOfContents = source.sizeOfContents;
    }

    /**
     * Adds an item to this knapsack if it fits.
     *
     * @param item the item to add to the list
     * @return true if the item was added
     */
    public boolean addItem(KnapsackItem item) {
        boolean wasAdded = false;
        int itemSize = item.getSize();

        if (sizeOfContents + itemSize <= capacity) {
            wasAdded = contents.add(item);
            if (wasAdded) {
                totalValue = totalValue + item.getValue();
                sizeOfContents = sizeOfContents + itemSize;
            }
        }

        return wasAdded;
    }

    /**
     * Gets the number of items in this knapsack.
     *
     * @return the size of the knapsack
     */
    public int getNumberOfItems() {
        return contents.getCurrentSize();
    }

    /**
     * Gets the items in this knapsack.
     *
     * @return an array of items stored in the knapsack
     */
    public Object[] toArray() {
        return contents.toArray();
    }

    /**
     * Gets the size of this knapsack.
     *
     * @return the size of the knapsack
     */
    public int getSize() {
        return capacity;
    }

    /**
     * Gets the total size of the items in this knapsack.
     *
     * @return the total size of all the items in the knapsack
     */
    public int getSizeOfContents() {
        return sizeOfContents;
    }

    /**
     * Sees whether this knapsack is empty.
     *
     * @return true if the knapsack is empty
     */
    public boolean isEmpty() {
        return sizeOfContents == 0;
    }

    /**
     * Gets the size of the empty space in this knapsack.
     *
     * @return the size of the empty space in the knapsack
     */
    public int getSizeOfSpace() {
        return capacity - sizeOfContents;
    }

    /**
     * Gets the total value of the items in this knapsack.
     *
     * @return the total value of all the items in the knapsack
     */
    public int getTotalValue() {
        return totalValue;
    }
}
