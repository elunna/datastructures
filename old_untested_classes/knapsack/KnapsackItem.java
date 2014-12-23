package knapsack;
/**
 * A class that represents an item that can be stored in a knapsack.
 *
 */
public class KnapsackItem {
    private int size;
    private int value;
    private String description;

    /**
     * Constructors for objects of class KnapsackItem
     */
    public KnapsackItem() {
        this(0, 0, "");
    }

    public KnapsackItem(int theSize, int theValue, String theDescription) {
        size = theSize;
        value = theValue;
        description = theDescription;
    }

    /**
     * Gets the size of this item.
     *
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of this item
     *
     * @param newSize the new size of the item
     */
    public void setSize(int newSize) {
        size = newSize;
    }

    /**
     * Gets the value of this item.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of this item.
     *
     * @param newValue a new value for the item
     */
    public void setValue(int newValue) {
        value = newValue;
    }

    /**
     * Gets the description of this item.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of this item.
     *
     * @param newDescription a new description of the item
     */
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    /**
     * Represents this item as a string.
     *
     * @return a string
     */
    @Override
    public String toString() {
        return description + ":\n\t size " + size + ", value " + value;
    }
}
