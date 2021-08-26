import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    LocalDate date = LocalDate.of(2021, 1, 10);
    Transaction transaction = new Transaction(50, date, 150);

    @Test
    void testStoresTransactionAmount() {
        assertEquals(50, transaction.getTransaction());
    }

    @Test
    void testStoresBalanceAtTimeOfTransaction() {
        assertEquals(150, transaction.getBalance());
    }

    @Test
    void testStoresDateAtTimeOfTransaction() {
        assertEquals(date, transaction.getDate());
    }
}
