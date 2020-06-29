package DataStructure.List;
/*
List
원소들이 순서 있게 나열
중복 또한 가능
 */
public abstract class List<T>{
    public List(){};

    //<상태 start>
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract int size();
    //<상태 end>

    //<내용 start>
    public abstract boolean doesContain(T anElement);
    public abstract T elementAt(int anOrder);
    public abstract T first();
    public abstract T last();
    public abstract int orderOf(T anElement);
    //<내용 end>

    public abstract boolean addTo(T anElement, int anOrder);
    public abstract boolean addToFirst(T anElement);
    public abstract boolean addToLast(T anElement);
    public abstract boolean add(T anElement);

    public abstract T removeFrom(int anOrder);
    public abstract T removeFirst();
    public abstract T removeLast();
    public abstract T removeAny();
    public abstract boolean remove(T anElement);

    public abstract boolean replaceAt(T anElement, int anOrder);
    public abstract void clear();

}
