package DataStructure.List;

public class LinkedList<T> extends List<T> {

    private int _size;
    private Node<T> _head;

    //<GETTER SETTER START>
    protected void setSize(int newSize){ this._size = newSize; }
    protected Node<T> head(){ return this._head; }
    protected void setHead(Node<T> newNode) { this._head = newNode; }
    //<GETTER SETTER END>

    public LinkedList(){}

    //<상태 START>
    @Override
    public boolean isEmpty() { return (this.size() == 0); }
    @Override
    public boolean isFull() { return false; }
    @Override
    public int size() { return this._size; }
    //<상태 END>

    @Override
    public boolean doesContain(T anElement) {
        Node<T> current = this.head();
        while(current != null){
            if((current.element()).equals(anElement))
                return true;
        }
        return false;
    }
    @Override
    public T elementAt(int anOrder) {
        T result = null;
        if( (0<=anOrder) && (anOrder<this.size()) ) {
            Node<T> current = this.head();
            for(int i = 0; i < anOrder; i++)
                current = current.next();
            result = current.element();
        }
        return result;
    }
    @Override
    public T first() {
        //order = 0
        return this.elementAt(0);
    }
    @Override
    public T last() {
        //order = this.size() - 1
        return this.elementAt(this.size() - 1);
    }
    @Override
    public int orderOf(T anElement) {
        int order = -1;
        Node<T> current = this.head();
        while(current != null){
            order++;
            if((current.element()).equals(anElement)) break;
            current = current.next();
        }
        return order;
    }

    //<삽입 START>
    @Override
    public boolean addTo(T anElement, int anOrder) {
        if((0<=anOrder) && (anOrder<=this.size())) { //삽입 시 범위
            Node<T> newNode = new Node<>(anElement, null);
            if (anOrder == 0){ //맨 앞에 삽입 될 때
                newNode.setNext(head());
                this.setHead(newNode);
            }
            else{ //연결 체인 중간에 삽입 될 때
                Node<T> previous = this.head();
                for (int i = 1; i < anOrder; i++)
                    previous = previous.next();
                newNode.setNext(previous.next());
                previous.setNext(newNode);
            }
            setSize(this.size()+1);
        }
        return  false;
    }
    @Override
    public boolean addToFirst(T anElement) {
        return this.addTo(anElement,0);
    }
    @Override
    public boolean addToLast(T anElement) {
        return this.addTo(anElement,this.size());
    }
    @Override
    public boolean add(T anElement) {
        //효율적인 자리 : 맨앞
        return this.addToFirst(anElement);
    }
    //<삽입 END>

    @Override
    public T removeFrom(int anOrder) {
        Node<T> result = null;
        if((0<=anOrder) && (anOrder < this.size())) {
            Node<T> previous = this.head();
            if (anOrder == 0) {
                result = previous;
                this.setHead(previous.next());
            } else {
                for (int i = 1; i < this.size(); i++)
                    previous = previous.next();
                result = previous.next();
                previous.setNext(result.next());
            }
            this.setSize(this.size()-1);
        }
        return result.element();
    }
    @Override
    public T removeFirst() {
        return this.removeFrom(0);
    }
    @Override
    public T removeLast() {
        return this.removeFrom(this.size()-1);
    }
    @Override
    public T removeAny() {
        //효율
        return this.removeFirst();
    }
    @Override
    public boolean remove(T anElement) {
        T result = this.removeFrom(this.orderOf(anElement));
        if(result == null) return false;
        else return true;
    }
    @Override
    public boolean replaceAt(T anElement, int anOrder) {
        if((0<=anOrder) && (anOrder<this.size())) {
            Node<T> current = this.head();
            for (int i = 0; i < anOrder; i++)
                current = current.next();
            current.setElement(anElement);
            return true;
        }
        return false;
    }
    @Override
    public void clear() {
        setSize(0);
        setHead(null);
    }

    public Iterator<T> iterator(){ return new ListIterator(); }

    public class ListIterator implements Iterator<T>{

        private Node<T> _nextNode;

        private Node<T> nextNode(){ return this._nextNode; }
        private void setNextNode(Node<T> newNode){ this._nextNode = newNode; }

        private ListIterator(){
            this.setNextNode(LinkedList.this.head());
        }

        @Override
        public boolean hasNext() {
            return (this.nextNode() != null);
        }

        @Override
        public T next() {
            T result = null;
            if(this.hasNext()) {
                result = nextNode().element();
                setNextNode(this.nextNode().next());
            }
            return result;
        }
    }
}
