public class CircularQueue<T> implements Queue<T>{

    private T[] elements;
    private int capacity;
    private int front;
    private int rear;

    private T[] elements(){ return elements; }
    private void setElements(T[] newElements){ this.elements = newElements; }
    private int capacity(){ return capacity; }
    private void setCapacity(int newCapacity){ this.capacity = newCapacity; }
    private int front(){ return front; }
    private void setFront(int newFront){ this.front = newFront; }
    private int rear(){ return rear; }
    private void setRear(int newRear){ this.rear = newRear; }

    private int nextRear(){
        return (this.rear()+1) % this.capacity();
    }
    private int nextFront(){
        return (this.front()+1) % this.capacity();
    }

    public CircularQueue(int maxNumberOfElements){
        this.setCapacity(maxNumberOfElements);
        this.setElements((T[]) new Object[this.capacity()]);
        this.reset();
    }

    public void reset(){
        this.setFront(0);
        this.setRear(0);
    }
    public int size(){
        if(this.front() <= this.rear()) return (this.rear() - this.front());
        else return (this.capacity() + this.rear() - this.front());
    }
    public boolean isEmpty(){
        return (this.front() == this.rear());
    }
    public boolean isFull(){
        return (this.front() == this.nextRear());
    }
    public boolean add(T anElement){
        if(this.isFull()) return false;
        else{
            this.setRear(this.nextRear());
            this.elements()[this.rear()] = anElement;
            return true;
        }
    }
    public T remove(){
        if(this.isEmpty()) return null;
        else{
            this.setFront(this.nextFront());
            return this.elements()[this.front()];
        }
    }

}

