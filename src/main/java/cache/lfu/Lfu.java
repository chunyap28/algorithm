package cache.lfu;

import cache.CacheAlgo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Lfu<T> implements CacheAlgo<T> {

    Map<Integer, LinkedList<String>> freqMap = new HashMap<>();
    Map<String, Node> cache = new HashMap<>();
    int size;
    int currentMin = 0;

    public Lfu(int size) {
        this.size = size;
    }

    @Override
    public void put(String key, T value) {
        Node<T> node;
        if( !cache.containsKey(key) ) {//new
            if( cache.size() == size ) {
                //remove lfu
                removeLeastFrequent();
            }

            currentMin = 0;
            node = new Node<>(key, value);
            cache.put(key, node);
        } else {
            node = cache.get(key);
            node.value = value;
        }

        increaseFreq(node);
    }

    @Override
    public T get(String key) {
        if( !cache.containsKey(key) ) {
            return null;
        }

        Node<T> node = cache.get(key);
        increaseFreq(node);
        return node.value;
    }

    @Override
    public T delete(String key) {
        if( !cache.containsKey(key) ) {
            return null;
        }

        Node<T> node = cache.get(key);
        LinkedList<String> list = freqMap.get(node.freq);
        list.remove(key);
        return node.value;
    }

    @Override
    public void clearAll() {
        cache.clear();
        freqMap.clear();
        currentMin = 0;
    }

    private void removeLeastFrequent() {
        LinkedList<String> linkedList = freqMap.get(currentMin);
        System.out.println(linkedList);
        String key = linkedList.remove();
        cache.remove(key);
    }

    private void increaseFreq(Node node) {
        int count = node.freq;
        boolean hasItemAtCount = false;
        if( freqMap.containsKey(count) ) { ;
            LinkedList<String> linkedList = freqMap.get(count);
            linkedList.remove(node.key);
            hasItemAtCount = linkedList.size() > 0;
            System.out.printf("removed from, count: %d, list: %s\n", count, linkedList.toString());
        }

        node.freq++;
        if( freqMap.containsKey(count+1) ) {
            LinkedList<String> linkedList = freqMap.get(count+1);
            linkedList.add(node.key);
            System.out.printf("added to, count: %d, list: %s\n", count+1, linkedList.toString());
        } else {
            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.add(node.key);
            freqMap.put(count+1, linkedList);
            System.out.printf("added to, count: %d, list: %s\n", count+1, linkedList.toString());
        }

        if( currentMin == count && !hasItemAtCount ) {
            currentMin++;
        }
    }
}

class Node<T> {
    String key;
    T value;
    int freq;

    public Node(String key, T value) {
        this.key = key;
        this.value = value;
        this.freq = 0;
    }
}
