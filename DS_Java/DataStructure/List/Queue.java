package DataStructure.List;

public interface Queue<E> {
    //FIFO first in first out

    public int size();
    public boolean isFull();
    public boolean isEmpty();

    public E front();
    public E rear();

    public boolean enQueue(E anElement);
    public E deQueue();

    public void clear();
}