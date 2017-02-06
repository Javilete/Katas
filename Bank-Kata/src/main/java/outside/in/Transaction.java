package outside.in;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;

public class Transaction {

    private static final String DATE_FORMATTER = "dd/MM/yyyy";

    private final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTER);

    private final double amount;
    private final String date;

    public Transaction(double amount, Date date) {
        this.amount = amount;
        this.date = dateFormat.format(date);
    }

    public String getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return date.equals(that.date);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + date.hashCode();
        return result;
    }
}
