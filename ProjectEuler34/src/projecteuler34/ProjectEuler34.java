/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler34;

/**
 *
 * @author USER
 */
public class ProjectEuler34 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println("{");
//        for(int i = 0; i < 10; i++) System.out.println(factorial(i)+",");
//        System.out.println("}");
        int sum = 0;
        for(int i = 10; i < 100000000; i++){
            int sub = 0;
            int[] expanded = expand(i);
            for(int e = 0; e < expanded.length; e++){
                sub+= factorial(expanded[e]);
                if(sub > i) break;
            }
            if(sub == i){
                sum+=i;
                System.out.println(i);
            }
        }
        System.out.println("SUM: " + sum);
    }
    public static int[] expand(int base){
        int[] arr = new int[Integer.toString(base).length()];
        for(int i = 0; i < Integer.toString(base).length(); i++) arr[i] = Integer.parseInt(Integer.toString(base).substring(i,i+1));
        return arr;
    }
    public static int factorial(int base){
        int[] factorial = {
1,
1,
2,
6,
24,
120,
720,
5040,
40320,
362880
};
        return factorial[base];
//        //if(base == 0) return -1;
//        int result = 1;
//        for(int i = 1; i <= base; i++){
//            result*=i;
//        }
//        return result;
    }
}
