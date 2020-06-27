
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
public class Part {
    String code, make, type;
    double price;
    int guarantee;
    Scanner sc = new Scanner(System.in);

    public Part() {
    }

    public Part(String code) {
        this.code = code;
    }

    
    public Part(String code, String make, String type, double price, int guarantee) {
        this.code = code;
        this.make = make;
        this.type = type; 
        this.price = price;
        this.guarantee = guarantee;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(int guarantee) {
        this.guarantee = guarantee;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    
    @Override
    public String toString() {
        return code+ "," +make+ "," +type+ "," +price+ "," + guarantee;
    }
    
    public void input(){
        System.out.print("Enter code: ");
        code=sc.nextLine().toUpperCase();
        System.out.println("Enter make");
        make=sc.nextLine().toUpperCase();
        System.out.print("Enter type: ");
        type=sc.nextLine().toUpperCase();
        System.out.print("Enter price: ");
        price=Double.parseDouble(sc.nextLine());
        System.out.print("Enter guarantee: ");
        guarantee=Integer.parseInt(sc.nextLine());
    }
    
    public boolean equals(Object obj){
        return this.code.equals(((Part)obj).code);
    }
    
}
