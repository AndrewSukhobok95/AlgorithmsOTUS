package Assignment4_BaseStructs.Array;

import java.util.Arrays;

public class SingleArray<T> implements IArray<T> {
    private T[] array;
    private int size = 0;
    private int capacity = 0;

    public SingleArray () {
        array = (T[])new Object[0];
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
        if (index >= size)
            index = size;
        if (size==capacity)
            addCapacity(index);
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

    public void clear() {
        size = 0;
    }

    private void addCapacity() {
        capacity++;
        T[] newArray = (T[])new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    private void addCapacity(int index) {
        capacity++;
        T[] newArray = (T[])new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index+1, size-index);
        array = newArray;
    }

    @Override
    public String toString() {
        String s = "SingleArray[ ";
        for (int i=0; i<size; i++) {
            s += array[i] + " ";
        }
        s += "]";
        return s;
    }
}
