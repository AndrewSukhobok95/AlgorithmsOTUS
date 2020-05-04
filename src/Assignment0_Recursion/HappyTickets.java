package Assignment0_Recursion;

import AlgTesting.ITask;

public class HappyTickets implements ITask {
    @Override
    public String Run(String[] data) {
        int N = Integer.parseInt(data[0]);
        int answer = solveWithRecursion(N);
        return String.format("%s", answer);
    }

    public static int solveWithRecursion(int N){
        int n_lucky = 0;
        for (int s=0; s<=9*N; s++){
            n_lucky += Nsn(s, N) * Nsn(s, N);
        }
        return n_lucky;
    }

    public static long Nsn(long s, int n){
        if (s==0 && n==0){
            return 1;
        }
        else if (s!=0 && n==0){
            return 0;
        } else {
            long new_s = 0;
            for (int i=0; i<10; i++){
                new_s += Nsn(s-i, n-1);
            }
            return new_s;
        }
    }
}
