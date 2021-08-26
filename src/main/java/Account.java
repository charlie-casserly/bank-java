import java.time.LocalDate;

public class Account {

    Statement statement;

    public Account(Statement injected) {
        statement = injected;
    }

    public void deposit(float amount, LocalDate localDate) {
        this.statement.recordTransaction(amount, localDate);
    }

    public void withdraw(float amount, LocalDate localDate) {
        if (amount > statement.currentBalance()) {
            throw new ArithmeticException("Invalid amount, Balance is:" + statement.currentBalance());
        } else {
            this.statement.recordTransaction(-amount, localDate);
        }
    }
}

