
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Bank implements IBank {

    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    @Override
    public void OpenAccount(IAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        accounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        IAccount accountToRemove = FindAccount(accountNumber);
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> inDebtAccounts = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() < 0) {
                inDebtAccounts.add(account);
            }
        }
        return Collections.unmodifiableList(inDebtAccounts);
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithSufficientBalance = new ArrayList<>();
        for (IAccount account : accounts) {
            if (account.GetCurrentBalance() >= balanceAbove) {
                accountsWithSufficientBalance.add(account);
            }
        }
        return Collections.unmodifiableList(accountsWithSufficientBalance);
    }

    private IAccount FindAccount(int accountNumber) {
        for (IAccount account : accounts) {
            if (account.GetAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}