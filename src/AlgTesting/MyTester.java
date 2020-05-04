package AlgTesting;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MyTester {
    private ITask task;
    private String dirPath;

    public MyTester(ITask task, String dirPath) {
        this.task = task;
        this.dirPath = dirPath;
    }

    public void RunTests() {
        int n = 0;
        while(true){
            Path inFilePath = Paths.get(dirPath + File.separator + String.format("test.%s.in", n));
            Path outFilePath = Paths.get(dirPath + File.separator + String.format("test.%s.out", n));
            if (!Files.exists(inFilePath) && !Files.exists(outFilePath)) {
                break;
            }
            System.out.println(String.format("+ Test %s - %s", n, RunTest(inFilePath, outFilePath)));
            n++;
        }
    }

    public boolean RunTest(Path inFilePath, Path outFilePath) {
        try {
            List<String> dataList = Files.readAllLines(inFilePath);
            String[] data = dataList.toArray(new String[0]);
            String actual = task.Run(data);

            BufferedReader outReader = Files.newBufferedReader(outFilePath);
            String expect = outReader.readLine().trim();
            if (outReader.readLine() != null) {
                System.out.println("+ WARNING: more lines in .out file!");
            }
            outReader.close();

            return actual.equals(expect);
        } catch (Exception e) {
            System.out.println("+ Error!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean RunTest(String inFilePathStr, String outFilePathStr) {
        Path inFilePath = Paths.get(inFilePathStr);
        Path outFilePath = Paths.get(outFilePathStr);
        return RunTest(inFilePath, outFilePath);
    }
}
