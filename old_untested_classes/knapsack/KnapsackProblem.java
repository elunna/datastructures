package knapsack;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This program reads items from a text file and then finds the items having the
 * optimal total value and that can fit in a given sized knapsack.
 *
 */
public class KnapsackProblem {
    private static final int MAX_ITEMS = 50;

    /**
     * Reads items from a file and places them into an array.
     *
     * @param fileName the name of the file
     * @return an array of items read
     */
    public static KnapsackItem[] getItems(String fileName) {
        KnapsackItem[] arrayOfItems = new KnapsackItem[MAX_ITEMS];

        Scanner fromFile = null;
        System.out.println("Reading items from file " + fileName);
        try {
            fromFile = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        int arrayIndex = -1;
        while (fromFile.hasNextInt()) {
            // read characteristics of next item
            int size = fromFile.nextInt();
            int value = fromFile.nextInt();
            String description = fromFile.nextLine();

            KnapsackItem theItem = new KnapsackItem(size, value, description);
            arrayIndex++;
            arrayOfItems[arrayIndex] = theItem;
        }
        int numberOfChoices = arrayIndex + 1;

        System.out.println("\nFinished reading file\n");
        fromFile.close();
        // array size is as small as possible
        return Arrays.copyOf(arrayOfItems, numberOfChoices); 
    }

    /**
     * Finds the optimal group of items to take for the knapsack problem.
     *
     * @param knapsack the knapsack
     * @param itemArray the array of items
     * @param itemIndex the array index of the next item to consider
     * @return the knapsack containing the optimal (maximum value) group of
     * items
     */
    public static Knapsack maxKnapsack(Knapsack knapsack, 
            KnapsackItem[] itemArray,
            int itemIndex) {
        Knapsack result = knapsack;
        int knapsackSize = knapsack.getSize();

        // copy items from knapsack to two new knapsack's of the same size
        Knapsack sackOne = new Knapsack(knapsackSize, knapsack);
        Knapsack sackTwo = new Knapsack(knapsackSize, knapsack);

        if (itemIndex >= 0) {
            // at least one item to consider
            KnapsackItem tryItem = itemArray[itemIndex];

            // Try one sack without the item; fill it with other items
            sackOne = maxKnapsack(sackOne, itemArray, itemIndex - 1);

            // Try another sack with the item, only if it fits
            if (tryItem.getSize() <= sackTwo.getSizeOfSpace()) {
                sackTwo.addItem(tryItem);

                // fill the 2nd knapsack with other items
                sackTwo = maxKnapsack(sackTwo, itemArray, itemIndex - 1);
            } // end if

            // return whichever sack is more valuable
            if (sackOne.getTotalValue() > sackTwo.getTotalValue()) {
                result = sackOne;
            } else {
                result = sackTwo;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int knapsackSize = 10; // for this test
        String fileName = "data.txt";

        KnapsackItem[] arrayOfChoices = getItems(fileName);
        System.out.println("Here are the items from which to choose:");
        for (KnapsackItem arrayOfChoice : arrayOfChoices) {
            System.out.print(arrayOfChoice + " ");
        }
        System.out.println();

        Knapsack bestSack = new Knapsack(knapsackSize);
        bestSack = maxKnapsack(bestSack, arrayOfChoices, arrayOfChoices.length - 1);

        System.out.println("The best choices for a knapsack of size " + knapsackSize + " are : ");
        Object[] bestChoices = bestSack.toArray();
        for (Object bestChoice : bestChoices) {
            System.out.println(bestChoice);
        }
        System.out.println();

        System.out.println("The best value is " + bestSack.getTotalValue());
    }
}