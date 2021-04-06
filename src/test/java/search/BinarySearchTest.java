package search;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BinarySearchTest {

    @Test
    public void testSearch_arrWithTarget_returnPos() {
        Search searchAlgo = new BinarySearch();

        int[] arr = {1,2,3,4,5,6,7};
        int target = 5;

        Assert.assertEquals(searchAlgo.search(arr, target), 4);
    }

    @Test
    public void testSearch_emptyArr_returnNegativeOne() {
        Search searchAlgo = new BinarySearch();

        int[] arr = {};
        int target = 5;

        Assert.assertEquals(searchAlgo.search(arr, target), -1);
    }

    @Test
    public void testSearch_SingleElementWithTarget_returnZero() {
        Search searchAlgo = new BinarySearch();

        int[] arr = {5};
        int target = 5;

        Assert.assertEquals(searchAlgo.search(arr, target), 0);
    }

    @Test
    public void testSearch_SingleElementWithoutTarget_returnNegativeOne() {
        Search searchAlgo = new BinarySearch();

        int[] arr = {1};
        int target = 5;

        Assert.assertEquals(searchAlgo.search(arr, target), -1);
    }

    @Test
    public void testSearch_MultipleElementWithoutTarget_returnNegativeOne() {
        Search searchAlgo = new BinarySearch();

        int[] arr = {1, 3, 6, 7};
        int target = 5;

        Assert.assertEquals(searchAlgo.search(arr, target), -1);
    }
}