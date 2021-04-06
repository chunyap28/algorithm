package search;

public class RotatedSortedArray implements Search {

    /*
    3 4 5 6 1 2 x x x
    6 1 2 3 4 5
     */
    @Override
    public int search(int[] arr, int target) {
        return method2(arr, target);
    }

    public int method1(int[] arr, int target) {
        if( arr.length <= 0 ) {
            return -1;
        }

        int pivotPos = getPivotPosition(arr);
        if( target >= arr[0] ) {
            //search the first subarr
            return binarySearch(arr, 0, pivotPos, target);
        } else {
            //search the second subarr
            return binarySearch(arr, pivotPos+1, arr.length-1, target);
        }
    }

    public int method2(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;

        while( l <= r ) {
            int m = (l+r)/2;

            if( arr[m] == target ) {
                return m;
            }

            if( arr[m] > arr[l] ) {
                // 3 4 5 1 2
                if( arr[l] <= target && target < arr[m] ) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if( arr[m] < arr[l] ) {
                // 4 5 1 2 3 4
                if( arr[m] < target && target <= arr[r] ) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                // 1 1 1 2 1 1
                l++;
            }
        }

        return -1;
    }

    private int binarySearch(int[] arr, int l, int r, int target) {
        while( l <= r ) {
            int m = (l+r)/2;

            if( arr[m] == target ) {
                return m;
            }

            if( arr[m] < target ) {
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return -1;
    }

    private int getPivotPosition(int[] arr) {
        int len = arr.length;
        int l = 0;
        int r = len - 1;

        while( l < r ) {
            int m = (l + r) / 2;

            if( (m + 1) <= r && arr[m] > arr[m+1] ) {
                return m;
            }
            if( (m - 1) >= l && arr[m-1] > arr[m] ) {
                return m-1;
            }
            if( arr[m] <= arr[0] ) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return (len - 1);
    }
}
