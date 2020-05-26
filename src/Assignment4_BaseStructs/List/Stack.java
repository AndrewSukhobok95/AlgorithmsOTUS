package Assignment4_BaseStructs.List;

public class Stack<T> {
    private LinkedList<T> stack = new LinkedList<>();

    public void push(T value){
        stack.addFirst(value);
    }

    public T pop(){
        return stack.removeFirst();
    }

    public T peek(){
        return stack.getFirst();
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }
}
