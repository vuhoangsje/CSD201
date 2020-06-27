package sorting;


import java.util.ArrayList;
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
public class Menu extends ArrayList{
    Scanner sc = new Scanner(System.in);
    public int getUserChoice(){
        for(int i=0;i<this.size();i++) System.out.println((i+1)+ "- " +this.get(i));
        System.out.print("Choose option: ");
        return Integer.parseInt(sc.nextLine());
    }
}
