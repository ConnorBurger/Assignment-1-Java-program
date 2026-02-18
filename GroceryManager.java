import java.util.Scanner;

/**
 * This program is a grocery management system.
 * It uses parallel arrays to store item names, prices, and stock.
 * The user can view inventory, restock items, or exit.
 *
 * @author Connor Burger
 * @version 1.0
 */
public class GroceryManager {

    /**
     * Prints all items in the inventory.
     * Skips any empty slots in the array.
     *
     * @param names the item names array
     * @param prices the item prices array
     * @param stocks the item stock array
     */
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("\n--- Inventory ---");

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.println("Item: " + names[i] + " | Price: $" + prices[i] + " | Stock: " + stocks[i]);
            }
        }

        System.out.println();
    }

    /**
     * Finds an item by name and adds stock to it.
     * Prints a message if the item is not found.
     *
     * @param names the item names array
     * @param stocks the item stock array
     * @param target the name of the item to restock
     * @param amount how much stock to add
     */
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equals(target)) {
                stocks[i] = stocks[i] + amount;
                System.out.println(target + " restocked! New stock: " + stocks[i]);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    /**
     * Main method that runs the menu loop.
     * Uses a Scanner to get user input.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // add some starting items
        itemNames[0] = "Apples";
        itemPrices[0] = 1.99;
        itemStocks[0] = 50;

        itemNames[1] = "Bread";
        itemPrices[1] = 2.49;
        itemStocks[1] = 30;

        itemNames[2] = "Milk";
        itemPrices[2] = 3.29;
        itemStocks[2] = 20;

        itemNames[3] = "Eggs";
        itemPrices[3] = 4.99;
        itemStocks[3] = 15;

        itemNames[4] = "Cheese";
        itemPrices[4] = 5.49;
        itemStocks[4] = 10;

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                printInventory(itemNames, itemPrices, itemStocks);
            } else if (choice == 2) {
                System.out.print("Enter item name: ");
                String name = scanner.nextLine();
                System.out.print("Enter amount to add: ");
                int amount = scanner.nextInt();
                scanner.nextLine();
                restockItem(itemNames, itemStocks, name, amount);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }
}