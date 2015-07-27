/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler36;

/**
 *
 * @author USER
 */
public class ProjectEuler36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1000000; i++){
            if(isDecimalPalindromic(i) && isBinaryPalindromic(i)){
                sum+=i;
//                System.out.println(i);
            }
            if(i%10000 == 0) System.out.print(".");
        }
        System.out.println(sum);
    }
    
    public static boolean isDecimalPalindromic(int n){
        String number = Integer.toString(n);
        String reversed = new StringBuilder(number).reverse().toString();
        return number.equals(reversed);
    }
    
    public static boolean isBinaryPalindromic(int n){
        String number = Integer.toBinaryString(n);
        String reversed = new StringBuilder(number).reverse().toString();
        return number.equals(reversed);
    }
    
}
