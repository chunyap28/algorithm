package cache.lru;

import cache.CacheAlgo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LruTest {
    CacheAlgo<Integer> lruCache;

    @BeforeMethod
    public void setup() {
        lruCache = new Lru2<>(3);
    }

    public void testPut_SufficientSize() {
        lruCache.put("key1", 1);
        lruCache.put("key2", 2);
        lruCache.put("key3", 3);

        Assert.assertEquals(lruCache.get("key1"), Integer.valueOf(1));
        Assert.assertEquals(lruCache.get("key2"), Integer.valueOf(2));
        Assert.assertEquals(lruCache.get("key3"), Integer.valueOf(3));
    }

    public void testPut_HitMaxSize() {
        lruCache.put("key1", 1);
        lruCache.put("key2", 2);
        lruCache.put("key3", 3);
        lruCache.put("key4", 4);

        Assert.assertEquals(lruCache.get("key1"), null);
        Assert.assertEquals(lruCache.get("key2"), Integer.valueOf(2));
        Assert.assertEquals(lruCache.get("key3"), Integer.valueOf(3));
        Assert.assertEquals(lruCache.get("key4"), Integer.valueOf(4));
    }

    public void testPut_LRUDeleteFirstHitMaxSize() {
        lruCache.put("key1", 1);
        lruCache.put("key2", 2);
        lruCache.put("key3", 3);
        lruCache.get("key1");
        lruCache.get("key2");
        lruCache.put("key4", 4);

        Assert.assertEquals(lruCache.get("key1"), Integer.valueOf(1));
        Assert.assertEquals(lruCache.get("key2"), Integer.valueOf(2));
        Assert.assertEquals(lruCache.get("key3"), null);
        Assert.assertEquals(lruCache.get("key4"), Integer.valueOf(4));
    }

    public void testPut_DeleteAll() {
        lruCache.put("key1", 1);
        lruCache.put("key2", 2);
        lruCache.put("key3", 3);
        lruCache.delete("key1");
        lruCache.delete("key2");
        lruCache.delete("key3");
        lruCache.put("key4", 4);


        Assert.assertEquals(lruCache.get("key1"), null);
        Assert.assertEquals(lruCache.get("key2"), null);
        Assert.assertEquals(lruCache.get("key3"), null);
        Assert.assertEquals(lruCache.get("key4"), Integer.valueOf(4));
    }
}
