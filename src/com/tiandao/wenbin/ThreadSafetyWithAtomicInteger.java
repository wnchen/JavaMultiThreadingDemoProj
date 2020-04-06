package com.tiandao.wenbin;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyWithAtomicInteger {
//    private int counter = 0;
    private AtomicInteger counter = new AtomicInteger(0);
    private static final int SUM = 5000;

    public static void main(String[] args) {
        ThreadSafetyWithAtomicInteger threadSafetyWithSynchronized = new ThreadSafetyWithAtomicInteger();
        System.out.println("counter init value: " + threadSafetyWithSynchronized.counter);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafetyWithSynchronized.increaseCounterBy5000();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadSafetyWithSynchronized.decreaseCounterBy5000();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("counter final value: " + threadSafetyWithSynchronized.counter.get());
    }

    private void decreaseCounterBy5000() {
        for (int i = 0; i < SUM; i++) {
//            counter--;
            counter.getAndDecrement();
        }
    }

    private void increaseCounterBy5000() {
        for (int i = 0; i < SUM; i++) {
//            counter++;
            counter.getAndIncrement();
        }
    }

}
