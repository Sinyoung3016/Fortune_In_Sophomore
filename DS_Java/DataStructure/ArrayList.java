package DataStructure;

public class ArrayList<T> {
    private static final int DEFAULT_CAPACITY = 25;
    private int _capacity;
    private int _size;
    private T[] _elements;


    //<CONSTRUCTER START>
    public ArrayList() {
        //여기서 this는 객체 생성자를 의미
        this(ArrayList.DEFAULT_CAPACITY);
    }

    public ArrayList(int givenCapacity) {
        this._capacity = givenCapacity;
        this._size = 0;
        this._elements = (T[]) new Object[givenCapacity];
    }
    //<CONSTRUCTER END>


    //<GETTER SETTER START>
    public int capacity(){ return _capacity; }
    public void setCapacity(int newCapacity){ this._capacity = newCapacity; }
    public int size(){ return _size; }
    private void setSize(int newSize){
        this._size = newSize;
    }
    private T[] elements(){
        return _elements;
    }
    private void setElement(T[] newElement){
        this._elements = newElement;
    }
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
        for(int i = 0;  i < this.size(); i++){
            if(this.elements()[i].equals(anElement))
                return true;
        }
        return false;
    }
    public int frequencyOf(T anElement){
        //anElement를 몇개 가지고 있는 지 출력
        int frequencyCount = 0;
        for(int i = 0; i < this.size(); i++){
            if(this.elements()[i].equals(anElement))
                frequencyCount++;
        }
        return frequencyCount;
    }
    public T elementAt(int anOrder) {
        //anOrder을 인덱스로 가지는 원소 출력
        if (this.anElementDoesExistAt(anOrder))
            return this.elements()[anOrder];
        else
            return null;
    }
    public T first() {
        //List의 처음 원소를 반환
        if (this.isEmpty())
            return null;
        else
            return this.elements()[0];
    }
    public T last() {
        //List의 마지막 원소를 반환
        if (this.isEmpty())
            return null;
        else
            return this.elements()[this.size() - 1];
    }
    public int orderOf(T anElement) {
        //원소 anElement가 리스트 안에 존재하면 해당 위치를 반환
        for (int aPosition = 0; aPosition < this.size(); aPosition++)
            if (this.elements()[aPosition].equals(anElement))
                return aPosition;
        return -1;
    }
    private boolean anElementDoesExistAt(int anOrder) {
        //anOrder번째 위치에 원소가 존재하는지
        return (0 <= anOrder) && (anOrder < this.size());
    }
    //<내용 END>


    //<원소 삽입 START>
    public boolean addTo(T anElement, int anOrder) {
        //anElement를 anOrder를 인덱스롤 하는 배열에 삽입
        if (this.isFull())
            return false;
        if ((0 <= anOrder) && (anOrder <= this.size())) {
            for (int i = this._size; i > anOrder; i--) {
                this.elements()[i] = this.elements()[i - 1];
            }
            this.elements()[anOrder] = anElement;
            this.setSize(this.size() + 1);
            return true;
        } else
            return false;
    }
    public boolean addToFirst(T anElement) {
        //리스트 맨 처음에 anElement를 삽입
        return this.addTo(anElement, 0);
    }
    public boolean addToLast(T anElement) {
        //리스트 맨 마지막에 anElement를 삽입
        return this.addTo(anElement, this.size());
    }
    public boolean add(T anElement) {
        //리스트 중 가장 효과적인 곳에 삽입 = 맨 뒤
        return this.addToLast(anElement);
    }
    //<원소 삽입 END>


    //<원소 제거 START>
    public T removeFrom(int anOrder) {
        //inOrder를 인덱스로 하는 원소 삭제
        if (this.isEmpty())
            return null;
        T removedElement = null;
        if (this.anElementDoesExistAt(anOrder)) {
            removedElement = this.elements()[anOrder];
            for (int i = anOrder + 1; i < this.size(); i++) {
                this.elements()[i - 1] = this.elements()[i];
            }
            this.elements()[this.size() - 1] = null;
            this.setSize(this.size() - 1);
            return removedElement;
        } else
            return null;
    }
    public T removeFirst() {
        //리스트 맨 처음의 원소 삭제
        return this.removeFrom(0);
    }
    public T removeLast() {
        //리스트 맨 마지막의 원소 삭제
        return this.removeFrom(this.size() - 1);
    }

    public T removeAny() {
        //리스트 중 가장 효과적인 곳에 삭제 = 맨 뒤
        return this.removeLast();
    }

    public boolean remove(T anElement) {
        //원소 anElement를 삭제
        T result = this.removeFrom(this.orderOf(anElement));
        if (result.equals(anElement))
            return true;
        else
            return false;
    }
    //<원소 제거 START>


    public boolean replaceAt(T anElement, int anOrder) {
        if (this.anElementDoesExistAt(anOrder)) {
            this.elements()[anOrder] = anElement;
            return true;
        } else
            return false;
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++)
            this.elements()[i] = null;
        this.setSize(0);
    }

    public Iterator<T> iterator(){
        return new ListIterator();
    }


    public class ListIterator implements Iterator<T>{
        private int _nextPosition; //배열에서의 다음 원소 위치

        private ListIterator(){
            this._nextPosition = 0;
        }

        public boolean hasNext(){
            return (this._nextPosition < ArrayList.this.size());
        }

        public T next(){
            if (this._nextPosition < ArrayList.this.size()) {
                T nextElement = ArrayList.this.elements()[this._nextPosition];
                this._nextPosition++;
                return nextElement;
            }
            else return null;
        }
    }


}