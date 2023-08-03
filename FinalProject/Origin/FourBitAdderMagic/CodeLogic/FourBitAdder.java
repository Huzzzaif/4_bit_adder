package FinalProject.Origin.FourBitAdderMagic.CodeLogic;

public class FourBitAdder {
    private FullAdder[] fullAdders;

    public FourBitAdder() {
        fullAdders = new FullAdder[4];
        for (int i = 0; i < 4; i++) {
            fullAdders[i] = new FullAdder();
        }

        connectAdders();
    }

    private void connectAdders() {
        int carryIn = 0;
        for (int i = 0; i < 4; i++) {
            fullAdders[i].connectGates(0, 0, carryIn);
            carryIn = fullAdders[i].getCarryOut(0, 0, carryIn);
        }
    }

    public String add(String binaryA, String binaryB, int carry) {
        StringBuilder result = new StringBuilder();
        //int carry = 0;

        for (int i = binaryA.length() - 1; i >= 0; i--) {
            int bitA = Character.getNumericValue(binaryA.charAt(i));
            int bitB = Character.getNumericValue(binaryB.charAt(i));

            int sum = fullAdders[i].getSum(bitA, bitB, carry);
            carry = fullAdders[i].getCarryOut(bitA, bitB, carry);

            result.insert(0, sum);
        }

        result.insert(0, carry);

        // Extend the result to 5 bits if needed
        while (result.length() < 5) {
            result.insert(0, "0");
        }

        return result.toString();
    }

    // ... rest of the class remains the same ...




    public static void main(String[] args) {
        FourBitAdder fourBitAdder = new FourBitAdder();

        String binaryA = "1000";
        String binaryB = "1000";

        // Ensure that binaryA and binaryB are of equal length
        while (binaryA.length() < 4) {
            binaryA = "0" + binaryA;
        }
        while (binaryB.length() < 4) {
            binaryB = "0" + binaryB;
        }

        String sum = fourBitAdder.add(binaryA, binaryB, 0);

        System.out.println("Input A: " + binaryA);
        System.out.println("Input B: " + binaryB);
        System.out.println("Sum: " + sum);
    }
}
