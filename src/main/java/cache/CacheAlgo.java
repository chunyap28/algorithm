package cache;

public interface CacheAlgo<T> {
    void put(String key, T value);
    T get(String key);
    T delete(String key);
    void clearAll();
}
