package DS_06;

public class UnSortedArrayList<T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 100;
    private int _capacity;
    private int _size;
    private T[] _elements;


    //<CONSTRUCTER START>
    public UnSortedArrayList() {
        //여기서 this는 객체 생성자를 의미
        this(UnSortedArrayList.DEFAULT_CAPACITY);
    }
    public UnSortedArrayList(int givenCapacity) {
        this.setCapacity(givenCapacity);
        this.setSize(0);
        this.setElement((T[]) new Comparable[givenCapacity]);
    }
    //<CONSTRUCTER END>

    //<GETTER SETTER START>
    public int capacity() { return _capacity; }
    public void setCapacity(int newCapacity) { this._capacity = newCapacity; }
    public int size() { return _size; }
    private void setSize(int newSize) { this._size = newSize; }
    private T[] elements() { return _elements; }
    private void setElement(T[] newElement) {this._elements = newElement; }
    //<GETTER SETTER END>

    public boolean addTo(T anElement, int anOrder) {
        //anElement를 anOrder를 인덱스롤 하는 배열에 삽입
        if (this.size() == this.capacity()) return false;
        if ((0 <= anOrder) && (anOrder <= this.size())) {
            for (int i = this.size(); i > anOrder; i--) {
                this.elements()[i] = this.elements()[i - 1];
            }
            this.elements()[anOrder] = anElement;
            this.setSize(this.size() + 1);
            return true;
        } else return false;
    }

    public boolean add(T anElement) {
        //리스트 중 가장 효과적인 곳에 삽입 = 맨 뒤
        return this.addTo(anElement, this.size());
    }

    public T max() {
        if (this.size() == 0) return null; //배열이 비어있는 경우
        else {
            T max = this.elements()[0];//배열의 처음값을 max로 설정
            for (int i = 1; i < this.size(); i++) { //순차적으로 비교
                if (max.compareTo(this.elements()[i]) < 0)
                    max = this.elements()[i];//max보다 큰값을 max로 재할당
            }
            return max;
        }
    }
}