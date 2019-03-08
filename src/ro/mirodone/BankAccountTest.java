package ro.mirodone;


import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class BankAccountTest {


    private BankAccount account;
    private static int count;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @Before
    public void setup(){
        account = new BankAccount("john", "doe", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test... ");
    }

    @Test
    public void deposit() {
        //BankAccount account = new BankAccount("john", "doe", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        double balance = account.withdraw(600.00, false);
        assertEquals(400.00, balance, 0);
    }


// for older versions of jUnit
 /*   @Test
    public void withdraw_notBranch() {
         try {
             account.withdraw(600.00, true);
         }catch (IllegalArgumentException e){
             fail(" Should throw an IllegalArgumentException");
         }
    }*/


    @Test
    public void getBalance_deposit() {
        //BankAccount account = new BankAccount("john", "doe", 1000.00, BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
       // BankAccount account = new BankAccount("john", "doe", 1000.00, BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }
    @Test
    public void isChecking_true(){
        //BankAccount account = new BankAccount("john", "doe", 1000.00, BankAccount.CHECKING);
        assertTrue("The account is not checking account", account.isChecking());
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @After
    public void teardown (){
        System.out.println("Count = " + count++);
    }
}