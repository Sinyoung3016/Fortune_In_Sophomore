package list;

public class ArrayStack<E> implements Stack<E> {
    private static final int DEFAULT_CAPACITY = 100;

    private int _capacity;
    private int _top;
    private E[] _elements;

    private int capacity() {
        return this._capacity;
    }
    private void setCapacity(int newCapacity) {
        this._capacity = newCapacity;
    }
    private int top() {
        return this._top;
    }
    private void setTop(int newTop) {
        this._top = newTop;
    }
    protected E[] elements() {
        return this._elements;
    }
    private void setElements(E[] newElements) {
        this._elements = newElements;
    }

    public ArrayStack(){
        this(ArrayStack.DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayStack(int givenCapacity){
        this.setCapacity(givenCapacity);
        this.setElements((E[])new Object[this.capacity()]);
        this.setTop(-1);
    }
    public void reset(){
        this.setTop(-1);
    }
    public int size(){
        return this.top()+1;
    }
    public boolean isEmpty(){
        return (this.size() == 0);
    }
    public boolean isFull(){
        return (this.size() == capacity());
    }
    public boolean push(E anElement){
        if(this.isFull()) return false;
        else{
            setTop(this.top()+1);
            elements()[this.top()] = anElement;
            return true;
        }
    }
    public E pop(){
        if(this.isEmpty()) return null;
        else{
            E returnElement = elements()[this.top()];
            setTop(this.top()-1);
            return returnElement;
        }
    }
    public E peek(){
        if(this.isEmpty()) return null;
        else return elements()[this.top()];
    }
}
