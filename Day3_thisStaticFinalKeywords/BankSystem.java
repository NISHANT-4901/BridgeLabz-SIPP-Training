package Day3_thisStaticFinalKeywords;

public class BankSystem {

    // BankAccount class
    static class BankAccount {
        // Static variable (shared across all instances)
        static String bankName = "State Bank of India";
        static int totalAccounts = 0;

        // Final variable (cannot be changed once assigned)
        final int accountNumber;
        String accountHolderName;
        double balance;

        // Constructor using 'this' to resolve ambiguity
        public BankAccount(int accountNumber, String accountHolderName, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
            totalAccounts++;
        }

        // Static method to get total accounts
        public static void getTotalAccounts() {
            System.out.println("Total Bank Accounts: " + totalAccounts);
        }

        // Display account details
        public void displayDetails() {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: ₹" + balance);
        }
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {
        // Create two bank accounts
        BankAccount acc1 = new BankAccount(1001, "Nishant", 25000.50);
        BankAccount acc2 = new BankAccount(1002, "Aarav", 30000.00);

        // Check using instanceof before displaying
        if (acc1 instanceof BankAccount) {
            System.out.println("Account 1 Details:");
            acc1.displayDetails();
        }

        if (acc2 instanceof BankAccount) {
            System.out.println("\nAccount 2 Details:");
            acc2.displayDetails();
        }

        // Call static method
        System.out.println();
        BankAccount.getTotalAccounts();
    }
}
