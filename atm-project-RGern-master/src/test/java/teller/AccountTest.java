package teller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void getAccountNumber() {
        assertEquals("1-2-3", (new Account("1-2-3", "Checking", 0).getAccountNumber()));
    }

    @Test
    void getAccountType() {
        assertEquals("Checking", (new Account("1-2-3", "Checking", 0).getAccountType()));
    }

    @Test
    void getAccountBalance() {
        assertEquals(0f, (new Account("1-2-3", "Checking", 0).getAccountBalance()));
    }

    @Test
    void canDeposit() {
        new Account("1-2-3", "Checking", 0).deposit(0);
    }

    @Test
    void depositWorks() {
        Account checking = new Account("1-2-3", "Checking", 0);
        checking.deposit(1);
        assertEquals(1, checking.getAccountBalance());
    }

    @Test
    void depositAdds() {
        Account checking = new Account("1-2-3", "Checking", 100);
        checking.deposit(1);
        assertEquals(101, checking.getAccountBalance());
    }

    @Test
    void canWithdraw() {
        new Account("1-2-3", "Checking", 0).withdraw(0);
    }

    @Test
    void withdrawWorks() {
        Account checking = new Account("1-2-3", "Checking", 100);
        checking.withdraw(1);
        assertEquals(99, checking.getAccountBalance());
    }
}