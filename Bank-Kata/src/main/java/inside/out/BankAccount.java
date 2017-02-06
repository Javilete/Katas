package inside.out;

import java.util.*;

public class BankAccount {

    private static final String DATE = "DATE";
    private static final String AMOUNT = "AMOUNT";
    private static final String BALANCE_HEADER = "BALANCE";
    private static final String SEPARATOR = "|";

    private double balance = 0.0;
    private final Printer printer;
    private List<Transaction> transactions = new ArrayList<>();

    public BankAccount(Printer printer) {
        this.printer = printer;
    }

    public void deposit(int amount) {}
    public void withdraw(int amount) {}
    public void printStatement(){
        printer.printFullStament(this);
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public double getCurrentBalance(Transaction transaction) {
        return this.balance += transaction.getAmount();
    }
}
