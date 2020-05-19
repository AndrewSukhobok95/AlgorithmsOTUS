package Assignment4_BaseStructs.Array;

public interface IArray<T> {
    int size();
    void add(T item);
    T get(int index);
    void add(T item, int index); // with shift to tail
    T remove(int index); // return deleted element
    void clear();
}
