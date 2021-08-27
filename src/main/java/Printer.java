import javax.swing.plaf.nimbus.State;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class Printer {
    public static String print(Statement statement) {
        System.out.println(statementHeader() + statementBody(statement));
        return statementHeader() + statementBody(statement);
    }

    private static String statementHeader() {
        return "date || credit || debit || balance\n";
    }

    private static String statementBody(Statement statement) {
        ArrayList<String> transactions = new ArrayList<>();
        for (int i = 0; i < statement.getLog().size(); i++) {
            transactions.add(formatBody(statement, i));
        }
        return String.join("\n", transactions);
    }

    private static String formatBody(Statement statement, int i) {
        return formatDate(statement, i) + formatTransaction(statement, i) + formatBalance(statement, i);
    }

    private static String formatDate(Statement statement, int i) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return statement.getLogEntry(i).getDate().format(formatter);
    }

    private static String formatTransaction(Statement statement, int i) {
        if (statement.getLogEntry(i).getTransaction() > 0) {
            return formatCredit(statement, i);
        } else {
            return formatDebit(statement, i);
        }
    }

    private static String formatCredit(Statement statement, int i) {
        return " || " + formatCashAmount(statement, i) + " || - || ";
    }

    private static String formatDebit(Statement statement, int i) {
        return " || - || " + formatCashAmount(statement, i) + " || ";
    }

    private static String formatCashAmount(Statement statement, int i) {
        return String.format("%.02f", Math.abs(statement.getLogEntry(i).getTransaction()));
    }

    private static String formatBalance(Statement statement, int i) {
        return String.format("%.02f", statement.getLogEntry(i).getBalance());
    }
}
