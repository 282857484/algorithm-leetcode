package com.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized
 */
public class TestSynchorized {
    Object o =new Object();

    public void awaitTest() throws Exception {
        synchronized (o) {
            o.wait();
            System.out.println("await awake");
        }
    }

    public void signalTest() {
        synchronized (o) {
            o.notify();
            System.out.println("signal...");
        }

    }
    public static void main(String[] args) throws InterruptedException {
        TestSynchorized t= new TestSynchorized();

        new Thread(()-> {
            try {
                t.awaitTest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(1000);
        new Thread(()->{
            System.out.println("will signal");
            t.signalTest();
        }).start();


        Thread.sleep(10000000);

    }
}
