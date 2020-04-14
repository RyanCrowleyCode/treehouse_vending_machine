package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditorTest {

    private Creditor creditor;

    @Before
    public void setUp() throws Exception {
        creditor = new Creditor();
    }

    @Test
    public void addingFundsIncrementsAvailableFunds() throws Exception {
        /*
            * Arrange things, getting objects in state you need to test.
            * We were creating a new creditor object, but that will be handled
            * with the @Before method setUp() and private Creditor property.
            * Creditor creditor = new Creditor();
        */


        // Act by having your code do the method that you are testing
        creditor.addFunds(25);
        creditor.addFunds(25);

        // Assert that the code is behaving the way you expect.
        // assertEqual takes two arguments: (expectedResult, actualResult)
        assertEquals(50, creditor.getAvailableFunds());
    }

    @Test
    public void refundingReturnsAllAvailableFunds() throws Exception {
        // Arrange
        creditor.addFunds(10);

        // Act
        int refund = creditor.refund();

        // Assert
        assertEquals(10, refund);
    }

    @Test
    public void refundingResetsAvailableFundsToZero() throws Exception {
        // Arrange
        creditor.addFunds(10);

        // Act
        creditor.refund();

        // Assert
        assertEquals(0, creditor.getAvailableFunds());
    }
}