package tree;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TreeConstructorTest {

    @Test
    public void testConstruct() {
        TreeConstructor constructor = new TreeConstructor();

        int[] data = {6,5,7,3,9,1,2};
        Node root = constructor.construct(data);
        Assert.assertEquals(root.data, Integer.valueOf(6));
    }
}