package csumb.william.homework5;

public class SavingsAccount extends Account {
    double monthlyIntrestRate;
    double monthlyIntrestPayment;


    public SavingsAccount(double balance, double monthlyIntrestRate) {
        super(balance);
        this.monthlyIntrestRate = monthlyIntrestRate;
       // this.monthlyIntrestPayment = monthlyIntrestPayment;
    }

    public double getMonthlyIntrestRate() {
        return monthlyIntrestRate * 100;
    }

    public double getMonthlyIntrestPayment() {
        return monthlyIntrestPayment;
    }

    public void setLastBalance(){
        monthlyIntrestPayment = monthlyIntrestRate * balance;
        balance += monthlyIntrestPayment;
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }
}
