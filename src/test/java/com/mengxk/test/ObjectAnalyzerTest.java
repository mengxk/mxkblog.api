package com.mengxk.test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjectAnalyzerTest {

    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            squares.add(i * i);
        System.out.println(Arrays.toString(squares.toArray()));
        System.out.println(new ObjectAnalyzer().toString(squares));
    }

    private static class ObjectAnalyzer {
        private ArrayList<Object> visited = new ArrayList<>();

        /**
         * Converts an object to a string representation that lists all fields.
         *
         * @param object
         * @return
         */
        public String toString(Object object) {
            if (object == null) return "null";
            if (visited.contains(object))
                return "...";
            visited.add(object);
            Class c1 = object.getClass();
            if (c1 == String.class)
                return (String) object;
            if (c1.isArray()) {
                String r = c1.getComponentType() + "[]{";
                for (int i = 0; i < Array.getLength(object); i++) {
                    if (i > 0)
                        r += ",";
                    Object val = Array.get(object, i);
                    if (c1.getComponentType().isPrimitive())
                        r += val;
                    else
                        r += toString(val);
                }
                return r + "}";
            }

            String r = c1.getName();
            //inspect the fields of this class and all superclasses
            do {
                r += "[";
                Field[] fields = c1.getDeclaredFields();
                AccessibleObject.setAccessible(fields, true);
                //get the names and values of all fields
                for (Field f : fields) {
                    if (!Modifier.isStatic(f.getModifiers())) {
                        if (!r.endsWith("["))
                            r += ",";
                        r += f.getName() + "=";
                        try {
                            Class t = f.getType();
                            Object val = f.get(object);
                            if (t.isPrimitive())
                                r += val;
                            else
                                r += toString(val);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                r += "]";
                c1 = c1.getSuperclass();
            } while (c1 != null);
            return r;

        }
    }
}
