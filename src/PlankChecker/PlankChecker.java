/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlankChecker;

import java.util.HashMap;

/**
 *
 * @author chunyap
 */
public class PlankChecker {
    static HashMap<Integer, Integer> coveredByMin;
    
    public static int findPlank(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8
        //Arrays.sort(C);
        
        //binary search C
        int low = 0;
        int high = C.length-1;
        int lastFound = -2;
        coveredByMin = new HashMap<>();
        
        while(low <= high){
            int mid = ((high-low)/2) + low;
            
            //System.out.printf("low: %d, high: %d, mid: %d ", low, high, mid);
            if( ableToPlankAll(A, B, C, mid) ){
                //System.out.printf("ABLE\n");
                lastFound = mid;
                
                if( high == mid){
                    break;
                }else{
                    high = mid;    
                }
                
                
            }else{
                //System.out.printf("NO\n");
                low = mid+1;
            }
        }
        
        
        return lastFound+1;
    }
    
    private static boolean ableToPlankAll(int[] A, int[] B, int[] C, int mid){
        for(int i=0; i<A.length; i++){
            boolean ok = false;
            if( coveredByMin.containsKey(i) && 
                coveredByMin.get(i) <= mid ){//its covered
                ok = true;
            }else{
                for(int j=0; j<=mid; j++){
                    if( ableToPlank(A[i], B[i], C[j]) ){
                        if( !coveredByMin.containsKey(i) ||
                             coveredByMin.get(i) > j){
                            coveredByMin.put(i, j);
                        }

                        ok = true;
                        break;
                    }
                }
            }
            
            if( !ok ){
                //System.out.printf("\n %d not ok\n", mid);
                return false;
            }
        }
        
        //System.out.printf("\n %d ok\n", mid);
        return true;
    }
    
    private static boolean ableToPlank(int A, int B, int C){
        return (A<=C && C<=B);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("In main");
        int[] A = new int[]{1,4,5,8};
        int[] B = new int[]{4,5,9,10};
        int[] C = new int[]{4,6,7,10,2};
        System.out.printf("findPlank Result: %d\n", findPlank(A,B,C));        
    }
}
