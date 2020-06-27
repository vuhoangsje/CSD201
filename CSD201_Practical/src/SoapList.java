
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
public class SoapList extends LinkedList<Soap>{
    Scanner sc = new Scanner(System.in);
    
    public void addSoap(){
        Soap s = new Soap();
        s.input();
        if(this.add(s)==true) System.out.println("Added.");
    }
    
    private int search(String code){
        return this.indexOf(new Soap(code));
    }
    
    public void searchSoap(){
        String code;
        System.out.print("Enter the search code: ");
        code=sc.nextLine();
        int pos=search(code);
        if(pos<0) System.out.println("Do not exist this code.");
        else{
            Soap s = new Soap();
            System.out.println("");
        }
           
        }
    
    public void removeSoap(){
        String code;
        System.out.print("Input removed soap code: ");
        code=sc.nextLine().toUpperCase();
        int pos=search(code);
        if(pos<0) System.out.println("Do not exist this code.");
        else{
            this.remove(pos);
            System.out.println("Soap " +code+ " was deleted.");
        }
    }
    
    public void print(){
        System.out.println("SOAP LIST:");
        for(Soap s:this) System.out.println(s);
    }
}
