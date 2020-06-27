/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linked_list;

import com.Employee;
import java.util.Scanner;

/**
 *
 * @author vuhoa
 */
public class LL_EmpList extends SLL<Employee>{
    Scanner sc = null;

    public LL_EmpList() {
        super();
        sc = new Scanner(System.in);
    }
    // Tìm nhân viên có mã đã biết Phương tiện để tạo validation
    private SLLNode<Employee> find (String code){
        SLLNode<Employee> ref;
        for (ref = this.getHead(); ref !=null; ref = ref.next) {//linear search
            if (ref.info.getCode().equals(code))
                    return ref;
        }
        return null;
    }
    //add a new emp to the end of the list
    public void add(){
        String code = "", name = "";
        int salary = 0;
        System.out.println("Add new employee");
        boolean proceed = false;// Biến kiểm trả dữ liệu nhập
        //Enter employee's code - khong cho phép trùng mã
        do {
            System.out.println("Enter emp code:");
            code  = sc.nextLine();
            proceed = find(code) != null;
            if (proceed == true){
                System.out.println("This code is duplicated!!");
            }
        }while (proceed);
        // enter emp name, name is require
        do{
            System.out.println("Enter emp name:");
            name = sc.nextLine();
            proceed = (name.length() == 0);
            if (proceed == true){
                System.out.println("Emp name must have.");
            }
        }while(proceed);
        // enter emp salary lương luôn là số dương.
        do{
            System.out.println("Emp salary: ");
            salary = Integer.parseInt(sc.nextLine());
            if (salary < 0){
                System.out.println("Pls input again.");
            }
        }while (salary <= 0);
        Employee emp = new Employee(code, name, salary);
        this.addToTail(emp);
        System.out.println("Adding done");
    }
    public void remove(){
        if (this.isEmpty()){
            System.out.println("The list is empty");
        }else {
            String code = "";
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if (ref == null){
                System.out.println("Emp is not exist.");
            }else{
                this.delete(ref.info);
                System.out.println("Emp has been remove");
                }
            }
        }
    //Increasing the salary
    public void increaseSalary(){
        if (this.isEmpty()){
            System.out.println("The list is empty");
        }else{
            String code = "";
            System.out.println("Enter code:");
            code = sc.nextLine().toUpperCase();
            SLLNode<Employee> ref = find(code);
            if (ref == null){
                System.out.println("Emp note exist.");
            }else{
                int oldSalary = ref.info.getSalary();
                int newSalary;
                do{ 
                    System.out.println("Old salary: " + oldSalary + " New salary: ");
                    newSalary = Integer.parseInt(sc.nextLine());
                }while (newSalary <= oldSalary);
                ref.info.setSalary(newSalary);
                System.out.println("Emp salary has been update");
            }
        }
    }
    public void print(){
        if (this.isEmpty()){
            System.out.println("The list is empty.");
        }else{
            System.out.println("EMPLOYEE LIST");
            this.printAll();
        }
    }
    //Xuat danh sach nhan vien co luong trong khoang
    public void print_Salary(int lowSalary, int highSalary){
        if (this.isEmpty()){
            System.out.println("The list is empty");
        }else{
            if (lowSalary > highSalary){
                System.out.println("EMPLOYEE LIST ");
            }
            for (SLLNode p = head; p!= null; p = p.next) {
                Employee emp = (Employee)p.info;
                int salary = emp.getSalary();
                if (salary >= lowSalary && salary <= highSalary){
                    System.out.println(emp);
                }
            }
        }
       // ll_Emplist
    }
}
