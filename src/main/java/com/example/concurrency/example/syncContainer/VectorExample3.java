package com.example.concurrency.example.syncContainer;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample3 {

    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1) {
        for (Integer i : v1) {
            if (i == 3) {
                v1.remove(i);
            }
        }
    }

    private static void test2(Vector<Integer> v1) {
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i == 3) {
//                v1.remove(i);//java.util.ConcurrentModificationException
                iterator.remove();//success
            }
        }
    }

    //success
    private static void test3(Vector<Integer> v1) {
        for (int i = 0; i < v1.size(); i++) {
            Integer integer = v1.get(i);
            if (integer == 3) {
                v1.remove(integer);
            }
        }
    }

    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
//        test1(vector);
//        test2(vector);
        test3(vector);
        System.out.println(vector.size());

    }
}
