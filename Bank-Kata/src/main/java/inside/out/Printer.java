package inside.out;

import java.util.*;
import java.util.stream.*;

public class Printer {

    private static final String SEPARATOR = "|";
    private static final String DATE_HEADER = "DATE";
    private static final String AMOUNT_HEADER = "AMOUNT";
    private static final String BALANCE_HEADER = "BALANCE";
    public static final String LINE_DELIMITER = "\n";


    public String printFullStament(BankAccount account) {
        return String.join(LINE_DELIMITER,
                printHeaders(),
                printStamentList(account));
    }
    
    private String printHeaders() {
        return String.join(SEPARATOR, DATE_HEADER, AMOUNT_HEADER, BALANCE_HEADER);
    }

    private String printTransaction(double balance, Transaction transaction) {
        return String.join(SEPARATOR,
                transaction.getFormattedDate(),
                String.valueOf(transaction.getAmount()),
                String.valueOf(balance));
    }

    private String printStamentList(BankAccount account) {
        List<String> transactionsLineFormatted = account.getTransactions().stream()
                .map(t -> printTransaction(account.getCurrentBalance(t), t))
                .collect(Collectors.toList());
        Collections.reverse(transactionsLineFormatted);
        return String.join(LINE_DELIMITER, transactionsLineFormatted);
    }

}
