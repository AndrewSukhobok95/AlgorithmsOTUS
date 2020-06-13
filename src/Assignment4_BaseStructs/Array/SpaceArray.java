package Assignment4_BaseStructs.Array;

public class SpaceArray<T> implements IArray<T> {
    private IArray<IArray<T>> array;
    private int size = 0;
    private FactorArray<Integer> sizeArray;
    private int vec_capacity;
    private int vec_fullcapacity;
    final static int DEFAULT_VEC_CAPACITY = 5;
    final static int DEFAULT_VEC_FULLCAPACITY = 10;

    public SpaceArray() {
        this(DEFAULT_VEC_FULLCAPACITY, DEFAULT_VEC_CAPACITY);
    }

    public SpaceArray(int vec_fullcapacity, int vec_capacity) {
        if (vec_fullcapacity<=0) vec_fullcapacity++;
        this.vec_fullcapacity = vec_fullcapacity;
        if (vec_capacity >= vec_fullcapacity) {
            this.vec_capacity = vec_fullcapacity - 1;
        } else {
            this.vec_capacity = vec_capacity;
        }
        array = new SingleArray<>();
        sizeArray = new FactorArray<>();
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return sizeArray.size()==0;
    }

    @Override
    public void add(T item) {
        if (isEmpty()) {
            addCapacity();
            sizeArray.add(0);
        }
        if (sizeArray.get(sizeArray.size()-1) == vec_capacity) {
            addCapacity();
            sizeArray.add(0);
        }
        int last_size_index = sizeArray.size()-1;
        array.get(last_size_index).add(item);
        size++;
        sizeArray.set(sizeArray.get(last_size_index)+1, last_size_index);
    }

    @Override
    public T get(int index) {
        if (index > size-1) index = size-1;
        SizeIndex size_index = getSizeIndex(index);
        int inside_index = index - (size_index.cumSum - sizeArray.get(size_index.index));
        return array.get(size_index.index).get(inside_index);
    }

    @Override
    public void add(T item, int index) {
        if (index > size-1) index = size-1;
        SizeIndex size_index = getSizeIndex(index);
        int inside_index = index - (size_index.cumSum - sizeArray.get(size_index.index));
        if (array.get(size_index.index).size() == vec_fullcapacity) {
            shift(size_index);
        } else {
            sizeArray.set(sizeArray.get(size_index.index)+1, size_index.index);
        }
        array.get(size_index.index).add(item, inside_index);
        size++;
    }

    @Override
    public T remove(int index) {
        if (index > size-1) index = size-1;
        SizeIndex size_index = getSizeIndex(index);
        int inside_index = index - (size_index.cumSum - sizeArray.get(size_index.index));
        T removed_element = array.get(size_index.index).remove(inside_index);
        if (sizeArray.get(size_index.index)==1) {
            array.remove(size_index.index);
            sizeArray.remove(size_index.index);
        } else {
            sizeArray.set(sizeArray.get(size_index.index) - 1, size_index.index);
        }
        return removed_element;
    }

    @Override
    public void clear() {
        array.clear();
        sizeArray.clear();
        size = 0;
    }

    private void addCapacity() {
        array.add(new FactorArray<T>(vec_fullcapacity));
    }

    private void shift(SizeIndex size_index) {
        int i = size_index.index;
        while (sizeArray.get(i) >= vec_fullcapacity) {
            T last_element = array.get(i).remove(vec_fullcapacity);
            i++;
            array.get(i).add(last_element, 0);
            if (i == sizeArray.size()-1 && sizeArray.get(i) >= vec_fullcapacity) {
                addCapacity();
                sizeArray.add(0);
            }
        }
        sizeArray.set(sizeArray.get(i)+1, i);
    }

    static class SizeIndex {
        public int index;
        public int cumSum;

        public SizeIndex(int index, int cumSum) {
            this.index = index;
            this.cumSum = cumSum;
        }
    }

    private SizeIndex getSizeIndex(int index) {
        int cumSize = 0;
        for (int i=0; i<sizeArray.size(); i++) {
            cumSize += sizeArray.get(i);
            if (index < cumSize) return new SizeIndex(i, cumSize);
        }
        return new SizeIndex(sizeArray.size()-1, cumSize);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("SpaceArray[\n");
        for (int i=0; i<sizeArray.size(); i++) {
            s.append("    ");
            s.append(array.get(i).toString());
            s.append("\n");
        }
        s.append("]");
        return s.toString();
    }
}
