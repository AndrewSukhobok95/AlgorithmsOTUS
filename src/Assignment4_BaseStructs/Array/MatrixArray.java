//package Assignment4_BaseStructs.Array;
//
//public class MatrixArray<T> implements IArray<T> {
//
//    private int size;
//    private int vector;
//    private IArray<IArray<T>> array;
//
//    public MatrixArray(int vector) {
//        this.vector = vector;
//        array = new SingleArray<>();
//        size = 0;
//    }
//
//    public MatrixArray() {
//        this(10);
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public void add(T item) {
//        if (size == array.size() * vector)
//            array.add(new VectorArray<T>(vector));
//        array.get(size / vector).add(item);
//        size ++;
//    }
//
//    @Override
//    public void add(T item, int index) {
//        System.out.println();
//    }
//
//    @Override
//    public T get(int index) {
//        return array.get(index / vector).get(index % vector);
//    }
//}
