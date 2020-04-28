package DS_03;

public class ArrayBag<E> {
    private static final int DEFALUT_CAPACITY = 100;
    private int _capacity;
    private int _size;
    private E _elements[];

    //<생성자 start>
    public ArrayBag() {
        this._capacity = DEFALUT_CAPACITY;
        this._elements = (E[]) new Object[_capacity];
        this._size = 0;
    }
    public ArrayBag(int givenCapacity) {
        this._capacity = givenCapacity;
        this._elements = (E[]) new Object[_capacity];
        this._size = 0;
    }
    //<생성자 end>

    //<getter setter start>
    private int capacity() { return this._capacity; }
    private void setCapacity(int newCapacity) { this._capacity = newCapacity; }
    public int size() { return _size; }
    private void setSize(int newSize) { this._size = newSize; }
    private E[] elements() { return this._elements; }
    private void setElements(E[] newElements) { this._elements = newElements; }
    //<getter setter end>

    public boolean isEmpty() {
        if (_size == 0) return true;
        return false;
    }
    public boolean isFull() {
        if (_size == _capacity) return true;
        return false;
    }
    // anElement의 존재여부
    public boolean doesContain(E anElement) {
        for (int i = 0; i < _size; i++) {
            if (_elements[i].equals(anElement)) return true;
        }
        return false;
    }
    // anElement의 빈도수
    public int frequencyOf(E anElement){
        int frequencyCount = 0;
        for(int i = 0; i < _size; i++){
            if(_elements[i].equals(anElement))
                frequencyCount++;
        }
        return frequencyCount;
    }
    // anElement를 추가
    public boolean add(E anElement){
        //가방이 전부 채워져 있는 경우
        if(isFull()) return false;

        _elements[_size] = anElement;
        _size++;
        return true;
    }
    // anElement를 제거
    public boolean remove(E anElement){
        //가방이 비어있는 경우
        if(isEmpty()) return false;
        //가방에 해당값이 존재하지 않는 경우
        if(!doesContain(anElement)) return false;

        //가장 작은 인덱스에 있는 해당값을 삭제
        int target = 0;
        for(int i = 0; i < _size; i++){
            if (_elements[i].equals(anElement)) {
                target = i;
                break;
            }
        }
        //빈칸을 매우기 위해 앞으로 한칸씩 옮김
        for(int i = target; i < _size -1 ; i++){
            this.elements()[i] = this.elements()[i + 1];
        }
        //하나 삭제 되었으므로 _size 1감소하고 가장 큰인덱스 값을 null값 처리
        _size--;
        _elements[_size] = null;
        return true;
    }
    //배열을 초기화
    public void clear(){
        E [] newElements = (E[]) new Object[_capacity];
        setElements(newElements);
    }
    //anOrder를 index로 가지고 있는 원소값을 반환
    public E elementAt(int anOrder){
        if((0 <= anOrder) && (anOrder < this.size()))
            return this.elements()[anOrder];
        return null;
    }
}