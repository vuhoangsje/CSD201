/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author vuhoa
 */
public class ClockList extends TreeSet<Clock>{

    public ClockList() {
        super(Clock.comparator);
    }
    public Clock search(String ID){
        return this.ceiling(new Clock(ID));
    }
    public void output(){
        Iterator it = this.iterator();
        while (it.hasNext()) {            
            System.out.println(it.next());
        }
    }
}
