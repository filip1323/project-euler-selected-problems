/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler24;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author filip1323@gmail.com
 */
public class ProjectEuler24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        final long startTime = System.currentTimeMillis();

        String[] chars = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        System.out.println(Arrays.toString(getPermutation(chars, 1000000))) ;
        
        
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
        
    }
    
    public static String[] getPermutation(String[] chars, int ordinal) throws Exception{
        if(ordinal > factorial(chars.length)) throw new Exception("Ordinal higher than permutations number!");
        return getPermutation(chars, getPermutationOrder(chars.length, ordinal));
    }
    
    public static String[] getPermutation(String[] chars, int[] order){
        String used = "";
        String[] permutation = new String[chars.length];
        
        for(int i = 0; i < order.length; i++){
            int e = 0;
            for(int step = 0; step < order[i]; step++){
                while(chars[e].equals(used)) e++;
                e++;
            }    
            while(chars[e].equals(used)) e++;
            permutation[i] = chars[e];
            chars[e] = used;
        }
        int e = 0;
        while(chars[e].equals(used)) e++;
        permutation[permutation.length - 1] = chars[e];
        
        return permutation;
        
    }
    
    public static int[] getPermutationOrder(int range, int ordinal){
        String numberPerm = "";
        int[] permutation = new int[range-1];
        int position = 0;
        int sum = 1;
        for(int currentPos = range-1; currentPos >= 1; currentPos--){
            for(int multiplier = currentPos; multiplier >= 0; multiplier--){
                int value = multiplier*factorial(currentPos);
                
                if(sum + value <= ordinal){
                    if(currentPos == 1 && ordinal%2==1 && multiplier == 1){
                        multiplier = 0;
                        value = 0;
                    }
                    sum+=value;
                    permutation[position++] = multiplier;
                    numberPerm = numberPerm + multiplier;
                    break;
                }
            }
        }
        return permutation;}
    
    public static int factorial(int base){
        int result = 1;
        for(int i = 1; i <= base; i++){
            result*=i;
        }
        return result;
    }
    
}
