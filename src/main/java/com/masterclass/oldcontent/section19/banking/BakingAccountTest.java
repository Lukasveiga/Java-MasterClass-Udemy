package com.masterclass.oldcontent.section19.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BakingAccountTest {

    private BakingAccount accountTest;

    @BeforeEach
    void setup(){
        accountTest = new BakingAccount("FirstTestName", "LastTestName");
    }

    @Test
    void deposit200ShouldReturnTrue() {
        assertTrue(accountTest.deposit(200));
        assertEquals(200, accountTest.getBalance(), 0);
    }

    @Test
    void depositNegativeShouldReturnFalse() {
        assertFalse(accountTest.deposit(-200));
    }

    @Test
    void withdraw200ShouldReturnTrue() {
        accountTest.deposit(200);
        assertTrue(accountTest.withdraw(200, false));
        assertEquals(0, accountTest.getBalance(), 0);
    }

    @Test
    void withdraw400ShouldReturnFalse() {
        assertFalse(accountTest.withdraw(400, false));

    }

    @Test
    void withdrawNegativeShouldReturnFalse() {
        assertFalse(accountTest.withdraw(-400, false));
    }

    @Test
     void withdrawAfterMidnightException(){
        accountTest.deposit(200);
        assertThrows(IllegalArgumentException.class, () -> {accountTest.withdraw(200, true);});
    }

    @Test
    void getBalance() {
        assertEquals(0, accountTest.getBalance());
    }

    @Test
    void getFirstName(){
        assertEquals("FirstTestName", accountTest.getFirstName());
    }

    @Test
    void getLastName(){
        assertEquals("LastTestName", accountTest.getLastName());
    }


}