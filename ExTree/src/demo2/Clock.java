/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author vuhoa
 */
public class Clock {
    String id = "", manufact = "";
    int price = 0;
    Scanner sc = new Scanner(System.in);

    public Clock() {
    }

    public Clock(String id) {
        this.id = id;
    }

    public Clock(String id, String manufact, int price) {
        this.id = id;
        this.manufact = manufact;
        this.price = price;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return "Id: " + id + "Manufact: " + manufact + "Price: " + price;
    }
    
    public static Comparator comparator = new Comparator() {
        @Override
        public int compare(Object t, Object t1) {
            return ((Clock)t).id.compareTo(((Clock)t1).id);
        }
    };
}
