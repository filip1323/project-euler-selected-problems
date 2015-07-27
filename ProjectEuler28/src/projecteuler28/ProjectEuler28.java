/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler28;

/**
 *
 * @author USER
 */
public class ProjectEuler28 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for(int i = 1; i <= 1001; i+=2)
        System.out.println(i+": "+count(i));
        
    }
    
    public static int count(int size){
        int sum = 0;
        int distance = 2;
        int counter = 0;
        for(int step = 1; step <= size*size; step+=distance, counter++){
            sum+=step;
            if(counter == 4){
                counter = 0;
                distance+=2;
            }
        }
        
        return sum;
    }
    
}
