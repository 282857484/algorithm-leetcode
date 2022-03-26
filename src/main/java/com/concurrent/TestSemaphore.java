package com.concurrent;


import java.util.concurrent.Semaphore;

public class TestSemaphore {
    public final static ThreadLocal t = new ThreadLocal();
    public static void main(String[] args){
        Semaphore sema = new Semaphore(2);
        for (int i = 0; i <10; i++) {
            int finalI = i;
            new Thread(()-> {
                try {
                    sema.acquire();
                    System.out.println(Thread.currentThread().getName()+"进站");
                    Thread.sleep(1000 * 3);
                    sema.release();
                    System.out.println(Thread.currentThread().getName()+"出站");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
