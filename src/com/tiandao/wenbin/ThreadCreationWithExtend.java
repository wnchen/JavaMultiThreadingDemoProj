package com.tiandao.wenbin;

public class ThreadCreationWithExtend extends Thread {

    @Override
    public void run() {
        System.out.println("creating thread by extends Thread class");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
