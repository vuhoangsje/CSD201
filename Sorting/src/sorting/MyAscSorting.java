/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author vuhoa
 */
public class MyAscSorting {
    public static boolean isAscending(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(a[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
    private static void swap(Comparable[] a, int i, int k){
        Comparable x = a[i];
        a[i] = a[k];
        a[k] = x;
    }
    public static void selectionSort(Comparable[] a, int first, int last){
        int i, j, minIndex;
        Comparable minVal;
        int n = a.length;
        for (i = first; i < last-1; i++) {
            minVal = a[i];
            minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (a[j].compareTo(minVal) < 0) {
                    minVal = j;
                    minVal = a[j];
                }
            }
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
    }
    public static void selectionSort(Comparable[] a){
        selectionSort(a, 0, a.length);
    }
    public static void bubbleSort(Comparable[] a, int first, int last){
        int i;
        boolean mustSwap;
        do {            
            mustSwap = false;
            for (i = 0; i < last - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    mustSwap = true;
                }
            }
        } while (mustSwap);
    }
    public static void bubbleSort(Comparable[] a){
        bubbleSort(a, 0, a.length);
    }
    public static void bubbleSort2(Comparable[] a, int first, int last){
        int i, k;
        boolean mustSwap;
        k = 1;
        do {            
            mustSwap = false;
            for (i = 0; i < last - k; i++) {
                if (a[i].compareTo(a[ i+ 1 ]) > 0) {
                    swap(a, i, i + 1);
                    mustSwap = true;
                }
            }
            i++;
        } while (mustSwap);
    }
    public static void bubbleSort2(Comparable[] a){
        bubbleSort(a, 0 , a.length);
    }
    public static void insertSort(Comparable[] a, int first, int last){
        int i, j, n = a.length;
        Comparable x;
        for (i = first + 1; i < last; i++) {
            x = a[i];
            j = i;
            while (j > 0 && x.compareTo(a[j - 1]) < 0) {                
                a[j] = a[j - 1];
                j--;
            }
            a[j] = x;
        }
    }
    public static void insertSort(Comparable[] a){
        insertSort(a, 0, a.length);
    }
    public static void quickSort(Comparable[] a, int first, int last){
        int lower = first + 1, upper = last;
        swap(a, first, (first + last) / 2);
        Comparable bound = a[first];
        while (lower <= upper) {            
            while (bound.compareTo(a[lower]) > 0) {                
                lower++;
            }
            if (lower < upper) {
                swap(a, lower++, upper--);
            }else{
                lower++;
            }
        }
        swap(a, upper, first);
        if (first < upper - 1) {
            quickSort(a, first, upper - 1);
        }
        if (upper + 1 < last) {
            quickSort(a, upper + 1, last);
        }
    }
    public static void quickSort(Comparable[] a){
        if (a.length < 2) {
            return;
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[max].compareTo(a[i]) < 0 ) {
                max = i;
            }
        }
        swap(a, a.length - 1, max);
        quickSort(a, 0, a.length - 2);
    }
    static Comparable[] temp;
    private static void merge(Comparable[] a, int first, int last){
        int mid = (first + last) / 2;
        int i1 = 0, i2 = first, i3 = mid + 1;
        while (i2 <= mid && i3 <= last) {            
            if (a[i2].compareTo(a[i3]) < 0) {
                temp[i1++] = a[i2++];
            } else {
                temp[i1++]  =a[i3++];
            }
        }
        while (i2 <= mid) {            
            temp[i1++] = a[i2++];
        }
        while (i3 <= last) {            
            temp[i1++] = a[i3++];
        }
        for (i1 = 0, i2 = first; i2 <= last; a[i2++] = temp[i1++]);
    }
    private static void mergeSort(Comparable[] a, int first, int last){
        int mid = (first + last) / 2;
        if (first < mid) {
            mergeSort(a, first, mid);
        }
        if (mid + 1 < last) {
            mergeSort(a, mid + 1, last);
        }
        merge(a, first, last);
    }
    public static void mergeSort(Comparable[] a){
        if (a.length < 2) {
            return ;
        }
        temp = new Comparable[a.length];
        mergeSort(a, 0, a.length - 1);
    }
}