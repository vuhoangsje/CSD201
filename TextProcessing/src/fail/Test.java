/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fail;

/**
 *
 * @author vuhoa
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void printArray(int a[]){
        for (int x: a) System.out.print(x + ", ");
    } 
    public static void main(String[] args){   
        String S2= "bacbabababacaca";
        String pattern=  "ababaca"; // found at position 6
        int fail[] = computer.computperFailKMP(pattern.toCharArray());
        System.out.println("Pattern:" + pattern);
        System.out.print("fail[] :");
        printArray(fail);
        System.out.println("\nPattern at position:" + 
                   computer.indexOf_KMP(S2, pattern));
    }
} // End of the MyStrMatcher class
