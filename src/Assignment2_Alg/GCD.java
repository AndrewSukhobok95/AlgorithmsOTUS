package Assignment2_Alg;

import AlgTesting.ITask;

import java.math.BigInteger;

public class GCD implements ITask {
    private GCDMethod method;
    private enum GCDMethod {
        EUCLID,
        BIT
    }
    private boolean methodContains(String method_name) {
        for (GCDMethod m : GCDMethod.values()) {
            if (m.name().equals(method_name)) return true;
        }
        return false;
    }

    public GCD() {
        this.method = GCDMethod.EUCLID;
    }

    public GCD(String method) {
        if (methodContains(method))
            this.method = GCDMethod.valueOf(method);
        else
            throw new IllegalArgumentException("Notexistent Method for GCD calculation.");
    }

    public BigInteger getGCD(BigInteger a, BigInteger b) {
        if (method.equals(GCDMethod.BIT))
            return getGCD_bit(a, b);
        return getGCD_Euclid(a, b);
    }

    public long getGCD(long a, long b) {
        if (method.equals(GCDMethod.BIT))
            return getGCD_bit(a, b);
        return getGCD_Euclid(a, b);
    }

    public static BigInteger getGCD_Euclid(BigInteger a, BigInteger b) {
        while (!a.equals(BigInteger.ZERO) && !b.equals(BigInteger.ZERO)) {
            if (a.compareTo(b)==1) {
                a = a.remainder(b);
            } else {
                b = b.remainder(a);
            }
        }
        return a.add(b);
    }

    public static long getGCD_Euclid(long a, long b) {
        while (a!=0 && b!=0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a + b;
    }

    public static BigInteger getGCD_bit(BigInteger a, BigInteger b) {
        BigInteger biTWO = BigInteger.valueOf(2);
        BigInteger mult2 = BigInteger.ONE;
        while (!a.equals(b)) {
            if (a.remainder(biTWO).equals(BigInteger.ZERO) &&
                    b.remainder(biTWO).equals(BigInteger.ZERO)) {
                a = a.divide(biTWO);
                b = b.divide(biTWO);
                mult2 = mult2.multiply(biTWO);
            } else if (!a.remainder(biTWO).equals(BigInteger.ZERO) &&
                    !b.remainder(biTWO).equals(BigInteger.ZERO)) {
                if (a.compareTo(b)==1)
                    a = a.subtract(b).divide(biTWO);
                else
                    b = b.subtract(a).divide(biTWO);
            } else {
                if (a.remainder(biTWO).equals(BigInteger.ZERO))
                    a = a.divide(biTWO);
                if (b.remainder(biTWO).equals(BigInteger.ZERO))
                    b = b.divide(biTWO);
            }
        }
        return mult2.multiply(a);
    }

    public static long getGCD_bit(long a, long b) {
        long mult2 = 1;
        while (a!=b) {
            if (a % 2 == 0 && b % 2 ==0) {
                a = a / 2;
                b = b / 2;
                mult2 = mult2 * 2;
            } else if (a % 2 != 0 && b % 2 != 0) {
                if (a > b)
                    a = (a - b) / 2;
                else
                    b = (b - a) / 2;
            } else {
                if (a % 2 == 0) a = a / 2;
                if (b % 2 == 0) b = b / 2;
            }
        }
        return mult2 * a;
    }


    @Override
    public String Run(String[] data) {
        BigInteger a = new BigInteger(data[0]);
        BigInteger b = new BigInteger(data[1]);
        BigInteger answer = getGCD(a, b);
        return String.format("%s", answer);
    }
}
