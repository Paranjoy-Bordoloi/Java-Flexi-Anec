import java.util.ArrayList;
import java.util.List;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into " + accountNumber);
        }
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Error: Insufficient funds in account " + accountNumber);
        }
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount + " from " + accountNumber);
    }

    public void transfer(Account targetAccount, double amount) throws InsufficientFundsException {
        if (targetAccount == null) {
            System.out.println("Transfer failed: Target account does not exist.");
            return;
        }
        
        this.withdraw(amount);
        targetAccount.deposit(amount);
        System.out.println("Transferred $" + amount + " to account " + targetAccount.getAccountNumber());
    }

    public void displayAccountDetails() {
        System.out.printf("Acc #: %s | Holder: %-10s | Balance: $%.2f%n", 
                          accountNumber, accountHolderName, balance);
    }

    public String getAccountNumber() { return accountNumber; }
}

class Bank {
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        Account newAcc = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.add(newAcc);
        System.out.println("Account created for " + accountHolderName);
    }

    public Account getAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        System.out.println("\n--- All Bank Accounts ---");
        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        myBank.createAccount("101", "Akash", 1000.00);
        myBank.createAccount("102", "B2", 500.00);

        Account Akash = myBank.getAccount("101");
        Account B2 = myBank.getAccount("102");

        try {
            Akash.deposit(200);
            Akash.transfer(B2, 300);
            B2.withdraw(2000); 

        } catch (InsufficientFundsException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        myBank.displayAllAccounts();
    }
}