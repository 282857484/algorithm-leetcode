package com.concurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayList {
    public CopyOnWriteArrayList list = null;

    public TestCopyOnWriteArrayList(CopyOnWriteArrayList l) {
        this.list = l;
    }

    public static void main(String[] args){

        CopyOnWriteArrayList l = new CopyOnWriteArrayList();
        TestCopyOnWriteArrayList t = new TestCopyOnWriteArrayList(l);

        new Thread(()-> {
            while (true) {
                t.list.stream().forEach(x -> System.out.println(x));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()-> {
            for (int i = 0; i < 100; i++) {
                l.add(i+"位");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
