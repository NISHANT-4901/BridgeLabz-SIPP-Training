package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.ArrayList;

class Bank {
    String name;
    ArrayList<Account> accounts;

    Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    void openAccount(Customer customer, int initialDeposit) {
        Account account = new Account(this, customer, initialDeposit);
        accounts.add(account);
        customer.addAccount(account);
        System.out.println("Account opened for " + customer.name + " at " + this.name + " Bank.");
    }

    void showAccounts() {
        System.out.println("Accounts in " + name + " Bank:");
        for (Account acc : accounts) {
            System.out.println("Customer: " + acc.customer.name + ", Balance: ₹" + acc.balance);
        }
        System.out.println();
    }
}

class Customer {
    String name;
    ArrayList<Account> accounts;

    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    void addAccount(Account account) {
        accounts.add(account);
    }

    void viewBalances() {
        System.out.println(name + "'s Accounts:");
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.bank.name + ", Balance: ₹" + acc.balance);
        }
        System.out.println();
    }
}

class Account {
    Bank bank;
    Customer customer;
    int balance;

    Account(Bank bank, Customer customer, int balance) {
        this.bank = bank;
        this.customer = customer;
        this.balance = balance;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        // Create banks
        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        // Create customers
        Customer nishant = new Customer("Nishant");
        Customer rahul = new Customer("Rahul");

        // Open accounts
        sbi.openAccount(nishant, 10000);
        hdfc.openAccount(nishant, 5000);
        hdfc.openAccount(rahul, 7000);

        // Display balances
        nishant.viewBalances();
        rahul.viewBalances();

        // Show all accounts per bank
        sbi.showAccounts();
        hdfc.showAccounts();
    }
}
