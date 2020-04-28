package DataStructure;
/*
List
원소들이 순서 있게 나열
중복 또한 가능
 */
public abstract class List {
    public List(){};

    //<상태 start>
    public abstract boolean isEmpty();
    public abstract boolean isFull();
    public abstract int size();
    //<상태 end>

    //<내용 start>
    public abstract boolean doesContain(Object anElement);
    public abstract Object elementAt(int anOrder);
    public abstract Object first();
    public abstract Object last();
    public abstract int orderOf(Object anElement);
    //<내용 end>

    public abstract boolean addTo(Object anElement, int anOrder);
    public abstract boolean addToFirst(Object anElement);
    public abstract boolean addToLast(Object anElement);
    public abstract boolean add(Object anElement);

    public abstract Object removeFrom(int anOrder);
    public abstract Object removeFirst();
    public abstract Object removeLast();
    public abstract Object removeAny();
    public abstract boolean remove(Object anElement);

    public abstract boolean replaceAt(Object anElement, int anOrder);
    public abstract void clear();
}
