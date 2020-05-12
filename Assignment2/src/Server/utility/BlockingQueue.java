package Server.utility;

import model.Burger;

public class BlockingQueue implements BlockingQueueInterface {

    private int maxCapacity;
    private ArrayList<Burger> burgers;

    public BlockingQueue()
    {
        maxCapacity = 50;
        burgers = new ArrayList<Burger>();
    }


    @Override
    public synchronized void enqueue(Object element) {
        if(capacity() <= 50)
        {
            burgers.add((Burger) element);
            notifyAll();
        }
    }

    @Override
    public synchronized Object dequeue() {
        notifyAll();
        return burgers.remove(0);
    }

    @Override
    public boolean isEmpty() {
        if(capacity() == 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean isFull() {
        if(capacity() == 50)
            return true;
        else
            return false;
    }

    @Override
    public int size() {
        return burgers.size();
    }

    private int capacity() {
        return burgers.size();
    }
}
