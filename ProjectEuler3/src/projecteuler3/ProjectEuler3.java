/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler3;

/**
 *
 * @author USER
 */
public class ProjectEuler3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        long n = 600851475143;
        System.out.println(n/leastPrimeFactor(n));
        
    }
    
    public static int leastPrimeFactor(int k){
        for(int i = 2; i <= k; i++){
            if(k % i == 0) return i;
        }
        return k;
    }
    
}
