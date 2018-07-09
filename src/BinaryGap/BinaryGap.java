/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryGap;

/**
 *
 * @author chunyap
 */
public class BinaryGap {
    public static int findBinaryGap(int A) {
        // write your code in Java SE 8
        int maxGap = 0;
        
        int currentGap = -1;
        for(int bit=0; bit<32; bit++){
            if( (A >> bit) == 0 ){
                break;
            }
            
            if( ((A >> bit) & 1) == 1 ){//is one
                System.out.printf("1");
                //complete current gap
                if( currentGap > maxGap ){
                    maxGap = currentGap;
                }

                //restart current gap
                currentGap = 0;
            }else{//is zero
                System.out.printf("0");
                if( currentGap >= 0 ){
                    currentGap++;
                }
            }
        }
        
        return maxGap;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("In main");

        System.out.printf("findBinaryGap Result: %d\n", findBinaryGap(1024));        
    }
}
