public class FullAdder {
    private HalfAdder halfAdder1;
    private HalfAdder halfAdder2;
    private LogicGates.OR orGate;

    public FullAdder() {
        halfAdder1 = new HalfAdder();
        halfAdder2 = new HalfAdder();
        orGate = new LogicGates.OR(1);

        connectAdder();
    }

    private void connectAdder() {
        halfAdder1.connectGates();
        halfAdder2.connectGates();
        orGate.setIn1(halfAdder2.getCarryOut());
        orGate.setIn2(halfAdder1.getCarryOut());
    }

    public int getSum(int a, int b, int carryIn) {
        int sum1 = halfAdder1.getSum(a, b);
        int sum2 = halfAdder2.getSum(sum1, carryIn);

        return sum2;
    }

    public int getCarryOut() {
        return orGate.out();
    }

    public void carryIn(int carry) {
        halfAdder1.carryIn(carry);
    }

    public static void main(String[] args) {
        FullAdder fullAdder = new FullAdder();

        int a = 1;
        int b = 1;
        int carryIn = 1;

        int sum = fullAdder.getSum(a, b, carryIn);
        int carryOut = fullAdder.getCarryOut();

        System.out.println("Input A: " + a);
        System.out.println("Input B: " + b);
        System.out.println("Carry In: " + carryIn);
        System.out.println("Sum: " + sum);
        System.out.println("Carry Out: " + carryOut);
    }

    public void connectGates() {
    }
}
