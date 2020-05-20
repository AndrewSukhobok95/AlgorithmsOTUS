import Assignment1_Comb.FullAssignment1;
import Assignment2_Alg.FullAssignment2;
import Assignment2_Alg.GCD;
import Assignment2_Alg.PowAlg;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //FullAssignment1.run();
        //FullAssignment2.run();

        int capacity = 100;
        int vec_capacity = 10;
        int index = 25;

        int index_fa = index / vec_capacity;
        for (int i = capacity / vec_capacity - 1; i > index_fa; i--){
            System.out.println(i);
        }
    }
}
