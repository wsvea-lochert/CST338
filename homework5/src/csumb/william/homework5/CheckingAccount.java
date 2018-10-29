package csumb.william.homework5;

public class CheckingAccount extends Account {
    double transactionFee;
    double totalFee;

    public CheckingAccount(double balance, double transactionFee) {
        super(balance);
        this.transactionFee = transactionFee;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public double getTotalFee() {
        return totalFee;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        balance = balance - transactionFee;
        totalFee += transactionFee;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        balance = balance - transactionFee;
        totalFee += transactionFee;
    }
}
