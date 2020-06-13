package Assignment6_SortingDCandLin;

import java.io.File;

public class TestSortBinFile {
    public static void main(String[] args) {
        String path = "/home/andrey/IdeaProjects/AlgorithmsOTUS/data/6_sort/short_array.dat";
        int N = 6;

        BinArrGenerator.writeToFile(N, path, true);

        try {
            BinArrayReader bar = new BinArrayReader(path);
            System.out.print("Read Array:    ");
            for (int i = 0; i < N; i++)
                System.out.print(bar.getNextShort() + " ");
            bar.close();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            SortBinFile sbf = new SortBinFile(path);
            sbf.RadixSort();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


//        File directory = new File("./tmp/");
//        if (!directory.exists()){
//            directory.mkdirs();
//        }
//
//        try {
//            BinArrayReader bar = new BinArrayReader(path);
//            System.out.print("Read Array:    ");
//            for (int i = 0; i < N; i++)
//                System.out.print(bar.getNextShort() + " ");
//            System.out.println();
//            bar.toFileStart();
//
//            BinArrayWriter baw = new BinArrayWriter("./tmp/tmp.dat");
//            for (int i = 0; i < N; i++)
//                baw.addShortValue(bar.getNextShort());
//            baw.close();
//
//            bar.close();
//
//            bar = new BinArrayReader("./tmp/tmp.dat");
//            System.out.print("Read Copy:     ");
//            for (int i = 0; i < N; i++)
//                System.out.print(bar.getNextShort() + " ");
//            System.out.println();
//            bar.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        deleteDirectory(directory);
    }

    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
