/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo1;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 *
 * @author vuhoa
 */
public class StudentManager1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentList list = new StudentList();
        Student st = new Student("SE009", "Name", 2);
        list.add(st);
        st = new Student("SE001", "Phuc", 7);
        list.add(st);
        st = new Student("SE006", "Vinh", 8);
        list.add(st);
        list.output();
        String ID = "SE003";
        st = list.search(ID);
        if (st == null || !st.getId().equals(ID)) {
            System.out.println("Student" + ID + "does not exist");
            
        }else {
            System.out.println("Found:" + st);
        }
        ID = "SE006";
        st = list.search(ID);
        if (st == null || !st.getId().equals(ID)) {
            System.out.println("Student" + ID + "does not exist");
            
        }else {
            System.out.println("Found:" + st);
        }
    }
}
