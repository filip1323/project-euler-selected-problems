/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler37;

import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class ProjectEuler37 {

    /**
     * @param args the command line arguments
     */
    
    static int greatest_prime = 11;
    
    static LinkedList<Integer> primes, truncatable_primes;
    public static void main(String[] args) {
        int sum = 0;
        truncatable_primes = new LinkedList<>();
        int n = 8;
        while(truncatable_primes.size()<11){
            if(isPrime(n) && isTruncatablePrime(n) && n > 9){
                truncatable_primes.add(n);
                System.out.println(truncatable_primes.size()+":"+n);
                sum += n;
            }
            
            n++;
            
            if(n%10000 == 0) System.out.print(".");
        }
        System.out.println("Sum: " + sum);
    }
    
    public static boolean isPrime(int n){
        if(n == 1 || n == 0) return false;
        
        double sqrt = Math.sqrt(n);
        for(int divisior = 2; divisior <= sqrt; divisior++){
            if( n % divisior == 0 ) return false;
        }
        
        
        return true;
    }
    
    public static boolean isTruncatablePrime(int n){
        String msg = n+" truncatables... ";
        String number = Integer.toString(n);
        
        LinkedList<Integer> truncated = new LinkedList<>();
        
        for(int i = 1; i <= number.length(); i++){
            truncated.add(Integer.parseInt(number.substring(0, i)));
            
            truncated.add(Integer.parseInt(number.substring(i-1, number.length())));
        }
        for(int trunc : truncated){
            msg += " " + trunc;
        }
//        System.out.println(msg);
        for(int trunc : truncated){
            if(!isPrime(trunc)) return false;
        }
        
        return true;
    }
}
