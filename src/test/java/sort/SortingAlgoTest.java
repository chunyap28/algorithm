package sort;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sort.insertionsort.InsertionSort;
import sort.mergesort.MergeSort;
import sort.quicksort.QuickSort;

import java.util.ArrayList;
import java.util.List;

@Test
public class SortingAlgoTest {

    private List<SortingAlgo> sortingAlgos = new ArrayList<>();

    @BeforeTest
    public void setup() {
        sortingAlgos.add(new MergeSort());
        sortingAlgos.add(new InsertionSort());
        sortingAlgos.add(new QuickSort());
    }

    @Test
    public void testSort() {
        for(SortingAlgo sortingAlgo: sortingAlgos) {
            int[] arr = {5,3,6,4,7,1,9};
            int[] expected = {1,3,4,5,6,7,9};
            execute(arr, expected, sortingAlgo);
        }
    }

    @Test
    public void testSort_Empty() {
        for(SortingAlgo sortingAlgo: sortingAlgos) {
            int[] arr = {};
            int[] expected = {};
            execute(arr, expected, sortingAlgo);
        }
    }

    @Test
    public void testSort_Exstream() {
        for(SortingAlgo sortingAlgo: sortingAlgos) {
            int[] arr = {9,8,7,6,5,4,3,2,1};
            int[] expected = {1,2,3,4,5,6,7,8,9};
            execute(arr, expected, sortingAlgo);
        }
    }

    @Test
    public void testSort_Duplicate() {
        for(SortingAlgo sortingAlgo: sortingAlgos) {
            int[] arr = {1,1,1,9,1};
            int[] expected = {1,1,1,1,9};
            execute(arr, expected, sortingAlgo);
        }
    }

    private void execute(int[] arr, int[] expected, SortingAlgo sortingAlgo) {
        System.out.println("Testing Algo: " + sortingAlgo.getClass().getSimpleName());
        sortingAlgo.sort(arr);
        Assert.assertEquals(arr, expected, sortingAlgo.getClass().getSimpleName());
    }
}
