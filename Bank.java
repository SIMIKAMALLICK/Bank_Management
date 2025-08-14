public class Bank {
    private int accountno;
    private String name;
    private double balance;

    public Bank(int accountno, String name, double balance) {
        this.accountno = accountno;
        this.name = name;
        this.balance = balance;
    }

    public int getAccountNo() {
        return accountno;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn. Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void display() {
        System.out.println("Account No: " + accountno);
        System.out.println("Account Holder: " + name);
        System.out.println("Current Balance: " + balance);
    }
}
