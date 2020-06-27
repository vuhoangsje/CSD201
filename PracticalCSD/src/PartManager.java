/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class PartManager {
    public static void main(String[] args){
        Menu menu = new Menu();
        menu.add("Add new part");
        menu.add("Seach a part");
        menu.add("Remove a part");
        menu.add("Print part list");
        menu.add("Exit");
        PartList list = new PartList();
        int userChoice;
        do{
            userChoice = menu.getUserChoice();
            switch(userChoice){
                case 1:
                    list.addPart();
                    break;
                case 2:
                    list.searchPart();
                    break;
                case 3:
                    list.removePart();
                    break;
                case 4:
                    list.print();
                    break;
                case 5:
                    System.out.println("Bye Bye");
                    break;
            }
        }
        while(userChoice != 5);
    }
}
