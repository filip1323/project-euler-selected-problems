/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author USER
 */
public class ProjectEuler32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 1;
//        for(int i = 0; i < 100000; i++){
//           if(isPandigital(i)) System.out.println(" - "+i + ": " + isPandigital(i));
//        }
        int sum = 0;
        ArrayList<Integer> products = new ArrayList<>();
        for(int multiplier = 1; multiplier < 10000; multiplier++)
        for(int multiplicand = 1; multiplicand < 1000; multiplicand++){
            
            int product = multiplicand*multiplier;
            int connected = connect(multiplicand,multiplier,product); 
            if(connected == -1) continue;
            if(isPandigital(connected) && Integer.toString(connected).length() == 9 && !products.contains(product)){
                products.add(product);
                sum+=product;
                System.out.println((n++) + ": "+ multiplier + " * " + multiplicand + " = " + product);
            }
        }
        
            System.out.println(sum);
    }
    
    public static int connect(int n, int m, int k){
        String number = Integer.toString(n)+Integer.toString(m)+Integer.toString(k);
        if(number.length() > 9) return -1;
        return Integer.parseInt(number);
    }
    
    public static boolean isPandigital(int n){
        int[] number = new int[Integer.toString(n).length()];
        for(int i = 0; i < Integer.toString(n).length(); i++) number[i] = Integer.parseInt(Integer.toString(n).substring(i,i+1));
        
        LinkedList<Integer> taken = new LinkedList<>();
        
        for(int i = 0; i < number.length; i++){
            if(taken.contains(number[i])) return false;
            taken.add(number[i]);
        }
        
        Arrays.sort(number);
        
        if(number[0] != 1) return false;
        for(int i = 1; i < number.length; i++){
            if(number[i-1]+1 != number[i]) return false;
        }
        
        
        return true;
    }
    
}
