public class StandardAccount implements IAccount {
    private double balance;
    private int accountNumber;
    private double creditLimit;

    public StandardAccount(int accountNumber, double initialBalance, double creditLimit) {
        this.balance = initialBalance;
        this.accountNumber = accountNumber;
        this.creditLimit = Math.min(creditLimit, 0.0); // Ensure credit limit is non-positive
    }

    @Override
    public void Deposit(double amount) {
        balance += amount;
    }

    @Override
    public double Withdraw(double amount) {
        double availableAmount = Math.min(balance + creditLimit, amount);
        availableAmount = Math.min(availableAmount, 0.0); // Ensure withdrawal doesn't exceed credit limit
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