import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(new Statement());

        account.deposit(50, LocalDate.of(2021, 1, 10));
        account.deposit(50, LocalDate.of(2021, 1, 10));
        account.withdraw(50, LocalDate.of(2021, 1, 10));
        account.withdraw(40, LocalDate.of(2021, 1, 10));

        Printer.print(account.statement);
    }
}
