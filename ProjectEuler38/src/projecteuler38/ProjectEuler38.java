package projecteuler38;

import java.util.ArrayList;

public class ProjectEuler38 {

    public static void main(String[] args) {
        long greatest = 0;
        for(long n = 1; n <= 10000; n++){
            if(!isPandigital(n)) continue;
            ArrayList<Long> numbers = new ArrayList<Long>();
            long m = 1;
            while(getConnected(numbers).length() < 9){
                numbers.add(n*m++);
            }
//            System.out.println(n+":"+getConnected(numbers));
            if(getConnected(numbers).length() > 9) continue;
            if(isPandigital(Long.parseLong(getConnected(numbers)))){
                if(getConnected(numbers).contains("0")) continue;
                if(Long.parseLong(getConnected(numbers)) > greatest) greatest = Long.parseLong(getConnected(numbers));
//                System.out.println(n);
            }
        }
        System.out.println("---"+greatest);
    }
    public static String getConnected(ArrayList<Long> collection){
        String number = "";
        for(long n : collection){
            number += Long.toString(n);
        }
        return number;
    }
    public static boolean isPandigital(long n){
        String number = Long.toString(n);
        ArrayList<String> chopped = new ArrayList<String>();
        for(int i = 0; i < number.length(); i++){
            String currentDigit = number.substring(i,i+1); 
            if(chopped.contains(currentDigit)) return false;
            chopped.add(currentDigit);
        }
        return true;
        
    }
}
