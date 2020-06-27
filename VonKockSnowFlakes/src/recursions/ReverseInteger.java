/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursions;

import java.util.Stack;

/**
 *
 * @author vuhoa
 */
public class ReverseInteger {
    public static void printReverse1(int n){
        if (n < 0){
            return;
        }
        System.out.print(n%10);
        n = n/10;
        if (n > 0) {
            printReverse1(n);
        }
    }
    public static void printReverse2(int n){
        if (n < 0) {
          return;
        }
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(n);
        while (!stk.empty()) {                
            int x;
            x = stk.pop();
            System.out.print(x%10);
            x /= 10;
            if (x > 0) {
                stk.push(x);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 123098;
        printReverse1(n);
        System.out.println();
        printReverse2(n);
        System.out.println();
    }
    
}
