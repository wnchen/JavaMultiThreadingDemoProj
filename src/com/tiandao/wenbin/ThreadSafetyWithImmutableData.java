package com.tiandao.wenbin;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyWithImmutableData {
//    private int counter = 0;
    private ImmutableCounter immutableCounter = new ImmutableCounter(0);
    private static final int SUM = 5000;

    public static void main(String[] args) {
        ThreadSafetyWithImmutableData threadSafetyWithSynchronized = new ThreadSafetyWithImmutableData();
        System.out.println("counter init value: " + threadSafetyWithSynchronized.immutableCounter.getCounter());
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
        System.out.println("counter final value: " + threadSafetyWithSynchronized.immutableCounter.getCounter());
    }

    private void decreaseCounterBy5000() {
        for (int i = 0; i < SUM; i++) {
            int updatedVal = immutableCounter.getCounter() + 1;
            ImmutableCounter newImmutableCounter = new ImmutableCounter(updatedVal);
        }
    }

    private void increaseCounterBy5000() {
        for (int i = 0; i < SUM; i++) {
            int updatedVal = immutableCounter.getCounter() - 1;
            ImmutableCounter newImmutableCounter = new ImmutableCounter(updatedVal);
        }
    }

}
