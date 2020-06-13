package Assignment6_SortingDCandLin;

import java.io.*;

public class SortBinFile {
    private String filePath;
    private BinArrayReader reader;
    private BinArrayWriter writer;
    private String TMP_FILES_PATH = "./tmp/";
    private File tmpDir = new File(TMP_FILES_PATH);

    public SortBinFile(String filePath) throws FileNotFoundException {
        reader = new BinArrayReader(filePath);
        writer = new BinArrayWriter(filePath);
    }

    public void RadixSort() throws IOException {
        createTmpDir();
        short maxValue = findMax();
//        for (int div = 1; maxValue / div > 0; div *= 10) {
//            reader.toFileStart();
//            countSort(div);
//        }

        reader.toFileStart();
        System.out.println(reader.getNextShort());
        countSort(1);
        //deleteTmpDir();
    }

    private short findMax() throws IOException {
        short maxV = 0;
        short val;
        while ((val = reader.getNextShort())!=-1) {
            if (val > maxV) {
                maxV = val;
            }
        }
        return maxV;
    }

    private void countSort(int div) throws IOException {
        int[] countArr = {0,0,0,0,0,0,0,0,0,0};

        short current;
        while (true) {
            current = reader.getNextShort();
            if (current == -1) break;
            countArr[(current / div) % 10]++;
        }

        distributeToTmp(countArr, div);
    }

    private void distributeToTmp(int[] countArr, int div) throws IOException {
        BinArrayWriter[] tmpWriters = new BinArrayWriter[10];

        for (int i=0; i<10; i++)
            tmpWriters[i] = new BinArrayWriter(TMP_FILES_PATH + "tmpArray_" + i + ".dat");

        short current = 0;
        while (current != -1) {
            current = reader.getNextShort();
            int divr = (current / div) % 10;
            tmpWriters[divr].addShortValue(current);
            countArr[divr]--;
        }

        for (int i=0; i<10; i++) {
            tmpWriters[i].close();
            BinArrayReader curTmpReader = new BinArrayReader(TMP_FILES_PATH + "tmpArray_" + i + ".dat");
            short value;
            while ((value = curTmpReader.getNextShort())!=-1) {
                writer.addShortValue(value);
            }
            curTmpReader.close();
        }
    }

    private void createTmpDir() {
        if (!tmpDir.exists()){
            tmpDir.mkdirs();
        }
    }

    private void deleteTmpDir() {
        deleteDirRecursively(tmpDir);
    }

    private boolean deleteDirRecursively(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirRecursively(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

}
