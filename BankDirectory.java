import java.util.HashMap;
import java.util.Scanner;

public class BankDirectory {

    HashMap<Integer, String> accounts = new HashMap<>();

    void addAccount(int accountNo, String customerName) {

        accounts.put(accountNo, customerName);

        System.out.println("Account added successfully.");
    }

    void getCustomer(int accountNo) {

        if (accounts.containsKey(accountNo)) {

            System.out.println(
                "Account No: " + accountNo +
                " → " + accounts.get(accountNo)
            );

        } else {

            System.out.println("Account not found.");
        }
    }

    void displayAll() {

        if (accounts.isEmpty()) {

            System.out.println("No accounts available.");

        } else {

            for (Integer accountNo : accounts.keySet()) {

                System.out.println(
                    "Account No: " + accountNo +
                    " → " + accounts.get(accountNo)
                );
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BankDirectory bank = new BankDirectory();

        int choice;

        do {

            System.out.println("\n1. Add Account");
            System.out.println("2. Get Customer Name");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account No: ");
                    int accountNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = sc.nextLine();

                    bank.addAccount(accountNo, customerName);

                    break;

                case 2:

                    System.out.print("Enter Account No: ");
                    int searchAccount = sc.nextInt();

                    bank.getCustomer(searchAccount);

                    break;

                case 3:

                    bank.displayAll();

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