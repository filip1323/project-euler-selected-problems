package projecteuler39;

import java.util.ArrayList;

public class ProjectEuler39 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> setups = new ArrayList<>();
        for(int p = 0; p <= 1000; p++) setups.add(p, new ArrayList<Integer>());
        for(int a = 1; a < 1000; a++){
            for(int b = 1; b < 1000; b++){
                double c = Math.sqrt(a*a +b*b);
                if( a + b + c > 1000 ){
                    break;
                }else if((int)c == c){
                    if(!setups.get((int)(a+b+c)).contains(a))
                    setups.get((int)(a+b+c)).add(a);
                    System.out.println(a + " + " + b + " + " + c + " = " + (a+b+c));
                }
                
            }
        }
        int greatest = 0;
        int saved = 0;
        for(int p = 0; p <= 1000; p++){
            if(setups.get(p).size() > greatest){
                greatest = setups.get(p).size();
                saved = p;
            }
        }
        System.out.println(saved+"   ---   "+greatest);
    }
    
}
