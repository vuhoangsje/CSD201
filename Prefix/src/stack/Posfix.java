/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author vuhoa
 */
public class Posfix {
    static double evaluatePosFixExp(String exp){
        double result = 0 ;
        StringTokenizer stk = new StringTokenizer(exp, "() ");
        Stack<Double> stack = new Stack<Double>();
        while (stk.hasMoreTokens()){
            String S = stk.nextToken();
            if(!S.equals("+") && !S.equals("-") &&
               !S.equals("*") && !S.equals("/")){
                stack.push(Double.parseDouble(S));   
            }else{
                double n1 = stack.pop();
                double n2 = stack.pop();
                if (S.equals("+")){
                    result = n1 + n2;
                }else if (S.equals("-")){
                    result = n1 - n2;
                }else if (S.equals("*")){
                    result = n1 * n2;
                }else if (S.equals("/")){
                    if(n2 == 0.0){
                        throw new RuntimeException("Divide by zero!!");
                    }else{ 
                        result = n1 / n2;
                    }
                }else throw new RuntimeException("This operator is not supported!");
                stack.push(result);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String exp = "1 2 * 3 4 * + 5 6 * + 2 *";
        System.out.println(evaluatePosFixExp (exp));
    }
}
    

