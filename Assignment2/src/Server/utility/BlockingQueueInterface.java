package Server.utility;

public interface BlockingQueueInterface<T> {

    public void enqueue(T element);

    public T dequeue();

    public boolean isEmpty();

    public boolean isFull();

    public int size();
}
