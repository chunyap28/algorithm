/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EasyPattern;

/**
 *
 * @author chunyap
 */
public class EasyPattern {
    public static void draw(int n){
        int size = (n-1)*2+1;
        char[][] patterns = new char[size][size];
        
        char pattern = 'x';
        int gap = 0;
        int half = (int) Math.ceil(n/2.0);
        for(int i=0; i<half; i++){
            for(int j=0; j<n-gap; j++){
                patterns[n-1+j][j+gap] = pattern;
                patterns[j+gap][n-1+j] = pattern;
            }
            
            if( pattern == 'x' ){
                pattern = 'o';
            }else{
                pattern = 'x';
            }
            
            gap += 2;            
        }
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if( patterns[i][j] == 'x' ){
                    System.out.printf("x");
                }else if( patterns[i][j] == 'o' ){
                    System.out.printf("o");
                }else{
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.printf("In main");       
        System.out.printf("draw easy pattern Result: \n");                
        draw(100);        
    }
}
