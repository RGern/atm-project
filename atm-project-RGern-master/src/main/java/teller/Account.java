package teller;

public class Account {

    private String accountNumber;
    private String accountType;
    private static double accountBalance;

    public Account(String accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }
    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdraw(double amount) {
        this.accountBalance -= amount;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public static double getAccountBalance() {
        return accountBalance;
    }

}
