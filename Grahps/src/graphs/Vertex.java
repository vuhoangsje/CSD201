/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.TreeSet;

/**
 *
 * @author vuhoa
 */
public class Vertex implements Comparable{
    String name;
    TreeSet<Edge> adjListl;
    int num = 0;

    public Vertex() {
        name = null;
        adjListl = new TreeSet<Edge>();
    }
    
    public Vertex(String n) {
        name = n;
        adjListl = new TreeSet<Edge>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeSet<Edge> getAdjListl() {
        return adjListl;
    }

    public void setAdjListl(TreeSet<Edge> adjListl) {
        this.adjListl = adjListl;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int compareTo(Object o) {
        return name.compareTo(((Vertex)o).name);
    }

    @Override
    public String toString() {
        return  name;
    }
    
}
