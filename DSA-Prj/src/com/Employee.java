/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author vuhoa
 */
public class Employee {
    String code = "", name = "";//data
    int salary;

    public Employee() {
    }
    //Constructors
    public Employee(String c, String n , int s) {
        this.salary = s;
        this.code = c;
        this.name = n;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    public boolean equals (Employee emp){
        return emp.getClass().equals(this.getCode()) &&
               emp.getName().equals(this.getName()) &&
               emp.getSalary() == this.getSalary();
    }
    //Matching 2 emp objects
    @Override
    public String toString() {
        return "Employee{" + "code=" + code + ", name=" + name + ", salary=" + salary + '}';
    }
}
