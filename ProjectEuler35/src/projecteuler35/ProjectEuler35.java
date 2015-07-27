/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler35;

import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class ProjectEuler35 {

    /**
     * @param args the command line arguments
     */
    static public LinkedList<Integer> primes;
    public static void main(String[] args) {
        primes = new LinkedList<Integer>();
        primes.add(2);
        primes.add(3);
        
        for(int i = 4; i < 1000000; i++){
            isPrime(i, false);
            if(i % 10000 == 0) System.out.print(".");
            //System.out.println(i);
        }
        System.out.println("\nPrimes: " + primes.size());
        int sum = 0;
        int temp = 1;
        LinkedList<Integer> primestemp = new LinkedList<>(primes);
        for(int prime : primestemp){
            //System.out.print(".");
            boolean flag = false;
            for(int e : rotate(prime)){
                if(!isPrime(e, true)){
                    //System.out.println(e+" is not prime ;/");
                    flag = true;
                    break;
                };
            }
            if(flag) continue;   
            System.out.println(temp++ + ": " + prime);
            sum++;
        }
        System.out.println("SUM: " + sum);
        
    }
    
    static public int[] rotate(int n){
        String number = Integer.toString(n);
        int[] rotations = new int[number.length()-1];
        for(int i = 1; i < number.length(); i++){
            String subNumber = number.substring(i, number.length()) + number.substring(0, i);
            rotations[i-1] = (Integer.parseInt(subNumber));
            //System.out.println(subNumber);
        }
        return rotations;
    }
    
    static public boolean isPrime(int n, boolean onlyArray){
        if(n==0 || n==1)return false;
//        if(primes.contains(n)) return true;
//        if(onlyArray) return false;
//        int greatest = 3;        
        double sqrt = Math.sqrt(n);
        for(int checked : primes){
            if(checked > sqrt){
                primes.add(n);
                return true;
            }
            if( n % checked == 0 ) return false;
//            if(greatest < checked) greatest = checked;
        }

        for(int i = 3; i <= sqrt; i+=2){
            if( n % i == 0 ) return false; 
        }
        primes.add(n);
        
        return true;
    }
    
    
    
}
