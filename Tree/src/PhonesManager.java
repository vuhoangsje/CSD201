
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
public class PhonesManager {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add a phone");
        menu.add("Search phone based on code");
        menu.add("Print list");
        menu.add("Quit");
        int userChoice;
        boolean changed=false;
        Phones list = new Phones();
        do{
            userChoice=menu.getUserChoice();
            switch(userChoice){
                case 1:
                    list.insert();
                    break;
                case 2:
                    list.searchCode();
                    break;
                case 3:
                    list.printCode();
                    break;
                case 4: System.out.println("Goodbye");
                    break;
            }
        }
        while(userChoice != 4);
    }
    
}
