/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler43;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ProjectEuler43 {

    /**
     * @param args the command line arguments
     */
    public static int[] primes = new int[]{2,3,5,7,11,13,17};
    public static void main( String[] args) {
        BigInteger sum = BigInteger.ZERO;
        String[] base = new String[]{"0","1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (long i = factorial(base.length); i > 0; i--) {
                String[] chars = new String[base.length];
                System.arraycopy(base, 0, chars, 0, base.length);
                String[] number;
                try {
                    number = getPermutation(chars, i);
                } catch (Exception ex) {
                    continue;
                }
                String tempNumber = "";
                for (int n = 0; n < chars.length; n++) {
                    tempNumber += number[n];
                }
                if(isWanted(tempNumber)){
                    long finalNumber = Long.parseLong(tempNumber);
                    System.out.println(finalNumber);
                    sum = sum.add(BigInteger.valueOf(finalNumber));
                }
            }
            System.out.println(sum);
    }
    
    public static boolean isWanted(String number){
        for(int i = 0; i <=6; i++){
            int subNumber = Integer.parseInt(number.substring(i+1, i+4)); 
            //System.out.println(subNumber + " % " + primes[i] + " = " + subNumber % primes[i]);
            if(subNumber%primes[i] != 0) return false;
        }
        
        return true;
    }

    public static boolean isPandigital(long n) {
        String number = Long.toString(n);
        ArrayList<String> chopped = new ArrayList<String>();
        for (int i = 0; i < number.length(); i++) {
            String currentDigit = number.substring(i, i + 1);
            if (chopped.contains(currentDigit)) {
                return false;
            }
            chopped.add(currentDigit);
        }
        return true;

    }

    public static boolean isPrime(long n) {
        if (n == 1 || n == 0) {
            return false;
        }

        double sqrt = Math.sqrt(n);
        for (long divisior = 2; divisior <= sqrt; divisior++) {
            if (n % divisior == 0) {
                return false;
            }
        }

        return true;
    }

    public static String[] getPermutation(String[] chars, long ordinal) throws Exception {
        if (ordinal > factorial(chars.length)) {
            throw new Exception("Ordinal higher than permutations number!");
        }
        return getPermutation(chars, getPermutationOrder(chars.length, ordinal));
    }

    public static String[] getPermutation(String[] chars, int[] order) {
        String used = "";
        String[] permutation = new String[chars.length];

        for (int i = 0; i < order.length; i++) {
            int e = 0;
            for (int step = 0; step < order[i]; step++) {
                while (chars[e].equals(used)) {
                    e++;
                }
                e++;
            }
            while (chars[e].equals(used)) {
                e++;
            }
            permutation[i] = chars[e];
            chars[e] = used;
        }
        int e = 0;
        while (chars[e].equals(used)) {
            e++;
        }
        permutation[permutation.length - 1] = chars[e];

        return permutation;

    }

    public static int[] getPermutationOrder(int range, long ordinal) {
        String numberPerm = "";
        int[] permutation = new int[range - 1];
        int position = 0;
        int sum = 1;
        for (int currentPos = range - 1; currentPos >= 1; currentPos--) {
            for (int multiplier = currentPos; multiplier >= 0; multiplier--) {
                int value = multiplier * factorial(currentPos);

                if (sum + value <= ordinal) {
                    if (currentPos == 1 && ordinal % 2 == 1 && multiplier == 1) {
                        multiplier = 0;
                        value = 0;
                    }
                    sum += value;
                    permutation[position++] = multiplier;
                    numberPerm = numberPerm + multiplier;
                    break;
                }
            }
        }
        return permutation;
    }

    public static int factorial(int base) {
        int result = 1;
        for (int i = 1; i <= base; i++) {
            result *= i;
        }
        return result;
    }

}
