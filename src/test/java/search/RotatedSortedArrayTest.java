package search;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class RotatedSortedArrayTest {

    public void testSearch_rotatedArray() {
        int[] arr = {3,4,5,1,2};
        Search rotatedSearch = new RotatedSortedArray();

        Assert.assertEquals(rotatedSearch.search(arr, 3), 0);
        Assert.assertEquals(rotatedSearch.search(arr, 4), 1);
        Assert.assertEquals(rotatedSearch.search(arr, 5), 2);
        Assert.assertEquals(rotatedSearch.search(arr, 1), 3);
        Assert.assertEquals(rotatedSearch.search(arr, 2), 4);
        Assert.assertEquals(rotatedSearch.search(arr, 7), -1);
    }

    public void testSearch_duplicateRotatedArray() {
        int[] arr = {1,1,1,2,1,1};
        Search rotatedSearch = new RotatedSortedArray();

        Assert.assertEquals(rotatedSearch.search(arr, 2), 3);
    }

    public void testSearch_duplicateRotatedArray2() {
        int[] arr = {1,1,2,1,1,1};
        Search rotatedSearch = new RotatedSortedArray();

        Assert.assertEquals(rotatedSearch.search(arr, 2), 2);
    }

    public void testSearch_emptyArray() {
        int[] arr = {};
        Search rotatedSearch = new RotatedSortedArray();

        Assert.assertEquals(rotatedSearch.search(arr, 7), -1);
    }

    public void testSearch_singleElementArray() {
        int[] arr = {4};
        Search rotatedSearch = new RotatedSortedArray();

        Assert.assertEquals(rotatedSearch.search(arr, 4), 0);
        Assert.assertEquals(rotatedSearch.search(arr, 1), -1);
    }

    public void testSearch_notRotatedArray() {
        int[] arr = {1,2,3,4,5};
        Search rotatedSearch = new RotatedSortedArray();

        Assert.assertEquals(rotatedSearch.search(arr, 1), 0);
        Assert.assertEquals(rotatedSearch.search(arr, 2), 1);
        Assert.assertEquals(rotatedSearch.search(arr, 3), 2);
        Assert.assertEquals(rotatedSearch.search(arr, 4), 3);
        Assert.assertEquals(rotatedSearch.search(arr, 5), 4);
        Assert.assertEquals(rotatedSearch.search(arr, 7), -1);
    }
}