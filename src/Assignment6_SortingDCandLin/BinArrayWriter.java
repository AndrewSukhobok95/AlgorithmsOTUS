package Assignment6_SortingDCandLin;

import java.io.*;

public class BinArrayWriter {
    private String filePath;
    private BufferedOutputStream writer;
    private boolean wasOpened = false;

    public BinArrayWriter(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        toFileStart();
    }

    public void toFileStart() throws FileNotFoundException {
        if (wasOpened) close();
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        this.writer = new BufferedOutputStream(fos);
        wasOpened = true;
    }

    public void addShortValue(short value) {
        try {
            writer.write(ByteShortConverter.shortToBytes(value));
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
