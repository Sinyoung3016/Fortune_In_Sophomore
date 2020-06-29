package DataStructure.List;

public class CircularLinkedQueue<T> implements Queue<T>{

    private int _size;
    private Node<T> _rearNode;
    //frontNode는 rearNode의 다음 노드

    public CircularLinkedQueue(){
        this.setSize(0);
        this.setRearNode(null);
    }

    //<GETTER SETTER START>
    public void setSize( int newSize ){ this._size = newSize; }
    public Node<T> rearNode(){ return this._rearNode; }
    public void setRearNode( Node<T> newNode ){ this._rearNode = newNode; }
    //<GETTER SETTER END>

    public boolean isEmpty(){ return (this.rearNode() == null); }
    public boolean isFull(){ return false;}
    public int size(){ return this._size; }

    public T front(){
        T frontElement = null;
        if(!this.isEmpty())
            frontElement = this.rearNode().next().element();
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
            newRearNode.setNext(newRearNode);//self loop
        else {
            newRearNode.setNext(this.rearNode().next());
            //마지막노드의 다음(== 첫노드)를 새로운 노드의 다음으로
            this.rearNode().setNext(newRearNode);
            //마지막 노드의 다음을 새로운 노드로 설정
        }
        this.setRearNode(newRearNode);
        this.setSize(this.size()+1);

        return true;
    }

    public T deQueue(){
        T frontElement = null;
        if(!this.isEmpty()){
            frontElement = this.rearNode().next().element();
            if(this.rearNode() == this.rearNode().next()) {
                //노드 한개 == self loop
                this.setRearNode(null);
            }
            else
                this.rearNode().setNext(this.rearNode().next().next());
            this.setSize(this.size()-1);
        }
        return frontElement;
    }

    public void clear(){
        this.setRearNode(null);
        this.setSize(0);
    }

}
