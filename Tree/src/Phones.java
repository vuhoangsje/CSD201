
import java.util.Scanner;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Phones {
    PhonesNode root;
    Scanner sc = new Scanner(System.in);

    public Phones() {
        root=null;
    }
    
    PhonesNode search(String code){
        if(root==null) return null;
        PhonesNode p=this.root;
        int d = code.compareTo(p.code);
        while(p!=null && d!=0){
            d=code.compareTo(p.code);
            if(d<0) p=p.left;
            else if(d>0) p=p.right;
        }
        return p;
    }
    
    public void insert(String code, double price){
        if(root==null){
            root= new PhonesNode(code, price);
            return;
        }
        PhonesNode p = root;
        PhonesNode prev=null;
        while(p!=null){
            prev=p;
            if(code.compareTo(p.code)>0) p=p.right;
            else p=p.left;
        }
        if(prev.code.compareTo(code)<0) prev.right= new PhonesNode(code, price);
        else prev.left= new PhonesNode(code, price);
    }
    
    public void insert(){
        String code;
        double price;
        PhonesNode p=null;
        do{
            System.out.print("Enter the code of new phone: ");
            code=sc.nextLine().trim().toUpperCase();
            p=this.search(code);
            if(p!=null) System.out.println("This code is duplicated.");
        }
        while(p!=null);
        do{
            System.out.println("Enter the price of new phone: ");
            price=Double.parseDouble(sc.nextLine());
            if(price<0) System.out.println("Price unvalid.");
        }
        while(price<0);
        insert(code, price);
        System.out.println("The new phone was added. ");
    }
    
    public void searchCode(){
        System.out.println("Insert the code you want to search: ");
        String code=sc.nextLine().trim().toUpperCase();
        PhonesNode p;
        p=this.search(code);
        if(p==null) System.out.println("Not found");
        else{
            System.out.println(code+ "," +p.price);
        }
    }
    
    public void printCode(PhonesNode p){
        if(p!=null){
            if(p.left!=null) printCode(p.left);
            System.out.println(p.code+ "," +p.price);
            if(p.right!=null) printCode(p.right);
        }
    }
    public void printCode(){
        if(root==null) System.out.println("Empty list.");
        else{
            System.out.println("Phone List: ");
            printCode(root);         
        }
    }
}
