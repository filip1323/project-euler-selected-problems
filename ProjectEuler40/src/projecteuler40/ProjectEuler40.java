package projecteuler40;

public class ProjectEuler40 {
    public static String[] fractionals;
    public static 
        int section = 1000;
    public static void main(String[] args) {
        fractionals = new String[1000];
        int i = 1;
        for (int indicator = 0; indicator < section; indicator++) {
            String fractional = "";
            if(indicator > 0){
                fractional = fractionals[indicator-1].substring(section);
            }
            for (; fractional.length() <= section; i++) {
                fractional += i;
            }
            fractionals[indicator] = fractional;
            System.out.print(".");
        }
//        for(int e = 1; e < 50; e++)
//        System.out.println(e+": " +getDigit(e));
        System.out.println(getDigit(1)*getDigit(10)*getDigit(100)*getDigit(1000)*getDigit(10000)*getDigit(100000)*getDigit(1000000));
    }
    
    
    public static int getDigit( int n){
        n-=1;
        int last = n%section;
        int main = (n-last)/section;
        return Integer.parseInt(fractionals[main].substring(last, last+1));
    }

}
