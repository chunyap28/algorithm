package sort.mergesort;

import sort.SortingAlgo;

import java.util.Arrays;

public class MergeSort implements SortingAlgo {

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private void mergeSort(int[] arr, int l, int r) {
        if( l < r ) {

            int m = (l+r)/2;

            //split
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);

            //merge
            merge(arr, l, m, r);
            //System.out.println(Arrays.toString(arr));
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i = 0; i < n1; i++) {
            arr1[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++) {
            arr2[i] = arr[m+1+i];
        }

        int j1 = 0, j2 = 0; //point to arr1, arr2
        int k = l;  //point to merged pos

        while(j1 < n1 && j2 < n2) {
            if( arr1[j1] <= arr2[j2] ) {
                arr[k] = arr1[j1];
                j1++;
            } else {
                arr[k] = arr2[j2];
                j2++;
            }
            k++;
        }

        for(int j = j1; j < n1; j++) {
            arr[k] = arr1[j];
            k++;
        }

        for(int j = j2; j < n2; j++) {
            arr[k] = arr2[j];
            k++;
        }
    }
}