/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textprocessing;

import textprocessing.MyStrMatcher;

/**
 *
 * @author vuhoa
 */
public class TextProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String S = "Please do not go away tonight";
        String p1 = "go home";
        String p2 = "away to";
        int pos1 = MyStrMatcher.indexOf_BF(S, p1);
        int pos2 = MyStrMatcher.indexOf_BF(S, p2);
        int pos3 = MyStrMatcher.lastIndexOf_BF(S, p2);
        System.out.println("Index of p1 in S: " + pos1);
        System.out.println("Index of p2 in S: " + pos2);
        System.out.println("Last index of p2 in S: " + pos2);
    }
    
}
