package tree;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TranversalTest {

    private Node root;

    @BeforeMethod
    public void setup() {
        TreeConstructor constructor = new TreeConstructor();
        int[] data = {6,5,7,3,9,2,4};
        root = constructor.construct(data);
    }

    @Test
    public void testPreOrderTranverse() {
        List<Integer> expected = Arrays.asList(6,5,3,2,4,7,9);
        TreeTranversal preOrder = new PreOrderTranversal();
        Assert.assertEquals(preOrder.tranverse(root), expected);
    }

    @Test
    public void testInOrderTranverse() {
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 9);
        TreeTranversal inOrderTransversal = new InOrderTransversal();
        Assert.assertEquals(inOrderTransversal.tranverse(root), expected);
    }

    @Test
    public void testPostOrderTranverse() {
        List<Integer> expected = Arrays.asList(2, 4, 3, 5, 9, 7, 6);
        TreeTranversal postOrderTransversal = new PostOrderTransversal();
        Assert.assertEquals(postOrderTransversal.tranverse(root), expected);
    }
}