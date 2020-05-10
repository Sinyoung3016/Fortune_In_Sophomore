package DS_09;

public interface Stack<E> {
    public int size();
    public boolean isFull();
    public boolean isEmpty();
    public boolean push(E anElement);
    //anElement를 스택의 맨 위에 추가
    public E pop();
    //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환하고 제거
    public E peek();
    //비어져 있는 스택이 아니면, 가장 꼭대기의 원소를 반환
    public void clear();
}
