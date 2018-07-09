/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FindMissing;

import java.util.HashSet;

/**
 *
 * @author chunyap
 */
public class FindMissing {
    public static int findMissing(int[] A) {
        // write your code in Java SE 8
        HashSet<Integer> elements = new HashSet<>();
        for(int a:A){
            elements.add(a);
        }
                
        int missing = 1;
        for(int n=1; n<=A.length; n++){
            if( !elements.contains(n)){
                missing = n;
                break;
            }else if( n == A.length){//last one
                missing = n+1;
            }
        }
        
        return missing;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("In main");
    }
}
