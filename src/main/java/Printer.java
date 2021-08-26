import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public final class Printer {
    public static String statementHeader() {
        return "date || credit || debit || balance";
    }

    public static ArrayList statementBody(Statement statement) {
        ArrayList<String> log = new ArrayList<>();
        for (int i = 0; i < statement.getLog().size(); i++) {
            log.add(String.format(formatDate(statement, i) + " || %f || %f || %f", statement.getLog().get(i).getTransaction(), statement.getLog().get(i).getTransaction(), statement.getLog().get(i).getBalance()));
        }
        return log;
    }

    private static String formatDate(Statement statement, int i) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return statement.getLogEntry(i).getDate().format(formatter);
    }
}
