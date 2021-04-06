package cache.lfu;

import cache.CacheAlgo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class LfuTest {

    CacheAlgo<Integer> lfu;

    @BeforeMethod
    public void setup() {
        lfu = new Lfu<>(3);
    }

    public void testPut_SufficientSize() {
        lfu.put("key1", 1);
        lfu.put("key2", 2);
        lfu.put("key3", 3);

        Assert.assertEquals(lfu.get("key1"), Integer.valueOf(1));
        Assert.assertEquals(lfu.get("key2"), Integer.valueOf(2));
        Assert.assertEquals(lfu.get("key3"), Integer.valueOf(3));
    }

    public void testPut_HitMaxSize() {
        lfu.put("key1", 1);
        lfu.put("key2", 2);
        lfu.put("key3", 3);
        lfu.put("key4", 4);

        Assert.assertEquals(lfu.get("key1"), null);
        Assert.assertEquals(lfu.get("key2"), Integer.valueOf(2));
        Assert.assertEquals(lfu.get("key3"), Integer.valueOf(3));
        Assert.assertEquals(lfu.get("key4"), Integer.valueOf(4));
    }

    public void testPut_LeastFreqUse() {
        lfu.put("key1", 1);
        lfu.put("key2", 2);
        lfu.put("key3", 3);
        lfu.get("key1");
        lfu.get("key1");
        lfu.get("key1");
        lfu.get("key2");
        lfu.get("key2");
        lfu.put("key4", 4);
        lfu.put("key5", 5);

        Assert.assertEquals(lfu.get("key1"), Integer.valueOf(1));
        Assert.assertEquals(lfu.get("key2"), Integer.valueOf(2));
        Assert.assertEquals(lfu.get("key3"), null);
        Assert.assertEquals(lfu.get("key4"), null);
        Assert.assertEquals(lfu.get("key5"), Integer.valueOf(5));
    }
}
