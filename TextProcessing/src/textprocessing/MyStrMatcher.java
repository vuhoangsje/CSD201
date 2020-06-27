/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textprocessing;

/**
 *
 * @author vuhoa
 */
public class MyStrMatcher {
    public static int indexOf_BF(String s, String pattern){
        int n = s.length();
        int m = pattern.length();
        int i, j;
        for (i = n - m; i >= 0; i--) {
            j = 0;
            while (j < m) {                
                if (s.charAt(i + j) != pattern.charAt(j)) {
                   break;
                }
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static int lastIndexOf_BF(String s, String pattern){
        int n = s.length();
        int m = pattern.length();
        int i, j;
        for (i = n - m; i >= 0; i--) {
            j = 0;
            while (j < m) {                
                if (s.charAt(i + j) != pattern.charAt(j)) {
                   break;
                }
                j++;
                if (j == m) {
                    return i;
                }
            }
        }
        return -1;
    }
}
