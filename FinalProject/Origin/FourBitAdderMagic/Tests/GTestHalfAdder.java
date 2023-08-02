package FinalProject.Origin.FourBitAdderMagic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.HalfAdder;

public class GTestHalfAdder {

    @Test
    public void testHalfAdderSum() {
        HalfAdder halfAdder = new HalfAdder();

        int a = 1;
        int b = 1;

        halfAdder.connectGates();
        int sum = halfAdder.getSum(a, b);

        assertEquals(0, sum); // Half adder sum of 1 and 1 should be 0
    }

    @Test
    public void testHalfAdderCarryOut() {
        HalfAdder halfAdder = new HalfAdder();

        int a = 1;
        int b = 1;

        halfAdder.connectGates();
        int carryOut = halfAdder.getCarryOut();

        assertEquals(1, carryOut); // Half adder carry-out of 1 and 1 should be 1
    }

    @Test
    public void testHalfAdderZeroInput() {
        HalfAdder halfAdder = new HalfAdder();

        int a = 0;
        int b = 0;

        halfAdder.connectGates();
        int sum = halfAdder.getSum(a, b);
        int carryOut = halfAdder.getCarryOut();

        assertEquals(0, sum); // Half adder sum of 0 and 0 should be 0
        assertEquals(0, carryOut); // Half adder carry-out of 0 and 0 should be 0
    }

    @Test
    public void testHalfAdderWithCarry() {
        HalfAdder halfAdder = new HalfAdder();

        int a = 1;
        int b = 1;

        halfAdder.connectGates();
        halfAdder.carryIn(1); // Set carry-in to 1
        int sum = halfAdder.getSum(a, b);
        int carryOut = halfAdder.getCarryOut();

        assertEquals(1, sum); // Half adder sum of 1 and 1 with carry-in 1 should be 1
        assertEquals(1, carryOut); // Half adder carry-out of 1 and 1 with carry-in 1 should be 1
    }
}
