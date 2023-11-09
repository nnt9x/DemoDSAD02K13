import java.util.ArrayList;
import java.util.List;

public class QueueADTImpl <T> implements QueueADT<T>{

    private int capacity;
    private List<T> items;

    public QueueADTImpl(int capacity) {
        if(capacity <= 0){
            throw new RuntimeException("Error");
        }
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    @Override
    public void enqueue(T t) {
        // Them vao cuoi hang doi
        if(!isFull()){
            items.add(t);
        }
        else {
            throw new RuntimeException("Queue is full");
        }
    }

    @Override
    public T dequeue() {
        if(!isEmpty()){
            T t = items.get(0);
            items.remove(0);
            return t;
        }
        else{
            throw new RuntimeException("Queue is empty");
        }
    }

    @Override
    public T peek() {
        return items.get(0);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.size() == 0;
    }

    @Override
    public boolean isFull() {
        return items.size() == capacity;
    }
}
