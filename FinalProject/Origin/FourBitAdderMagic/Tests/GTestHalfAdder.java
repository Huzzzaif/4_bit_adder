

package FinalProject.Origin.FourBitAdderMagic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.HalfAdder;

public class GTestHalfAdder {

    @Test
    public void testHalfAdderSum() {
        HalfAdder halfAdder = new HalfAdder();
    
        System.out.println("Half Adder Sum Truth Table:");
        System.out.println("+-------+-------+-------+---------+");
        System.out.println("|   A   |   B   | Carry |  Sum    |");
        System.out.println("+-------+-------+-------+---------+");
    
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                halfAdder.connectGates(a,b);
    
                // Set carry-in based on current input values
                halfAdder.carryIn(a & b);
    
                int sum = halfAdder.getSum(a, b);
                int carryOut = halfAdder.getCarryOut(a,b);
    
                System.out.printf("|   %d   |   %d   |   %d   |    %d    |\n", a, b, carryOut, sum);
                assertEquals(a ^ b, sum); // Half adder sum using only NAND, OR, and AND gates
            }
        }
        System.out.println("+-------+-------+-------+---------+");
    }
    

}
