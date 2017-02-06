# **Bank-Kata**

Problem description: Bank kata

Create a simple bank application with the following features:

Deposit into Account
Withdraw from an Account
Print a bank statement to the statementGenerator.
The entry point should be the following interface, which you can not change. Don't worry about introducing abstractions on Money or Date as this is not the point of the exercise.

public class inside.out.BankAccount {
    public void deposit(int amount);
    public void withdraw(int amount);
    public void printStatement();
}

Acceptance criteria Statement should have the following format:

    DATE       | AMOUNT  | BALANCE
    10/04/2014 | 500.00  | 1400.00
    02/04/2014 | -100.00 | 900.00
    01/04/2014 | 1000.00 | 1000.00


## **Inside-out TDD:**

Once the domain problem has been understood and what the AC is requiring the starting point
was to create a test that would cover it.
To do so, it was started creating a test method that would assert on the headers display on
its own (shouldGenerateHeadersOfAnStatement). Split in small chunks
This lead me to create a method inside the bank class that would generate and return
the headers as it is they are in the AC.

The next step was to create a test that would print a transaction in the format
specified in the AC, so a new method in the bank account was created. The
arrange in the test was a bankAccount instance and this would have a variable
that would hold the list of transactions. A new class inside.out.Transaction was created

After checking so far the code, Account class was holding more responsability
that it should, so a new class inside.out.Printer was create that would take care of
all the printing stuff. Then test were move to a new class inside.out.PrinterTest.
Amendments were done so our test were still passing and covering our AC.

Next thing was to cover with a test the full printing statement, with headers and
transactions (first of all with one). printFullStatement() method was needed to
be created. With more than one (as it is in the AC) it was needed to update
the code in the inside.out.Printer class to do the calculation of the balance.

After this, the solution was done. Starting with our tests allowed me to
see better what was needed to build. Asserting first in the test lead me
to add only the instances needed to cover what the test was supposed to.
And once test were passing, before moving one refactoring checkings were done,
so it took me to create the inside.out.Printer class and move methods from bankAccount to
the former.

## **Outside-in TDD:**

In this case, we will start with a test method that will assert on the
whole AC as such.

The main difference here is the use of mocks to check the collaborators.
AccountTest now verifies the interaction with the collaborators, in this case, Repository
where we get the transactions from (as if it were our data store) and Generator (which
will generate the right format as our AC).

This led me to add test for the behaviour of Repository, when executing a desposit or withdraw.
So a RespositoryTest class was added to test that when any of those operations occur a transaction
is added. Well, so a new class is needed, right? Transaction class was added in our domain.

The test to verify that the printing was as expect made me think that all this should be done in a different
class, therefore the Generator class was created.
Inside the class, the statement generation was done spliting the responsability per method, allowing better
readiability and code structure:
- having a method for generating the headers
- having a method for generating the statements content
- having a method for generating a single statment 

