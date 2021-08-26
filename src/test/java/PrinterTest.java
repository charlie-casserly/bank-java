import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class PrinterTest {
    Statement statement = new Statement();

    @Test
    void testPrintsTheStatementBody() {
        statement.recordTransaction(1000, LocalDate.of(2021, 1, 10));
        assertEquals("10/01/2021 || 1000.00 || - || 1000.00", Printer.statementBody(statement));
    }

    @Test
    void testPrintsTheStatementHeader() {
        assertEquals("date || credit || debit || balance", Printer.statementHeader());
    }
}
