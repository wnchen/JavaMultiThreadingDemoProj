package com.tiandao.wenbin;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    final String name;
    Lock lock = new ReentrantLock();

    Chopstick(String name) {
        this.name = name;
    }

    void getChopstick() {
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void releaseChopstick() {
        System.out.println("release chopstick " + name + "lock");
        lock.unlock();
    }
 }
