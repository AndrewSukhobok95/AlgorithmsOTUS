package Assignment1_Comb;

import java.io.FileWriter;
import java.io.IOException;

public class SquarePattern {

    public static String getSquarePattern(int p){
        String squarePic = "";
        if (p>12 || p<1){
            System.out.println("+ Warning: There are 12 patterns (from 1 to 12)");
        }
        for (int y = 0; y < 25; y++) {
            for (int x = 0; x < 25; x++) {
                squarePic += pattern(p, x, y);
            }
            squarePic += System.getProperty("line.separator");
        }
        squarePic += System.getProperty("line.separator");
        return squarePic;
    }

    public static void printSquarePattern(int p){
        String squarePic = getSquarePattern(p);
        System.out.println(squarePic);
    }

    public static void writeSquarePatternToFile(int p, String fPath){
        try {
            FileWriter fw = new FileWriter(fPath, true);
            fw.write(String.format("Pattern %s:" + System.getProperty("line.separator"), p));
            fw.write(getSquarePattern(p));
            fw.close();
            System.out.println(String.format("+ Successfully wrote pattern %s to the file.", p));
        } catch (IOException e) {
            System.out.println("+ Error:");
            e.printStackTrace();
        }
    }

    private static String pattern(int p, int x, int y){
        String symbol;
        switch (p) {
            case 1:
                symbol = x > y ? "# " : ". ";
                break;
            case 2:
                symbol = x == y ? "# " : ". ";
                break;
            case 3:
                symbol = x == 24-y ? "# " : ". ";
                break;
            case 4:
                symbol = x <= 29-y ? "# " : ". ";
                break;
            case 5:
                symbol = x == 2*y || x == 2*y+1 ? "# " : ". ";
                break;
            case 6:
                symbol = x < 10 || y < 10 ? "# " : ". ";
                break;
            case 7:
                symbol = x > 15 && y > 15 ? "# " : ". ";
                break;
            case 8:
                symbol = x*y == 0 ? "# " : ". ";
                break;
            case 9:
                symbol = x > y+10 || x < y-10 ? "# " : ". ";
                break;
            case 10:
                symbol = x > y && x <= 2*y ? "# " : ". ";
                break;
            case 11:
                symbol = x==1 || x==23 || y==1 || y==23 ? "# " : ". ";
                break;
            case 12:
                symbol = x*x + y*y <= 400 ? "# " : ". ";
                break;
            default:
                symbol = ". ";
        }
        return symbol;
    }
}
