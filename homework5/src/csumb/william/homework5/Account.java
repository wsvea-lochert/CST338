package csumb.william.homework5;

public abstract class Account implements Balanceable, Depositable, Withdrawable{
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double newBalance) {
        balance = newBalance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance = balance - amount;
    }
}
