/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo1;

import java.util.Scanner;

/**
 *
 * @author vuhoa
 */
public class Student implements Comparable{
    String id = "";
    String name = "";
    int mark = 0;
    Scanner sc = new Scanner(System.in);

    public Student() {
    }
    public Student(String id) {
        this.id = id;
    }
    public Student(String id, String name, int mark) {
        this.id = id ;
        this.name = name;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
    @Override
    public int compareTo(Object that) {
        return this.id.compareTo(((Student)that).id);
    }

    @Override
    public String toString() {
        return   id + ", " + name + ", " + mark;
    }
    
    
}
