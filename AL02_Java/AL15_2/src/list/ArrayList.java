package list;

public class ArrayList<T> implements List<T> {
    private static int DEFAULT_CAPACITY = 100;

    private int _capacity;
    private int _size;
    private T[] _elements;

    public ArrayList(){
        this(ArrayList.DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayList(int givenCapacity){
        this._capacity = givenCapacity;
        this._size =0;
        this._elements = (T[])new Object[this._capacity];
    }

    protected void setElementAt(T element,int order){
        this._elements[order] = element;
    }
    @Override
    public int capacity() {
        return this._capacity;
    }
    @Override
    public int size() {
        return this._size;
    }
    @Override
    public boolean isEmpty() {
        return size() == 0 ;
    }
    @Override
    public boolean isFull() {
        return size() == capacity();
    }
    @Override
    public boolean orderIsValid(int order) {
        return 0<=order && order<size();
    }
    @Override
    public T elementAt(int order) {
        if(orderIsValid(order))
            return this._elements[order];
        else return null;
    }
    @Override
    public boolean add(T elementForAdd) {
        if(!isFull()){
            this._elements[size()] = elementForAdd;
            this._size++;
            return true;
        }
        else return false;
    }
}
