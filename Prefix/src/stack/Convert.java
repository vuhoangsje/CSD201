/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author vuhoa
 */
public class Convert {

    public static String convert(int n, int base){
        String S = "";
        Stack<Integer> stk = new Stack<Integer>();
        do {
            stk.push(n%base);
            n /= base;
        }while (n > 0);
        int x;
        while (!stk.empty()){
            x = stk.pop();
            S += Character.forDigit(x, base);
        }
        return S;
    }
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer");
        n = Integer.parseInt(sc.nextLine());
        System.out.println("Base 16: " + convert(n, 16));
        System.out.println("Base 10: " + convert(n, 10));
        System.out.println("Base 8: " + convert(n, 8) );
        System.out.println("Base 2: " + convert(n, 2));
    }
}
