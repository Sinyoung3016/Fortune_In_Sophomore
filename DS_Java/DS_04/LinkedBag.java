package DS_04;

public class LinkedBag<E> {
    private int _size; //가방이 가지고 있는 원소의 개수
    private LinkedNode<E> _head;//연결 체인, 맨 앞의 노드

    public LinkedBag() {
        this._head = null;
        this._size = 0;
    }

    public int size() {
        //Bag에 들어있는 개수를 확인한다.
        return this._size;
    }
    public boolean isEmpty() {
        //Bag이 비어있는 지 확인한다.
        if (size() == 0) return true;
        else return false;
    }
    private int orderOf(E anElement){
        //anElement값을 가진 Node의 순서를 반환
        if(this.isEmpty()) return -1;

        int order = 0;
        LinkedNode <E> current = this._head;
        while((current != null) && (!current.element().equals(anElement))){
            current = current.next();
            order++;
        }
        if(current == null) return -1;
        else return order;
    }

    public boolean doesContain(E anElement) {
        //Bag 안에 주어진 원소가 존재하는 지 확인한다.
        if(this.orderOf(anElement) == -1) return false;
        else return true;
    }

    public int frequencyOf(E element) {
        //Bag안에 주어진 원소가 몇개 있는 지 확인한다.
        int count = 0;
        LinkedNode <E> current = this._head;
        while(current != null){
            if(current.element().equals(element))
                count++;
            current = current.next();
        }
        return count;
    }

    public E elementAt(int anOrder) {
        //anOrder번째 위치한 원소를 반환한다.
        if( (0 > anOrder) || (anOrder >= this._size)) return null;

        LinkedNode <E> current = this._head;
        for(int i = 0; i < anOrder; i++){
            current = current.next();
        }
        return current.element();
    }

    public boolean add(E anElement) {
        //Bag에 원소를 추가한다.
        LinkedNode <E> newNode = new LinkedNode<E>(anElement);
        newNode.setNext(this._head);
        this._head = newNode; //head 설정
        this._size++; //size 설정
        return true;
    }

    public E remove(E anElement) {
        //Bag에 원소를 삭제한다.
        int count = this.orderOf(anElement);//몇번째 순서에 있는 지

        if(this.isEmpty()) return null;//가방이 비어있을 때
        if(count == -1) return null;//해당값을 가진 노드가 없을 때
        if(count == 0) return this.removeAny();//previous가 없을 때

        LinkedNode <E> removedNode = null;
        LinkedNode <E> previous = this._head;
        for(int i = 1; i < count; i++){
            previous = previous.next();
        }
        removedNode = previous.next();
        previous.setNext(removedNode.next());
        this._size--;//size 설정
        return removedNode.element();
    }

    public E removeAny() {
        //Bag에 원소 하나를 무작위로 삭제한다.
        LinkedNode <E> removedNode = this._head;
        this._head = this._head.next();//head 설정
        this._size--;//size 설정
        return removedNode.element();
    }

    public void clear() {
        //Bag안의 모든 원소를 삭제한다.
        this._size = 0;//size 설정
        this._head = null;//head 설정
    }
}

