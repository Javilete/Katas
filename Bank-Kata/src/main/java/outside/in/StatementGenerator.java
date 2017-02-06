package outside.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatementGenerator {

    public static final String LINE_DELIMITER = "\n";
    public static final String DATE = "DATE";
    public static final String AMOUNT = "AMOUNT";
    public static final String BALANCE = "BALANCE";
    private static final String COLUMN_SEPARATOR = " | ";

    private final Printer printer;

    public StatementGenerator(Printer printer) {
        this.printer = printer;
    }

    public void generateFullStatement(List<Transaction> transactions) {
        printer.print(
                String.join(LINE_DELIMITER,
                generateHeaders(),
                generateStatements(transactions)));

    }

    private String generateStatements(List<Transaction> transactions) {
        List<String> formattedStatements = new ArrayList<>();
        double balance = 0.0;

        for(int i = 0; i < transactions.size(); i++) {
            balance += transactions.get(i).getAmount();
            formattedStatements.add(generateStatement(transactions.get(i), balance));
        }

        Collections.reverse(formattedStatements);
        return String.join(LINE_DELIMITER, formattedStatements);
    }

    private String generateStatement(Transaction transaction, double balance) {
        return String.join(COLUMN_SEPARATOR,
                transaction.getDate(),
                String.valueOf(transaction.getAmount()),
                String.valueOf(balance));
    }

    private String generateHeaders() {
        return String.join(COLUMN_SEPARATOR, DATE, AMOUNT, BALANCE);
    }
}
