package FinalProject.Origin.FourBitAdderMagic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.FullAdder;

public class GTestFullAdder {

    @Test
    public void testFullAdderSum() {
        FullAdder fullAdder = new FullAdder();

        System.out.println("Full Adder Sum Truth Table:");
        System.out.println("+-------+-------+-------+-------+---------+");
        System.out.println("|   A   |   B   | Carry |  Sum  | Carry   |");
        System.out.println("+-------+-------+-------+-------+---------+");

        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    fullAdder.connectGates(a, b, c);

                    int sum = fullAdder.getSum(a, b, c);
                    int carryOut = fullAdder.getCarryOut(a, b, c);

                    System.out.printf("|   %d   |   %d   |   %d   |    %d  |    %d    |\n", a, b, c, carryOut, sum);
                    assertEquals((a ^ b) ^ c, sum); // Full adder sum using only NAND, OR, and AND gates
                }
            }
        }
        System.out.println("+-------+-------+-------+-------+---------+");
    }

}
