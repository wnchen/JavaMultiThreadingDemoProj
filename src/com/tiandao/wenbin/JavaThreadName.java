package com.tiandao.wenbin;

public class JavaThreadName {

    public static void main(String[] args) {
        System.out.println("test main thread name: " + Thread.currentThread().getName());
        System.out.println("Starting a new thread");
        Thread newThread = new Thread("testMain") {
            @Override
            public void run() {
                try {
                    System.out.println("test new thread name: " + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        newThread.start();
        System.out.println("main() ended");
    }
}
