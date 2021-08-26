import javax.swing.plaf.nimbus.State;
import java.time.LocalDate;

public class Account {
    private float balance;

    Statement statement;

    public Account(float initBalance, Statement injected) {
        balance = initBalance;
        statement = injected;
    }

    public void deposit(float amount, LocalDate localDate) {
        this.balance += amount;
        this.statement.recordTransaction(amount, localDate);
    }

    public void withdraw(float amount, LocalDate localDate) {
        if (amount > statement.currentBalance()) {
            throw new ArithmeticException("Invalid amount, Balance is:" + statement.currentBalance());
        } else {
            this.balance -= amount;
            this.statement.recordTransaction(-amount, localDate);
        }
    }

    public double getBalance() {
        return balance;
    }
}

