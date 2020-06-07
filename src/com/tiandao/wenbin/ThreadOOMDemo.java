package com.tiandao.wenbin;

public class ThreadOOMDemo {

    private static final int COUNTER = 100000;

    public static void main(String[] args) {
        for (int i = 0; i < COUNTER; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
