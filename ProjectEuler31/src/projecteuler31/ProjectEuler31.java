package projecteuler31;

import java.util.ArrayList;

public class ProjectEuler31 {

    public static void main(String[] args) {
        int sum = 0;
        for (int c200 = 0; c200 <= 1; c200++) {
            for (int c100 = 0; c100 <= 2; c100++) {
                for (int c50 = 0; c50 <= 4; c50++) {
                    for (int c20 = 0; c20 <= 10; c20++) {
                        for (int c10 = 0; c10 <= 20; c10++) {
                            for (int c5 = 0; c5 <= 40; c5++) {
                                for (int c2 = 0; c2 <= 100; c2++) {
                                    for (int c1 = 0; c1 <= 200; c1++) {
                                        int value = c200*200+c100*100+c50*50+c20*20+c10*10+c5*5+c2*2+c1*1;
                                        if(value == 200){
                                            sum++;
                                            System.out.println(sum + ": " + c200 + "*200 +" + c100 + "*100 +" + c50 + "*50 +" + c20 + "*20 +" + c10 + "*10 +" + c5 + "*5 +" + c2 + "*2 +" + c1 + "*1");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
            System.out.println(sum);
    }
}
