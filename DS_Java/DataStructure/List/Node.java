package DataStructure.List;

class Node<T>{
    private T _element;
    private Node<T> _next;

    //<CONSTRUCTOR START>
    public Node(){
        this._element = null;
        this._next = null;
    }
    public Node(T givenElement, Node<T> givenNext){
        this._element = givenElement;
        this._next =  givenNext;
    }
    //<CONSTRUCTOR END>

    //<GETTER SETTER START>
    public T element(){ return this._element;}
    public void setElement(T newElement){
        this._element = newElement;
    }
    public Node<T> next(){ return this._next;}
    public void setNext(Node <T> newNext){
        this._next = newNext;
    }
    //<GETTER SETTER END>
}

