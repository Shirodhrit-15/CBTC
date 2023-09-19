import java.util.Scanner;

class Account {
    private String userId;
    private String userPin;
    private double balance;

    public Account(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 1000.0; // Initial balance for demonstration purposes.
    }

    public String getUserId() {
        return userId;
    }

    public boolean validatePin(String inputPin) {
        return userPin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("The ammount you are withdrawing is more than your available balance (Insufficient funds).");
        }
    }

    public void transfer(Account targetAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public String toString() {
        return "Account Holder: " + userId + "\nBalance: $" + balance;
    }
}

class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an account (for demonstration, you can add multiple accounts in a real system).
        Account account = new Account("123456", "1234");

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter PIN: ");
            String userPin = scanner.nextLine();

            if (account.validatePin(userPin)) {
                System.out.println("Login successful.");
                break;
            } else {
                System.out.println("Invalid User ID or PIN. Please try again.");
            }
        }

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Implement Transaction History
                    System.out.println("Transaction History: Not implemented in this demo.");
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    String recipientUserId = scanner.next();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();

                    // Simulate transfer to another account (for demonstration).
                    Account recipientAccount = new Account("654321", "5678"); // Another account for demonstration.
                    account.transfer(recipientAccount, transferAmount);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Display account details after each transaction.
            System.out.println("\n" + account);
        }
    }
}
