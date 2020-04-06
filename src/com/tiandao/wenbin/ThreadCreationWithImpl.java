package com.tiandao.wenbin;

public class ThreadCreationWithImpl implements Runnable {
    @Override
    public void run() {
        System.out.println("creating thread by implementing Runnable interface");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
