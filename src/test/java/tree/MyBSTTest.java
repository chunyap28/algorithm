package tree;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MyBSTTest {

    @Test
    public void testTruncate() {
        BST bst = new MyBST();

        bst.add(8);

        bst.add(3);
        bst.add(1);
        bst.add(6);
        bst.add(4);
        bst.add(7);

        bst.add(10);
        bst.add(14);
        bst.add(13);

        Assert.assertEquals(bst.inOrderTranversal(), Arrays.asList(1, 3, 4, 6, 7, 8, 10, 13, 14));
        bst.truncate(7, 20);
        Assert.assertEquals(bst.inOrderTranversal(), Arrays.asList(7, 8, 10, 13, 14));
    }
}