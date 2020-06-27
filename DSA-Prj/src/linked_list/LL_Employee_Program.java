/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import com.Menu;
import java.util.Scanner;

/**
 *
 * @author vuhoa
 */
public class LL_Employee_Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.add("Add new emp");
        menu.add("Remove an emp");
        menu.add("Increase salary of emp");
        menu.add("Print employee list");
        menu.add("Empoyee having salary in a range");
        menu.add("Quit");
        LL_EmpList empList = new LL_EmpList();
        int userChoice;
        int lowSal = 0, highSal = 0; 
        do{
            userChoice = menu.getChoice();
            switch (userChoice){
                case 1: empList.add(); break;
                case 2: empList.remove(); break;
                case 3: empList.increaseSalary(); break;
                case 4: empList.print(); break;
                case 5: 
                    System.out.println("Enter the low salary: ");
                    lowSal = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter the high salaty");
                    highSal = Integer.parseInt(sc.nextLine());
                    empList.print_Salary(lowSal, highSal);
                    break;
            }
        }while (userChoice != 6);
    }
}
