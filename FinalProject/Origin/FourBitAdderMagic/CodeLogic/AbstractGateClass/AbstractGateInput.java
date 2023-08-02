package FinalProject.Origin.FourBitAdderMagic.CodeLogic.AbstractGateClass;

public abstract class AbstractGateInput {
    protected int mUsiIn1;
    protected int mUsiIn2;
    protected int mUsiOut;

    public AbstractGateInput() {
        mUsiIn1 = 0;
        mUsiIn2 = 0;
        mUsiOut = 0;
    }

    public abstract int out();
    public abstract int in1();
    public abstract int in2();

    public void setIn1(int val) {
        mUsiIn1 = val;
        update();
    }

    public void setIn2(int val) {
        mUsiIn2 = val;
        update();
    }

    protected abstract void update();
    protected String repr() {
        return "in1: " + mUsiIn1 + "\n\tin2: " + mUsiIn2 + "\n\t\tout: " + mUsiOut;
    }
}
