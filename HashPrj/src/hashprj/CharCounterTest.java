/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashprj;

import java.io.IOException;

/**
 *
 * @author vuhoa
 */
public class CharCounterTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        CharCounter counter  = new CharCounter("laychong.txt");
        counter.print();
    }
}
