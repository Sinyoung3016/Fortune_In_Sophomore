package DS_04;

public class LinkedNode<E> {
    private E _element; // 현재 노드에 있는 요소, 여기서는 Coin
    private LinkedNode<E> _next; //다음 노드

    //<생성자 START>
    public LinkedNode() {
        this._element = null;
        this._next = null;
    }
    public LinkedNode(E givenElement) {
        //원소 givenElement를 가지는 LinkedNode를 설정
        this._element = givenElement;
        this._next = null;
    }
    public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
        //원소 givenElement와 다음노드 givenNext를 가지는 LinkedNode 객체를 생성
        this._element = givenElement;
        this._next = givenNext;
    }
    //<생성자 END>

    //<GETTER/SETTER START>
    public void setElement(E newElement) {
        //LinkedNode의 element를 newElement로 변경한다.
        this._element = newElement;
    }
    public E element() {
        //LinkedNode 객체의 element를 반환한다.
        return this._element;
    }
    public LinkedNode<E> next() {
        //LinkedNode 객체의 다음 LinkedNode를 반환한다.
        return this._next;
    }
    public void setNext(LinkedNode<E> newNext) {
        //LinkedNode 객체의 next를 newNext로 변경한다.
        this._next = newNext;
    }
    //<GETTER/SETTER END>
}
