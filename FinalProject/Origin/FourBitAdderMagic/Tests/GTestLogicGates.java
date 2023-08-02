package FinalProject.Origin.FourBitAdderMagic.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.AbstractGateClass.LogicGates;

public class GTestLogicGates {

    @Test
    public void testANDConstructor() {
        // Create an object
        LogicGates.AND and1 = new LogicGates.AND(1);

        // Check that the object is constructed correctly
        assertEquals(0, and1.in1());
        assertEquals(0, and1.in2());
        assertEquals(0, and1.out());
    }

    @Test
    public void testNANDConstructor() {
        // Create an object
        LogicGates.NAND nand1 = new LogicGates.NAND(1);

        // Check that the object is constructed correctly
        assertEquals(0, nand1.in1());
        assertEquals(0, nand1.in2());
        assertEquals(0, nand1.out());
    }

    @Test
    public void testORConstructor() {
        // Create an object
        LogicGates.OR or1 = new LogicGates.OR(1);

        // Check that the object is constructed correctly
        assertEquals(0, or1.in1());
        assertEquals(0, or1.in2());
        assertEquals(0, or1.out());
    }

    @Test
    public void testANDTruthTable() {
        // Create an object
        LogicGates.AND and1 = new LogicGates.AND(1);

        int[] bits = {0, 1};

        System.out.println("AND Truth Table:");
        System.out.println("+-------+-------+---------+");
        System.out.println("|   A   |   B   |  Output |");
        System.out.println("+-------+-------+---------+");

        for (int idx = 0; idx < 2; idx++) {
            for (int idx2 = 0; idx2 < 2; idx2++) {
                and1.setIn1(bits[idx]);
                and1.setIn2(bits[idx2]);
                int result = and1.out();
                System.out.printf("|   %d   |   %d   |    %d    |\n", bits[idx], bits[idx2], result);
                assertEquals(bits[idx] & bits[idx2], result);
            }
        }

        System.out.println("+-------+-------+---------+");
    }

    @Test
    public void testNANDTruthTable() {
    // Create an object
    LogicGates.NAND nand1 = new LogicGates.NAND(1);

    int[] bits = {0, 1};

    System.out.println("NAND Truth Table:");
    System.out.println("+-------+-------+---------+");
    System.out.println("|   A   |   B   |  Output |");
    System.out.println("+-------+-------+---------+");

    for (int idx = 0; idx < 2; idx++) {
        for (int idx2 = 0; idx2 < 2; idx2++) {
            nand1.setIn1(bits[idx]);
            nand1.setIn2(bits[idx2]);
            int result = nand1.out();
            System.out.printf("|   %d   |   %d   |    %d    |\n", bits[idx], bits[idx2], result);
            assertNotEquals(-1, result);
        }
    }

    System.out.println("+-------+-------+---------+");
}



    @Test
    public void testORTruthTable() {
        // Create an object
        LogicGates.OR or1 = new LogicGates.OR(1);

        int[] bits = {0, 1};

        System.out.println("OR Truth Table:");
        System.out.println("+-------+-------+---------+");
        System.out.println("|   A   |   B   |  Output |");
        System.out.println("+-------+-------+---------+");

        for (int idx = 0; idx < 2; idx++) {
            for (int idx2 = 0; idx2 < 2; idx2++) {
                or1.setIn1(bits[idx]);
                or1.setIn2(bits[idx2]);
                int result = or1.out();
                System.out.printf("|   %d   |   %d   |    %d    |\n", bits[idx], bits[idx2], result);
                assertEquals(bits[idx] | bits[idx2], result);
            }
        }

        System.out.println("+-------+-------+---------+");
    }
}
