package Assignment4_BaseStructs.Array;

public class MatrixArray<T> implements IArray<T> {
    private IArray<IArray<T>> array;
    private int size = 0;
    private int capacity = 0;
    private int vec_capacity;
    final static int DEFAULT_VEC_CAPACITY = 10;

    public MatrixArray() {
        this(DEFAULT_VEC_CAPACITY);
    }

    public MatrixArray(int vec_capacity) {
        if (vec_capacity<=0) vec_capacity++;
        this.vec_capacity = vec_capacity;
        array = new SingleArray<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return array.get(index / vec_capacity).get(index % vec_capacity);
    }

    @Override
    public void add(T item) {
        if (size == array.size() * vec_capacity) {
            addCapacity();
        }
        array.get(size / vec_capacity).add(item);
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (index > size)
            index = size;
        if (size==capacity)
            addCapacity();
        shift(index);
        array.get(index / vec_capacity).add(item, index % vec_capacity);
    }

    @Override
    public T remove(int index) {
        if (index>=size)
            index = size - 1;
        T removed_value = array.get(index / vec_capacity).remove(index % vec_capacity);
        shift_bw(index);
        size--;
        return removed_value;
    }

    @Override
    public void clear() {
        size = 0;
        for (int i=0; i < capacity / vec_capacity; i++)
            array.get(i).clear();
    }

    private void addCapacity() {
        array.add(new FactorArray<T>(vec_capacity));
        capacity += vec_capacity;
    }

    private void shift_bw(int index) {
        int fa_index = index / vec_capacity;
        int n_fa = (size + vec_capacity - 1) / vec_capacity;
        for (int i = fa_index + 1; i < n_fa; i++){
            T last_element = array.get(i).remove(0);
            array.get(i-1).add(last_element, vec_capacity-1);
        }
    }

    private void shift(int index) {
        int index_fa = index / vec_capacity;
        for (int i = capacity / vec_capacity - 1; i > index_fa; i--){
            T last_element = array.get(i-1).remove(vec_capacity - 1);
            array.get(i).add(last_element, 0);
        }
    }

    @Override
    public String toString() {
        String s = "MatrixArray[" + "\n";
        int n_fa = capacity / vec_capacity;
        for (int i=0; i<n_fa; i++) {
            s += "    " + array.get(i).toString() + "\n";
        }
        s += "]";
        return s;
    }
}
