import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StatementTest {
    Statement statement = new Statement();

    @Test
    void testRecordTransactionSendsTransactionToLogWithAmount() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        assertTrue(statement.getLogEntry(0) instanceof Transaction);
    }

    @Test
    void testRecordsThreeTransactionAndSendsThemAllToLog() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(70, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(-30, LocalDate.of(2021, 1, 10));
        assertTrue(statement.getLogEntry(2) instanceof Transaction);
    }

    @Test
    void testRecordsThreeTransactionAndAddsUpCurrentBalance() {
        statement.recordTransaction(50, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(70, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(-30, LocalDate.of(2021, 1, 10));
        assertEquals(90, statement.currentBalance());
    }
}
