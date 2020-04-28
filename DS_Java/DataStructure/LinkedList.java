package DataStructure;

public class LinkedList<T> {
    private int _size;//List가 가지고 있는 원소의 개수
    private Node <T> _head; //LinkedChain의 맨 앞노드

    public LinkedList(){
        this._head = null;
        this._size = 0;
    }

    //<GETTER SETTER START>
    public int size(){ return _size; }
    private void setSize(int newSize){ this._size = newSize;}
    private Node<T> head(){ return _head; }
    private void setHead(Node <T> newHead){ this._head = newHead; }
    //<GETTER SETTER END>


    //<상태 START>
    public boolean isEmpty() { return (this._size == 0); }
    public boolean isFull() { return false; }
    //<상태 END>


    //<내용 START>
    public T elementAt(int anOrder) {
        //anOrder번째의 element를 반환
        if(this.anElementDoesExistAt(anOrder)){
            Node<T> currentNode = this.head();
            int nodeCount = 0;
            while(nodeCount < anOrder){
                currentNode = currentNode.next();
                nodeCount++;
            }
            return currentNode.element();
        } else return null;
    }
    public T first() {
        //LinkedChain 처음 값 반환
        if(this.isEmpty()) return null;
        else return elementAt(0);
    }
    public T last() {
        //LinkedChain 마지막 값 반환
        if(this.isEmpty()) return null;
        else return elementAt(this.size() - 1);
    }
    public int orderOf(T anElement) {
        //anElement가 있는 노드의 순서 반환
        int order = 0;
        Node <T> currentNode = this.head();
        while(currentNode != null && (!currentNode.element().equals(anElement))){
            order++;
            currentNode = currentNode.next();
        }
        if(currentNode == null) return -1;
        else return order;
    }
    public boolean doesContain(T anElement) {
        //만약 anElement값을 가진 노드가 있는 지 확인
        return (orderOf(anElement) != -1);
    }
    //<내용 END>


    //<원소 삽입 START>
    public boolean addTo(T anElement, int anOrder) {
        //anOrder 순서에 anElement를 값으로 하는 노드 삽입
        if(!this.anElementDoesExistAt(anOrder))//anOrder가 유효한지 확인
            return false;

        Node <T> nodeForAdd = new Node<T> (anElement, null);
        if(anOrder == 0){ //Node 순서가 맨 앞일 때, previous 노드가 없는 경우
            nodeForAdd.setNext(this.head());
            setHead(nodeForAdd);
        }
        else{ //previous 노드가 있는 경우
            Node <T> previous = this.head();
            for(int i = 1; i < anOrder; i++){
                previous = previous.next();
            }
            nodeForAdd.setNext(previous.next());
            previous.setNext(nodeForAdd);
        }
        this.setSize(size() + 1);
        return true;
    }
    public boolean addToFirst(T anElement) {
        this.addTo(anElement, 0);
        return true;
    }
    public boolean addToLast(T anElement) {
        this.addTo(anElement,this.size());
        return true;
    }
    public boolean add(T anElement) {
        //처음에 넣는 이유 : 편하니까 (for문을 안돌아도 됨)
        this.addToFirst(anElement);
        return true;
    }
    //<원소 삽입 END>


    //<원소 삭제 START>
    public T removeFrom(int anOrder) {
        //anOrder의 순서의 노드를 삭제
        if(!anElementDoesExistAt(anOrder))
            return null;//범위내에 존재하는지 확인

        Node <T> removed = null;
        if(anOrder == 0){
            removed = this.head();
            this.setHead(this.head().next());
        }
        else{
            Node<T> previous = this.head();
            for(int i = 1; i < anOrder; i++){
                previous = previous.next();
            }
            removed = previous.next();
            previous.setNext(removed.next());
        }
        this.setSize(this.size() - 1);
        return removed.element();
    }
    public T removeFirst() {
        //리스트 맨 처음의 원소 삭제
        return this.removeFrom(0);
    }
    public T removeLast() {
        //리스트 맨 마지막의 원소 삭제
        return this.removeFrom(this.size() - 1);
    }
    public T removeAny() {
        //리스트 중 가장 효과적인 곳에 삭제 = 맨 뒤
        return this.removeFirst();
    }
    public boolean remove(T anElement) {
        int orderOfRemove = this.orderOf(anElement);
        if (orderOfRemove < 0)
            return false; //해당 순서의 값이 없을 때, -1
        else
            this.removeFrom(orderOfRemove);
        return true;
    }
    //<원소 삭제 END>


    public boolean replaceAt(T anElement, int anOrder) {
        //anElemtent로 anOrder순서의 노드값 변경
        if(!this.anElementDoesExistAt(anOrder)) return false;

        Node<T> current = this.head();
        for(int i = 0; i < anOrder; i++){
            current = current.next();
        }
        current.setElement(anElement);
        return true;
    }
    public void clear() {
        this.setSize(0);
        this.setHead(null);
    }
    private boolean anElementDoesExistAt(int anOrder){
        return ((0 <= anOrder) && (anOrder < this.size()));
    }

    public Iterator<T> iterator(){
        return new ListIterator();
    }


    //<ITERATOR START>
    private class ListIterator implements Iterator<T>{
        private Node<T> _nextNode; //연결 체인에서 다음 원소를 소유하고 있는 노드

        private ListIterator(){
            this._nextNode = LinkedList.this._head;
        }


        //<GETTER SETTER START>
        private Node<T> nextNode(){
            return this._nextNode;
        }
        private void setNextNode(Node <T> newNextNode){
            this._nextNode = newNextNode;
        }
        //<GETTER SETTER END>


        public boolean hasNext(){
            return (this.nextNode() !=  null);
        }

        public T next(){
            T nextNode = null;
            if (this.nextNode() != null) return null;
            else{
                nextNode = this.nextNode().element();
                this.setNextNode(this.nextNode().next());
                return nextNode;
            }
        }
    }
    //<ITERATOR END>

}