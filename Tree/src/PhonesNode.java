


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class PhonesNode implements Comparable{
    String code;
    double price;
    PhonesNode left;
    PhonesNode right;
    public PhonesNode(String code, double price) {
        this.code = code;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public int compareTo(Object t){
        return this.code.compareTo(((PhonesNode)t).code);
    }

    
    
    
}
