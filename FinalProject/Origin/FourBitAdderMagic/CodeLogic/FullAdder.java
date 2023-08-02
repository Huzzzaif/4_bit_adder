package FinalProject.Origin.FourBitAdderMagic.CodeLogic;

import FinalProject.Origin.FourBitAdderMagic.CodeLogic.AbstractGateClass.LogicGates;

public class FullAdder {
    private HalfAdder halfAdder1;
    private HalfAdder halfAdder2;
    private LogicGates.OR orGate;

    public FullAdder() {
        halfAdder1 = new HalfAdder();
        halfAdder2 = new HalfAdder();
        orGate = new LogicGates.OR(1);

        connectAdder(0, 0, 0); // Default connection
    }

    private void connectAdder(int a, int b, int c) {
        halfAdder1.connectGates(a, b);
        halfAdder2.connectGates(halfAdder1.getSum(a, b), c);
        orGate.setIn1(halfAdder2.getCarryOut(a, b));
        orGate.setIn2(halfAdder1.getCarryOut(a, b));
    }

    public int getSum(int a, int b, int carryIn) {
        int sum1 = halfAdder1.getSum(a, b);
        int sum2 = halfAdder2.getSum(sum1, carryIn);

        return sum2;
    }

    public int getCarryOut(int a, int b, int carryIn) {
        connectAdder(a, b, carryIn); // Update the connections based on input
        return orGate.out();
    }

    public void carryIn(int carry) {
        halfAdder1.carryIn(carry);
    }

    // public static void main(String[] args) {
    //     FullAdder fullAdder = new FullAdder();

    //     int a = 1;
    //     int b = 1;
    //     int carryIn = 1;

    //     int sum = fullAdder.getSum(a, b, carryIn);
    //     int carryOut = fullAdder.getCarryOut(a, b, carryIn);

    //     System.out.println("Input A: " + a);
    //     System.out.println("Input B: " + b);
    //     System.out.println("Carry In: " + carryIn);
    //     System.out.println("Sum: " + sum);
    //     System.out.println("Carry Out: " + carryOut);
    // }

    public void connectGates(int a, int b, int c) {
        connectAdder(a, b, c);
    }
}
