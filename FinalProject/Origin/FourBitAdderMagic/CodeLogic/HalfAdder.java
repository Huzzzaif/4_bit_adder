package FinalProject.Origin.FourBitAdderMagic.CodeLogic;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.AbstractGateClass.LogicGates;

public class HalfAdder {
    private LogicGates.AND andGate;
    private LogicGates.OR orGate;
    private LogicGates.NAND nandGate1;
    private LogicGates.NAND nandGate2;

    public HalfAdder() {
        andGate = new LogicGates.AND(1);
        orGate = new LogicGates.OR(1);
        nandGate1 = new LogicGates.NAND(1);
        nandGate2 = new LogicGates.NAND(2);
    }

    public void connectGates(int a , int b) {
        // Calculate A' and B' using NAND gates
        int aNot = nandGate1.out();
        nandGate1.setIn1(a);
        nandGate1.setIn2(a);
        int bNot = nandGate2.out();
        nandGate2.setIn1(b);
        nandGate2.setIn2(b);
    
        // Calculate the output of the first AND gate (A' AND B)
        int and1 = andGate.out();
        andGate.setIn1(aNot);
        andGate.setIn2(b);
    
        // Calculate the output of the second AND gate (A AND B')
        int and2 = andGate.out();
        andGate.setIn1(a);
        andGate.setIn2(bNot);
    
        // Calculate the output of the NAND gate (A' AND B) NAND (A AND B')
        int carryOut = nandGate1.out();
        nandGate1.setIn1(and1);
        nandGate1.setIn2(and2);
    
        // Set the carry value for the Half Adder
        andGate.setIn1(carryOut); // Connect carry to AND gate input A
        andGate.setIn2(carryOut); // Connect carry to AND gate input B
    }
    
    

    public int getSum(int a, int b) {
        // Calculate A' and B' using NAND gates
        nandGate1.setIn1(a);
        nandGate1.setIn2(a);
        int aNot = nandGate1.out();
    
        nandGate2.setIn1(b);
        nandGate2.setIn2(b);
        int bNot = nandGate2.out();
    
        // Calculate the first AND gate
        andGate.setIn1(aNot);
        andGate.setIn2(b);
        int and1 = andGate.out();
    
        // Calculate the second AND gate
        andGate.setIn1(a);
        andGate.setIn2(bNot);
        int and2 = andGate.out();
    
        // Calculate the final OR gate
        orGate.setIn1(and1);
        orGate.setIn2(and2);
    
        return orGate.out();
    }
    

    public int getCarryOut(int a, int b) {
        andGate.setIn1(a);
        andGate.setIn2(b);
    
        return andGate.out(); // Return the output of the AND gate
    }
    
    
    public void carryIn(int carry) {
        nandGate1.setIn1(carry);
    }

    // public static void main(String[] args) {
    //     HalfAdder halfAdder = new HalfAdder();

    //     int a = 1;
    //     int b = 1;

    //     halfAdder.connectGates();
    //     int sum = halfAdder.getSum(a, b);
    //     int carryOut = halfAdder.getCarryOut();

    //     System.out.println("Input A: " + a);
    //     System.out.println("Input B: " + b);
    //     System.out.println("Sum: " + sum);
    //     System.out.println("Carry Out: " + carryOut);
    // }
}
