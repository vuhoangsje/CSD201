/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.ArrayList;

/**
 *
 * @author vuhoa
 */
public class testGraph1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Graph g = new Graph();
        g = g.loadFromFile("graph1.txt");
        System.out.println(g.toString());
        ArrayList<Edge> edges = g.depthFirstSearch();
        System.out.println("Depth first search");
        g.printEdge(edges, System.out);
        edges = g.breathFirstSearch();
        System.out.println("Breath first search");
        g.printEdge(edges, System.out);
    }
    
}
