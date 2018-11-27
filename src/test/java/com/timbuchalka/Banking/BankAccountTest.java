package com.timbuchalka.Banking;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private double expectedBalance;
    private BankAccount account;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases");
    }

    @Before
    public void setUp() {
        System.out.println("Test is running...");
        expectedBalance = Math.random()*1000;
        System.out.printf("initialBalance=%.2f\n", expectedBalance);
        account = new BankAccount("Tim", "Buchalka", expectedBalance, BankAccount.CHECKING);
    }
    @Test
    public void getBalance() {
        assertEquals(expectedBalance, account.getBalance(), 0.1);
    }

    @Test
    public void deposit() {
        double increaseBalance = Math.random()*200;
        System.out.printf("increaseBalance=%.2f\n", increaseBalance);
        double accountBalance = account.deposit(increaseBalance, true);
        System.out.printf("accountBalance=%.2f\n", accountBalance);
        expectedBalance += increaseBalance;
        System.out.printf("expectedBalance=%.2f\n", expectedBalance);
        assertEquals(expectedBalance, accountBalance, 0.1);
    }

    @Test
    public void withdraw_branch() throws IllegalArgumentException {
        double decreaseBalance = Math.random()*300;
        System.out.printf("decreaseBalance=%.2f\n", decreaseBalance);
        double accountBalance = account.withdraw(decreaseBalance, true);
        System.out.printf("accountBalance=%.2f\n", accountBalance);
        expectedBalance -= decreaseBalance;
        System.out.printf("expectedBalance=%.2f\n", expectedBalance);
        assertEquals(expectedBalance, accountBalance, 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        double decreaseBalance = 500 + Math.random()*100;
        account.withdraw(decreaseBalance, false);
    }

    @Test
    public void isChecking() {
        assertTrue(account.isChecking());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases");
    }
}