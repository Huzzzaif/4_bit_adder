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

    public void connectGates() {
        nandGate1.setIn1(0);
        nandGate1.setIn2(0);

        nandGate2.setIn1(1);
        nandGate2.setIn2(1);

        andGate.setIn1(nandGate1.out());
        andGate.setIn2(nandGate2.out());

        orGate.setIn1(nandGate1.out());
        orGate.setIn2(nandGate2.out());
    }

    public int getSum(int a, int b) {
        nandGate1.setIn1(a);
        nandGate1.setIn2(b);

        nandGate2.setIn1(a);
        nandGate2.setIn2(b);

        return andGate.out();
    }

    public int getCarryOut() {
        return orGate.out();
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
