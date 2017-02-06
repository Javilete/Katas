package outise.in;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import outside.in.BankAccount;
import outside.in.StatementGenerator;
import outside.in.Repository;
import outside.in.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankAcountTest {

    @Mock
    private Repository repository;

    @Mock
    private StatementGenerator statementGenerator;

    @InjectMocks
    private BankAccount bankAccount;

    @Test
    public void shouldCallAddFromRepository_when_aWithdrawIsDone() {
        Transaction transaction = new Transaction(-100, new Date());

        bankAccount.withdraw(100);

        verify(repository).save(transaction);
    }

    @Test
    public void shouldCallAddFromRepository_when_aDepositIsDone(){
        Transaction transaction = new Transaction(100, new Date());

        bankAccount.deposit(100);

        verify(repository).save(transaction);
    }

    @Test
    public void shouldRetrieveStatementsFromRepository() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(100, new Date()));
        when(repository.getTransactions())
                .thenReturn(transactions);

        bankAccount.printStatement();

        verify(statementGenerator).generateFullStatement(transactions);
    }
}
