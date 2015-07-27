/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler2;

/**
 *
 * @author USER
 */
public class ProjectEuler2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        values = new int[100];
        int sum = 0;
        int fibVal = 0;
        for(int i = 0; fibVal < 4000000; i++){
            fibVal = fib(i);
            if(fibVal < 4000000 && fibVal%2 == 0) sum+=fibVal;
            System.out.println(i + ": " + fibVal);
        }
        System.out.println("Sum: " + sum);
    }
    
    static int[] values;
    
    public static int fib(int k){
        
        if( values[k] != 0 ) return values[k];
        else if( k == 0 ) return 0;
        else if( k == 1 ) return 1;
        else{
            int n = (fib(k-2) + fib(k-1));
            values[k] = n;
            return n;
        }
        
    }
    
}
