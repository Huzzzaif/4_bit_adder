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
            for (int i = 0; i < 3; i++) {
            fullAdders[i].connectGates();
                fullAdders[i + 1].carryIn(fullAdders[i].getCarryOut());
            }
        }

        public String add(String binaryA, String binaryB) {
            StringBuilder result = new StringBuilder();
            int carry = 0;

            for (int i = binaryA.length() - 1; i >= 0; i--) {
                int bitA = Character.getNumericValue(binaryA.charAt(i));
                int bitB = Character.getNumericValue(binaryB.charAt(i));

                int sum = fullAdders[i].getSum(bitA, bitB, carry);
                carry = fullAdders[i].getCarryOut();

                result.insert(0, sum);
            }

            result.insert(0, carry);

            return result.toString();
        }

        public static void main(String[] args) {
            FourBitAdder fourBitAdder = new FourBitAdder();

            String binaryA = "1010";
            String binaryB = "1101";

            // Ensure that binaryA and binaryB are of equal length
            while (binaryA.length() < 4) {
                binaryA = "0" + binaryA;
            }
            while (binaryB.length() < 4) {
                binaryB = "0" + binaryB;
            }

            String sum = fourBitAdder.add(binaryA, binaryB);

            System.out.println("Input A: " + binaryA);
            System.out.println("Input B: " + binaryB);
            System.out.println("Sum: " + sum);
        }
    }
