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
public class computer {
    public static int[] computperFailKMP(char[] pattern){
        int m= pattern.length;
        int[] fail = new int [m];
        fail[0]=0; // first element having no previous element
        int j=1; // position of the array fail will be assigned value
        int k=0; // value will be asssigned  to elements in the array fail 
        while (j<m) { // assign values to fail[1]…..fail[m-1] 
            if (pattern[j]==pattern[k]){  // 2 characters are the same
                fail[j]= k+1; // skip k+1 characters
                k++;
            }
            else if (k>0) k=fail[k-1]; // getback/backward previous value
            else fail[j]=0; // no improvement, go to the first character
            j++; // next fail element
        }
        return fail;
    }
    public static int indexOf_KMP(char S[], char p[]) {
        int n= S.length, m= p.length; int[] prefixes = computperFailKMP(p);
        int j=0; // position into source string S
        int k=0; // index into pattern p
        while (j<n){ // traverse S
            if (S[j]==p[k]) {
                 if (k==m-1) return j-m+1; // found
            }
            else // 2 characters are not equal
                if (k>0) k= prefixes[k-1]; // update position in p
            j++; // next chracter in S
            k++;
        }
        return -1; // Not found
    }
    public static int indexOf_KMP(String S, String pattern) {
        return indexOf_KMP ( S.toCharArray(),                  
                                 pattern.toCharArray() );
    } 

}
