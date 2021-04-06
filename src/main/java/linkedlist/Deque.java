package linkedlist;

public interface Deque<T> {
    void addFirst(T value);
    void addLast(T value);
    T removeFirst();
    T removeLast();
}
