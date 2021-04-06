package cache.lru;

import cache.CacheAlgo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Lru2<T> implements CacheAlgo<T> {

    private Map<String, T> cache = new HashMap<>();
    private LinkedList<String> linkedList = new LinkedList<>();
    int size;

    public Lru2(int size) {
        this.size = size;
    }

    @Override
    public void put(String key, T value) {
        if( cache.containsKey(key) ) {
            linkedList.remove(key);
            linkedList.add(key);
            cache.put(key, value);
        } else {
            if( cache.size() == size ) {
                String lastKey = linkedList.remove();
                cache.remove(lastKey);
            }

            linkedList.add(key);
            cache.put(key, value);
        }
    }

    @Override
    public T get(String key) {
        if( !cache.containsKey(key) ) {
            return null;
        }

        linkedList.remove(key);
        linkedList.add(key);
        return cache.get(key);
    }

    @Override
    public T delete(String key) {
        linkedList.remove(key);
        return cache.remove(key);
    }

    @Override
    public void clearAll() {
        cache.clear();
        linkedList.clear();
    }
}
