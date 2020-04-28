package DS_06;

public class SortedLinkedList <E extends Comparable<E>> {

    private int _size;
    private Node<E> _head;

    //<GETTER SETTER START>
    public int size(){ return this._size; }
    public void setSize(int newSize){ this._size = newSize; }
    private Node<E> head(){ return _head; }
    private void setHead(Node<E> newHead){ this._head = newHead; }
    //<GETTER SETTER END>

    public SortedLinkedList(){
        this._head = null;
        this._size = 0;
    }

    public boolean add(E anElement) {
        Node<E> nodeForAdd = new Node<E>(anElement, null);
        if (this.size() == 0) {
            this.setHead(nodeForAdd);
        } else { //리스트에 적어도 하나의 노드가 있는 경우
            Node<E> current = this.head(); //비교하는 노드에 head로 초기화
            Node<E> previous = null; //삽입할 노드의 그전값을 의미
            while(current != null){ //마지막의 next가 아닐때를 의미
                if(current.element().compareTo(anElement) > 0) break;//노드가 삽입할 위치를 찾음
                previous = current;
                current = current.next();
            }
            if(previous == null){//리스트 맨 처음에 삽입될 때
                nodeForAdd.setNext(this.head());
                this.setHead(nodeForAdd);
            }
            else{//삽입되는 위치 앞에 노드가 있을 때
                nodeForAdd.setNext(previous.next());
                previous.setNext(nodeForAdd);
            }
        }
        this.setSize(this.size() + 1);// 성공적으로 삽입되면, 사이즈 1추가
        return true;
    }

    public E max(){
        if(this.size() == 0) return null;
        else {
            Node<E> currentNode = this.head();
            while (currentNode.next() != null) {
                currentNode = currentNode.next();
            }
            return currentNode.element();
        }
    }

}
