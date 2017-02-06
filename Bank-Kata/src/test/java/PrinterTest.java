import org.junit.*;

import java.text.*;

import static org.junit.Assert.assertEquals;

public class PrinterTest {

    @Test
    public void shouldGenerateHeadersOfAnStatement() throws ParseException {
        Printer printer = new Printer();
        BankAccount account = new BankAccount(printer);

        String fullStatement = printer.printFullStament(account);

        assertEquals("DATE|AMOUNT|BALANCE\n", fullStatement);
    }

    @Test
    public void shouldGenerateFullStatementOfAnAccountWithOneTransaction() throws ParseException {
        Printer printer = new Printer();
        BankAccount account = new BankAccount(printer);
        account.addTransaction(new Transaction(500.0, "10/04/2014"));

        String fullStatement = printer.printFullStament(account);

        assertEquals("DATE|AMOUNT|BALANCE\n" +
                "10/04/2014|500.0|500.0", fullStatement);
    }

    @Test
    public void shouldGenerateFullStatementOfAnAccountWithSeveralTransactions() throws ParseException {
        Printer printer = new Printer();
        BankAccount account = new BankAccount(printer);
        account.addTransaction(new Transaction(1000.0, "01/04/2014"));
        account.addTransaction(new Transaction(-100.0, "02/04/2014"));
        account.addTransaction(new Transaction(500.0, "10/04/2014"));

        String fullStatement = printer.printFullStament(account);

        assertEquals("DATE|AMOUNT|BALANCE\n" +
                "10/04/2014|500.0|1400.0\n" +
                "02/04/2014|-100.0|900.0\n" +
                "01/04/2014|1000.0|1000.0", fullStatement);
    }

}
