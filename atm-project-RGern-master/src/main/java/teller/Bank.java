package teller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    final private Map<String, Account> accounts = new HashMap<>();

    Collection<Account> getAllAccounts() {
        return accounts.values();
    }

    public void openNewAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String id) {
        return accounts.get(id);
    }

    public void closeAccount(String id) {
        accounts.remove(id);
    }

    public static final String TEST_ACCOUNT_NUMBER1 = "654-321";
    public static final String TEST_ACCOUNT_TYPE1 = "Checking";
    public static final double TEST_ACCOUNT_BALANCE1 = 100;
    public static final String TEST_ACCOUNT_NUMBER2 = "123-456";
    public static final String TEST_ACCOUNT_TYPE2 = "Savings";
    public static final double TEST_ACCOUNT_BALANCE2 = 1000;

    public void populateWithTestAccount() {
        openNewAccount(new Account(TEST_ACCOUNT_NUMBER1, TEST_ACCOUNT_TYPE1, TEST_ACCOUNT_BALANCE1));
        openNewAccount(new Account(TEST_ACCOUNT_NUMBER2, TEST_ACCOUNT_TYPE2, TEST_ACCOUNT_BALANCE2));
    }

}
