/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler44;

/**
 *
 * @author USER
 */
public class ProjectEuler44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //j: 2167, k: 1020
        System.out.println(getPentagonal(2167) - getPentagonal(1020));
        int j = 1;
        while(true){
            for(int k = 1; k < j; k++){
                if(isPentagonal(getPentagonal(j)+getPentagonal(k)) && isPentagonal(getPentagonal(j)-getPentagonal(k))) System.out.println("\nj: " + j +", k: " + k);
                //System.out.println((getPentagonal(j)+getPentagonal(k)) + " ::: " + (getPentagonal(j)-getPentagonal(k)));
            }
            System.out.print(".");
            if(j%30==0)System.out.println(j);
            j++;
        }
    }
    
    public static int getPentagonal(int n){
        return (int)((float)(n*(3*n-1)/2));
    }
    
    public static boolean isPentagonal(int n){
        int i = 0;
        while(true){
            int pentagonal = getPentagonal(i++);
            if(n == pentagonal) return true;
            if( pentagonal > n ) return false;
        }
    }
    
}
