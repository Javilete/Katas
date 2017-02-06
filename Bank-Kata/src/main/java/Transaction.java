import java.text.*;
import java.util.*;

public class Transaction implements Comparator<Transaction>{

    private static final String DATE_FORMATTER = "dd/MM/yyyy";

    private final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTER);

    private final double amount;
    private final Date date;

    public Transaction(double amount, String date) throws ParseException {
        this.amount = amount;
        this.date = dateFormat.parse(date);
    }

    public Date getDate() {
        return date;
    }

    public String getFormattedDate() {
        return dateFormat.format(date);
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public int compare(Transaction t1, Transaction t2) {
        return t1.getDate().compareTo(t2.getDate());
    }
}
