package Assignment2_Alg.fibNumUtils;

public class Matrix2D {
    public int x11;
    public int x12;
    public int x21;
    public int x22;

    public Matrix2D(int x11, int x12, int x21, int x22) {
        this.x11 = x11;
        this.x12 = x12;
        this.x21 = x21;
        this.x22 = x22;
    }

    public Matrix2D multiply(Matrix2D M) {
        int a = x11 * M.x11 + x12 * M.x21;
        int b = x11 * M.x12 + x12 * M.x22;
        int c = x21 * M.x11 + x22 * M.x21;
        int d = x21 * M.x12 + x22 * M.x22;
        return new Matrix2D(a, b, c, d);
    }

//    public Matrix2D multiply(Matrix2D M) {
//        int a = M.x11 * x11 + M.x12 * x21;
//        int b = M.x11 * x12 + M.x12 * x22;
//        int c = M.x21 * x11 + M.x22 * x21;
//        int d = M.x21 * x12 + M.x22 * x22;
//        return new Matrix2D(a, b, c, d);
//    }

    @Override
    public String toString() {
        return "Matrix2D{" +
                "x11=" + x11 +
                ", x12=" + x12 +
                ", x21=" + x21 +
                ", x22=" + x22 +
                '}';
    }
}
