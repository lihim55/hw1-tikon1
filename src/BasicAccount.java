public class BasicAccount implements IAccount {
    private double balance;
    private int accountNumber;
    private double withdrawalLimit;

    public BasicAccount(int accountNumber, double initialBalance, double withdrawalLimit) {
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
        this.withdrawalLimit = Math.max(withdrawalLimit, 0.0); // Ensure withdrawal limit is non-negative
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableAmount = Math.min(balance, withdrawalLimit);
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