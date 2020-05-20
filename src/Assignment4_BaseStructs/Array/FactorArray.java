package Assignment4_BaseStructs.Array;

public class FactorArray<T> implements IArray<T> {
    private T[] array;
    private int size = 0;
    private int capacity;
    private final int factor;
    final static int DEFAULT_CAPACITY = 10;
    final static int DEFAULT_FACTOR = 2;

    public FactorArray() {
        this(DEFAULT_CAPACITY, DEFAULT_FACTOR);
    }

    public FactorArray(int initCapacity) {
        this(initCapacity, DEFAULT_FACTOR);
    }

    public FactorArray(int initCapacity, int factor) {
        if (initCapacity<=0) initCapacity++;
        this.capacity = initCapacity;
        this.factor = factor;
        array = (T[])new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void add(T item) {
        if (size==capacity)
            addCapacity();
        array[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (index > size)
            index = size;
        if (size==capacity)
            addCapacity();
        shift(index);
        array[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        if (index>=size)
            index = size - 1;
        T removed_value = get(index);
        System.arraycopy(array, index+1, array, index, size - index - 1);
        size--;
        return removed_value;
    }

    @Override
    public void clear() {
        size = 0;
    }

    private void addCapacity() {
        capacity += capacity * factor;
        T[] newArray = (T[])new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void shift(int index) {
        T[] newArray = (T[])new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index+1, size-index);
        array = newArray;
    }

    @Override
    public String toString() {
        String s = "FactorArray[ ";
        for (int i=0; i<size; i++) {
            s += array[i] + " ";
        }
        s += "]";
        return s;
    }
}
