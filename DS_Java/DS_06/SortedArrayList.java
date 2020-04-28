package DS_06;

public class SortedArrayList <E extends Comparable<E>> {

    private static final int DEFAULT_CAPACITY = 100;

    private int _capacity;
    private int _size;
    private E[] _element;

    //<GETTER SETTER START>
    public int capacity(){ return this._capacity; }
    public void setCapacity(int newCapacity){ this._capacity= newCapacity; }
    public int size(){ return this._size; }
    public void setSize(int newSize){ this._size = newSize; }
    public E[] element(){ return this._element; }
    public void setElements(E[] newElements){ this._element = newElements; }
    //<GETTER SETTER END>

    //CONSTRUCTER START
    public SortedArrayList(){
        this(DEFAULT_CAPACITY);
    }
    @SuppressWarnings("unused")
    public SortedArrayList(int givenCapacity){
        this.setCapacity(givenCapacity);
        this.setElements((E []) new Comparable[this.capacity()]);
    }
    //CONSTRUCTER END

    public boolean add(E anElement) {
        if (this.size() == this.capacity()) return false; //배열이 전부 차있으면, 삽입 불가
        else {
            int aPosition; //원소가 삽입 할 위치
            for (aPosition = 0; aPosition < this.size(); aPosition++) {
                if (anElement.compareTo(this.element()[aPosition]) == -1) break;
            }

            if ((0 <= aPosition) && (aPosition <= this.size())) { //aPosition에 대한 범위 검사
                for (int i = this.size(); i > aPosition; i--) {
                    this.element()[i] = this.element()[i - 1]; //원소들 배열에서 한칸씩 뒤로 미루기
                }
                this.element()[aPosition] = anElement; //인덱스 aPosition에 anElement 삽입
                this.setSize(this.size() + 1); //크기 1 증가
                return true;
            } else return false;
        }
    }
    public E max(){ //최댓값, 배열 마지막에 있는 원소 출력
        if(this.size() == 0) return null;
        else return this.element()[this.size()-1];
    }
}
