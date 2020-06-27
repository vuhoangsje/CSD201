/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashprj;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author vuhoa
 */
public class CharCounter extends HashMap<Character, Integer>{
    private int numOfChars = 0;

    public CharCounter() {
        super();
    }
    public CharCounter(String filename) throws IOException{
        super();
        try {
            FileReader fr = new FileReader(filename);
            int code;
            Character ch;
            while ((code = fr.read()) != -1) {                
                ch = (char) code;
                if (!this.containsKey(ch)) {
                    this.put(ch, 1);
                } else {
                    this.replace(ch, this.get(ch) + 1);
                    numOfChars++;
                }
                
            }
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void print(){
        Iterator it = this.keySet().iterator();
        while (it.hasNext()) {
            Character c = (Character)it.next();
            int freq = this.get(c);
            System.out.println(c + "" + freq + ", " + 1.0 * freq/numOfChars);
        }
    }
}
