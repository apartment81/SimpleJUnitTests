package ro.mirodone;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;

    public static final int  CHECKING =1;
    public static final int  SAVINGS =2;

    private int accountType;


    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType=typeOfAccount;
    }

    //The branch argument is true, if the customer performs transaction with a teller
    //It is false, if the customer is performing transaction at an ATM

    public double deposit ( double amount, boolean branch){
        balance += amount;
        return balance;
    }

    public double withdraw ( double amount, boolean branch){
        if((amount > 500) && !branch){
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking () {
        return accountType == CHECKING;
    }
}
