package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
    private VendingMachine machine;

    public class NotifierSub implements Notifier {

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        // Arrange
        Notifier notifier = new NotifierSub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "Twinkies", 10, 30, 75);
    }

    @Test
    public void vendingWhenStockedReturnsItem() throws Exception {
        // Arrange
        machine.addMoney(75);

        // Act
        Item item = machine.vend("A1");

        // Assert
        assertEquals("Twinkies", item.getName());
    }

    @Test
    public void successfulVendIncrementsRunningSalesTotal() throws Exception {
        // Arrange
        machine.addMoney(150);

        // Act
        machine.vend("A1");
        machine.vend("A1");

        // Assert
        assertEquals(150, machine.getRunningSalesTotal());
    }
}