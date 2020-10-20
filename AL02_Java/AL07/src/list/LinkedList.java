package list;

public class LinkedList <T> extends List<T>{
    private LinkedNode<T> head;
    private int size;

    private LinkedNode<T> head(){ return head; }
    private void setHead(LinkedNode<T> newHead){ this.head = newHead; }
    public int size(){ return size; }
    private void setSize(int newSize){ this.size = newSize; }

    public LinkedList(){
        this.setSize(0);
        this.setHead(null);
    }

    public boolean isEmpty(){
        return (this.size() == 0);
    }
    public boolean isFull(){
        return false;
    }
    public boolean add(T anElement){
        LinkedNode<T> newHeadNode = new LinkedNode<>(anElement, this.head());
        this.setHead(newHeadNode);
        this.setSize(this.size()+1);
        return true;
    }
    public T removeAny(){
        if(this.isEmpty()) return null;
        else{
            T removedElement = this.head().element();
            this.setHead(this.head().next());
            this.setSize(this.size()-1);
            return removedElement;
        }
    }

    @Override
    public void reset() {
        this.setSize(0);
        this.setHead(null);
    }

    @Override
    public Iterator<T> listIterator() {
        return new LinkedListIterator<T>();
    }

    public class LinkedListIterator<T> implements Iterator<T>{

        LinkedNode<T> nextNode;

        private LinkedNode<T> nextNode(){ return this.nextNode; }
        private void setNextNode(LinkedNode<T> newLinkedNode){ this.nextNode = newLinkedNode; }

        private LinkedListIterator(){
            this.setNextNode((LinkedNode<T>) LinkedList.this.head());
        }

        @Override
        public boolean hasNext() {
            return (this.nextNode() != null);
        }

        @Override
        public T next() {
            T nextElement = this.nextNode().element();
            this.setNextNode(this.nextNode().next());
            return nextElement;
        }
    }
}
