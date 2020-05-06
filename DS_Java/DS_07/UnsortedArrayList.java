package DS_07;

public class UnsortedArrayList<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 100;

    private int _capacity;
    private int _size;
    private T[] _elements;

    //<CONSTRUCTOR START>
    public UnsortedArrayList() {
        this(UnsortedArrayList.DEFAULT_CAPACITY);
    }
    public UnsortedArrayList(int givenCapacity) {
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
    private void setElement(T[] newElement) {this._elements = newElement; }
    //<GETTER SETTER END>

    //<상태 START>
    public boolean isEmpty() {
        return (this.size()== 0);
    }
    public boolean isFull() {
        return (this.size() == this.capacity());
    }
    //<상태 END>

    //<내용 START>
    public boolean doesContain(T anElement) {
        //anElement값을 가지는 원소가 존재하면 true
        return (this.orderOf(anElement) >= 0);
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
        if ((0 > anOrder) || (anOrder >= this.size()))
            return null;
        else
            return this.elements()[anOrder];
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
    public boolean add(T anElement) {
        //리스트 중 가장 효과적인 곳에 삽입 = 맨 뒤
        return this.addToLast(anElement);
    }
    //<원소 삽입 END>


    //<원소 제거 START>
    private void removeGapAt(int aPosition){
        for(int i = aPosition+1; i < this.size(); i++){
            this.elements()[i-1] = this.elements()[i];
        }
        this.elements()[this.size()-1] = null;
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
            T removedElement = this.elements()[this.size()];
            this.setSize(this.size() - 1);
            return removedElement;
        }
    }
    public T removeAny() {
        //리스트 중 가장 효과적인 곳에 삭제 = 맨 뒤
        return this.removeLast();
    }

    public boolean remove(T anElement) {
        //원소 anElement를 삭제
        int foundIndex = this.orderOf(anElement);
        //anElement의 위치를 찾음

        if(foundIndex < 0) return false;
        else{
            this.removeGapAt(foundIndex);
            this.setSize(this.size()-1);
            this.elements()[this.size()] = null;
            return true;
        }
    }
    //<원소 제거 START>

    //<ITERATOR START>
    public Iterator<T> iterator(){
        return new ListIterator();
    }

    public class ListIterator implements Iterator<T> {
        private int _nextPosition; //배열에서의 다음 원소 위치

        private ListIterator(){ this.setNextPosition(0); }

        private int nextPosition(){ return this._nextPosition; }
        private void setNextPosition(int newPosition){ this._nextPosition = newPosition; }

        public boolean hasNext(){
            return (this.nextPosition() < UnsortedArrayList.this.size());
        }

        public T next(){
            if (this.nextPosition() < UnsortedArrayList.this.size()) {
                T nextElement = UnsortedArrayList.this.elements()[this.nextPosition()];
                this.setNextPosition(this.nextPosition()+1);
                return nextElement;
            }
            else return null;
        }
    }
    //<ITERATOR END>
}