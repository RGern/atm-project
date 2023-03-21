package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void getAllAccounts() {
        for (Account account: new Bank().getAllAccounts()) {
            System.out.println(account);
        }
    }

    @Test
    void openNewAccount() { new Bank().openNewAccount(new Account("123-456", "Checking", 0));    }

    @Test
    void getAccount() {
        Bank bank = new Bank();
        Account account = new Account("123-456", "Checking", 0);
        bank.openNewAccount(account);
        assertEquals(account, bank.getAccount(account.getAccountNumber()));
    }

    @Test
    void closeAccount() {
        Bank bank = new Bank();
        Account account = new Account("123-456", "Checking", 0);
        bank.openNewAccount(account);
        bank.closeAccount(account.getAccountNumber());
        assertEquals(null, bank.getAccount("123-456"));
    }
}