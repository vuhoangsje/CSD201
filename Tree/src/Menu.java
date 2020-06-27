
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
public class Menu extends Vector <String> {
    //default constructor
    public Menu(){
        super();
    }
    
    //thêm yêu cầu lệnh 
    void addMenuItem(String S){
        this.add(S);
    }
    
    //chọn yêu cầu
     int getUserChoice(){
        int result = 0;
        if(this.size()>0) {
            for(int i=0;i<this.size();i++) System.out.println( (i+1)+ "-" +this.get(i));
            System.out.println("Please select an operation: ");
            Scanner sc = new Scanner(System.in);
            result= Integer.parseInt(sc.nextLine());
        }
        return result;
    }
}
