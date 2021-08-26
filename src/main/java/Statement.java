import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Statement {
    private ArrayList<Transaction> log = new ArrayList<>();

    public Statement() {
        ArrayList<Transaction> log = new ArrayList<Transaction>();
    }

    public void recordTransaction(float amount, LocalDate localDate) {
        Transaction transaction = new Transaction(amount, localDate, (currentBalance() + amount));
        this.log.add(transaction);
    }

    public float currentBalance() {
        float result = 0;
        for (int i = 0; i < this.log.size(); i++) { result += this.log.get(i).getTransaction(); }
        return result;
    }

    public Transaction getLogEntry(int index) {
        return this.log.get(index);
    }

    public ArrayList<Transaction> getLog() {
        return this.log;
    }
}
