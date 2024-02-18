public class PremiumAccount implements IAccount {
    private double balance;
    private int accountNumber;

    public PremiumAccount(int accountNumber, double initialBalance) {
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        // Premium accounts have no withdrawal limit, so allow full withdrawal
        double availableAmount = amount;
        balance -= availableAmount;
        return availableAmount;
    }

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}