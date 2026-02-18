import java.util.Scanner;

/**
 * GroceryManager is a simple grocery inventory management system
 * that uses parallel arrays to track item names, prices, and stock levels.
 *
 * <p>This program allows users to view the current inventory,
 * restock existing items, and exit via a text-based menu.</p>
 *
 * @author Your Team Names Here
 * @version 1.0
 * @since 2025
 */
public class GroceryManager {

    /**
     * Prints the current inventory to the console.
     *
     * @param names  the array of item names
     * @param prices the array of item prices corresponding to each name
     * @param stocks the array of stock quantities corresponding to each name
     */
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("\n===== Current Inventory =====");
        boolean hasItems = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.printf("%-15s | Price: $%.2f | Stock: %d%n",
                        names[i], prices[i], stocks[i]);
                hasItems = true;
            }
        }

        if (!hasItems) {
            System.out.println("Inventory is empty.");
        }
        System.out.println("=============================\n");
    }

    /**
     * Restocks an existing item in the inventory by name.
     *
     * @param names  the array of item names
     * @param stocks the array of stock quantities corresponding to each name
     * @param target the name of the item to restock
     * @param amount the quantity to add to the item's current stock
     */
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                System.out.println("Restocked \"" + names[i] + "\". New stock: " + stocks[i]);
                return;
            }
        }
        System.out.println("Item not found.");
    }

    /**
     * The main entry point of the GroceryManager application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        itemNames[0] = "Apples";   itemPrices[0] = 1.99;  itemStocks[0] = 50;
        itemNames[1] = "Bread";    itemPrices[1] = 2.49;  itemStocks[1] = 30;
        itemNames[2] = "Milk";     itemPrices[2] = 3.29;  itemStocks[2] = 20;
        itemNames[3] = "Eggs";     itemPrices[3] = 4.99;  itemStocks[3] = 15;
        itemNames[4] = "Cheese";   itemPrices[4] = 5.49;  itemStocks[4] = 10;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Grocery Manager Menu =====");
            System.out.println("1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                printInventory(itemNames, itemPrices, itemStocks);
            } else if (choice == 2) {
                System.out.print("Enter item name to restock: ");
                String target = scanner.nextLine();
                System.out.print("Enter amount to add: ");
                int amount = scanner.nextInt();
                scanner.nextLine();
                restockItem(itemNames, itemStocks, target, amount);
            } else if (choice == 3) {
                System.out.println("Exiting Grocery Manager. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close();
    }
}