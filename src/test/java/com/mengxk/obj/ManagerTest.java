package com.mengxk.obj;

import org.junit.Test;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void getSalary() {
        Manager manager = new Manager("Carl Cracker", 8000, 2018, 12, 15);
        manager.setBonus(5000);

        Employee[] employees = new Employee[3];
        employees[0] = manager;
        employees[1] = new Employee("Harry Hacker", 5000, 1989, 10, 1);
        employees[2] = new Employee("Tony Tester", 4000, 1990, 12, 1);
        System.out.println(employees[0].getClass());
        System.out.println(employees[1].getClass());
        System.out.println(employees[1] instanceof Comparable);
        System.out.println(employees[1] instanceof Employee);
        System.out.println(employees[1] instanceof Object);
        /*for (Employee employee : employees) {
            System.out.println(employee.getName() + ":" + employee.getSalary());
        }
        System.out.println(" 1 ");
        Arrays.sort(employees);
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ":" + employee.getSalary());
        }
        System.out.println(" 2 ");
        List<Employee> employees1 = Arrays.asList(employees);
        Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee.getName() + ":" + employee.getSalary());
        }
        System.out.println(" 3 ");
        Collections.sort(employees1, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
        for (Employee employee : employees1) {
            System.out.println(employee.getName() + ":" + employee.getSalary());
        }*/

        /*System.out.println(Integer.compare(1, 3));
        System.out.println(Integer.compare(3, 1));*/
    }

    @Test
    public void setBonus() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //triple(3);
        //System.out.println(max(0.1, 3.14, -20));
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = (int[]) goodCopyOf(a, 10);
//        //System.out.println(Arrays.toString(b));
//        Employee employee = new Employee("mxk", 1, 2018, 12, 12);
//        System.out.println(employee.getClass().getName() + ": " + employee.getName());
//
//        Random random = new Random();
//        Class c1 = random.getClass();
//        System.out.println(c1.getName());
//        Class c2 = Class.forName(c1.getName());
//        System.out.println(c2.getName());
//
//        System.out.println(int[].class.getName());
//        System.out.println(int.class.getName());

        /*String s = "java.util.Random";
        Random m = (Random) Class.forName(s).newInstance();
        System.out.println(m);*/
        Calendar cd = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT")); // 设置时区为GMT
        String str = sdf.format(cd.getTime());
        System.out.println(str);

    }

    public static void triple(Integer x) {
        x = 3 * x;
        Logger.global.info(String.valueOf(x));
        //System.out.println(x);
    }

    public static double max(double... values) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double d : values) {
            if (d > largest) {
                largest = d;
            }
        }
        return largest;
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class c1 = a.getClass();
        if (!c1.isArray()) return null;
        Class componenType = c1.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componenType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}