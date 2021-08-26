import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class Printer {
    public static String print(Statement statement) {
        return statementHeader() + statementBody(statement);
    }

    private static String statementHeader() {
        return "date || credit || debit || balance\n";
    }

    private static String statementBody(Statement statement) {
        ArrayList<String> log = new ArrayList<>();
        for (int i = 0; i < statement.getLog().size(); i++) {
            log.add(formatBody(statement, i));
        }
        return String.join("\n", log);
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
            return " || " + formatCashAmount(statement, i) + " || - || ";
        } else {
            return " || - || " + formatCashAmount(statement, i) + " || ";
        }
    }

    private static String formatCashAmount(Statement statement, int i) {
        return String.format("%.02f", Math.abs(statement.getLogEntry(i).getTransaction()));
    }

    private static String formatBalance(Statement statement, int i) {
        return String.format("%.02f", statement.getLogEntry(i).getBalance());
    }

}
