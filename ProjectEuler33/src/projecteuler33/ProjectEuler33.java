/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler33;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ProjectEuler33 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> numerators = new ArrayList<>();
        ArrayList<Integer> denominators = new ArrayList<>();
        for(int numerator = 1; numerator <= 9; numerator++)
            for(int denominator = 1; denominator <= 9; denominator++){
                for(int digit = 1; digit <= 9; digit++){
                    int lD = digit*10 + denominator;
                    int rD = denominator*10 + digit;
                    int lN = digit*10 + numerator;
                    int rN = numerator*10 + digit;
                    if(numerator/denominator >= 1 ) continue;
                    if(lN/(float)lD == numerator/(float)denominator){
                        System.out.println(lN+"/"+lD + " = " + numerator + "/"+denominator);
                        denominators.add(lD);
                        numerators.add(lN);
                    }
                    if(rN/(float)rD == numerator/(float)denominator){
                        System.out.println(rN+"/"+rD + " = " + numerator + "/"+denominator);
                        denominators.add(rD);
                        numerators.add(rN);
                    }
                    if(lN/(float)rD == numerator/(float)denominator){
                        System.out.println(lN+"/"+rD + " = " + numerator + "/"+denominator);
                        denominators.add(rD);
                        numerators.add(lN);
                    }
                    if(rN/(float)lD == numerator/(float)denominator){
                        System.out.println(rN+"/"+lD + " = " + numerator + "/"+denominator);
                        denominators.add(lD);
                        numerators.add(rN);
                    }
                }
            }
        int denominator = 1;
        int numerator = 1;
        for(int i = 0; i < numerators.size(); i++){
            int n = numerators.get(i);
            int d = denominators.get(i);
            denominator *= d;
            numerator *= n;
        }
        System.out.println(findLowestCommonDenominator(numerator, denominator));
    }
    
    public static int findCommonDenominator(ArrayList<Integer> denominators){
        int common = 1;
        for(int denom : denominators){
            common *= denom;
        }
        return common;
    }
    
    public static int findLowestCommonDenominator(int numerator, int denominator){
        System.out.println("..."+numerator +"/"+denominator);
        for(int i = 2; i <= numerator; i++){
            if( numerator % i == 0 && denominator % i == 0){
                System.out.print("("+i+")");
                return findLowestCommonDenominator(numerator/i, denominator/i);
            }
        }
        return denominator;
    }
    
}
