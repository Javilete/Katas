package outise.in;


import org.junit.Test;
import outside.in.Repository;
import outside.in.Transaction;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

     @Test
    public void shouldAddAtransaction_when_addIsCalled() {
         Transaction transaction = new Transaction(100, new Date());
         Repository repository = new Repository();

         repository.save(transaction);

         List<Transaction> transactions = repository.getTransactions();
         assertEquals(transactions.get(0), transaction);
     }
}
