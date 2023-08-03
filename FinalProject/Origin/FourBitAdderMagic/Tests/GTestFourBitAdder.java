package FinalProject.Origin.FourBitAdderMagic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.FourBitAdder;

public class GTestFourBitAdder {

    @Test
    public void testFourBitAdder() {
        FourBitAdder fourBitAdder = new FourBitAdder();

        System.out.println("Four Bit Adder Truth Table:");
        System.out.println("+---------+---------+---------+---------+---------+");
        System.out.println("|   binA  |   binB  |   Sum   |  Carry  |  Expected |");
        System.out.println("+---------+---------+---------+---------+---------+");

        String[] inputBinA = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String[] inputBinB = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};

        int carryIn = 0;

        for (int i = 0; i < inputBinA.length; i++) {
            String binaryA = inputBinA[i];
            String binaryB = inputBinB[i];

            String sum = fourBitAdder.add(binaryA, binaryB, carryIn);
            int carryOut = Character.getNumericValue(sum.charAt(0));
            sum = sum.substring(1);

            int intA = Integer.parseInt(binaryA, 2);
            int intB = Integer.parseInt(binaryB, 2);
            int intSum = Integer.parseInt(sum, 2);
            int expectedSum = (intA + intB + carryIn) & 0xF; // Keep only 4 bits

            System.out.printf("|   %s   |   %s   |  %s  |    %d    |   %d + %d + %d   |\n",
                    binaryA, binaryB, sum, carryOut, intA, intB, carryIn);
            assertEquals(expectedSum, intSum);

            carryIn = carryOut; // Update carry-in for the next iteration
        }

        System.out.println("+---------+---------+---------+---------+---------+");
    }
}
