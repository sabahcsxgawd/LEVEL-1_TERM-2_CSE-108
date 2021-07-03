interface Account {
    // the following method returns the balance
    double balance();

    // the following method subtracts the amount from the balance,
    // the amount in the method can’t be negative, the balance can’t be negative
    void debit(double amount) throws InvalidAmountException, InvalidBalanceException;

    // the following method adds the amount directly to the balance,
    // the amount in the method can’t be negative
    void credit(double amount) throws InvalidAmountException;
}

class SavingsAccount implements Account {
    private double balance;

    public SavingsAccount() {
        this.balance = 0;
    }

    @Override
    public double balance() {
        return this.balance;
    }

    @Override
    public void debit(double amount) throws InvalidAmountException, InvalidBalanceException {
        System.out.println("Debit Request: " + amount);
        if(amount < 0) {
            throw new InvalidAmountException(amount);
        }
        if(this.balance < amount) {
            throw new InvalidBalanceException(this.balance - amount);
        }
        this.balance -= amount;
    }

    @Override
    public void credit(double amount) throws InvalidAmountException {
        System.out.println("Credit Request: " + amount);
        if(amount < 0) {
            throw new InvalidAmountException(amount);
        }
        this.balance += amount;
    }
}

class InvalidBalanceException extends Exception {
    private double reducedBalance;

    public InvalidBalanceException(double reducedBalance) {
        this.reducedBalance = reducedBalance;
    }

    @Override
    public String toString() {
        return "The account balance can’t be less than zero: " + this.reducedBalance;
    }
}

class InvalidAmountException extends Exception {
    private double amount;

    public InvalidAmountException(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "The given amount can’t be negative: " + this.amount;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account a = new SavingsAccount();
        try {
            a.credit(1000);
        } catch (InvalidAmountException e) {
            System.out.println(e);
        }
        System.out.println("Balance: " + a.balance());
        try {
            a.credit(-100);
        } catch (InvalidAmountException e) {
            System.out.println(e);
        }
        System.out.println("Balance: " + a.balance());
        try {
            a.debit(2000);
        } catch (InvalidAmountException e) {
            System.out.println(e);
        } catch (InvalidBalanceException e) {
            System.out.println(e);
        }
        System.out.println("Balance: " + a.balance());
        try {
            a.debit(200);
        } catch (InvalidAmountException e) {
            System.out.println(e);
        } catch (InvalidBalanceException e) {
            System.out.println(e);
        }
        System.out.println("Balance: " + a.balance());
        try {
            a.debit(-200);
        } catch (InvalidAmountException e) {
            System.out.println(e);
        } catch (InvalidBalanceException e) {
            System.out.println(e);
        }
        System.out.println("Balance: " + a.balance());
    }
}

/* Output of the main method:
Credit Request: 1000.0
Balance: 1000.0
Credit Request: -100.0
The given amount can’t be negative: -100.0
Balance: 1000.0
Debit Request: 2000.0
The account balance can’t be less than zero: -1000.0
Balance: 1000.0
Debit Request: 200.0
Balance: 800.0
Debit Request: -200.0
The given amount can’t be negative: -200.0
Balance: 800.0
*/
