package teller;

import java.io.PrintStream;
import java.util.Scanner;

public class BankUI {

    private final Bank bank;
    private final Scanner input;
    private final PrintStream output;

    public static final String HELP_MSG = "\nPress 1 to deposit\nPress 2 to withdrawal\nPress 3 to check balance\nPress 4 to close an account\nPress 0 to exit\n";
    public static final String PLEASE_ENTER_A_NUMBER_RATHER_THAN = "Please enter a number rather than:";
    public static final String PLEASE_ENTER_A_NUMBER_RATHER_THAN_SUFFIX = "\n";
    public static final String UNEXPECTED_COMMAND = "Only commands 0,1,2,3, or 4 are expected\n";
    public static final String DEPOSIT = "You want to deposit\n";
    public static final String WITHDRAW  = "You want to withdraw\n";
    public static final String CLOSE  = "You would like to close an account\n";
    public static final String HERE_ARE_YOUR_ACCOUNTS = "Here are your accounts\n";
    public static final String ENTER_ACCOUNT = "Type the account number to choose an account to deposit to.\n";
    public static final String ENTER_DEPOSIT_AMOUNT = "Enter the amount to deposit.\n";
    public static final String YOU_HAVE_SELECTED = "You have selected account: ";
    public static final String YOU_HAVE_SELECTED_SUFFIX = "\n";
    public static final String YOU_DEPOSITED = "You deposited: ";
    public static final String YOU_DEPOSITED_SUFFIX = "\n";
    public static final String ENTER_WITHDRAW_AMOUNT = "Enter the amount to withdraw.\n";
    public static final String YOU_WITHDREW = "You withdrew: ";
    public static final String YOU_WITHDREW_SUFFIX = "\n";
    public static final String UPDATED_BALANCE = "Your updated balance is now: ";
    public static final String UPDATED_BALANCE_SUFFIX = "\n";
    public static final String YOU_CLOSED = "You closed: ";
    public static final String YOU_CLOSED_SUFFIX = "\nHere are your remaining accounts\n";
    public static final String NEXT = "What would you like to do next?";
    public static final String BYE = "Goodbye ... please come again!\n";

    public BankUI(Bank bank, Scanner input, PrintStream output) {
        this.bank = bank;
        this.input = input;
        this.output = output;
    }
        public void runUntilDone() {
            displayAccounts();
            int command = 0;
            do {
                output.print(HELP_MSG);
                while (!input.hasNextInt()) {
                    output.print(PLEASE_ENTER_A_NUMBER_RATHER_THAN + input.next() + PLEASE_ENTER_A_NUMBER_RATHER_THAN_SUFFIX);
                }

                command = input.nextInt();
                switch (command) {
                    case 0:
                        break;
                    case 1: {
                        output.print(DEPOSIT);
                        displayAccounts();
                        output.print(ENTER_ACCOUNT);
                        final String accountNumber = input.next();
                        output.print(YOU_HAVE_SELECTED + accountNumber + YOU_HAVE_SELECTED_SUFFIX);
                        output.print(ENTER_DEPOSIT_AMOUNT);
                        final double amt = getAmt();
                        bank.getAccount(accountNumber).deposit(amt);
                        output.print(YOU_DEPOSITED + amt + YOU_DEPOSITED_SUFFIX);
                        output.print(UPDATED_BALANCE + bank.getAccount(accountNumber).getAccountBalance() + UPDATED_BALANCE_SUFFIX);
                        output.print(NEXT);
                        break;
                    }
                    case 2: {
                        output.print(WITHDRAW);
                        displayAccounts();
                        output.print(ENTER_ACCOUNT);
                        final String accountNumber = input.next();
                        output.print(YOU_HAVE_SELECTED + accountNumber + YOU_HAVE_SELECTED_SUFFIX);
                        output.print(ENTER_WITHDRAW_AMOUNT);
                        final double amt = getAmt();
                        bank.getAccount(accountNumber).withdraw(amt);
                        output.print(YOU_WITHDREW + amt + YOU_WITHDREW_SUFFIX);
                        output.print(UPDATED_BALANCE + bank.getAccount(accountNumber).getAccountBalance() + UPDATED_BALANCE_SUFFIX);
                        output.print(NEXT);
                        break;
                    }
                    case 3: {
                        displayAccounts();
                        output.print(NEXT);
                        break;
                    }
                    case 4: {
                        output.print(CLOSE);
                        displayAccounts();
                        output.print(ENTER_ACCOUNT);
                        final String accountNumber = input.next();
                        output.print(YOU_HAVE_SELECTED + accountNumber + YOU_HAVE_SELECTED_SUFFIX);
                        bank.closeAccount(accountNumber);
                        output.print(YOU_CLOSED + accountNumber + YOU_CLOSED_SUFFIX);
                        displayAccounts();
                        output.print(NEXT);
                        break;
                    }
                    default:
                        output.print(UNEXPECTED_COMMAND);
                        break;
                }
            } while (command != 0);

            output.print(BYE);
        }

        private double getAmt() {return input.nextDouble();}

        private void displayAccounts() {
            output.print(HERE_ARE_YOUR_ACCOUNTS);
            for (final Account account : bank.getAllAccounts()) {
                output.print("(" + account.getAccountNumber() + ") " + account.getAccountType() + " " + account.getAccountBalance() + "\n");
            }
    }
}
