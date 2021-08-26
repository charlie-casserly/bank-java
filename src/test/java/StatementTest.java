import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StatementTest {
    Statement statement = new Statement();

    @Test
    void testRecordTransactionSendsTransactionToLogWithAmount() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        assertEquals(50, statement.getLogEntry(0).getTransaction());
    }

    @Test
    void testRecordsThreeTransactionAndSendsThemAllToLog() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(70, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(-30, LocalDate.of(2021, 1, 10));
        assertEquals(-30, statement.getLogEntry(2).getTransaction());
    }

    @Test
    void testRecordsThreeTransactionAndAddsUpCurrentBalance() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(70, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(-30, LocalDate.of(2021, 1, 10));
        assertEquals(90, statement.currentBalance());
    }

    @Test
    void testCurrentBalanceIsRecordedToTransaction() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(70, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(-30, LocalDate.of(2021, 1, 10));
        assertEquals(90, statement.getLogEntry(2).getBalance());
    }

    @Test
    void testRecordTransactionSendsTransactionToLogWithDate() {
        LocalDate date1 = LocalDate.of(2021, 1, 10);
        statement.recordTransaction(50, date1);
        assertEquals(date1, statement.getLogEntry(0).getDate());
    }
}
