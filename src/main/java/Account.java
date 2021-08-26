import java.time.LocalDate;

public class Account {

    Statement statement;

    public Account(Statement injected) {
        statement = injected;
    }

    public void deposit(float amount, LocalDate localDate) {
        if (amount < 0) {
            throw new ArithmeticException("Cannot deposit a negative amount");
        } else {
            this.statement.recordTransaction(amount, localDate);
        }
    }

    public void withdraw(float amount, LocalDate localDate) {
        if (amount > statement.currentBalance()) {
            throw new ArithmeticException("Invalid amount, Balance is:" + statement.currentBalance());
        } else if (amount < 0 ) {
            throw new ArithmeticException("Cannot withdraw a negative amount");
        } else {
            this.statement.recordTransaction(-amount, localDate);
        }
    }
}

