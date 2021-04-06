package linkedlist;

public class MyDeque<T> implements Deque<T> {

    Node<T> head = null;
    Node<T> tail = null;

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        if( head == null ) {
            addOnEmptyList(newNode);
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    @Override
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if( head == null ) {
            addOnEmptyList(newNode);
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    private void addOnEmptyList(Node node) {
        head = node;
        tail = node;
    }

    @Override
    public T removeFirst() {
        if( head == null ) {
            return null;
        }

        if( head == tail ) {//single element
            return removeSingleElement();
        }

        T val = head.value;
        head = head.next;
        head.prev = null;
        return val;
    }

    @Override
    public T removeLast() {
        if( head == null ) {
            return null;
        }

        if( head == tail ) {//single element
            return removeSingleElement();
        }

        T val = tail.value;
        tail = tail.prev;
        tail.next = null;
        return val;
    }

    private T removeSingleElement() {
        T val = head.value;
        head = null;
        tail = null;
        return val;
    }
}

class Node<T> {
    T value;
    Node next;
    Node prev;

    public Node(T value) {
        this.value = value;
    }
}