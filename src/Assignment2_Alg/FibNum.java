package Assignment2_Alg;

import AlgTesting.ITask;
import Assignment2_Alg.fibNumUtils.Matrix2D;

public class FibNum implements ITask {
    private static final Matrix2D mIDENTITY = new Matrix2D(1,0,1,0);
    private static final Matrix2D mBASE = new Matrix2D(1,1,1,0);

    public static int fibByMM(int input) {
        if (input == 0) return 0;
        Matrix2D res = mIDENTITY; // 1-0-1-0
        Matrix2D base = mBASE;    // 1-1-1-0
        while (input > 1) {
            if ((input & 1) == 1)
                res = res.multiply(base);
            base = base.multiply(base);
            input >>= 1;
        }
        res = res.multiply(base);
        return res.x12;
    }

    @Override
    public String Run(String[] data) {
        int N = Integer.parseInt(data[0]);
        int answer = fibByMM(N);
        return String.format("%s", answer);
    }
}
