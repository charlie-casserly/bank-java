import java.time.LocalDate;

public class Transaction {
    private LocalDate localDate;
    private float transaction;
    private float balance;

    public Transaction(float amountInit, LocalDate localDateInit, float balanceInit) {
        transaction = amountInit;
        localDate = localDateInit;
        balance = balanceInit;
    }

    public float getTransaction() {
        return this.transaction;
    }

    public LocalDate getDate() {
        return this.localDate;
    }

    public float getBalance() { return this.balance; }
}
