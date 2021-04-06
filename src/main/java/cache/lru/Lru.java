package cache.lru;

import cache.CacheAlgo;

import java.util.HashMap;
import java.util.Map;

public class Lru<T> implements CacheAlgo<T> {
    private int size;
    private Map<String, Node>  nodeIndex = new HashMap<>();
    private Node head;  //most recent
    private Node tail; //least recent

    public Lru(int size) {
        this.size = size;
    }

    @Override
    public void put(String key, T value) {
        if( nodeIndex.containsKey(key) ) {
            Node node = nodeIndex.get(key);
            node.data = value;
            //move to head
            removeNode(node);
            addNodeToHead(node);
        } else {//new key
            if( nodeIndex.size() == size ) {//hitting limit
                removeNode(tail);
            }

            Node node = new Node(key, value);
            addNodeToHead(node);
        }
    }

    @Override
    public T get(String key) {
        if( !nodeIndex.containsKey(key) ) {
            return null;    //or throw exception
        }

        Node node = nodeIndex.get(key);
        //move to head
        removeNode(node);
        addNodeToHead(node);
        return (T) node.data;
    }

    @Override
    public T delete(String key) {
        Node node = nodeIndex.get(key);
        removeNode(node);

        return (T) node.data;
    }

    @Override
    public void clearAll() {
        nodeIndex.clear();
        head = null;
        tail = null;
    }

    private void removeNode(Node node) {
        if( node.prev == null && node.next == null) {//it is the only node
            head = null;
            tail = null;
        } else if( node.prev == null ) {//it is head
            head = node.next;
            node.next = null;
            head.prev = null;
        } else if( node.next == null ) {//it is tail
            tail = node.prev;
            node.prev = null;
            tail.next = null;
        } else {//it is middle
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }

        nodeIndex.remove(node.key);
    }

    private void addNodeToHead(Node node) {
        if( head == null && tail == null ) {
            head = node;
            tail = node;
        }else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        nodeIndex.put(node.key, node);
    }
}

class Node<T> {
    String key;
    T data;
    Node prev;
    Node next;

    public Node(String key, T data) {
        this.key = key;
        this.data = data;
    }
}
