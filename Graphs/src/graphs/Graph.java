/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 *
 * @author vuhoa
 */
public class Graph extends TreeSet<Vertex>{
    public Graph(){
        super();
    }
    public void addVertex(Vertex v){
        this.add(v);
    }
    Vertex get(String vertexName){
        Iterator it = this.iterator();
        while (it.hasNext()) {            
            Vertex v = (Vertex)(it.next());
            if (v.name.equals(vertexName)) {
                return v;
            }
        }
        return null;
    }
    public boolean addEdge(String nameFrom, String nameTo){
        Vertex v = this.get(nameFrom);
        Vertex u = this.get(nameTo);
        if (u == null || v == null) {
            return false;
        }
        Edge e = new Edge(u, v , 1);
        u.adjListl.add(e);
        return true;
    }
    public boolean addEdge(Vertex u, Vertex v){
        if (u == null || v == null) {
            return false;
        }
        Edge e = new Edge(u, v , 1);
        u.adjListl.add(e);
        return true;
    }
    public boolean addEdge(String nameFrom, String nameTo, double  w){
        Vertex v = this.get(nameFrom);
        Vertex u = this.get(nameTo);
        if (u == null || v == null) {
            return false;
        }
        Edge e = new Edge(u, v , w);
        u.adjListl.add(e);
        return true;
    }
    public boolean addEdge(Vertex u, Vertex v, double  w){
        if (u == null || v == null) {
            return false;
        }
        Edge e = new Edge(u, v , w);
        u.adjListl.add(e);
        return true;
    }
    public Graph loadFromFile(String fname){
        Graph g = null;
        File f = new File(fname);
        if (!f.exists()) {
            System.out.println("File not found");
            System.exit(0);
            return g;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line  = null;
            StringTokenizer stk = null;
            line = br.readLine();
            if (line != null) {
                g = new Graph();
                stk = new StringTokenizer(line, " ");
                while (stk.hasMoreElements()) {
                   String name = stk.nextToken();
                   Vertex v = new Vertex(name);
                   g.add(v); 
                }
            }
            while ((line = br.readLine()) != null) {                
                stk = new StringTokenizer(line, " ");
                String nameFrom = stk.nextToken();
                Vertex u = g.get(nameFrom);
                while (stk.hasMoreElements()) {
                    String name = stk.nextToken();
                    Vertex v = new Vertex(name);
                    g.addEdge(u,v);               
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            g = null;
        }
        return g;
    }

    @Override
    public String toString() {
        String S = "Empty graph";
        if (this == null || this.size() == 0) {
            return S;
        }
        S = "Graph:\n";
        Iterator<Vertex> it_Vertex = this.iterator();
        while (it_Vertex.hasNext()){
            Vertex u = it_Vertex.next();
            S += u.getName() + "\t";
            Iterator<Edge> it_Edge = u.getAdjListl().iterator();
            while (it_Edge.hasNext()) {
                Edge e = it_Edge.next();
                S += e.toString() + " ";
            }
            S += "\n";
        }
        return S;
    }
    protected int DFS(Vertex u, int order, ArrayList<Edge> edges){
        int newOrder = order + 1;
        u.setNum(order);
        Iterator<Edge> it =u.getAdjListl().iterator();
        while (it.hasNext()) {
            Edge e = it.next();
            Vertex v = e.getV();
            if (v.num == 0) {
                edges.add(e);
                newOrder = DFS(u, newOrder, edges);
            }
        }
        return newOrder;
    }
    public ArrayList<Edge> depthFirstSearch(){
        ArrayList result = new ArrayList<Edge>();
        Object[] vertices = this.toArray();
        for (int i = 0; i < vertices.length; i++) {
            Vertex v = (Vertex)vertices[i];
            v.num = 0;
        }
        Integer order = 1;
        for (int i = 0; i < vertices.length; i++) {
            Vertex v =(Vertex)vertices[i];
            if (v.num == 0) {
                order = DFS(v, order, result);
            } 
        }   
        return result.size() > 0 ? result : null;
    }
    public  ArrayList<Edge> breathFirstSearch(){
        ArrayList resutl = new ArrayList<Edge>();
        MyQueue<Vertex> queue = new MyQueue<Vertex>();
        Object[] vertices = this.toArray();
        for (int i = 0; i < vertices.length; i++) {
            Vertex v =(Vertex)vertices[i];
            v.num = 0;
        }
        int order = 1;
        for (int i = 0; i < vertices.length; i++) {
            Vertex u = (Vertex)vertices[i];
            if (u.num == 0) {
                u.num = order++;
                queue.enqueue(u);
                while (!queue.isEmpty()) {                    
                    u = queue.dequeue();
                    Iterator<Edge> it = u.adjListl.iterator();
                    while (it.hasNext()) {
                        Edge e = it.next();
                        Vertex v = e.getV();
                        if(v.num == 0){
                            v.num = order++;
                            queue.enqueue(v);
                            resutl.add(e);
                        }
                    }
                }
            }
        }
        return resutl.size() > 0? resutl: null;
    }
    public  void printEdge(ArrayList<Edge> edges, PrintStream pw){
        if (edges == null || edges.isEmpty()) {
            pw.print("No edge");
        }else{
            pw.println("Set of edges:");
            pw.println(edges);
        }
    }
    
}
