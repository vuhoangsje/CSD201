/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashstudprj;

/**
 *
 * @author vuhoa
 */
public class HashStudPrj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String filename = "student.txt";
        Menu menu = new Menu();
        menu.add("Add new student");
        menu.add("Search student");
        menu.add("Remove student");
        menu.add("Update a student");
        menu.add("Print the list");
        menu.add("Save the list to file");
        menu.add("Exit");
        int choice;
        StudentList L = new StudentList();
        L.loadFromFile(filename);
        do {            
            System.out.println("\nStudent manager");
            choice = menu.getUserChoice();
            switch(choice){
                case 1: L.addStudent(); break;
                case 2: L.searchStudent(); break;
                case 3: L.removeStudent(); break;
                case 4: L.updateStudent(); break;
                case 5: L.print(); break;
                case 6: L.saveToFile(filename); break;
                case 7: System.out.println("Bye bye !!");
            }
        } while (choice != 7);
    }
    
}
