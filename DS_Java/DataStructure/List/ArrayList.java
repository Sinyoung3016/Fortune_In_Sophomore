package DataStructure.List;

public class ArrayList<T> extends List<T> {

    private static int DEFAULT_CAPACITY = 100;

    private T [] _list;
    private int _size;
    private int _capacity;

    //<GETTER SETTER START>
    protected T[] list(){ return this._list; }
    private void setList(T[] newList) { this._list = newList; }
    protected void setSize(int newSize) { this._size = newSize; }
    private int capacity(){ return this._capacity; }
    private void setCapacity(int newCapacity){ this._capacity = newCapacity; }
    //<GETTER SETTER END>

    //<CONSTRUCTOR START>
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    public ArrayList(int givenCapacity){
        setCapacity(givenCapacity);
        setList( (T[]) new Object [this.capacity()] );
        setSize(0);
    }
    //<CONSTRUCTOR END>

    //<상태 START>
    @Override
    public boolean isEmpty() { return (this.size() == 0); }
    @Override
    public boolean isFull() { return (this.size() == this.capacity()); }
    @Override
    public int size() { return this._size; }
    //<상태 END>


    @Override
    public boolean doesContain(T anElement) {
        int n = this.size();
        for(int i = 0; i < n; i++) {
            if (this.list()[i].equals(anElement)) return true;
        }
        return false;
    }
    @Override
    public T elementAt(int anOrder) {
        T result = null;
        if( (0<=anOrder) && (anOrder<this.size()) ){
            result = this.list()[anOrder];
        }
        return result;
    }
    @Override
    public T first() {
        T result = null;
        if(!isEmpty())
            result = this.list()[0];
        return result;
    }
    @Override
    public T last() {
        T result = null;
        if(!isEmpty())
            result = this.list()[this.size()-1];
        return result;
    }
    @Override
    public int orderOf(T anElement) {
        int n = this.size();
        for(int i = 0; i < n; i++) {
            if (this.list()[i].equals(anElement)) return i;
        }
        return -1;
    }

    //<삽입 START>
    @Override
    public boolean addTo(T anElement, int anOrder) {
        //anElement를 anOrder를 인덱스롤 하는 배열에 삽입
        if(!isFull()){
            if( (0<=anOrder) && (anOrder<=this.size()) ){ //삽입 시 범위
                for(int i = this.size(); i > anOrder; i--)
                    this.list()[i] = this.list()[i-1];
                this.list()[anOrder] = anElement;
                this.setSize(this.size()+1);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean addToFirst(T anElement) {
        return this.addTo(anElement,0);
    }
    @Override
    public boolean addToLast(T anElement) {
        return this.addTo(anElement,this.size());
    }
    @Override
    public boolean add(T anElement) {
        //리스트 중 가장 효과적인 곳에 삽입 = 맨 뒤
        return addToLast(anElement);
    }
    //<삽입 END>

    //<제거 START>
    @Override
    public T removeFrom(int anOrder) {
        T result =  null;
        if(!isEmpty()){
            if( (0<=anOrder)&&(anOrder<this.size()) ){
                result = this.list()[anOrder];
                for(int i = (anOrder+1); i < this.size(); i++)
                    this.list()[i-1] = this.list()[i];
                this.setSize(this.size()-1);
            }
        }
        return result;
    }
    @Override
    public T removeFirst() {
        return removeFrom(0);
    }
    @Override
    public T removeLast() {
        return removeFrom(this.size()-1);
    }
    @Override
    public T removeAny() {
        //리스트 중 가장 효과적인 곳에 삭제 = 맨 뒤
        return this.removeLast();
    }
    @Override
    public boolean remove(T anElement) {
        //원소 anElement를 삭제
        T result = this.removeFrom(this.orderOf(anElement));
        if(result == null) return false;
        else return true;
    }
    //<제거 END>

    @Override
    public boolean replaceAt(T anElement, int anOrder) {
        if(!isEmpty()){
            if((0<=anOrder)&&(0<this.size())){
                this.list()[anOrder] = anElement;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.setSize(0);
        for(int i = 0; i< this.size(); i++)
            this.list()[i] = null;
    }

    public Iterator<T> iterator() { return new ListIterator(); }

    public class ListIterator implements Iterator<T>{

        private int _position;

        private int position(){return this._position; }
        private void setPosition(int newPosition){this._position = newPosition;}

        public boolean hasNext() { return (this.position() < ArrayList.this.size()); }

        public T next() {
            T result = null;
            if(this.hasNext()){
                result = ArrayList.this.list()[this.position()];
                this.setPosition(this.position()+1);
            }
            return result;
        }
    }

}
