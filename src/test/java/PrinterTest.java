import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;

public class PrinterTest {
    Statement statement = new Statement();

    @Test
    void testPrintsTheStatement() {
        statement.recordTransaction(1000, LocalDate.of(2021, 1, 10));
        statement.recordTransaction(-400, LocalDate.of(2021, 1, 10));
        assertEquals("date || credit || debit || balance\n10/01/2021 || 1000.00 || - || 1000.00\n10/01/2021 || - || 400.00 || 600.00", Printer.print(statement));
    }
}
