package outside.in;

import java.util.ArrayList;
import java.util.List;

public class Repository {

    private List<Transaction> transactions = new ArrayList<>();

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }
}
