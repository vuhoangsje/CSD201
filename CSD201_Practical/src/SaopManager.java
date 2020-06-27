/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class SaopManager {
    public static void main(String[] args){
        Menu menu = new Menu();
        menu.add("Add new soap");
        menu.add("Seach a soap");
        menu.add("Remove a soap");
        menu.add("Print soap list");
        SoapList list = new SoapList();
        int userChoice;
        do{
            userChoice = menu.getUserChoice();
            switch(userChoice){
                case 1:
                    list.addSoap();
                    break;
                case 2:
                    list.searchSoap();
                    break;
                case 3:
                    list.removeSoap();
                    break;
                case 4:
                    list.print();
                    break;
            }
        }
        while(userChoice>=0 && userChoice<5);
    }
}
