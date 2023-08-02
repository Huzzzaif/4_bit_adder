package FinalProject.Origin.FourBitAdderMagic.Tests;

import static org.junit.Assert.assertEquals;

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
    public void testORTruthTable() {
        // Create an object
        LogicGates.OR or1 = new LogicGates.OR(1);

        int[] bits = {0, 1};

        for (int idx = 0; idx < 2; idx++) {
            for (int idx2 = 0; idx2 < 2; idx2++) {
                or1.setIn1(bits[idx]);
                or1.setIn2(bits[idx2]);
                assertEquals(bits[idx] | bits[idx2], or1.out());
            }
        }
    }
}
