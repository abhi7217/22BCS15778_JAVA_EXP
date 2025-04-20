import java.util.Scanner;

class BankAccount {
    String name;
    String accNumber;
    double balance;

    BankAccount(String name, String accNumber, double balance) {
        this.name = name;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount > balance)
            System.out.println("Insufficient balance.");
        else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void display() {
        System.out.println("Name: " + name + ", Account No: " + accNumber + ", Balance: " + balance);
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name, account number and initial balance:");
        BankAccount account = new BankAccount(sc.next(), sc.next(), sc.nextDouble());

        int choice;
        do {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Display\n4. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.display();
                    break;
            }
        } while (choice != 4);
    }
}
