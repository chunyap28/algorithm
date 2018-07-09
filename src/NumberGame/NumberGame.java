/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NumberGame;

/**
 *
 * @author chunyap
 */
public class NumberGame {
    public static boolean numberGame(int[] a){
        return isEnd(a, 0);
    }
    
    private static boolean isEnd(int[] a, int i){
        if( i >= (a.length-1) ){
            return true;
        }
        
        int val = a[i];
        boolean result = false;
        
        for(int j=1; j<=val; j++){            
            result = result || isEnd(a, i+j);
        }
        
        System.out.printf("testing %d - %d: %s\n", i, i+val, result?"true":"false");
        return result;
    }
    
    /**
     * @param args the command line arguments
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("In main");
                
        int[] numberGameArr = new int[]{2, 3, 0, 1};
        System.out.printf("numberGame: %s\n", numberGame(numberGameArr)? "true": "false");
    }
}
