/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashstudprj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author vuhoa
 */
public class StudentList extends Hashtable<String, Student>{
    Scanner sc = new Scanner(System.in);
    public StudentList(){
        super();
    }
    public boolean loadFromFile(String filename){
        try {
            FileInputStream fi = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fi, "UTF8");
            BufferedReader bf = new BufferedReader(isr);
            String line;
            while ((line = bf.readLine()) != null) {                
                line = line.trim();
                String[] ar = line.split("[,]");
                if (ar.length == 3) {
                    Student st = new Student(ar[0], ar[1], Integer.parseInt(ar[2]));
                    this.put(st.code, st);
                }
            }
            bf.close();
            isr.close();
            fi.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean saveToFile(String filename){
        try {
            FileOutputStream fo = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF8");
            PrintWriter pw = new PrintWriter(osw);
            Iterator<String> it = this.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                Student st = this.get(key);
                pw.println(st);
            }
            pw.close();
            osw.close();
            fo.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public Student search(String code){
        return this.get(code);
    }
    public void addStudent(){
        String code, name;
        int mark;
        System.out.println("Enter data of new student");
        boolean cont = true;
        do {            
            System.out.println("Code:");
            code = sc.nextLine().toUpperCase().trim();
            cont = search(code) != null;
            if (cont) {
                System.out.println("Code is dupicated!");
            }
        } while (cont == true);
        System.out.println("Name:");
        name = sc.nextLine().toUpperCase().trim();
        System.out.println("Mark:");
        mark = Integer.parseInt(sc.nextLine());
        this.put(code, new Student(code, name, mark));
        System.out.println("New student " + code + "has been added.");
    }
    public void searchStudent(){
        String code;
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return;
        }
        System.out.println("Enter student code for searching:");
        code = sc.nextLine().toUpperCase();
        Student st = this.search(code);
        if (st == null) {
            System.out.println("This code doesn't exist!");
        }else{
            System.out.println(st);
        }
    }
    public void removeStudent(){
        String code;
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return;
        }
        System.out.println("Enter student code for removing:");
        code = sc.nextLine().toUpperCase();
        Student st = this.search(code);
        if (st == null) {
            System.out.println("This code doesn't exist!");
        }else{
            remove(code);
            System.out.println("The student " + code + "has been removed!");
        }
    }
    public void updateStudent(){
        String code;
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return;
        }
        System.out.println("Enter student code for updating:");
        code = sc.nextLine().toUpperCase();
        Student st = this.search(code);
        if (st == null) {
            System.out.println("This code doesn't exist!");
        }else{
            st.update();
        }
    }
    public void print(){
        if (this.size() == 0) {
            System.out.println("Empty list!");
            return;
        }
        Vector<Student> list = new Vector<>();
        list.addAll(this.values());
        Collections.sort(list);
        for (Student st : list) {
            System.out.println(st);
        }
    }
}
