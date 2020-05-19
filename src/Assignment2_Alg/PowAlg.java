package Assignment2_Alg;

import AlgTesting.ITask;

public class PowAlg  implements ITask {
    private powMethod method;
    private enum powMethod {
        SIMPLE,
        POWER_OF_TWO
    }

    public PowAlg() {
        this.method = powMethod.SIMPLE;
    }

    public PowAlg(String method) {
        if (methodContains(method))
            this.method = powMethod.valueOf(method);
        else
            throw new IllegalArgumentException("Notexistent Method for GCD calculation.");
    }

    private boolean methodContains(String method_name) {
        for (powMethod m : powMethod.values()) {
            if (m.name().equals(method_name)) return true;
        }
        return false;
    }

    public double pow(double base, long power) {
        if (method.equals(powMethod.POWER_OF_TWO))
            return powBy2(base, power);
        return powSimple(base, power);
    }

    public static double powSimple(double base, long power) {
        double res = 1;
        for (int i=0; i<power; i++){
            res = res * base;
        }
        return res;
    }

    public static double powBy2(double base, long power) {
        double res = 1;
        while (power > 1) {
            if (power % 2 == 1)
                res = res * base;
            base = base * base;
            power = power / 2;
        }
        if (power > 0) res = res * base;
        return res;
    }

    @Override
    public String Run(String[] data) {
        double a = Double.parseDouble(data[0]);
        long b = Long.parseLong(data[1]);
        double answer = pow(a, b);
        return String.format("%.11f", answer).replace(",", ".");
    }
}
