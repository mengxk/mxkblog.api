package com.mengxk.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {

    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter calss name (e.g java.util.Date):");
            name = in.next();
        }

        try {
            Class c1 = Class.forName(name);
            Class superc1 = c1.getSuperclass();
            String modifiers = Modifier.toString(c1.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            System.out.print("class " + name);
            if (superc1 != null && superc1 != Object.class)
                System.out.print(" extends " + superc1.getName());
            System.out.print("\n{\n");
            printConstructors(c1);
            System.out.println();
            printMethods(c1);
            System.out.println();
            printFields(c1);
            System.out.println("}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * print all fields of a class
     * @param c1
     */
    private static void printFields(Class c1) {
        Field[] fields = c1.getDeclaredFields();
        for (Field file : fields){
            Class type = file.getType();
            String name = file.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(file.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

    /**
     * print class methods of a class
     *
     * @param c1
     */
    private static void printMethods(Class c1) {
        Method[] methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            Class retType = method.getReturnType();
            String name = method.getName();
            System.out.print(" ");
            //print modifiers, return type and method name
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            //print parameter types
            Class[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(",");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    /**
     * print all constructors of a class
     *
     * @param c1
     */
    private static void printConstructors(Class c1) {
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String name = constructor.getName();
            System.out.print(" ");
            String modifiers = Modifier.toString(constructor.getModifiers());
            if (modifiers.length() > 0)
                System.out.print(modifiers + " ");
            System.out.print(name + "(");

            //print parameter types
            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(")");
        }
    }
}
