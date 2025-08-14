import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank[] accounts = new Bank[100]; 
        int count = 0;

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("\nEnter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account No: ");
                    int newAcNo = sc.nextInt();

                    // check if already exists
                    if (search(accounts, count, newAcNo) != null) {
                        System.out.println("Account already exists!");
                    } else {
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Initial Balance: ");
                        double bal = sc.nextDouble();
                        accounts[count++] = new Bank(newAcNo, name, bal);
                        System.out.println("Account Created!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account No: ");
                    int depNo = sc.nextInt();
                    Bank depAcc = search(accounts, count, depNo);
                    if (depAcc != null) {
                        System.out.print("Enter Deposit Amount: ");
                        depAcc.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account No: ");
                    int withNo = sc.nextInt();
                    Bank withAcc = search(accounts, count, withNo);
                    if (withAcc != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        withAcc.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account No: ");
                    int showNo = sc.nextInt();
                    Bank showAcc = search(accounts, count, showNo);
                    if (showAcc != null) {
                        showAcc.display();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No accounts to display.");
                    } else {
                        System.out.println("\n--- All Accounts ---");
                        for (int i = 0; i < count; i++) {
                            accounts[i].display();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    public static Bank search(Bank[] accounts, int count, int acNo) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNo() == acNo) {
                return accounts[i];
            }
        }
        return null;
    }
}
