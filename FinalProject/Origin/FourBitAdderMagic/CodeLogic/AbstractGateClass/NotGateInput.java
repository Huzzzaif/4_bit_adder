package FinalProject.Origin.FourBitAdderMagic.CodeLogic.AbstractGateClass;

public class NotGateInput extends AbstractGateInput {
    @Override
    public int out() {
        return mUsiOut;
    }

    @Override
    public int in1() {
        return mUsiIn1;
    }

    @Override
    public int in2() {
        return mUsiIn2;
    }

    @Override
    protected void update() {
        mUsiOut = ~mUsiIn1 & 0x1; // Using NAND gate to implement NOT
    }
}
