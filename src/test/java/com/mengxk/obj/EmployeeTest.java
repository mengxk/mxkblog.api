package com.mengxk.obj;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EmployeeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("John Public", 50000);
        original.setHireDay(2018, 12, 26);
        Employee copy = original.clone();
        copy.raiseSalary(10);
        copy.setHireDay(2018, 12, 27);
        System.out.println("original=" + original.getSalary());
        System.out.println("copy=" + copy.getSalary());
        int[] luckNumbers = {1, 5, 5, 7, 3, 5};
        int[] cloned = luckNumbers.clone();
        cloned[0] = 0;
        System.out.println(Arrays.toString(luckNumbers));
        System.out.println(Arrays.toString(cloned));
    }

    @Test
    public void getName() {
    }

    @Test
    public void getSalary() {
    }

    @Test
    public void getHireDay() {
    }

    @Test
    public void raiseSalary() {
    }

    @Test
    public void compareTo() {
    }
}