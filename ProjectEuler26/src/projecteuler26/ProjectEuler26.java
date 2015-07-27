/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler26;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class ProjectEuler26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int number = 7;
        String longest_pattern = "";
        for(int base = 2; base < 1000; base++){
            String decimalRep;
            try {
                decimalRep = getDecimalRepresentation(base, 1000);
            } catch (Exception ex) {
                continue;
            }
            String pattern = "";
            try {
                 pattern = getPattern(decimalRep);
            } catch (Exception ex) {
                try {
                decimalRep = getDecimalRepresentation(base, 10000);
                    pattern = getPattern(decimalRep);
                } catch (Exception ex1) {
                }
            }
            
            if(pattern.length() > longest_pattern.length()){
                longest_pattern = pattern;
                number = base;
            }
            if(base % 30 == 0) System.out.println();
            System.out.print(".");
        }
        
        System.out.println("1/"+number + " =["+longest_pattern.length()+"] 0.(" + longest_pattern + ")");
    }
    
    public static String getDecimalRepresentation(int n, int length) throws Exception{
        String rep = "";
        int base = 10;
        while(rep.length() <= length + 2){
            if(n <= base){
                int r = base % n;
                rep += (base - r) / n;
                base = r;
            }
            else if(base!=0){
                base*=10;
            }else{
                rep += 0;
                throw new Exception();
            }
        }
        return rep;
    }
    
    static public String getPattern(String rep) throws Exception{
        for(int i = 1; i <= rep.length()/2 - 4; i++){
            String pattern = rep.substring(0, i);
            String match = rep.substring(i+1, 2*i+1);
            //System.out.println(pattern+"/"+match);
            if(pattern.equals(match)){
                return pattern;
            }
        }
        throw new Exception();
    }
    
}
