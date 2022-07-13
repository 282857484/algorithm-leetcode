package com.concurrent;

/**
 * synchronized
 * 相当于临界区做lock unlock操作
 * 同一个线程可以重入
 * 非公平锁
 *
 * wait notify
 * 需要在临界区内操作
 * 非公平锁，notify时唤醒的线程是乱序
 */
public class TestSomeThread{
    public static void main(String[] args) {
        Object obj = new Object();
        for (int i = 0; i<10 ; i ++) {
            TestRunnable t1 = new TestRunnable(obj,"waitWithoutLock");
            Thread t = new Thread(t1,"线程：waitWithoutLock" +i);
            t.start();
        }
    }
    public static void main1(String[] args) {

        Object obj = new Object();
        for (int i = 0; i<10 ; i ++) {
            TestRunnable t1 = new TestRunnable(obj,"wait");
            Thread t = new Thread(t1,"线程：wait" +i);
            t.start();
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestRunnable t2 = new TestRunnable(obj,"notify");
        Thread t = new Thread(t2,"线程：notify");
        t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestRunnable t3 = new TestRunnable(obj,"notifyAll");
        Thread tt = new Thread(t3,"线程：notifyAll");
        tt.start();

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TestRunnable implements Runnable{
    Object obj = null;
    String flag = "";

    public TestRunnable(Object obj,String flag) {
        this.obj = obj;
        this.flag = flag;
    }

    @Override
    public void run() {
        switch (flag){
            case "wait":
                waitFunc();
                break;
            case "notify":
                notifyFunc();
                break;
            case "notifyAll":
                notifyAllFunc();
                break;
            case "reentrant":
                reentrant();
                break;
            case "waitWithoutLock":
                waitWithoutLockFunc();
                break;
        }

    }

    private void waitFunc() {
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName() + "waiting");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");

        }
    }

    private void waitWithoutLockFunc() {
            System.out.println(Thread.currentThread().getName() + "waiting");
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "end");
    }


    private void reentrant() {
        synchronized (obj) {
            synchronized (obj) {
                synchronized (obj) {
                    System.out.println(Thread.currentThread().getName() + "synchronized reentrant ");
                }
            }
        }
    }

    private void notifyFunc() {
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName() + "");
            obj.notify();
//            for (int i = 0; i < 50; i++) {
//                obj.notify();
//            }

            System.out.println(Thread.currentThread().getName() + " end");
        }
    }

    private void notifyAllFunc() {
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName() + "");
            obj.notifyAll();
            System.out.println(Thread.currentThread().getName() + " end");
        }
    }
}
