package com.mengxk.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This program shows how to invoke methods through reflection.
 */
public class MethodTableTest {
    public static void main(String[] args) throws NoSuchMethodException {
        //get method pointers to the square and sqrt methods
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        //print tables of x- and y-values
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

    /**
     * Prints a table with x- and y-values for a method.
     *
     * @param from
     * @param to
     * @param n
     * @param f
     */
    private static void printTable(double from, double to, int n, Method f) {
        //print out the method as table header
        System.out.println(f);
        double dx = (to - from) / (n - 1);
        for (double x = from; x <= to; x += dx){
            try {
                double y = (double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the square of a number.
     * @param x
     * @return
     */
    public static double square(double x){
        return x * x;
    }
}
