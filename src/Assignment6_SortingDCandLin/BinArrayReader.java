package Assignment6_SortingDCandLin;

import java.io.*;

public class BinArrayReader {
    private String filePath;
    private BufferedInputStream reader;
    private boolean wasOpened = false;

    public BinArrayReader(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        toFileStart();
    }

    public void toFileStart() throws FileNotFoundException {
        if (wasOpened) close();
        FileInputStream fis = new FileInputStream(new File(this.filePath));
        this.reader = new BufferedInputStream(fis);
        wasOpened = true;
    }

    public short getNextShort() throws IOException {
        byte[] b = new byte[2];

        for (int i=0; i<2; i++) {
            int read = reader.read();
            if (read == -1) {
                return -1;
            }
            b[i] = (byte) read;
        }
        return ByteShortConverter.bytesToShort(b);
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
