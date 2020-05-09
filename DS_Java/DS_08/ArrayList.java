package DS_08;

public class ArrayList<T extends Comparable<T>>  implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 5;

    private int _capacity;
    private int _size;
    private T[] _elements;

    //<CONSTRUCTOR START>
    public ArrayList() { this(ArrayList.DEFAULT_CAPACITY); }
    public ArrayList(int givenCapacity) {
        this.setCapacity(givenCapacity);
        this.setElement((T[]) new Comparable[givenCapacity]);
    }
    //<CONSTRUCTOR END>

    //<GETTER SETTER START>
    public int capacity() { return _capacity; }
    public void setCapacity(int newCapacity) { this._capacity = newCapacity; }
    public int size() { return _size; }
    private void setSize(int newSize) { this._size = newSize; }
    private T[] elements() { return _elements; }
    private void setElement(T[] newElement) { this._elements = newElement; }
    //<GETTER SETTER END>

    //<상태 START>
    public boolean isEmpty() { return (this.size() == 0); }
    public boolean isFull() { return (this.size() == this.capacity()); }
    //<상태 END>

    //<내용 START>
    public boolean doesContain(T anElement) {
        //anElement값을 가지는 원소가 존재하면 true
        for (int i = 0; i < this.size(); i++) {
            if (this.elements()[i].equals(anElement))
                return true;
        }
        return false;
    }
    public int orderOf(T anElement) {
        //원소 anElement가 리스트 안에 존재하면 해당 위치를 반환
        for (int aPosition = 0; aPosition < this.size(); aPosition++)
            if (this.elements()[aPosition].equals(anElement))
                return aPosition;
        return -1;
    }
    public T elementAt(int anOrder) {
        //anOrder을 인덱스로 가지는 원소 출력
        if ((0 <= anOrder) && (anOrder < this.size()))
            return this.elements()[anOrder];
        else
            return null;
    }
    protected void setElementAt(int anOrder, T anElement){
        if ((0 > anOrder) || (anOrder >= this.size()))
            return ;
        else
            this.elements()[anOrder] = anElement;
    }
    //<내용 END>

    //<원소 삽입 START>
    private void makeRoomAt(int aPosition){
        for(int i = this.size(); i > aPosition; i--){
            this.elements()[i] = this.elements()[i-1];
        }
    }
    public boolean addToFirst(T anElement) {
        //리스트 맨 처음에 anElement를 삽입
        if(this.isFull())
            return false;
        else{
            this.makeRoomAt(0);
            this.elements()[0] = anElement;
            this.setSize(this.size()+1);
            return true;
        }
    }
    public boolean addToLast(T anElement) {
        //리스트 맨 마지막에 anElement를 삽입
        if(this.isFull())
            return false;
        else{
            this.elements()[this.size()] = anElement;
            this.setSize(this.size()+1);
            return true;
        }
    }
    //<원소 삽입 END>

    //<원소 제거 START>
    private void removeGapAt(int aPosition){
        for(int i = aPosition+1; i < this.size(); i++){
            this.elements()[i-1] = this.elements()[i];
        }
        this.elements()[this.size()-1] = null;
    }
    public boolean removeFrom(int anOrder) {
        //원소 anElement를 삭제
        if(anOrder< 0) return false;
        else{
            this.removeGapAt(anOrder);
            this.setSize(this.size()-1);
            this.elements()[this.size()] = null;
            return true;
        }
    }
    public T removeFirst() {
        //리스트 맨 처음의 원소 삭제
        if(this.isEmpty())
            return null;
        else{
            T removedElement = this.elements()[0];
            this.removeGapAt(0);
            this.setSize(this.size() - 1);
            return removedElement;
        }
    }
    public T removeLast() {
        //리스트 맨 마지막의 원소 삭제
        if(this.isEmpty())
            return null;
        else{
            T removedElement = this.elements()[this.size()-1];
            this.setSize(this.size() - 1);
            return removedElement;
        }
    }
    //<원소 제거 START>

    public void clear() {
        for (int i = 0; i < this.size(); i++)
            this.elements()[i] = null;
        this.setSize(0);
    }

    //<STACK START>
    public boolean push(T anElement) {
        //anElement를 스택의 맨 위에 추가
        //return this.addToLast(anElement);
        if(this.isFull())
            return false;
        else{
            this.elements()[this.size()] = anElement;
            this.setSize(this.size() + 1);
            return true;
        }
    }
    public T pop() {
        //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환하고 제거
        //return this.removeLast();
        T ReturnElement = null;
        if(!this.isEmpty()){
            ReturnElement = this.elements()[this.size()-1];
            this.elements()[this.size()-1] = null;
            this.setSize(this.size()-1);
        }
        return ReturnElement;
    }
    public T peek() {
        //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환
        //return elementAt(this.size()-1)
        T ReturnElement = null;
        if(!this.isEmpty()){
            ReturnElement = this.elements()[this.size()-1];
        }
        return ReturnElement;
    }
    //<STACK END>

}
