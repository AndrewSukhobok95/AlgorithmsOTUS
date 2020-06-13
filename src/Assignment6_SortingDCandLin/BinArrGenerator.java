package Assignment6_SortingDCandLin;

import java.io.*;
import java.util.Random;

public class BinArrGenerator {
    public static void writeToFile(int N, String filePath, boolean verbose) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            BufferedOutputStream writer = new BufferedOutputStream(fos);

            if (verbose) System.out.print("Written Array: ");

            Random random = new Random();
            for (int i = 0; i < N; i++) {
                short sval = (short) random.nextInt(Short.MAX_VALUE);

                if (verbose) System.out.print(sval + " ");

                writer.write(ByteShortConverter.shortToBytes(sval));

                if (i % 100 == 0) writer.flush();
            }
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (verbose) System.out.println();
    }
}
