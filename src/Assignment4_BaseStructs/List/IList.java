package Assignment4_BaseStructs.List;

public interface IList<T> {
    int size();
    void addFirst(T item);
    void addLast(T item);
    void add(T item, int index);
    T removeFirst();
    T removeLast();
    T remove(int index);
    T getFirst();
    T getLast();
    T get(int index);
    void clear();
}
