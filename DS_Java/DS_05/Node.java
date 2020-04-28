package DS_05;

class Node<T>{
    private T _element;
    private Node<T> _next;


    //<CONSTRUCTER START>
    public Node(){
        this._element = null;
        this._next = null;
    }
    public Node(T givenElement, Node givenNext){
        this._element = givenElement;
        this._next =  givenNext;
    }
    //<CONSTRUCTER END>


    //<GETTER SETTER START>
    public T element(){ return this._element;}
    public void setElement(T newElement){
        this._element = newElement;
    }
    public Node<T> next(){ return this._next;}
    public void setNext(Node<T> newNext){
        this._next = newNext;
    }
    //<GETTER SETTER END>
}

