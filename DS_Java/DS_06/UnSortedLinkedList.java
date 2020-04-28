package DS_06;

public class UnSortedLinkedList <T extends Comparable<T>>{
    private int _size;//List가 가지고 있는 원소의 개수
    private Node<T> _head; //LinkedChain의 맨 앞노드

    public UnSortedLinkedList(){
        this._head = null;
        this._size = 0;
    }

    //<GETTER SETTER START>
    public int size(){ return _size; }
    private void setSize(int newSize){ this._size = newSize;}
    private Node<T> head(){ return _head; }
    private void setHead(Node<T> newHead){ this._head = newHead; }
    //<GETTER SETTER END>


    public boolean addTo(T anElement, int anOrder) {
        //anOrder 순서에 anElement를 값으로 하는 노드 삽입
        if((0 > anOrder) || (anOrder > this.size()+1))//anOrder가 유효한지 확인
            return false;

        Node<T> nodeForAdd = new Node<T>(anElement, null);
        if(anOrder == 0){ //Node 순서가 맨 앞일 때, previous 노드가 없는 경우
            nodeForAdd.setNext(this.head());
            setHead(nodeForAdd);
        }
        else{ //previous 노드가 있는 경우
            Node<T> previous = this.head();
            for(int i = 1; i < anOrder; i++){
                previous = previous.next();
            }
            nodeForAdd.setNext(previous.next());
            previous.setNext(nodeForAdd);
        }
        this.setSize(size() + 1);
        return true;
    }
    public boolean add(T anElement) {
        //처음에 넣는 이유 : 편하니까 (for문을 안돌아도 됨)
        this.addTo(anElement, 0);
        return true;
    }

    public T max(){
        if(this.size() == 0) return null; //리스트가 비워져 있을때
        else {
            Node<T> current = this.head();
            T max = this.head().element(); //첫번째 노드의 원소
            while(current != null){//리스트의 마지막까지 돌기 위해서
                if(max.compareTo(current.element()) < 0)//음수이면, max가 작기 때문에, 재할당
                    max = current.element();//max값에 current의 원소를 반환
                current = current.next();
            }
            return max;
        }
    }
}