import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    HashMap<Integer, Integer> inventory = new HashMap<>();

    void addProduct(int productId, int stock) {

        inventory.put(productId, stock);

        System.out.println(
            "Product " + productId +
            " added with stock " + stock
        );
    }

    void updateStock(int productId, int stock) {

        if (inventory.containsKey(productId)) {

            inventory.put(productId, stock);

            System.out.println("Stock updated successfully.");

        } else {

            System.out.println("Product not found.");
        }
    }

    void displayInventory() {

        if (inventory.isEmpty()) {

            System.out.println("Inventory is empty.");

        } else {

            System.out.println("Current Inventory:");

            Iterator<Map.Entry<Integer, Integer>> iterator =
                inventory.entrySet().iterator();

            while (iterator.hasNext()) {

                Map.Entry<Integer, Integer> entry =
                    iterator.next();

                System.out.println(
                    "Product ID: " + entry.getKey() +
                    " → Stock: " + entry.getValue()
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Inventory inventory = new Inventory();

        int choice;

        do {

            System.out.println("\n1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();

                    System.out.print("Enter Stock: ");
                    int stock = sc.nextInt();

                    inventory.addProduct(productId, stock);

                    break;

                case 2:

                    System.out.print("Enter Product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new Stock: ");
                    int newStock = sc.nextInt();

                    inventory.updateStock(updateId, newStock);

                    break;

                case 3:

                    inventory.displayInventory();

                    break;

                case 4:

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}