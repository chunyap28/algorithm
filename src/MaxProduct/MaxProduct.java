/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaxProduct;

import java.util.Arrays;

/**
 *
 * @author chunyap
 */
public class MaxProduct {
    public static int findMaxProduct(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int product = 1;
        if(A.length == 0) return 0;
        for(int i= A.length -1 ; i > A.length - 4 ; i-- ){
            product *= A[i];
        }
        
        if(A[0] < 0 && A[1] < 0) {
            product = (A[0]*A[1]*A[A.length-1]) > product ?(A[0]*A[1]*A[A.length-1]):product;
        }
        
        return product;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("In main");
        
        int[] maxProductArray = new int[]{4, 5, 1, 0 };
        System.out.printf("findMaxProduct Result: %d\n", findMaxProduct(maxProductArray));
    }
}
