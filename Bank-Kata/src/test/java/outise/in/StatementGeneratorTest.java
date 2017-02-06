package outise.in;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import outside.in.Printer;
import outside.in.StatementGenerator;
import outside.in.Transaction;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementGeneratorTest {

    private static final String DATE_FORMATTER = "dd/MM/yyyy";
    private final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMATTER);

    @Mock
    Printer printer;

    @InjectMocks
    StatementGenerator statementGenerator;

    @Test
    public void shouldCallPrintFromConsole_when_generateStamentCall() throws ParseException {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1000, dateFormat.parse("01/04/2014")));
        transactions.add(new Transaction(-100, dateFormat.parse("02/04/2014")));
        transactions.add(new Transaction(500, dateFormat.parse("10/04/2014")));

        statementGenerator.generateFullStatement(transactions);

        verify(printer).print("DATE | AMOUNT | BALANCE\n" +
                "10/04/2014 | 500.0 | 1400.0\n" +
                "02/04/2014 | -100.0 | 900.0\n" +
                "01/04/2014 | 1000.0 | 1000.0");
    }
}
