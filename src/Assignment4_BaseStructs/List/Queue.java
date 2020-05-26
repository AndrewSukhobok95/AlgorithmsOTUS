package Assignment4_BaseStructs.List;

public class Queue<T> {
    private LinkedList<T> queue = new LinkedList<T>();

    public void enqueue(T value){
        queue.addFirst(value);
    }

    public T dequeue(){
        return queue.removeLast();
    }

    public T peek(){
        return queue.getFirst();
    }

    public int size(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
}
