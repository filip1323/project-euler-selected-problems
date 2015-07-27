/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler29;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class ProjectEuler29 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<BigInteger> existing = new ArrayList<>();
        for(int a = 2; a <= 100; a++){
            System.out.print(".");
            for(int b = 2; b <= 100; b++){
                BigInteger result = pow(a, b);
                if(!existing.contains(result)) existing.add(result);
            }
        }
        
        System.out.println(existing.size());
        
    }
    
    public static BigInteger pow(int base, int power){
        BigInteger a = BigInteger.valueOf(base);
        for(int i = 1; i < power; i++){
            a = a.multiply(BigInteger.valueOf(base));
        }
        return a;
    }
    
}
