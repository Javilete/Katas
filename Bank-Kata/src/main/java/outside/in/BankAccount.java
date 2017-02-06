package outside.in;

import java.util.Date;
import java.util.List;

public class BankAccount {

    private final StatementGenerator statementGenerator;
    private final Repository repository;

    public BankAccount(Repository repository, StatementGenerator statementGenerator) {
        this.repository = repository;
        this.statementGenerator = statementGenerator;
    }

    public void deposit(int amount) {
        repository.save(new Transaction(amount, new Date()));
    }

    public void withdraw(int amount){
        repository.save(new Transaction(-amount, new Date()));
    }

    public void printStatement(){
        List<Transaction> transactions = repository.getTransactions();
        statementGenerator.generateFullStatement(transactions);
    }
}
