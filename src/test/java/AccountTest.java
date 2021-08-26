import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    Statement statement = new Statement();
    Account account = new Account(statement);

    @Test
    void testExceptionIsThrownIfWithdrawalTakesBalanceBelow0() {
        account.deposit(10, LocalDate.of(2021, 1, 10));
        assertThrows(ArithmeticException.class, () -> account.withdraw(15, LocalDate.of(2021, 1, 10)));
    }
}
