package Assignment0_Recursion;

import AlgTesting.ITask;

public class StringLength implements ITask {
    @Override
    public String Run(String[] data) {
        return String.format("%s", data[0].length());
    }
}
