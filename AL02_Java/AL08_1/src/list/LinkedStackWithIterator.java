package list;

public class LinkedStackWithIterator<E> implements StackWithIterator<E> {
    private LinkedNode<E> _top;
    private int _size;

    private LinkedNode<E> top() {
        return this._top;
    }
    private void setTop(LinkedNode<E> newTop) {
        this._top = newTop;
    }
    public int size() {
        return this._size;
    }
    private void setSize(int newSize) {
        this._size = newSize;
    }

    public LinkedStackWithIterator(){
        this.reset();
    }
    @Override
    public void reset() {
        this.setSize(0);
        this.setTop(null);
    }
    @Override
    public boolean isEmpty() {
        return (this.size()==0);
    }
    @Override
    public boolean isFull() {
        return false;
    }
    @Override
    public boolean push(E anElement) {
        LinkedNode<E> newTop = new LinkedNode<E>(anElement,this.top());
        this.setTop(newTop);
        this.setSize(this.size()+1);
        return true;
    }
    @Override
    public E pop() {
        if(this.isEmpty()) return null;
        else{
            E removedElement = this.top().element();
            this.setTop(this.top().next());
            this.setSize(this.size()-1);
            return removedElement;
        }
    }
    @Override
    public E peek() {
       if(this.isEmpty()) return null;
       else return this.top().element();
    }
    public IteratorForLinkedStack iterator(){
        return new IteratorForLinkedStack();
    }
    public class IteratorForLinkedStack implements Iterator<E> {
        LinkedNode<E> _nextNode;
        private LinkedNode<E> nextNode(){
            return this._nextNode;
        }
        private void setNextNode(LinkedNode<E> newNextNode){
            this._nextNode =newNextNode;
        }

        private IteratorForLinkedStack(){
            this.setNextNode(LinkedStackWithIterator.this.top());
        }
        @Override
        public boolean hasNext() {
            return (this.nextNode() != null);
        }
        @Override
        public E next() {
            E nextElement = this.nextNode().element();
            this.setNextNode(this.nextNode().next());
            return nextElement;
        }
    }
}
