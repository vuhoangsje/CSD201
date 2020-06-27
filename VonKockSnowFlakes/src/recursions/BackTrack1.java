/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursions;

/**
 *
 * @author vuhoa
 */
public class BackTrack1 {
    int n;
    int a[];
    int d1, d2;
    boolean success = false;
    int count = 0;
    public BackTrack1(int n, int d1, int d2){
        this.n = n;
        a = new int[n];
        if (d1 > d2) {
            int t = d1; d1 = d2; d2 = t;
        }
        this.d1 = d1; this.d2 = d2;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public  int[] getSolution(){
        return success == true ? a : null;
    }
    boolean valid(int i, int val){
        if (i==0) {
            return true;
        }
        a[i] = val;
        int d = Math.abs(a[i] - a[i -1]);
        boolean proceed = d >= d1 && d <= d2;
        int j = i -1;
        while (proceed && j >= 0) {            
            proceed = (a[i] != a[j--]);
        }
        return proceed;
    }
    public void processSolution(){
        for (int i = 0; i < n - 1; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(a[n-1]);
    }
    private void backTrack(int i){
        if (i >= n) {
            return;
        }
        for (int val = 0; val < n; val++) {
            if (valid(i, val)) {
                a[i] = val;
                if (i == n-1) {
                    success = true;
                    count++;
                    processSolution();
                }
                else{
                    backTrack(i+1);
                }
            }
        }
    }
    public void solve(){
        success = false;
        backTrack(0);
        if (success == false) {
            System.out.println("No solution");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BackTrack1 problem = new BackTrack1(10, 3, 5);
        problem.solve();
        System.out.println("Solution count:" + problem.count);
    }
    
}
