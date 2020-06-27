/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Huffman;

/**
 *
 * @author Kaden Arabic
 */
public class Entry1 implements Comparable{
    final static int INTERIOR=-1;
    public int symbol;
    public int weight;
    public String codeword;
    public Entry1(int symbol)
    {
        this.symbol=symbol;
        weight=1;
        codeword="";
    }

    public Entry1(int symbol, int weight, String codeword) {
        this.symbol = symbol;
        this.weight = weight;
        this.codeword = codeword;
    }
    
                

    @Override
    public int compareTo(Object o) {
        return weight-((Entry1)o).weight;
    }

    @Override
    public String toString() {
        return "Entry{" + "symbol=" + symbol + ", weight=" + weight + ", codeword=" + codeword + '}';
    }
    
    
    
}
