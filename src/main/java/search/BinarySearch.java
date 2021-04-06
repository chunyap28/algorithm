package search;

import search.Search;

public class BinarySearch implements Search {

    public int search(int[] arr, int target) {
        int len = arr.length;
        if( len == 0 ) {
            return -1;
        }

        int l = 0;
        int r = len - 1;
        while( l <= r ) {
            int m = (l+r)/2;

            if( arr[m] == target ) {
                return m;
            } else if( arr[m] < target ) {
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return -1;
    }
}
