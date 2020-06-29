package DataStructure.BinarySearchTree_Dic;

public class BinaryNode <T>{
    private T _element;
    private BinaryNode<T> _left;
    private BinaryNode<T> _right;

    public BinaryNode(){
        this(null, null, null);
    }
    public BinaryNode(T givenElement, BinaryNode<T> givenLeft, BinaryNode<T> givenRight){
        this.setElement(givenElement);
        this.setLeft(givenLeft);
        this.setRight(givenRight);
    }

    public T element(){ return this._element; }
    public void setElement(T newElement){ this._element = newElement; }
    public BinaryNode<T> left(){ return this._left; }
    public void setLeft(BinaryNode<T> newLeft){ this._left = newLeft; }
    public BinaryNode<T> right(){ return this._right; }
    public void setRight(BinaryNode<T> newRight){ this._right = newRight; }

}
