/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler27;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ProjectEuler27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        primes = new ArrayList<>();
        ordinars = new ArrayList<>();
        int longestConsecutive = 0;
        int product = 0;
        
        for(int a = -9999; a < 10000; a++)
        for(int b = -9999; b < 10000; b++){
          
            if(!isPrime(b)) continue;
            int currentConsecutive = testCoefficients(a, b);
            if(currentConsecutive > longestConsecutive){
                product = a*b;
                System.out.println(a + " & " + b + " => " + currentConsecutive + " ||| " + ((a+10000)/200f)+"%");
                longestConsecutive = currentConsecutive;
            }
        }
        
        System.out.println(product);
        
        
    }
    
    
    static int testCoefficients(int a, int b){
       int n = 0;
       while(true){
           if(!isPrime(n*n + n*a + b)) break;
           n++;
       }
       return n;
    }
    
    static ArrayList<Integer> primes;
    static ArrayList<Integer> ordinars;
    
    public static boolean isPrime(int n){
        if(n < 0) n = -n;
        if(primes.contains(n)) return true;
        else if(ordinars.contains(n)) return false;
        
        for(int k = 2; k < n; k++){
            if(n%k == 0){
                ordinars.add(n);
                return false;
            }
        }
        
        primes.add(n);
        return true;
    }
}
