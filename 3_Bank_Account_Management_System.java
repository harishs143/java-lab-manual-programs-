public class Bank_Account_Management_System {
    static class BankAccount {
        private int accountNumber;
        private String holderName;
        private double balance;

        BankAccount(int accountNumber, String holderName, double openingBalance) {
            this.accountNumber = accountNumber; this.holderName = holderName;
            if (openingBalance >= 0) this.balance = openingBalance;
            else throw new IllegalArgumentException("Opening balance cannot be negative.");
        }
        void deposit(double amount) {
            if (amount > 0) { balance += amount; System.out.println("Deposited: Rs." + amount); }
            else System.out.println("Invalid deposit amount.");
        }
        void withdraw(double amount) {
            if (amount <= 0) System.out.println("Invalid withdrawal amount.");
            else if (amount > balance) System.out.println("Insufficient balance.");
            else { balance -= amount; System.out.println("Withdrawn: Rs." + amount); }
        }
        void display() {
            System.out.println("\nAccount Number: " + accountNumber);
            System.out.println("Holder Name: " + holderName);
            System.out.println("Balance: Rs." + balance);
        }
    }
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, "Harish", 5000);
        System.out.println("=== BANK ACCOUNT MANAGEMENT SYSTEM ===");
        account.display();
        account.deposit(2000);
        account.withdraw(1500);
        account.display();
    }
}