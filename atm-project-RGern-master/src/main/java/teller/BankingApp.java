package teller;

import java.io.PrintStream;
import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
            final Bank bank = new Bank();
            bank.populateWithTestAccount();

            final Scanner input = new Scanner(System.in);
            final PrintStream output = System.out;

            final BankUI bankUI = new BankUI(bank, input, output);
            bankUI.runUntilDone();
    }
}
