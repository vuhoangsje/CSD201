/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

/**
 *
 * @author vuhoa
 */
public class ClockMng1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClockList list = new ClockList();
        list.add(new Clock("C003", "SG", 125));
        list.add(new Clock("C007", "STG", 210));
        list.add(new Clock("C005", "Citizen", 180));
        list.output();
        list.output();
        String ID = "C333";
        Clock ck = list.search(ID);
        if (ck == null || !ck.getId().equals(ID)) {
            System.out.println("Student" + ID + "does not exist");
            
        }else {
            System.out.println("Found:" + ck);
        }
        ID = "C009";
        ck = list.search(ID);
        if (ck == null || !ck.getId().equals(ID)) {
            System.out.println("Student" + ID + "does not exist");
            
        }else {
            System.out.println("Found:" + ck);
        }
    }
}
    

