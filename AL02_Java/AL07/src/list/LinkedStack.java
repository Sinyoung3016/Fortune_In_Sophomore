package list;

public class LinkedStack<E> implements Stack<E> {
    private int size;
    private LinkedNode<E> top;

    public int size() { return size; }
    private void setSize(int size) { this.size = size; }
    private LinkedNode<E> top() { return top; }
    private void setTop(LinkedNode<E> top) { this.top = top; }

    public LinkedStack(){
        this.setSize(0);
        this.setTop(null);
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
    public boolean isFull(){
        return false;
    }
    public boolean push(E anElement){
        LinkedNode<E> newTop = new LinkedNode<E>(anElement, this.top());
        this.setTop(newTop);
        this.setSize(this.size()+1);
        return true;
    }
    public E pop(){
        if(this.isEmpty()) return null;
        else{
            E removedElement = this.top().element();
            this.setTop(this.top().next());
            this.setSize(this.size()-1);
            return removedElement;
        }
    }

    public E peek() {
        if(this.isEmpty()) return null;
        else return this.top().element();
    }

    public void reset() {
        this.setTop(null);
        this.setSize(0);
    }

    public IteratorForLinkedStack iterator(){
        return new IteratorForLinkedStack();
    }

    public class IteratorForLinkedStack implements Iterator<E>{
        LinkedNode<E> nextNode;

        public LinkedNode<E> nextNode() { return nextNode; }
        public void setNextNode(LinkedNode<E> nextNode) { this.nextNode = nextNode; }

        private IteratorForLinkedStack(){
            this.setNextNode(LinkedStack.this.top());
        }

        public boolean hasNext(){
            return this.nextNode() != null;
        }
        public E next(){
            E nextElement = this.nextNode().element();
            this.setNextNode(this.nextNode().next());
            return nextElement;
        }
    }
}


