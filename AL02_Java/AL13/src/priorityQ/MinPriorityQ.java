package priorityQ;

public abstract class MinPriorityQ<T> {
	public abstract int size();
	public abstract T removeMin();
	public abstract T min();
	public abstract boolean add(T element);
	public abstract boolean isFull();
	public abstract boolean isEmpty();
}
