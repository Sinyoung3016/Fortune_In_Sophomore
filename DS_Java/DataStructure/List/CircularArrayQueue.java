package DataStructure.List;

public class CircularArrayQueue<T> implements Queue<T> {

    private static final int DEFAULT_CAPACITY = 50;

    private int _maxLength; //capacity + 1
    private int _frontPosition; //항상 직전의 원소를 가르킴
    private int _rearPosition;
    private T[] _elements;

    //<CONSTRUCTOR START>
    public CircularArrayQueue(){
        this(CircularArrayQueue.DEFAULT_CAPACITY);
        //static으로 선언된 상수변수함수를 언급할때는 class의 이름으로
        //아닐때는 this
    }
    public CircularArrayQueue(int givenCapacity){
        this.setElements((T[]) new Object[this.maxLength()]);
        this.setMaxLength(givenCapacity + 1);
        this.setFrontPosition(-1);
        this.setRearPosition(-1);
    }
    //<CONSTRUCTOR END>

    //<GETTER SETTER START>
    public int maxLength(){ return this._maxLength; }
    public void setMaxLength(int newCapacity){ this._maxLength = newCapacity; }
    public int frontPosition(){ return this._frontPosition; }
    private void setFrontPosition(int newFrontPosition){ this._frontPosition = newFrontPosition; }
    public int rearPosition(){ return this._rearPosition; }
    private void setRearPosition(int newRearPosition){ this._rearPosition = newRearPosition; }
    private T[] elements(){ return this._elements; }
    private void setElements(T[] newElements){ this._elements = newElements; }
    //<GETTER SETTER END>

    public int size(){
        if(this.frontPosition() <= this.rearPosition())
            return (this.rearPosition() - this.frontPosition());
        else
            return ((this.rearPosition() + this.maxLength()) - this.frontPosition());
    }
    public boolean isFull(){
        int nextRearPosition = (this.rearPosition() + 1) % this.maxLength();
        return (nextRearPosition == this.rearPosition());
    }
    public boolean isEmpty(){
        return (this.frontPosition() == this.rearPosition());
    }

    public T front(){
        T frontElement = null;
        if(!this.isEmpty())
            frontElement = this.elementAt(this.frontPosition()+1);
        return frontElement;
    }
    public T rear(){
        T rearElement = null;
        if(!this.isEmpty())
            rearElement = this.elementAt(this.rearPosition());
        return rearElement;
    }

    public boolean enQueue(T anElement){
        //원소 삽입
        if(this.isFull()) return false;
        else{
            this.setRearPosition((this.rearPosition()+1) % this.maxLength());
            this.elements()[this.rearPosition()] = anElement;
            return true;
        }
    };
    public T deQueue(){
        //원소 삭제
        T frontElement = null;
        if(!this.isEmpty()) {
            this.setFrontPosition((this.frontPosition() + 1) % this.maxLength());
             frontElement = this.elements()[this.frontPosition()];
            this.elements()[this.frontPosition()] = null;
        }
        return frontElement;
    }

    public void clear(){
        this.setFrontPosition(0);
        this.setRearPosition(0);
        for(int i = 0; i < this.maxLength(); i++)
            this.elements()[i] = null;
    }


    public T elementAt(int Order){
        if((0 <= Order) && (Order < this.size()))
            return this.elements()[(Order+1+frontPosition())%maxLength()];
        else
            return null;
    }

}
