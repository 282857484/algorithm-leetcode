package com.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestAQSCondition {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void awaitTest() throws Exception {
        try {
            lock.lock();
            condition.await();
            System.out.println("await awake");
        } finally {
            lock.unlock();
        }
    }

    public void signalTest() {
        try {
            lock.lock();
            condition.signal();
            System.out.println("signal...");
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestAQSCondition t= new TestAQSCondition();

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
