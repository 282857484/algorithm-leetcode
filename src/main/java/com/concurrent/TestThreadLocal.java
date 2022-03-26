package com.concurrent;


public class TestThreadLocal {
    public final static ThreadLocal t = new ThreadLocal();
    public static void main(String[] args){

        new Thread(()-> {
            TestThreadLocal.t.set("shit");
            while (true) {
                System.out.println(Thread.currentThread().getName() + TestThreadLocal.t.get());
                TestThreadLocal.t.set(TestThreadLocal.t.get() + ".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()-> {
            TestThreadLocal.t.set("bitch");
            while (true) {
                System.out.println(Thread.currentThread().getName() + TestThreadLocal.t.get());
                TestThreadLocal.t.set(TestThreadLocal.t.get() + "~");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }
}
