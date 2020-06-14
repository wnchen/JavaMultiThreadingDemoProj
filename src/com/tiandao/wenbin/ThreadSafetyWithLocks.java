package com.tiandao.wenbin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafetyWithLocks {
    private int counter = 0;
    private static final int SUM = 5000;

    public static void main(String[] args) {
        ThreadSafetyWithLocks threadSafetyWithLocks = new ThreadSafetyWithLocks();
        System.out.println("counter init value: " + threadSafetyWithLocks.counter);
        Lock lock = new ReentrantLock();
        Lock lock1 = new ReentrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (this) {
//                lock.lock();
                    threadSafetyWithLocks.increaseCounterBy5000();
//                }
//                lock.unlock();

                System.out.println("hello world");

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                synchronized (this) {
//                lock.lock();
                    threadSafetyWithLocks.decreaseCounterBy5000();
//                }
//                lock.unlock();
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
        System.out.println("counter final value: " + threadSafetyWithLocks.counter);
    }

    private void decreaseCounterBy5000() {
        synchronized (this) {
            for (int i = 0; i < SUM; i++) {
                counter--;
            }
        }
    }

    private void increaseCounterBy5000() {
        synchronized (this) {
            for (int i = 0; i < SUM; i++) {
                counter++;
            }
        }
    }

}
