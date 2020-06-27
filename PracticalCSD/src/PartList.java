
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class PartList extends LinkedList<Part>{
    Scanner sc = new Scanner(System.in);
    
    public void addPart(){
        Part p = new Part();
        p.input();
        if(this.add(p)==true) System.out.println("Added.");
    }
    
    private int search(String code){
        return this.indexOf(new Part(code));
    }
    
    public void searchPart(){
        String code;
        System.out.print("Enter the search code: ");
        code=sc.nextLine();
        int pos=search(code);
        if(pos<0) System.out.println("Do not exist this code.");
        else{
            for (Part p : this) {
                System.out.println(p.toString());
            }
        }  
    }
    
    public void removePart(){
        String code;
        System.out.print("Input removed part code: ");
        code=sc.nextLine().toUpperCase();
        int pos=search(code);
        if(pos<0) System.out.println("Do not exist this code.");
        else{
            this.remove(pos);
            System.out.println("Part " +code+ " was deleted.");
        }
    }
    
    public void print(){
        System.out.println("PART LIST:");
        for(Part s:this) System.out.println(s);
    }
}
