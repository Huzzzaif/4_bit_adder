public class LogicGates {

    public static abstract class AbstractGate {
        protected int mUsiIn1;
        protected int mUsiIn2;
        protected int mUsiOut;

        public AbstractGate() {
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

    public static class AND extends AbstractGate {
        private String mStrID;

        public AND(int id) {
            mStrID = id + "AND";
        }

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
            if (mUsiIn1 != 0 && mUsiIn2 != 0) {
                mUsiOut = 1;
            } else {
                mUsiOut = 0;
            }
        }

        public String repr() {
            String rp = super.repr();
            return "id: " + mStrID + "\n\t" + rp;
        }
    }

    public static class NAND extends AbstractGate {
        private String mStrID;

        public NAND(int id) {
            mStrID = id + "NAND";
        }

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
            if (mUsiIn1 != 0 && mUsiIn2 != 0) {
                mUsiOut = 0;
            } else {
                mUsiOut = 1;
            }
        }

        public String repr() {
            String rp = super.repr();
            return "id: " + mStrID + "\n\t" + rp;
        }
    }

    public static class OR extends AbstractGate {
        private String mStrID;

        public OR(int id) {
            mStrID = id + "OR";
        }

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
            if (mUsiIn1 != 0 || mUsiIn2 != 0) {
                mUsiOut = 1;
            } else {
                mUsiOut = 0;
            }
        }

        public String repr() {
            String rp = super.repr();
            return "id: " + mStrID + "\n\t" + rp;
        }
    }
}
