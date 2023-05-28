package randomq.com;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class AccountHolder {
    private String userId;
    private String userPin;

    public AccountHolder(String userId, String userPin) {
        this.userId = userId;
        this.userPin = userPin;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }
}

class Account {
    private String accountId;
    private double balance;
    private List<BankTransaction> transactionHistory;
    private String userPin; // Add userPin property

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new BankTransaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add(new BankTransaction("Withdrawal", -amount));
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void transfer(Account recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add(new BankTransaction("Transfer", -amount));
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        for (BankTransaction transaction : transactionHistory) {
            System.out.println(transaction.getTransactionType() + ": " + transaction.getAmount());
        }
    }

    public String getUserPin() { // Getter for userPin
        return userPin;
    }

    public void setUserPin(String userPin) { // Setter for userPin
        this.userPin = userPin;
    }
}

class BankTransaction {
    private String transactionType;
    private double amount;

    public BankTransaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountById(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    public AccountHolder getAccountHolderById(String userId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(userId)) {
                return new AccountHolder(account.getAccountId(), account.getUserPin());
            }
        }
        return null;
    }
}

class ATM {
    private Bank bank;
    private AccountHolder accountHolder;

    public ATM(Bank bank) {
        this.bank = bank;
        this.accountHolder = null;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("User ID: ");
        String userId = scanner.nextLine();
        System.out.print("User PIN: ");
        String userPin = scanner.nextLine();

        if (authenticate(userId, userPin)) {
            showMenu(scanner);
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private boolean authenticate(String userId, String userPin) {
        AccountHolder accountHolder = new AccountHolder(userId, userPin);
        AccountHolder storedAccountHolder = bank.getAccountHolderById(userId);

        if (storedAccountHolder != null && storedAccountHolder.getUserPin().equals(userPin)) {
            this.accountHolder = accountHolder;
            return true;
        }

        return false;
    }

    private void showMenu(Scanner scanner) {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Show Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");

            System.out.print("Option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    transfer(scanner);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showTransactionHistory() {
        Account account = bank.getAccountById(accountHolder.getUserId());
        account.showTransactionHistory();
    }

    private void withdraw(Scanner scanner) {
        Account account = bank.getAccountById(accountHolder.getUserId());
        System.out.print("Amount to withdraw: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void deposit(Scanner scanner) {
        Account account = bank.getAccountById(accountHolder.getUserId());
        System.out.print("Amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void transfer(Scanner scanner) {
        Account account = bank.getAccountById(accountHolder.getUserId());
        System.out.print("Recipient Account ID: ");
        String recipientId = scanner.nextLine();
        Account recipient = bank.getAccountById(recipientId);

        if (recipient != null) {
            System.out.print("Amount to transfer: ");
            double amount = scanner.nextDouble();
            account.transfer(recipient, amount);
        } else {
            System.out.println("Recipient account not found.");
        }
    }
}
public class test {

	public static void main(String[] args) {
		  Bank bank = new Bank();

	        Account account1 = new Account("19981998");
	        account1.setUserPin("2222"); // Set the PIN for the account
	        Account account2 = new Account("19971997");
	        account2.setUserPin("2222"); // Set the PIN for the account

	        bank.addAccount(account1);
	        bank.addAccount(account2);

	        ATM atm = new ATM(bank);
	        atm.start();

	}

}
