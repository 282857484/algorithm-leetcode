package com.concurrent;


import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {
    public static void main(String[] args){
        CountDownLatch cdl = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(()-> {
                try {
                    cdl.await();
                    System.out.println(Thread.currentThread().getName() + "notify");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    cdl.countDown();
                    System.out.println("countDown");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }
}
