package sort.quicksort;

import sort.SortingAlgo;

import java.util.Arrays;

public class QuickSort implements SortingAlgo {

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    /*
    Take the right most as pivot,
    sort small than pivot to left
    sort greater than pivot to right
    recursive that same for left & right subarr
     */
    private void quickSort(int[] arr, int l, int r) {
        if( l >= r) {
            return;
        }

        int value = arr[r];
        int j = l;
        for(int i=l; i <= r-1; i++) {
            if( arr[i] <= value ) {
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        //swap the pivot
        arr[r] = arr[j];
        arr[j] = value;

        System.out.println(Arrays.toString(arr));
        quickSort(arr, l, j-1);
        quickSort(arr, j+1, r);
    }
}
