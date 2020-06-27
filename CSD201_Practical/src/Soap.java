
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
public class Soap {
    String code, type;
    double weight, price;
    String odor;
    Scanner sc = new Scanner(System.in);

    public Soap() {
    }

    public Soap(String code) {
        this.code = code;
    }

    
    public Soap(String code, String type, double weight, double price, String odor) {
        this.code = code;
        this.type = type;
        this.weight = weight;
        this.price = price;
        this.odor = odor;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOdor() {
        return odor;
    }

    public void setOdor(String odor) {
        this.odor = odor;
    }

    @Override
    public String toString() {
        return code+ "," +type+ "," +weight+ "," +price+ "," +odor;
    }
    
    public void input(){
        System.out.print("Enter code: ");
        code=sc.nextLine().toUpperCase();
        System.out.print("Enter type: ");
        type=sc.nextLine().toUpperCase();
        System.out.print("Enter weight: ");
        weight=Double.parseDouble(sc.nextLine());
        System.out.print("Enter price: ");
        price=Double.parseDouble(sc.nextLine());
        System.out.print("Enter odor: ");
        odor=sc.nextLine().toUpperCase();
    }
    
    public boolean equals(Object obj){
        return this.code.equals(((Soap)obj).code);
    }
    
}
