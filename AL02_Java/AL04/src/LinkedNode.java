public class LinkedNode<T> {
    private T element;
    private LinkedNode<T> next;

    public T element(){ return element; }
    public void setElement(T newElement){ this.element = newElement; }
    public LinkedNode<T> next(){ return next; }
    public void setNext(LinkedNode<T> newNext){ this.next = newNext; }

    public LinkedNode(){
        this.setElement(null);
        this.setNext(null);
    }
    public LinkedNode(T givenElement, LinkedNode<T> givenNext){
        this.setElement(givenElement);
        this.setNext(givenNext);
    }
}
