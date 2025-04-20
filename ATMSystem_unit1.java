import java.util.Scanner;

class ATM {
    private double balance;

    ATM(double initialBalance) {
        this.balance = initialBalance;
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount.");
        } else if (amount > balance) {
            throw new ArithmeticException("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining Balance: " + balance);
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM(10000); // Initial balance

        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            atm.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }
}
