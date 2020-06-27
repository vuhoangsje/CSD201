/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import sorting.Menu;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vuhoa
 */
public class TestMySorting {
    final static Scanner sc  = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static  Integer[] generateArray(int n, int min, int max){
        if (max < min) {
            int t = min;
            min = max;
            max = t;
        }
        Integer a[] = new Integer[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = min + r.nextInt(max - min);
        }
        return a;
    }
    public static Integer[] copy(Integer[] a){
        Integer[] b =new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }
    public static void display(Integer[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
            if (i > 0 && i%20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] a = null;
        Integer[] b = null;
        int n = 0, min = 0, max = 0;
        long t1 = 0, t2 = 0;
        Menu menu = new Menu();
        menu.add("Create an array of randomly integers");
        menu.add("Dislay initial array");
        menu.add("Bubble sort 1");
        menu.add("Bubble sort 2");
        menu.add("Insertion sort");
        menu.add("Selection sort");
        menu.add("Merge sort");
        menu.add("Quick sort");
        menu.add("Exit");
        int choice;
        do {            
            choice = menu.getUserChoice();
            switch(choice){
                case 1: System.out.println("Number of randomly integer");
                        n = Integer.parseInt(sc.nextLine());
                        System.out.println("Minimun value");
                        min = Integer.parseInt(sc.nextLine());
                        System.out.println("Maximum");
                        max = Integer.parseInt(sc.nextLine());
                        a = generateArray(n, min, max);
                        break;
                case 2: System.out.println("Initial array");
                        display(a);
                        break;
                case 3: b = copy(a);
                        t1 = System.currentTimeMillis();
                        MyAscSorting.bubbleSort(b);
                        t2 = System.currentTimeMillis();
                        display(b);
                        System.out.println("Bubble sort 1:" + (t2 - t1) + "secs");
                        break;
                case 4: b = copy(a);
                        t1 = System.currentTimeMillis();
                        MyAscSorting.bubbleSort2(b);
                        t2 = System.currentTimeMillis();
                        display(b);
                        System.out.println("Bubble sort 2:" + (t2 - t1) + "secs");
                        break;
                case 5: b = copy(a);
                        t1 = System.currentTimeMillis();
                        MyAscSorting.insertSort(b);
                        t2 = System.currentTimeMillis();
                        display(b);
                        System.out.println("Insertion sort:" + (t2 - t1) + "secs");
                        break;
                case 6: b = copy(a);
                        t1 = System.currentTimeMillis();
                        MyAscSorting.selectionSort(b);
                        t2 = System.currentTimeMillis();
                        display(b);
                        System.out.println("Selection sort:" + (t2 - t1) + "secs");
                        break;
                case 7: b = copy(a);
                        t1 = System.currentTimeMillis();
                        MyAscSorting.mergeSort(b);
                        t2 = System.currentTimeMillis();
                        display(b);
                        System.out.println("Merge sort:" + (t2 - t1) + "secs");
                        break;
                case 8: b = copy(a);
                        t1 = System.currentTimeMillis();
                        MyAscSorting.quickSort(b);
                        t2 = System.currentTimeMillis();
                        display(b);
                        System.out.println("Quick sort:" + (t2 - t1) + "ms");
                        break;
                case 9: System.out.println("Bye Bye");
                        break;
            }   
        } while (choice !=9);
    }
    
}
