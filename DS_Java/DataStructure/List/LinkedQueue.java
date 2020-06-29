package DataStructure.List;

public class LinkedQueue<T> implements Queue<T>{

    private int _size;
    private Node<T> _frontNode;
    private Node<T> _rearNode;

    public LinkedQueue(){
        this.setSize(0);
        this.setFrontNode(null);
        this.setRearNode(null);
    }

    //<GETTER SETTER START>
    public void setSize( int newSize ){ this._size = newSize; }
    public Node<T> frontNode(){ return this._frontNode; }
    public void setFrontNode( Node<T> newNode ){ this._frontNode = newNode; }
    public Node<T> rearNode(){ return this._rearNode; }
    public void setRearNode( Node<T> newNode ){ this._rearNode = newNode; }
    //<GETTER SETTER END>

    public boolean isEmpty(){
        return (this.frontNode() == null) && (this.rearNode() == null);
    }
    public boolean isFull(){ return false;}
    public int size(){ return this._size; }

    public T front(){
        T frontElement = null;
        if(!this.isEmpty())
            frontElement = this.frontNode().element();
        return frontElement;
    }
    public T rear(){
        T rearElement = null;
        if(!this.isEmpty())
            rearElement = this.rearNode().element();
        return rearElement;
    }

    public boolean enQueue(T anElement){
        Node<T> newRearNode = new Node(anElement, null);
        if(this.isEmpty())
           setFrontNode(newRearNode);
        else
            this.rearNode().setNext(newRearNode);

        this.setRearNode(newRearNode);
        this.setSize(this.size()+1);
        return true;
    }

    public T deQueue(){
        T frontElement = null;
        if(!this.isEmpty()){
            frontElement = this.frontNode().element();
            setFrontNode(this.frontNode().next());
            if(this.frontNode() == null)//isEmpty()
                this.setRearNode(null);
            this.setSize(this.size()-1);
        }
        return frontElement;
    }

    public void clear(){
        this.setFrontNode(null);
        this.setRearNode(null);
        this.setSize(0);
    }
}
