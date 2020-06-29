package DataStructure.List;

public class ArrayQueue<T> implements Queue<T> {

    private static int DEFAULT_CAPACITY = 100;

    private int _capacity;
    private int _frontPos; //이전의 인덱스를 의미
    private int _rearPos;
    private T[] _list;

    //<GETTER SETTER START>
    public T[] list(){ return this._list; }
    public void setList(T[] newList){this._list = newList; }
    public int capacity(){ return this._capacity; }
    public void setCapacity( int newCapacity ){ this._capacity = newCapacity; }
    public int frontPos(){ return this._frontPos; }
    public void setFrontPos( int newPos ){ this._frontPos = newPos; }
    public int rearPos(){ return this._rearPos; }
    public void setRearPos( int newPos ){ this._rearPos = newPos; }
    //<GETTER SETTER END>

    public ArrayQueue(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayQueue(int givenCapacity){
        setCapacity(givenCapacity);
        setList((T[]) new Object[this.capacity()]);
        setFrontPos(-1);
        setRearPos(-1);
    }

    @Override
    public int size() { return (this.rearPos() - this.frontPos()); }
    @Override
    public boolean isFull() { return this.rearPos() == (this.capacity()-1);}
    @Override
    public boolean isEmpty() { return (this.frontPos() == this.rearPos()); }

    @Override
    public T front() {
        T result = null;
        if(!isEmpty())
            result = this.list()[frontPos()+1];
        return result;
    }
    @Override
    public T rear() {
        T result = null;
        if(!isEmpty())
            result = this.list()[rearPos()];
        return result;
    }

    @Override
    public boolean enQueue(T anElement) {
        if(!isFull()){
            this.setRearPos(this.rearPos()+1);
            this.list()[this.rearPos()] = anElement;
            return true;
        }
        return false;
    }

    @Override
    public T deQueue() {
        T result = null;
        if(!isEmpty()){
            this.setFrontPos(this.frontPos()+1);
            result = this.list()[this.frontPos()];
            this.list()[this.frontPos()] = null;
        }
        return result;
    }

    @Override
    public void clear() {
        this.setFrontPos(-1);
        this.setRearPos(-1);
        for(int i = 0;i < this.capacity(); i++)
            this.list()[i] = null;
    }
}
